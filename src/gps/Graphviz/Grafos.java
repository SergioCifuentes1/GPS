/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps.Graphviz;

import gps.ArbolB.ArbolB;
import gps.Grafos.Camino;
import gps.Grafos.Ruta;
import gps.Grafos.Ubicacion;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class Grafos {
    
    public void crearGrafo(String nombre,ArrayList<Ubicacion> ubicaciones,Ruta rutaAMarcar){
        String contenido="digraph G {\n";
        contenido+="size =\"150,150\";\n";
        for (int i = 0; i < ubicaciones.size(); i++) {
            for (int j = 0; j < ubicaciones.get(i).getCaminos().size(); j++) {
                Camino camino=ubicaciones.get(i).getCaminos().get(j);
                contenido+=camino.getOrigen()+" -> "+camino.getDestino()+" [style=bold,label=\""+camino.getDistancia()+"\"";
                if (verificarCaminoYRuta(camino, rutaAMarcar)) {
                    contenido+=",color=blue";
                }
                contenido+="];\n";
            }
        }
        
        
        contenido+="}";
        
        crearArchivo(nombre,contenido);
    }
    
    private boolean verificarCaminoYRuta(Camino camino,Ruta ruta){
        for (int i = 0; i < ruta.getRuta().size(); i++) {
            
            if (ruta.getRuta().get(i).equals(camino)) {
                
                return true;
            }
        }
        return false;
    }
    
    
    public void crearArbol(ArbolB arbolB,String id){
        File carpeta=new File("./ArbolB");
        if (!carpeta.exists()) {
            carpeta.mkdir();
            carpeta.mkdirs();
            
        }
        File archivo = new File(carpeta.getPath()+"/"+id+".dot");
        try {
            archivo.createNewFile();
            FileWriter fw = new FileWriter(archivo);
            fw.write(arbolB.toDot());
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Grafos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            Process p = Runtime.getRuntime().exec("dot -Tpng "+archivo.getPath()+" -o "+"./ArbolB/"+id+".png");
        } catch (IOException ex) {
            Logger.getLogger(Grafos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public  void eliminarGrafosAnteriores(){
        File carpeta=new File("./Grafos");
        
        if (carpeta.exists()) {
        String[] archivos= carpeta.list();
            for (int i = 0; i <archivos.length; i++) {
                
                File file = new File(carpeta.getPath()+"/"+archivos[i]);
                
                file.delete();
            }
        }
    }
    private void crearArchivo(String nombre,String contenido){
        File carpeta=new File("./Grafos");
        if (!carpeta.exists()) {
            carpeta.mkdir();
            carpeta.mkdirs();
            
        }
        File archivo = new File(carpeta.getPath()+"/"+nombre+".dot");
        try {
            archivo.createNewFile();
            FileWriter fw = new FileWriter(archivo);
            fw.write(contenido);
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Grafos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            Process p = Runtime.getRuntime().exec("dot -Tpng "+archivo.getPath()+" -o "+"./Grafos/"+nombre+".png");
        } catch (IOException ex) {
            Logger.getLogger(Grafos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
