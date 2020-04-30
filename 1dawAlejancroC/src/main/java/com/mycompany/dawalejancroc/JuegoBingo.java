/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dawalejancroc;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class JuegoBingo {
    public static void main(String[] args) {
        // Creamos 2 objetos, un carton y un bombo
        Carton carton = new Carton();
        Bombo bombo = new Bombo();

        //Imprimo el carton, primero lo relleno y lo muestro
        System.out.println("Imprimiento carton...");
        carton.rellenarCarton();
        carton.mostarCarton();

//        Imprimir el número de la bola sacada.
        System.out.println("Sacamos una bola...");
        System.out.println(bombo.sacarBola());
        System.out.println("------------------");

//        Comprobar si esa bola está presente en el cartón y proceder a “tacharla”, 
//        informando con un mensaje por consola.
        carton.tacharCasilla(bombo.sacarBola());

//        Comprobar si, después de haber tachado alguna casilla, se hace línea 
//        (se tachan todos los números de una fila del cartón). Entonces la aplicación 
//        cantará "línea", mostrando un mensaje, indicando la fila en la que se ha 
//        producido.
        carton.comprobarLinea();

//        Comprobar si, después de haber cantado línea, se puede cantar bingo 
//        (se tachan todos los números del cartón). En este caso la aplicación 
//        cantará "bingo", mostrando un mensaje también y el juego termina.
        carton.comprobarBingo();

//        También se debe mostrar el estado del cartón (números tachados y números activos).
        carton.mostarCarton();

//        Para sacar una bola nueva el usuario debe pulsar alguna tecla.
        String seguir;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Pulse una tecla para continuar");

        try {

            seguir = teclado.nextLine();
            System.out.println(bombo.sacarBola());

        } catch (Exception e) {
        }
        System.out.println("----------------------------------------------");
        System.out.println("-----------------------");
        System.out.println("----Juego del bingo----");
        System.out.println("-----------------------");

        System.out.println("Generando un carton...");
        System.out.println("-----------------------");
        carton.rellenarCarton();
        carton.mostarCarton();
        System.out.println("-----------------------");

        int opcion = 0;

        do {
            System.out.println("¿Quieres sacar bola?");
            System.out.println("1. Si");
            System.out.println("2. No");
            opcion = teclado.nextInt();
            int numero = bombo.sacarBola();
            System.out.println("Has sacado la bola " + numero);
            carton.tacharCasilla(numero);
            carton.mostarCarton();
        } while (opcion == 1);

        System.out.println("Comprobemos si has sacado alguna linea");
        carton.comprobarLinea();
        System.out.println("Comprobemos si has hecho bingo");
        carton.comprobarBingo();

        carton.mostarCarton();
    }
}
