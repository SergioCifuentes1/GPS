/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps.Grafos;

/**
 *
 * @author sergio
 */
public class Camino {
    private Ubicacion origen;
    private Ubicacion destino;
    private double distancia;
    private double tiempoEnVehiculo;
    private double tiempoAPie;
    private double consumoDeGas;
    private double desgastePersonal;

    public Camino(Ubicacion origen, Ubicacion destino, double distancia, double tiempoEnVehiculo, double tiempoAPie, double consumoDeGas, double desgastePersonal) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.tiempoEnVehiculo = tiempoEnVehiculo;
        this.tiempoAPie = tiempoAPie;
        this.consumoDeGas = consumoDeGas;
        this.desgastePersonal = desgastePersonal;
    }

    public Ubicacion getOrigen() {
        return origen;
    }

    public Ubicacion getDestino() {
        return destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getTiempoEnVehiculo() {
        return tiempoEnVehiculo;
    }

    public double getTiempoAPie() {
        return tiempoAPie;
    }

    public double getConsumoDeGas() {
        return consumoDeGas;
    }

    public double getDesgastePersonal() {
        return desgastePersonal;
    }
    
    
}
