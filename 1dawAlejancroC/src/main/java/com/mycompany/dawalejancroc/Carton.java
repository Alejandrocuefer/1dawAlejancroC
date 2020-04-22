/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dawalejancroc;

import java.util.Random;

/**
 *
 * @author Alex
 */
public class Carton {
    //Creamos el array del Carton, las dimensiones son 3x9
    int[][] cartones = new int[3][9];
    
    //Creamos un metodo que nos genere el numero que vamos a poner en las casillas
    //Este numero tiene que ser aleatorio y debe cumplir la condicion que vaya en
    //orden ascendente, por lo que marcaré unos intervalos para poder controlar que
    //por ejemplo haya un 9 en la primera casilla y ya no podamos rellenar las otras
    //2 restantes. Esto lo haré mediante switch cases y una variable Random()
    private int generarNumero(int i, int j) {
    
        Random r = new Random();
        switch (i) {
            case 0:
                switch (j) {
                    //Las filas devolverán valores que estén entre los 3 primeros
                    //valores de la fila, en la primera 1-3, en la segunda 10-13...
                    case 0:
                        return this.cartones[i][j] = r.nextInt(3) + 1;
                    case 1:
                        return this.cartones[i][j] = r.nextInt(3) + 10;
                    case 2:
                        return this.cartones[i][j] = r.nextInt(3) + 20;
                    case 3:
                        return this.cartones[i][j] = r.nextInt(3) + 30;
                    case 4:
                        return this.cartones[i][j] = r.nextInt(3) + 40;
                    case 5:
                        return this.cartones[i][j] = r.nextInt(3) + 50;
                    case 6:
                        return this.cartones[i][j] = r.nextInt(3) + 60;
                    case 7:
                        return this.cartones[i][j] = r.nextInt(3) + 70;
                    case 8:
                        return this.cartones[i][j] = r.nextInt(3) + 80;
                }
            case 1:
                switch (j) {
                    //La segunda fila haremos lo mismo pero entre 4 y 6
                    case 0:
                        return this.cartones[i][j] = r.nextInt(3) + 4;
                    case 1:
                        return this.cartones[i][j] = r.nextInt(3) + 14;
                    case 2:
                        return this.cartones[i][j] = r.nextInt(3) + 24;
                    case 3:
                        return this.cartones[i][j] = r.nextInt(3) + 34;
                    case 4:
                        return this.cartones[i][j] = r.nextInt(3) + 44;
                    case 5:
                        return this.cartones[i][j] = r.nextInt(3) + 54;
                    case 6:
                        return this.cartones[i][j] = r.nextInt(3) + 64;
                    case 7:
                        return this.cartones[i][j] = r.nextInt(3) + 74;
                    case 8:
                        return this.cartones[i][j] = r.nextInt(3) + 84;
                }

            case 2:
                switch (j) {
                    //Y la tercera será entre 7 y 9
                    case 0:
                        return this.cartones[i][j] = r.nextInt(3) + 7;
                    case 1:
                        return this.cartones[i][j] = r.nextInt(3) + 17;
                    case 2:
                        return this.cartones[i][j] = r.nextInt(3) + 27;
                    case 3:
                        return this.cartones[i][j] = r.nextInt(3) + 37;
                    case 4:
                        return this.cartones[i][j] = r.nextInt(3) + 47;
                    case 5:
                        return this.cartones[i][j] = r.nextInt(3) + 57;
                    case 6:
                        return this.cartones[i][j] = r.nextInt(3) + 67;
                    case 7:
                        return this.cartones[i][j] = r.nextInt(3) + 77;
                    case 8:
                        return this.cartones[i][j] = r.nextInt(3) + 87;

                }

        }
        //Para asegurar que no haya ninguna casilla a null, si por algún casual
        //falla, tendremos  esto para dejarla a 0
        return 0;  
    }
}
