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
public class ArbolB {

    private Nodo mRaiz = null;
    private int mK = 5;
    private int mAltura = 0;

    public ArbolB(int k) {
        this.mK = k;
    }

    public ArbolB(Nodo pRaiz) {
        mK = pRaiz.getK();
        this.mRaiz = pRaiz;
        mAltura = 1;
    }

    public void insert(Ruta ruta) {
        if (this.mAltura == 0) {
            this.mRaiz = new Nodo(this.mK, ruta);
            this.mAltura = 1;
            return;
        }

        Split splitted = insert(this.mRaiz, ruta, 1);
        if (splitted != null) {

            Nodo ptr = this.mRaiz;
            this.mRaiz = new Nodo(this.mK, splitted.getRuta());
            this.mRaiz.mPunteros[0] = ptr;
            this.mRaiz.mPunteros[1] = splitted.getmPuntero();
            this.mAltura++;
        }
    }

    protected Split insert(Nodo node, Ruta ruta, int level) {
        Split splitted = null;
        Nodo ptr = null;
        int i = 0;
        while ((i < node.mB) && (ruta.getId() > (node.mLlaves[i]).getId())) {//Comparaciones con las llaves del nodo
            i++;
        }
        if ((i < node.mB) && ruta.getId() == (node.mLlaves[i]).getId()) {//Verifica si es el mismo elemnto a inserta para remplazar
            node.mLlaves[i] = ruta;
            return null;
        }
        if (level < this.mAltura) {
            splitted = insert(node.mPunteros[i], ruta, level + 1);
            if (splitted == null) {
                return null;
            } else {
                ruta = splitted.getRuta();
                ptr = splitted.getmPuntero();
            }
        }
        i = node.mB - 1;
        while ((i >= 0)
                && (node.mLlaves[i] == null || ruta.getId() < (node.mLlaves[i]).getId())) {
            node.mLlaves[i + 1] = node.mLlaves[i];
            node.mPunteros[i + 2] = node.mPunteros[i + 1];
            i--;
        }
        node.mLlaves[i + 1] = ruta;
        if (splitted != null) {
            node.mPunteros[i + 2] = splitted.getmPuntero();
        }
        node.mB++;
        if (node.mB > 2 * mK) {
            Nodo newnode = new Nodo(this.mK);
            newnode.mPunteros[this.mK] = node.mPunteros[node.mB];
            node.mPunteros[node.mB] = null;
            node.mB = this.mK + 1;
            for (i = 0; i < this.mK; i++) {
                newnode.mLlaves[i] = node.mLlaves[i + node.mB];
                node.mLlaves[i + node.mB] = null;
                newnode.mPunteros[i] = node.mPunteros[i + node.mB];
                node.mPunteros[i + node.mB] = null;
            }
            node.mB--;
            splitted = new Split(newnode, node.mLlaves[node.mB]);
            node.mLlaves[node.mB] = null;
            newnode.mB = this.mK;
            node.mB = this.mK;
            return splitted;
        }

        return null;
    }

    public String toDot() {
        StringBuilder b = new StringBuilder();

        b.append("digraph g { \n node [shape=record];\n");

        b.append(mRaiz.toDot());

        b.append("}");

        return b.toString();
    }

