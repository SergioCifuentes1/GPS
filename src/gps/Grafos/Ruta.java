/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps.Grafos;

import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class Ruta {

    private Ubicacion origen;
    private Ubicacion destino;
    private ArrayList<Camino> ruta;
    private double distanciaTotal;
    private double gasolinaTotal;
    private double desgasteTotal;
    private double tiempoEnVehiculoTotal;
    private double tiempoAPieTotal;
    
    
    
    private boolean mejorDistancia = false;
    private boolean peorDistancia = false;
    private boolean mejorPromedio = false;
    private boolean peorPromedio = false;
    private boolean mejorDesgaste = false;
    private boolean peorDesgaste = false;
    private int id=0;

    public boolean isMejorDistancia() {
        return mejorDistancia;
    }

    public void setMejorDistancia(boolean mejorDistancia) {
        this.mejorDistancia = mejorDistancia;
    }

    public void reset() {
    mejorDistancia = false;
    peorDistancia = false;
    mejorPromedio = false;
    peorPromedio = false;
    mejorDesgaste = false;
    peorDesgaste = false;
}
public boolean isPeorDistancia() {
        return peorDistancia;
    }

    public void setPeorDistancia(boolean peorDistancia) {
        this.peorDistancia = peorDistancia;
    }

    public boolean isMejorPromedio() {
        return mejorPromedio;
    }

    public void setMejorPromedio(boolean mejorPromedio) {
        this.mejorPromedio = mejorPromedio;
    }

    public boolean isPeorPromedio() {
        return peorPromedio;
    }

    public void setPeorPromedio(boolean peorPromedio) {
        this.peorPromedio = peorPromedio;
    }

    public int getId() {
        return id;
    }

    public boolean isMejorDesgaste() {
        return mejorDesgaste;
    }

    public void setMejorDesgaste(boolean mejorDesgaste) {
        this.mejorDesgaste = mejorDesgaste;
    }

    public boolean isPeorDesgaste() {
        return peorDesgaste;
    }

    public void setPeorDesgaste(boolean peorDesgaste) {
        this.peorDesgaste = peorDesgaste;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    public Ruta(Ubicacion origen, Ubicacion destino) {
        this.origen = origen;
        this.destino = destino;
        ruta = new ArrayList<>();
        distanciaTotal=0;
        gasolinaTotal=0;
        desgasteTotal=0;
        tiempoAPieTotal=0;
        tiempoEnVehiculoTotal=0;
        id=0;
    }

    public void agregarCamino(Camino camino) {
        ruta.add(camino);
        distanciaTotal+=camino.getDistancia();
        gasolinaTotal+=camino.getConsumoDeGas();
        desgasteTotal+=camino.getDesgastePersonal();
        tiempoAPieTotal+=camino.getTiempoAPie();
        tiempoEnVehiculoTotal+=camino.getTiempoEnVehiculo();
        
        
    }

    public void setAtributos(double distanciaTotal, double gasolinaTotal, double desgasteTotal, double tiempoEnVehiculoTotal, double tiempoAPieTotal) {
        this.distanciaTotal = distanciaTotal;
        this.gasolinaTotal = gasolinaTotal;
        this.desgasteTotal = desgasteTotal;
        this.tiempoEnVehiculoTotal = tiempoEnVehiculoTotal;
        this.tiempoAPieTotal = tiempoAPieTotal;
    }

    public double getGasolinaTotal() {
        return gasolinaTotal;
    }

    public double getDesgasteTotal() {
        return desgasteTotal;
    }
    public double getPromedio(boolean Envehiculo){
        if (Envehiculo) {
            return (gasolinaTotal+distanciaTotal)/2;
        }else{
            return (desgasteTotal+distanciaTotal)/2;
        }
    }
    public double getTiempoEnVehiculoTotal() {
        return tiempoEnVehiculoTotal;
    }

    public double getTiempoAPieTotal() {
        return tiempoAPieTotal;
    }
    

    
    
    public void removerCamino() {
        if (ruta.size()>0) {
             Camino camino = ruta.get(ruta.size()-1);
            distanciaTotal-=camino.getDistancia();
        gasolinaTotal-=camino.getConsumoDeGas();
        desgasteTotal-=camino.getDesgastePersonal();
        tiempoAPieTotal-=camino.getTiempoAPie();
        tiempoEnVehiculoTotal-=camino.getTiempoEnVehiculo();
            ruta.remove(ruta.size() - 1);
           
            
        }
        
    }

    public double getDistanciaTotal() {
        return distanciaTotal;
        
    }

    public Ubicacion getDestino() {
        return destino;
    }

    public Ubicacion getOrigen() {
        return origen;
    }

    public ArrayList<Camino> getRuta() {
        return ruta;
    }

}
