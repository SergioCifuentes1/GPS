/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps.Grafos;

import gps.Graphviz.Grafos;
import gps.ui.InfoRuta;
import gps.ui.MenuPrincipal;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author sergio
 */
public class ControladorDeRutas {

    private ArrayList<Ruta> rutas;
    private MenuPrincipal jFrame;
    private boolean enVehiculo;
    private InfoRuta rutaSeleccionada;
    private ControladorGrafos cg;
    private int contadorID = 0;

    public ControladorDeRutas(ArrayList<Ruta> rutas, MenuPrincipal jFrame, boolean enVehiculo, ControladorGrafos cg) {
        this.rutas = rutas;
        this.jFrame = jFrame;
        this.enVehiculo = enVehiculo;
        this.cg = cg;
    }

    public void setRutas(ArrayList<Ruta> rutas) {
        this.rutas = rutas;
    }
    public void borrarElementosArbolB(){
        for (int i = 0; i < rutas.size(); i++) {
            if (!rutas.get(i).equals(rutaSeleccionada.getRuta())) {
                jFrame.getControladorArbolB().getArbolB().eliminar(rutas.get(i).getId());
            }
        }
        
     
        jFrame.getControladorArbolB().clear(rutaSeleccionada.getRuta());
    }
    public void agregarRutas() {
        JPanel jpanel = jFrame.getPanelRutas();
        jpanel.removeAll();
        jpanel.setSize(150, rutas.size()*InfoRuta.ALTO+100);
        jpanel.setPreferredSize(jpanel.getSize());

        Grafos gr = new Grafos();
        gr.eliminarGrafosAnteriores();

        for (int i = 0; i < rutas.size(); i++) {
            if (rutas.get(i).getId() == 0) {
                contadorID++;
                rutas.get(i).setId(contadorID);
            }

            InfoRuta infoRuta = new InfoRuta(rutas.get(i), enVehiculo, this, String.valueOf(LocalDateTime.now()));
            gr.crearGrafo(infoRuta.getIndex(), cg.getUbicaciones(), rutas.get(i));
            infoRuta.setSize(InfoRuta.ANCHO, InfoRuta.ALTO);
            infoRuta.setBounds(0, i * infoRuta.getHeight(), InfoRuta.ANCHO, InfoRuta.ALTO);

            jpanel.add(infoRuta);
            infoRuta.setVisible(true);

            jFrame.getControladorArbolB().insertarRuta(rutas.get(i));

            if (i == 0) {
                try {
                    Thread.sleep(700);
                    seleccionarRuta(infoRuta, infoRuta.getIndex());
                } catch (InterruptedException ex) {
                    Logger.getLogger(ControladorDeRutas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        jFrame.getControladorArbolB().crearGrafo(jFrame);
        try {
            Thread.sleep(700);
            File file = new File("./ArbolB/" + jFrame.getControladorArbolB().getId() + ".png");

            if (file.exists()) {
                ImageIcon im = new ImageIcon(file.getPath());
                jFrame.setImageArbol(im);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorDeRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public InfoRuta getRutaSeleccionada() {
        return rutaSeleccionada;
    }

    public void seleccionarRuta(InfoRuta ruta, String index) {
        if (!ruta.isSeleccionado()) {
            if (rutaSeleccionada != null) {
                rutaSeleccionada.setSeleccionado(false);
            }
            File file = new File("./Grafos/" + index + ".png");

            if (file.exists()) {
                ImageIcon im = new ImageIcon(file.getPath());
                jFrame.setImageGrafos(im);
            }

            ruta.setSeleccionado(true);

            rutaSeleccionada = ruta;
        }

    }

    public void mostrarImagenInicial(){
        String index = String.valueOf(LocalDateTime.now());
        Grafos gr = new Grafos();
        gr.eliminarGrafosAnteriores();
        gr.crearGrafo(index, cg.getUbicaciones(), new Ruta(null, null));
        
        File file = new File("./Grafos/" + index + ".png");
        try {
            Thread.sleep(700);
             if (file.exists()) {
                ImageIcon im = new ImageIcon(file.getPath());
                jFrame.setImageGrafos(im);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorDeRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }
}
