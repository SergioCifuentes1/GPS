/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps.Entrada;

import gps.Grafos.Camino;
import gps.Grafos.ControladorGrafos;
import gps.Grafos.Ubicacion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class ManejadorEntrada {
    
    public void abrirArchivo(ControladorGrafos controladorGrafos,File file){
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea =br.readLine();
            while (linea!=null) {
                linea= linea.replace("|", "@");
                String[] parametros = linea.split("@");
                if (parametros.length==7) {
                    Ubicacion origen;
                    origen=controladorGrafos.obtnerUbicacion(parametros[0]);
                    if (origen==null) {
                        origen= new Ubicacion(parametros[0]);
                        controladorGrafos.addUbicacion(origen);
                    }
                    Ubicacion destino;
                    destino=controladorGrafos.obtnerUbicacion(parametros[1]);
                    if (destino==null) {
                        destino= new Ubicacion(parametros[1]);
                        controladorGrafos.addUbicacion(destino);
                    }
                    Camino camino = new Camino(origen, destino,Double.valueOf(parametros[6]),
                            Double.valueOf(parametros[2]),Double.valueOf(parametros[3]),
                            Double.valueOf(parametros[4]),Double.valueOf(parametros[5]));
                    origen.agregarCamino(camino);
                    destino.agregarCaminoAPie(camino);
                }
                
                linea=br.readLine();
                        
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejadorEntrada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejadorEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
