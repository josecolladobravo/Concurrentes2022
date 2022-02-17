/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uja.ssccdd.curso2122.problemassesion1.grupo5;

import es.uja.ssccdd.curso2122.problemassesion1.grupo5.Utils.TipoReserva;

/**
 *
 * @author Josec
 */
public class Coche {
    private final int iD;
    private final TipoReserva tipoReserva;

    public Coche(int iD, TipoReserva tipoReserva) {
        this.iD = iD;
        this.tipoReserva = tipoReserva;
    }

    public int getiD() {
        return iD;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    @Override
    public String toString() {
        return "Coche{" + "iD=" + iD + ", tipoReserva=" + tipoReserva + '}';
    }

    
}
