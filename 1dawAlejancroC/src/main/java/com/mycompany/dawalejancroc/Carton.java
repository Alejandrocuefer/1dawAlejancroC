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
    private int[][] cartones = new int[3][9];
    
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
    
    //Metodo para rellenar el carton de numeros, en este metodo tenemos que controlar
    //que los numeros no se repitan, asi que hemos creado un metodo auxiliar llamado
    //comprobarNumero(); que nos ayudará en eso.
    public void rellenarCarton() {

        int num = 0;

        //Tenemos un booleano que nos marcará, a través de la funcion 
        //comprobarNumero, si está o no repetido, el numero.
        boolean check = false;

        
        //Recorremos el array dandole a la variable num un valor aleatorio y
        //probamos con comprobarNumero si está o no repetido el numero en el
        //array
        
        for (int i = 0; i < cartones.length; i++) {

            for (int j = 0; j < cartones[i].length; j++) {

                do {
                    num = generarNumero(i, j);
                    if (check) {
                        check = comprobarNumero(cartones, num, i);
                    }
                } while (check);
                cartones[i][j] = num;

            }
//            Arrays.sort(cartones[i]);
        }
    }
    
    //Metodo que comprueba que el numero no está repetido
    static boolean comprobarNumero(int carton[][], int num, int nCarton) {

        //Tenemos un booleano que será el que marcará si está o no repetido el numero
        boolean repetido = false;

        // En el bucle vamos probando que el numero que nos han mandado a la funcion
        // esté repetido en el array, y si lo está marca como verdadero el booleano.
        for (int i = 0; i < carton[nCarton].length; i++) {
            if (num == carton[nCarton][i]) {
                repetido = true;
            }
        }
        return repetido;
    }
    
    //Un bucle for each que nos muestra el cartón
    public void mostarCarton() {

        for (int[] aux : cartones) {
            for (int aux2 : aux) {
                System.out.print(aux2 + " \t");
            }
            System.out.println("");
        }
    }
    
    //Metodo para tachar la casilla según el número que contenga, que se lo
    //pasaremos por parametro.
    public void tacharCasilla(int num) {
        for (int i = 0; i < cartones.length; i++) {
            for (int j = 0; j < cartones[i].length; j++) {
                if (cartones[i][j] == num) {
                    cartones[i][j] = 0;
                }
            }
        }
    }
    
    //Metodo para comprobar si la linea está tachada entera, en nuestra logica del
    //programa esto se comprueba si la linea tiene todo 0, por lo que la suma de 
    //toda la fila debe ser 0 si está tachada.
    public void comprobarLinea() {
        int num = 0;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 9; j++) {
                num += cartones[i][j];

            }
            if (num == 0) {
                System.out.println("Comprobao");
            } else {
                System.out.println("no comprobao");
            }
        }

    }
    
    //Metodo para comprobar si tenemos todo el carton sin numeros, esto lo compruebo
    //del mismo modo que comprobarLinea, pero a diferencia que esto lo haremos si
    //toda la matriz nos da 0
    public void comprobarBingo() {
        int num = 0;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 9; j++) {
                num += cartones[i][j];

            }
        }
        if (num == 0) {
            System.out.println("Comprobao");
        } else {
            System.out.println("no comprobao");
        }
    }

    public int[][] getCartones() {
        return cartones;
    }

    public void setCartones(int[][] cartones) {
        this.cartones = cartones;
    }
}
