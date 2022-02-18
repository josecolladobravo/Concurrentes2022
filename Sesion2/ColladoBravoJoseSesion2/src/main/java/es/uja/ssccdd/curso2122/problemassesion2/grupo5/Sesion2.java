/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uja.ssccdd.curso2122.problemassesion2.grupo5;

import static es.uja.ssccdd.curso2122.problemassesion2.grupo5.Utils.COCHES_A_GENERAR_MAX;
import static es.uja.ssccdd.curso2122.problemassesion2.grupo5.Utils.COCHES_A_GENERAR_MIN;
import static es.uja.ssccdd.curso2122.problemassesion2.grupo5.Utils.GESTORES_A_GENERAR;
import static es.uja.ssccdd.curso2122.problemassesion2.grupo5.Utils.MAXIMO_COCHES_POR_RESERVA;
import static es.uja.ssccdd.curso2122.problemassesion2.grupo5.Utils.TIEMPO_ESPERA_HILO_PRINCIPAL;
import es.uja.ssccdd.curso2122.problemassesion2.grupo5.Utils.TipoReserva;
import static es.uja.ssccdd.curso2122.problemassesion2.grupo5.Utils.TipoReserva.getTipoReserva;
import static es.uja.ssccdd.curso2122.problemassesion2.grupo5.Utils.VALOR_GENERACION;
import static es.uja.ssccdd.curso2122.problemassesion2.grupo5.Utils.random;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UJA
 */
public class Sesion2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int idReserva = 0;
        int idCoches = 0;
        int idGestores = 0;

        ArrayList<Thread> hilosGestores = new ArrayList<>();
        ArrayList<Coche> cochesPerdidos = new ArrayList<>();

        System.out.println("HILO-Principal Ha iniciado la ejecución");

        for (int i = 0; i < GESTORES_A_GENERAR; i++) {
            ArrayList<Reserva> listaReservas = new ArrayList<>();
            listaReservas.add(new Reserva(idReserva++, random.nextInt(MAXIMO_COCHES_POR_RESERVA) + 1, getTipoReserva(random.nextInt(VALOR_GENERACION))));

            int cochesAGenerar = random.nextInt(COCHES_A_GENERAR_MAX - COCHES_A_GENERAR_MIN) + COCHES_A_GENERAR_MIN;
            ArrayList<Coche> listaCoches = new ArrayList<>();
            for (int j = 0; j < cochesAGenerar; j++) {
                int cocheAleatorio = random.nextInt(VALOR_GENERACION);
                listaCoches.add(new Coche(idCoches++, TipoReserva.getTipoReserva(cocheAleatorio)));
            }

            Gestor gestor = new Gestor(idGestores++, listaCoches, listaReservas, cochesPerdidos);
            Thread thread = new Thread(gestor);
            thread.start();
            hilosGestores.add(thread);
        }

        System.out.println("HILO-Principal Espera a la finalización de los gestores");

        try {
            TimeUnit.SECONDS.sleep(TIEMPO_ESPERA_HILO_PRINCIPAL);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sesion2.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("HILO-Principal Solicita la finalización de los gestores");

        for (int i = 0; i < GESTORES_A_GENERAR;i++) {
            hilosGestores.get(i).interrupt();
        }

        System.out.println("HILO-Principal Espera a los gestores");

        for (int i = 0;i < GESTORES_A_GENERAR;i++) {
            try {
                hilosGestores.get(i).join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Sesion2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("\nLos siguientes " + cochesPerdidos.size() + " coches no han podido ser insertados: ");
        cochesPerdidos.forEach(c -> {
            System.out.println(c.toString());
        });
        
        System.out.println("HILO-Principal Ha finalizado la ejecución");

    }
}
