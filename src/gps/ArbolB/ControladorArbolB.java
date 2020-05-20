/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps.ArbolB;

import gps.Grafos.Ruta;
import gps.Graphviz.Grafos;
import gps.ui.MenuPrincipal;
import java.time.LocalDateTime;

/**
 *
 * @author sergio
 */
public class ControladorArbolB {
    private ArbolB arbolB;
    private String id;
    private  Grafos grafo;
    
    public ControladorArbolB() {
        arbolB= new  ArbolB(2);
        
        grafo= new Grafos();
    }
    
    public void crearGrafo(MenuPrincipal mp){
        id=String.valueOf(LocalDateTime.now());
        grafo.crearArbol(arbolB, id);
    }
    
    public void insertarRuta(Ruta ruta){
       arbolB.insert(ruta);
    }

    public String getId() {
        return id;
    }

    public ArbolB getArbolB() {
        return arbolB;
    }
    public void clear(Ruta ruta){
        arbolB= new ArbolB(2);
        insertarRuta(ruta);
    }
    
    
}
