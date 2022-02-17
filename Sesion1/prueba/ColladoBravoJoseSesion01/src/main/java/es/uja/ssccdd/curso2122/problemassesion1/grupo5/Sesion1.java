/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.uja.ssccdd.curso2122.problemassesion1.grupo5;

import static es.uja.ssccdd.curso2122.problemassesion1.grupo5.Utils.COCHES_A_GENERAR;
import static es.uja.ssccdd.curso2122.problemassesion1.grupo5.Utils.MAXIMO_COCHES_POR_RESERVA;
import static es.uja.ssccdd.curso2122.problemassesion1.grupo5.Utils.RESERVAS_A_GENERAR;
import es.uja.ssccdd.curso2122.problemassesion1.grupo5.Utils.TipoReserva;
import static es.uja.ssccdd.curso2122.problemassesion1.grupo5.Utils.VALOR_GENERACION;
import static es.uja.ssccdd.curso2122.problemassesion1.grupo5.Utils.random;
import java.util.ArrayList;

/**
 *
 * @author Adrian Luque Luque (alluque)
 */
public class Sesion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Reserva> listaReservas;
        
        System.out.println("Se inicia la ejecución del hilo principal");
        
        listaReservas=new ArrayList<>();
        for (int i = 0; i < RESERVAS_A_GENERAR; i++) {
            int reservaRandom = random.nextInt(VALOR_GENERACION);
            listaReservas.add(new Reserva(i+1, TipoReserva.getTipoReserva(reservaRandom), random.nextInt(MAXIMO_COCHES_POR_RESERVA)+1));
        }
        
        ArrayList<Coche> cochesPendientes;
        cochesPendientes = new ArrayList<>();
        int siguienteReserva = 0;
        
        for (int i = 0; i < COCHES_A_GENERAR; i++) {
            int reservaRandom = random.nextInt(VALOR_GENERACION);
            Coche coche = new Coche(i+1, TipoReserva.getTipoReserva(reservaRandom));
            cochesPendientes.add(coche);
            
            int reservaComprobada=0;
            boolean encola = false;
            while(!encola && reservaComprobada < RESERVAS_A_GENERAR){
                if(listaReservas.get(siguienteReserva).addCoche(coche)){
                    encola=true;
                }
                reservaComprobada++;
                siguienteReserva=(siguienteReserva + 1) % RESERVAS_A_GENERAR;
            }
        }
        
        System.out.println("(Hilo principal) Lista de colas de impresion");
        listaReservas.forEach(reserva -> {
            System.out.println("reserva = " + reserva);
        });
        
        System.out.println("Ha finalizado la ejecución del hilo principal");
    }
    
}
