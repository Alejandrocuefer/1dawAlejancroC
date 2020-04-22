/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dawalejancroc;

/**
 *
 * @author Alex
 */
public class Bola {

    private int numero;

    public Bola(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

//    public void setNumero(int numero) {
//        this.numero = numero;
//    }
    @Override
    public String toString() {
        return "Bola{" + "numero=" + numero + '}';
    }
}
