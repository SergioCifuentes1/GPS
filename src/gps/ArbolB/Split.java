/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps.ArbolB;

import gps.Grafos.Ruta;

/**
 *
 * @author sergio
 */
public class Split {
    private Nodo mPuntero;
    private Ruta ruta;
 
        public Split(Nodo pPuntero, Ruta ruta) {
        this.mPuntero = pPuntero;
        this.ruta = ruta;
    }

    public Nodo getmPuntero() {
        return mPuntero;
    }

    public void setmPuntero(Nodo mPuntero) {
        this.mPuntero = mPuntero;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

        
        
}