    public void eliminar(int id) {
        try {
            int nivel=1;
            Nodo padre=mRaiz;
            int indice=0;
            Nodo nodo = buscarElemento(mRaiz, id,nivel,padre,indice);
            for (int i = 0; i < nodo.mLlaves.length; i++) {
                if (nodo.mLlaves[i] != null && nodo.mLlaves[i].getId() == id) {
                    nodo.mLlaves[i] = null;
                    nodo.mB--;
                }
            }
            if (nivel<mAltura) {
                Nodo menorALADerecha=obtenreMayorALaDerecha(padre.mPunteros[indice+1],padre);
                nodo.mLlaves[indice]=menorALADerecha.mLlaves[0];
                 if (menorALADerecha.mB<this.mK) {
                    if (indice==0) {
                        if (padre.mPunteros[1].mB>this.mK) {
                            padre.mLlaves[indice]=prestar(menorALADerecha, padre.mPunteros[1], padre.mLlaves[0]);
                        }else{  
                            padre.mPunteros[0]=fusionarNodos(menorALADerecha, padre.mPunteros[1], padre.mLlaves[0]);
                            padre.mLlaves[indice]=null;
                        }
                    }else{
                        if (padre.mPunteros[indice-1].mB>mK) {
                            padre.mLlaves[indice]=prestar(menorALADerecha, padre.mPunteros[indice-1], padre.mLlaves[indice]);
                        }else if(padre.mPunteros[indice+1].mB>mK){
                            padre.mLlaves[indice]=prestar(menorALADerecha, padre.mPunteros[indice+1], padre.mLlaves[indice]);
                        }else{
                            padre.mPunteros[indice]=fusionarNodos(menorALADerecha, padre.mPunteros[indice-1], padre.mLlaves[indice]);
                            padre.mLlaves[indice]=null;
                        }
                    }
                }
            }else{
                if (nodo.mB<this.mK) {
                    if (indice==0) {
                        if (padre.mPunteros[1].mB>this.mK) {
                            padre.mLlaves[indice]=prestar(nodo, padre.mPunteros[1], padre.mLlaves[0]);
                        }else{
                            
                            padre.mPunteros[0]=fusionarNodos(nodo, padre.mPunteros[1], padre.mLlaves[0]);
                            padre.mLlaves[indice]=null;
                        }
                    }else{
                        if (padre.mPunteros[indice-1].mB>mK) {
                            padre.mLlaves[indice]=prestar(nodo, padre.mPunteros[indice-1], padre.mLlaves[indice]);
                        }else if(padre.mPunteros[indice+1].mB>mK){
                            padre.mLlaves[indice]=prestar(nodo, padre.mPunteros[indice+1], padre.mLlaves[indice]);
                        }else{
                            padre.mPunteros[indice]=fusionarNodos(nodo, padre.mPunteros[indice-1], padre.mLlaves[indice]);
                            padre.mLlaves[indice]=null;
                        }
                    }
                    
                }
            }
        } catch (Exception e) {  
        }

    }

    
    
    public Nodo buscarElemento(Nodo nodo, int id,int nivel,Nodo padre,int indice) {
        int aux = 0;
        for (int i = 0; i < nodo.mLlaves.length; i++) {
            if (nodo.mLlaves[i] != null && nodo.mLlaves[i].getId() == id) {
                return nodo;
            } else if (nodo.mLlaves[i] != null && nodo.mLlaves[i].getId() < id) {
                aux++;
            } else {
                break;
            }
        }
        if (nodo.mPunteros.length > 0) {
            nivel++;
            padre=nodo;
            indice=aux;
            return buscarElemento(nodo.mPunteros[aux], id,nivel,padre,indice);
        } else {
            return null;
        }

    }
    
    
    public Ruta prestar(Nodo prestador ,Nodo aPrestar,Ruta Padre){
        Ruta rutaNuevoPadre=null;
        aPrestar.mLlaves[mK]=Padre;
        if (aPrestar.mLlaves[0].getId()>prestador.mLlaves[0].getId()) {
            rutaNuevoPadre=prestador.mLlaves[0];
            for (int i = 0; i < prestador.mLlaves.length; i++) {
                prestador.mLlaves[i]=prestador.mLlaves[i+1];
            }
        }else{
            for (int i = prestador.mLlaves.length; i == mK; i--) {
                if (prestador.mLlaves[i]!=null) {
                    rutaNuevoPadre=prestador.mLlaves[i];
                    prestador.mLlaves[i]=null;
                }
            }
        }
        
        return rutaNuevoPadre;
    }
    
        public Nodo fusionarNodos(Nodo prestador ,Nodo aPrestar,Ruta Padre){
        Nodo nodo=new Nodo(mK);
        if (aPrestar.mLlaves[0].getId()>prestador.mLlaves[0].getId()) {
            nodo.mLlaves[0]=prestador.mLlaves[0];
            nodo.mLlaves[1]=Padre;
            nodo.mLlaves[2]=aPrestar.mLlaves[0];
            nodo.mLlaves[3]=aPrestar.mLlaves[1];
            
        }else{
            nodo.mLlaves[3]=prestador.mLlaves[0];
            nodo.mLlaves[2]=Padre;
            nodo.mLlaves[1]=aPrestar.mLlaves[0];
            nodo.mLlaves[0]=aPrestar.mLlaves[1];
        }
        
        return nodo;
    }
    public Nodo obtenreMayorALaDerecha(Nodo nodo,Nodo padre){
 
        if (nodo.mPunteros!=null) {
            padre=nodo.mPunteros[0];
           return  obtenreMayorALaDerecha(nodo.mPunteros[0], padre);
        }else{
            return nodo;
        }

                
    }
}
