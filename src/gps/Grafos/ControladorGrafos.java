/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps.Grafos;

import gps.ui.MenuPrincipal;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class ControladorGrafos {

    private ArrayList<Ubicacion> ubicaciones;
    private ControladorDeRutas cdr;
    private Ubicacion destino;
    private Ubicacion origen;
    private MenuPrincipal jframe;
    private boolean enVehiculo;

    public ControladorGrafos(MenuPrincipal jframe) {
        this.jframe=jframe;
        ubicaciones = new ArrayList<>();
        cdr= new  ControladorDeRutas(new ArrayList<Ruta>(), jframe, enVehiculo, this);
    }
    public void resetUbicacion(){
        ubicaciones= new  ArrayList<>();
    }
    public Ubicacion getDestino() {
        return destino;
    }

    public Ubicacion obtnerUbicacion(String nombre) {
        int posicion = binarySearch(nombre);
        if (posicion < ubicaciones.size()) {
            if (ubicaciones.get(posicion).getNombre().equals(nombre)) {
                return ubicaciones.get(posicion);
            }
        }

        return null;

    }
    public void dibujarGrafo(MenuPrincipal jFrame){
     cdr.mostrarImagenInicial();
        
        
    }
    public void moverALaSiguienteUbicacion() {
         Ruta actual = cdr.getRutaSeleccionada().getRuta();
        if (actual.getRuta().size()==1) {
            jframe.mostrarLLegarADestino();
        } else {
       
        if (actual.getRuta().get(0).getDestino().equals(actual.getRuta().get(1).getOrigen()) || actual.getRuta().get(0).getOrigen().equals(actual.getRuta().get(1).getOrigen())) {
            origen = actual.getRuta().get(1).getOrigen();
        } else if (actual.getRuta().get(0).getOrigen().equals(actual.getRuta().get(1).getDestino()) || actual.getRuta().get(0).getDestino().equals(actual.getRuta().get(1).getDestino())) {
            origen = actual.getRuta().get(1).getDestino();
        }
            cdr.borrarElementosArbolB();
        actual.getRuta().remove(0);
        
            ArrayList<Ruta> rutas = new ArrayList<>();
            Ruta ruta = new Ruta(origen, destino);
            buscarRuta(origen, destino, ruta, rutas, enVehiculo);
            actual.reset();
            for (int i = 0; i < rutas.size(); i++) {
                if (compararRutas(rutas.get(i), actual)) {
                    rutas.remove(i);
                }
            }
            rutas.add(0, actual);
            
            clasificarRutas(rutas, enVehiculo);
            rutas = ordenarRutasConRutaAcutal(rutas, enVehiculo);
        cdr.setRutas(rutas);

        cdr.agregarRutas();
        
        
        
        }

    }

    private boolean compararRutas(Ruta ruta1, Ruta ruta2) {
        if (ruta1.getRuta().size() == ruta2.getRuta().size()) {
            for (int i = 0; i < ruta1.getRuta().size(); i++) {
                if (!ruta1.getRuta().get(i).equals(ruta2.getRuta().get(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public void addUbicacion(Ubicacion ubicacion) {
        if (ubicaciones.isEmpty()) {
            ubicaciones.add(ubicacion);
        } else {
            ubicaciones.add(binarySearch(ubicacion.getNombre()), ubicacion);
        }

    }

    private int binarySearch(String value) {
        int low = 0;
        int high = ubicaciones.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midVal = ubicaciones.get(mid).getNombre();
            int cmp = midVal.compareTo(value);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    public void agregarRutas(int indexOrigen, int indexDestino, MenuPrincipal jframe, boolean enVehiculo) {
        this.jframe = jframe;
        this.enVehiculo = enVehiculo;
        ArrayList<Ruta> rutas = new ArrayList<>();
        Ubicacion origen = ubicaciones.get(indexOrigen);
        destino = ubicaciones.get(indexDestino);
        Ruta ruta = new Ruta(origen, destino);
        buscarRuta(origen, destino, ruta, rutas, enVehiculo);
        rutas = ordenarRutas(rutas, enVehiculo);
        cdr = new ControladorDeRutas(rutas, jframe, enVehiculo, this);

        cdr.agregarRutas();

    }

    private void clasificarRutas(ArrayList<Ruta> rutas, boolean enVehiculo) {
        System.out.println(rutas);
        Ruta rutaDistanciaMenor = rutas.get(0);
        Ruta rutaDesgasteoGasolinaMenor = rutas.get(0);
        Ruta rutaPromedioMenor = rutas.get(0);
        Ruta rutaDistanciaMayor = rutas.get(0);
        Ruta rutaDesgasteoGasolinaMayor = rutas.get(0);
        Ruta rutaPromedioMayor = rutas.get(0);
        for (int i = 1; i < rutas.size(); i++) {
            if (rutaDistanciaMenor.getDistanciaTotal() > rutas.get(i).getDistanciaTotal()) {
                rutaDistanciaMenor = rutas.get(i);
            } else if (rutaDistanciaMayor.getDistanciaTotal() < rutas.get(i).getDistanciaTotal()) {
                rutaDistanciaMayor = rutas.get(i);
            }

            if (enVehiculo) {
                if (rutaDesgasteoGasolinaMenor.getGasolinaTotal() > rutas.get(i).getGasolinaTotal()) {
                    rutaDesgasteoGasolinaMenor = rutas.get(i);
                } else if (rutaDesgasteoGasolinaMayor.getGasolinaTotal() < rutas.get(i).getGasolinaTotal()) {
                    rutaDesgasteoGasolinaMayor = rutas.get(i);
                }
            } else {
                if (rutaDesgasteoGasolinaMenor.getDesgasteTotal() > rutas.get(i).getDesgasteTotal()) {
                    rutaDesgasteoGasolinaMenor = rutas.get(i);
                } else if (rutaDesgasteoGasolinaMayor.getDesgasteTotal() < rutas.get(i).getDesgasteTotal()) {
                    rutaDesgasteoGasolinaMayor = rutas.get(i);
                }
            }

            if (rutaPromedioMenor.getPromedio(enVehiculo) > rutas.get(i).getPromedio(enVehiculo)) {
                rutaPromedioMenor = rutas.get(i);
            } else if (rutaPromedioMayor.getPromedio(enVehiculo) < rutas.get(i).getPromedio(enVehiculo)) {
                rutaPromedioMayor = rutas.get(i);
            }

        }
        rutaDistanciaMenor.setMejorDistancia(true);
        rutaDistanciaMayor.setPeorDistancia(true);
        rutaPromedioMenor.setMejorPromedio(true);
        rutaPromedioMayor.setPeorPromedio(true);
        rutaDesgasteoGasolinaMenor.setMejorDesgaste(true);
        rutaDesgasteoGasolinaMayor.setPeorDesgaste(true);
    }

    private ArrayList<Ruta> ordenarRutasConRutaAcutal(ArrayList<Ruta> rutas, boolean enVehiculo) {
        ArrayList<Ruta> rutasAux = new ArrayList<>();
        ArrayList<Ruta> rutasPeores = new ArrayList<>();
        ArrayList<Ruta> rutasNormales = new ArrayList<>();
        rutasAux.add(rutas.get(0));
        rutasAux.add(null);
        rutasAux.add(null);
        rutasAux.add(null);
        rutasPeores.add(null);
        rutasPeores.add(null);
        rutasPeores.add(null);
        int aux = 3;
        if (rutas.get(0).isMejorPromedio()) {
            aux--;
        }
        if (!rutas.get(0).isMejorDistancia()) {
            aux--;
        }
        for (int i = 1; i < rutas.size(); i++) {

            if (rutas.get(i).isMejorPromedio()) {
                rutasAux.set(1, rutas.get(i));
            } else if (rutas.get(i).isMejorDistancia()) {
                if (!rutas.get(0).isMejorPromedio()) {
                    rutasAux.set(2, rutas.get(i));
                } else {
                    rutasAux.set(1, rutas.get(i));
                }

            } else if (rutas.get(i).isMejorDesgaste()) {
                rutasAux.set(aux, rutas.get(i));
            } else if (rutas.get(i).isPeorPromedio()) {
                rutasPeores.add(rutas.get(i));
            } else if (rutas.get(i).isPeorDistancia()) {
                rutasPeores.add(rutas.get(i));
            } else if (rutas.get(i).isPeorDesgaste()) {
                rutasPeores.add(rutas.get(i));
            } else {
                rutasNormales.add(rutas.get(i));
            }
        }
        for (int i = rutasAux.size() - 1; i >= 0; i--) {
            if (rutasAux.get(i) == null) {
                rutasAux.remove(i);
            }
        }
        for (int i = rutasPeores.size() - 1; i >= 0; i--) {
            if (rutasPeores.get(i) == null) {
                rutasPeores.remove(i);
            }
        }
        for (int i = 0; i < rutasNormales.size(); i++) {
            rutasAux.add(rutasNormales.get(i));
        }
        for (int i = 0; i < rutasPeores.size(); i++) {
            rutasAux.add(rutasPeores.get(i));
        }
        return rutasAux;

    }

    private ArrayList<Ruta> ordenarRutas(ArrayList<Ruta> rutas, boolean enVehiculo) {
        clasificarRutas(rutas, enVehiculo);
        ArrayList<Ruta> rutasAux = new ArrayList<>();
        ArrayList<Ruta> rutasPeores = new ArrayList<>();
        ArrayList<Ruta> rutasNormales = new ArrayList<>();
        rutasAux.add(null);
        rutasAux.add(null);
        rutasAux.add(null);
        rutasPeores.add(null);
        rutasPeores.add(null);
        rutasPeores.add(null);
        for (int i = 0; i < rutas.size(); i++) {
            if (rutas.get(i).isMejorPromedio()) {
                rutasAux.set(0, rutas.get(i));
            } else if (rutas.get(i).isMejorDistancia()) {
                rutasAux.set(1, rutas.get(i));
            } else if (rutas.get(i).isMejorDesgaste()) {
                rutasAux.set(2, rutas.get(i));
            } else if (rutas.get(i).isPeorPromedio()) {
                rutasPeores.set(0, rutas.get(i));
            } else if (rutas.get(i).isPeorDistancia()) {
                rutasPeores.set(1, rutas.get(i));
            } else if (rutas.get(i).isPeorDesgaste()) {
                rutasPeores.set(2, rutas.get(i));
            } else {
                rutasNormales.add(rutas.get(i));
            }
        }
        for (int i = rutasAux.size() - 1; i >= 0; i--) {
            if (rutasAux.get(i) == null) {
                rutasAux.remove(i);
            }
        }
        for (int i = rutasPeores.size() - 1; i >= 0; i--) {
            if (rutasPeores.get(i) == null) {
                rutasPeores.remove(i);
            }
        }
        for (int i = 0; i < rutasNormales.size(); i++) {
            rutasAux.add(rutasNormales.get(i));
        }
        for (int i = 0; i < rutasPeores.size(); i++) {
            rutasAux.add(rutasPeores.get(i));
        }

        return rutasAux;

    }

    public void buscarRuta(Ubicacion actual, Ubicacion destino, Ruta rutaActual, ArrayList<Ruta> rutas, boolean enVehiculo) {
        ArrayList<Camino> caminosDelActual = actual.getCaminos();
        actual.setVisitado(true);
        for (int i = 0; i < caminosDelActual.size(); i++) {
            Ubicacion ubiSiguiente = caminosDelActual.get(i).getDestino();
            if (!ubiSiguiente.isVisistado()) {
                rutaActual.agregarCamino(caminosDelActual.get(i));
                if (ubiSiguiente.equals(destino)) {
                    Ruta rutaAux = new Ruta(rutaActual.getOrigen(), destino);
                    rutaAux.getRuta().addAll(rutaActual.getRuta());
                    rutaAux.setAtributos(rutaActual.getDistanciaTotal(), rutaActual.getGasolinaTotal(), rutaActual.getDesgasteTotal(),
                             rutaActual.getTiempoEnVehiculoTotal(), rutaActual.getTiempoAPieTotal());
                    rutas.add(rutaAux);
                    rutaActual.removerCamino();
                } else {
                    buscarRuta(ubiSiguiente, destino, rutaActual, rutas, enVehiculo);
                }
            }
        }
        if (!enVehiculo) {
            caminosDelActual = actual.getCaminosAPieNoRepitentes();
            for (int i = 0; i < caminosDelActual.size(); i++) {
                Ubicacion ubiSiguiente = caminosDelActual.get(i).getOrigen();
                if (!ubiSiguiente.isVisistado()) {
                    rutaActual.agregarCamino(caminosDelActual.get(i));
                    if (ubiSiguiente.equals(destino)) {
                        Ruta rutaAux = new Ruta(rutaActual.getOrigen(), destino);
                        rutaAux.getRuta().addAll(rutaActual.getRuta());
                        rutaAux.setAtributos(rutaActual.getDistanciaTotal(), rutaActual.getGasolinaTotal(), rutaActual.getDesgasteTotal(),
                                 rutaActual.getTiempoEnVehiculoTotal(), rutaActual.getTiempoAPieTotal());
                        rutas.add(rutaAux);
                        rutaActual.removerCamino();
                    } else {
                        buscarRuta(ubiSiguiente, destino, rutaActual, rutas, enVehiculo);
                    }
                }
            }
        }
        rutaActual.removerCamino();
        actual.setVisitado(false);
    }

}
