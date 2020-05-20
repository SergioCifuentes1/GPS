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
public class Nodo {
    int mK;
    int mB;
    Ruta[] mLlaves;
    Nodo[] mPunteros;
    
    public Nodo(int pK) {
        this.mK = pK;
        mB = 0;
        mLlaves = new Ruta[2 * pK + 1];
        mPunteros = new Nodo[(2 * pK) + 2];
    }

    public Nodo(int pK ,Ruta pDato) {
        this(pK);
        mB = 1;
        mLlaves[0] = pDato;
       
    }

    public void setK(int mK) {
        this.mK = mK;
    }

    public int getK() {
        return mK;
    }
    
    
    
        public String getDotName() {
        return "Nodo" + this.hashCode();
    }
    
    public String toDot(  )  {
        
        StringBuilder b = new StringBuilder();
        
        b.append( getDotName() );
        b.append("[label=\"<P0>");
        for( int i = 0; i < mB; i++ ) {
            b.append("|" +  mLlaves[i].getId());
            b.append("|<P" + (i+1) + ">" );                
        }
        
        b.append("\"];\n");
        
        for( int i = 0; i <= mB ; i++ ) {
            if( mPunteros[i] != null )   {
                b.append( mPunteros[i].toDot() );
                b.append( getDotName() + ":P" + i + " -> " + mPunteros[i].getDotName() + ";\n" );
            }
        }
        
        return b.toString();
        
    }
    
    
}
