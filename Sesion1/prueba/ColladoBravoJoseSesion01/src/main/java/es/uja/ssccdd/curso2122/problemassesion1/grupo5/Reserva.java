/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uja.ssccdd.curso2122.problemassesion1.grupo5;

import es.uja.ssccdd.curso2122.problemassesion1.grupo5.Utils.TipoReserva;
import java.util.ArrayList;

/**
 *
 * @author Josec
 */
public class Reserva {

    private final int iD;
    private final TipoReserva tipoReserva;
    private final int cantidad;
    private ArrayList<Coche> colaReservas;

    public Reserva(int iD, TipoReserva tipoReserva, int cantidad) {
        this.iD = iD;
        this.tipoReserva = tipoReserva;
        this.cantidad = cantidad;
        this.colaReservas = new ArrayList<>();
    }

    public boolean addCoche(Coche coche) {
        boolean resultado = false;
        if (coche.getTipoReserva().equals(tipoReserva) && colaReservas.size() < cantidad) {
            colaReservas.add(coche);
            resultado = true;
        }
        return resultado;
    }

    public int getiD() {
        return iD;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public int getCantidad() {
        return cantidad;
    }

    public ArrayList<Coche> getColaReservas() {
        return colaReservas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reserva{iD=").append(iD);
        sb.append(", tipoReserva=").append(tipoReserva);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", colaReservas=").append(colaReservas);
        sb.append('}');
        return sb.toString();
    }



    



}
