/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps.Grafos;

import java.util.ArrayList;

/**        boolean aparece = false;
 *
 * @author sergio
 */
public class Ubicacion {
    private String nombre;
    private ArrayList<Camino> caminos;
    private ArrayList<Camino> caminosAPie;
    private boolean visitado;
    public Ubicacion(String Nombre) {
        this.nombre = Nombre;
        caminos = new ArrayList<>();
        caminosAPie= new ArrayList<>();
    }

    public boolean isVisistado() {
        return visitado;
    }

    public void setVisitado(boolean marca) {
        this.visitado = marca;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
    public void agregarCamino(Camino camino){
        caminos.add(camino);
    }
    public void agregarCaminoAPie(Camino camino){
        caminosAPie.add(camino);
    }
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Camino> getCaminos() {
        return caminos;
    }

    public ArrayList<Camino> getCaminosAPieNoRepitentes() {
        ArrayList<Camino> caminosAPieAux = new ArrayList<>();
        for (int i = 0; i < caminosAPie.size(); i++) {
            caminosAPieAux.add(caminosAPie.get(i));
            
        }
        return caminosAPieAux;
    }
    
}
