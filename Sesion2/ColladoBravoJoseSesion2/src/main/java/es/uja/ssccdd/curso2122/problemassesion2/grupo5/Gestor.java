/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssccdd.curso2122.problemassesion2.grupo5;

import static es.uja.ssccdd.curso2122.problemassesion2.grupo5.Utils.TIEMPO_ESPERA_MAX;
import static es.uja.ssccdd.curso2122.problemassesion2.grupo5.Utils.TIEMPO_ESPERA_MIN;
import static es.uja.ssccdd.curso2122.problemassesion2.grupo5.Utils.TipoReserva.PREMIUM;
import static es.uja.ssccdd.curso2122.problemassesion2.grupo5.Utils.random;
import java.util.ArrayList;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 *
 * @author UJA
 */
public class Gestor implements Runnable {

    private final int iD;
    private final ArrayList<Coche> coches;
    private final ArrayList<Reserva> reservas;
    private final ArrayList<Coche> cochesNoEncontrados;
    private int cochesProcesados;
    private boolean interrumpido;
    private int siguienteReserva;

    public Gestor(int iD, ArrayList<Coche> coches, ArrayList<Reserva> reservas, ArrayList<Coche> cochesNoEncontrados) {
        this.iD = iD;
        this.coches = coches;
        this.reservas = reservas;
        this.cochesNoEncontrados = cochesNoEncontrados;
        this.cochesProcesados = 0;
        this.interrumpido = false;
        this.siguienteReserva = 0;
    }

    @Override
    public void run() {
        System.out.println("El gestor " + iD + " ha comenzado a preparar los coches.");

        for (int i = 0; i < coches.size(); i++) {
            if (!interrumpido || (interrumpido && coches.get(i).getCalidadCoche() == PREMIUM)) {
                encolarCocche(i);
                cochesProcesados++;
                try {
                    SECONDS.sleep(TIEMPO_ESPERA_MAX- random.nextInt(TIEMPO_ESPERA_MIN+2));
                } catch (InterruptedException ex) {
                    if (coches.size() != cochesProcesados) {
                        interrumpido = true;
                    }
                }
            }
        }
        System.out.println(this.toString());
    }

    private boolean encolarCocche(int indiceCoche) {
        int reservasComprobadas = 0;
        boolean encolado = false;
        while (!encolado && reservasComprobadas < reservas.size()) {
            if (reservas.get(siguienteReserva).addCoche(coches.get(indiceCoche))) {
                encolado = true;
            }

            reservasComprobadas++;
            siguienteReserva = (siguienteReserva + 1) % reservas.size();
        }

        if (!encolado) {
            cochesNoEncontrados.add(coches.get(indiceCoche));
        }

        return encolado;
    }

    private float porcentajeCompletado() {
        return 1.0f * cochesProcesados / coches.size();
    }

    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("\n\nGestor ").append(iD).append(" ");

        if (interrumpido) {
            mensaje.append("\"INTERRUMPIDO\"");
        }

        mensaje.append(" ").append(coches.size()).append(" coches disponibles, de los cuales se han procesado el ").append(porcentajeCompletado() * 100).append("%.");

        reservas.forEach(res -> {
            mensaje.append("\n\t").append(res.toString());
        });

        if (cochesProcesados < coches.size()) {
            mensaje.append("\n\tSe han quedado fuera ").append(coches.size() - cochesProcesados).append(" coches por falta de tiempo.");
        }

        return mensaje.toString();
    }

}
