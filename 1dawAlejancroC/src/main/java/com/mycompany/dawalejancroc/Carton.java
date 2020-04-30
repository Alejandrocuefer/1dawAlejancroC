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
        int numGenerado = 0;
        switch (i) {
            case 0:
                switch (j) {
                    //Las filas devolverán valores que estén entre los 3 primeros
                    //valores de la fila, en la primera 1-3, en la segunda 10-13...
                    case 0:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 1;
                        break;
                    case 1:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 10;
                        break;
                    case 2:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 20;
                        break;
                    case 3:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 30;
                        break;
                    case 4:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 40;
                        break;
                    case 5:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 50;
                        break;
                    case 6:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 60;
                        break;
                    case 7:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 70;
                        break;
                    case 8:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 80;
                        break;
                }
                return numGenerado;
            case 1:
                switch (j) {
                    //La segunda fila haremos lo mismo pero entre 4 y 7
                    case 0:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 4;
                        break;
                    case 1:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 14;
                        break;
                    case 2:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 24;
                        break;
                    case 3:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 34;
                        break;
                    case 4:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 44;
                        break;
                    case 5:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 54;
                        break;
                    case 6:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 64;
                        break;
                    case 7:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 74;
                        break;
                    case 8:
                        numGenerado = this.cartones[i][j] = r.nextInt(3) + 84;
                        break;
                }
                return numGenerado;

            case 2:
                switch (j) {
                    //Y la tercera será entre 8 y 9
                    case 0:
                        numGenerado = this.cartones[i][j] = r.nextInt(2) + 8;
                        break;
                    case 1:
                        numGenerado = this.cartones[i][j] = r.nextInt(2) + 18;
                        break;
                    case 2:
                        numGenerado = this.cartones[i][j] = r.nextInt(2) + 28;
                        break;
                    case 3:
                        numGenerado = this.cartones[i][j] = r.nextInt(2) + 38;
                        break;
                    case 4:
                        numGenerado = this.cartones[i][j] = r.nextInt(2) + 48;
                        break;
                    case 5:
                        numGenerado = this.cartones[i][j] = r.nextInt(2) + 58;
                        break;
                    case 6:
                        numGenerado = this.cartones[i][j] = r.nextInt(2) + 68;
                        break;
                    case 7:
                        numGenerado = this.cartones[i][j] = r.nextInt(2) + 78;
                        break;
                    case 8:
                        numGenerado = this.cartones[i][j] = r.nextInt(2) + 88;
                        break;

                }
                return numGenerado;

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
        }
        generarCeros();
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
                System.out.println("¡Perfecto, has tachado una linea entera!");
            } else {
                System.out.println("aún te faltan casillas por tachar");
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
            System.out.println("Has hecho bingo, ¡enhorabuena!");
        } else {
            System.out.println("aún te faltan casillas por tachar");
        }
    }

    public int[][] getCartones() {
        return cartones;
    }

    public void setCartones(int[][] cartones) {
        this.cartones = cartones;
    }

    // Metodo para generar 0
    public void generarCeros() {
        //Creamos un numero auxiliar para darle valores a la columna de la matriz
        int aux = 0;

        //Tambien creamos una matriz copia para hacer los cambios sobre ella y
        //que cada vez que recorramos el bucle nos aseguramos de generar bien las
        //condiciones para rellenar los 0
        int[][] cartonesCopia = new int[3][9];

        //Añadimos un boolean que recorra el bucle si no se cumple alguna condicion
        boolean conf = false;

        do {
            conf = false;
            //Ahora hacemos 2 bucles for para crear la copia del carton
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 9; j++) {
                    aux = cartones[i][j];
                    cartonesCopia[i][j] = aux;
                }
            }
            //Creamos 2 bucles for para rellenar los 0, teniendo en cuenta que no 
            //tendremos más de 4 ceros por fila
            Random r = new Random();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    //Metemos dentro un bucle que nos genere numeros y luego,
                    //como minimo un 0
                    do {
                        aux = r.nextInt(9);

                    } while (cartonesCopia[i][aux] == 0);
                    cartonesCopia[i][aux] = 0;
                }
            }

            //Creo una condicion que compruebe que los numeros se han generado sean
            //minimo un 0 y no sea todo 0
            if ((cartonesCopia[0][0] == 0 && cartonesCopia[1][0] == 0 && cartonesCopia[2][0] == 0)
                    || (cartonesCopia[0][0] != 0 && cartonesCopia[1][0] != 0 && cartonesCopia[2][0] != 0)) {
                conf = true;
            }

            if ((cartonesCopia[0][1] == 0 && cartonesCopia[1][1] == 0 && cartonesCopia[2][1] == 0)
                    || (cartonesCopia[0][1] != 0 && cartonesCopia[1][1] != 0 && cartonesCopia[2][1] != 0)) {
                conf = true;
            }

            if ((cartonesCopia[0][2] == 0 && cartonesCopia[1][2] == 0 && cartonesCopia[2][2] == 0)
                    || (cartonesCopia[0][2] != 0 && cartonesCopia[1][2] != 0 && cartonesCopia[2][2] != 0)) {
                conf = true;
            }

            if ((cartonesCopia[0][3] == 0 && cartonesCopia[1][3] == 0 && cartonesCopia[2][3] == 0)
                    || (cartonesCopia[0][3] != 0 && cartonesCopia[1][3] != 0 && cartonesCopia[2][3] != 0)) {
                conf = true;
            }

            if ((cartonesCopia[0][4] == 0 && cartonesCopia[1][4] == 0 && cartonesCopia[2][4] == 0)
                    || (cartonesCopia[0][4] != 0 && cartonesCopia[1][4] != 0 && cartonesCopia[2][4] != 0)) {
                conf = true;
            }

            if ((cartonesCopia[0][5] == 0 && cartonesCopia[1][5] == 0 && cartonesCopia[2][5] == 0)
                    || (cartonesCopia[0][5] != 0 && cartonesCopia[1][5] != 0 && cartonesCopia[2][5] != 0)) {
                conf = true;
            }

            if ((cartonesCopia[0][6] == 0 && cartonesCopia[1][6] == 0 && cartonesCopia[2][6] == 0)
                    || (cartonesCopia[0][6] != 0 && cartonesCopia[1][6] != 0 && cartonesCopia[2][6] != 0)) {
                conf = true;
            }

            if ((cartonesCopia[0][7] == 0 && cartonesCopia[1][7] == 0 && cartonesCopia[2][7] == 0)
                    || (cartonesCopia[0][7] != 0 && cartonesCopia[1][7] != 0 && cartonesCopia[2][7] != 0)) {
                conf = true;
            }

            if ((cartonesCopia[0][8] == 0 && cartonesCopia[1][8] == 0 && cartonesCopia[2][8] == 0)
                    || (cartonesCopia[0][8] != 0 && cartonesCopia[1][8] != 0 && cartonesCopia[2][8] != 0)) {
                conf = true;
            }

        } while (conf);

        //Ahora le meto al carton los valores de cartonesCopia para asegurarnos
        //de no cambiar los valores durante el programa
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                aux = cartonesCopia[i][j];
                cartones[i][j] = aux;
            }
        }

    }

}
