/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dawalejancroc;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Alex
 */
public class Bombo {
    
    //Creamos un array para el bombo y atributos que nos ayudarán
    //a la creacion de los metodos
    private ArrayList<Integer> array;
    Random aleatorio = new Random();
    int numeroAleatorio = 0;
    int numeroSacado = 0;
    int longitud = 90;
    
    //Contructor del bombo, genera un array para rellenar las bolas
    public Bombo() {
        array = new ArrayList<>();
        rellenarBolas();
    }
    
    //Getter y setter
    public ArrayList<Integer> getArray() {
        return array;
    }

    public void setArray(ArrayList<Integer> array) {
        this.array = array;
    }
    
    //Con este metodo comprobamos si el bombo está vacío, para ello usamos
    //la funcion de ArrayList .isEmpty y con esto devolveremos un boolean
    public boolean estaVacia() {
        if (array.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
