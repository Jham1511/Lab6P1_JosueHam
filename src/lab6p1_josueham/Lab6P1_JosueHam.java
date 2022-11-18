package lab6p1_josueham;

import java.util.Random;
import java.util.Scanner;

public class Lab6P1_JosueHam {

    static Scanner leer = new Scanner(System.in);
    static Random aleatorio = new Random();

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println();
            System.out.println("----- Bienvenido al menú del programa -----");
            System.out.println("1 -> Ejercicio 1 (Turing)");
            System.out.println("2 -> Ejercicio 2 (Constante de Kaprekar)");
            System.out.println("3 -> Salir del programa");
            System.out.println("Ingrese la opcion que desea: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.println("Ingrese el tamaño del arreglo: ");
                    int tam = leer.nextInt();
                    System.out.println("Ejemplo de cadena de instrucciones: RRRXLX");
                    System.out.println("Ingrese la cadena de instrucciones: ");
                    String cadena = leer.next().toUpperCase();

                    if (cadena.length() == tam) {
                        int[] arr = arregloRandom(tam);
                        imprimir(arr);
                        System.out.println();
                        System.out.println("Resultado de la cadena: ");
                        System.out.println(cadenaInstrucciones(cadena, arr));
                    }//Fin if validacion
                    else {
                        System.out.println("El tamaño de la cadena de instrucciones debe ser igual al tamaño del arreglo");
                    }//Fin else

                }//Fin case 1
                break;

                case 2: {
                    System.out.println("Ingrese el numero que desea de 4 digitos: ");
                    int num = leer.nextInt();

                    String digitos = Integer.toString(num);
                    if (digitos.length() == 4) {
                        imprimir (arrayDeNumEntero(num));
                        int[] arreglo = arrayDeNumEntero(num); 
                        System.out.println();
                        System.out.println("Arreglo organizado: ");
                        imprimir (organizarMenores (arreglo));
                    }//Fin if
                    else {
                        System.out.println("El numero ingresado tiene que ser de 4 digitos");
                    }//Fin else validacion 4 digitos 

                }//Fin case 2
                break;

                default:
                    System.out.println("Saliendo del programa...");
            }//Fin del switch
        } while (opcion != 3);
    }//Fin del main

    public static int[] arregloRandom(int tam) {
        int[] arregloRandom = new int[tam];

        for (int i = 0; i < arregloRandom.length; i++) {
            arregloRandom[i] = aleatorio.nextInt(10);
        }

        return arregloRandom;
    }//Fin metodo random

    public static void imprimir(int[] arreglo) {

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]" + " ");
        }
    }//Fin del metodo para imprimir

    public static String cadenaInstrucciones(String cadena, int[] arregloRandom) {

        int pos = 0;
        String res = "";

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == 'R') {
                pos++;
            }//Fin if
            else if (cadena.charAt(i) == 'L') {
                pos--;
            }//Fin else if
            else if (cadena.charAt(i) == 'X') {
                res += arregloRandom[pos];
            }//Fin else
        }//Fin del for i
        return res;
    }//Fin del metodo cadenaInstrucciones

   public static int[] arrayDeNumEntero (int num){
       String digitos = Integer.toString(num);
       int[] arrayEnteros = new int [digitos.length()];
       for (int i = 0; i < arrayEnteros.length; i++) {
           arrayEnteros[i] = digitos.charAt(i)- 48;
       }
       
       return arrayEnteros;
   }//Fin metodo organizar menores
   
   public static int [] organizarMenores (int [] arrayEnteros){
       
       int[] menores = new int [arrayEnteros.length];
       
       
       for (int i = 1; i < menores.length; i++) {
           for (int j = 0; j < menores.length - 1; j++) {
               if (arrayEnteros[j] > arrayEnteros [j+1]) {
                   int posGuardada = arrayEnteros [j];
                   arrayEnteros[j] = arrayEnteros[j +1];
                   arrayEnteros[j + 1] = posGuardada;
               }//Fin if
           }//Fin for j
       }//Fin for i
       menores = arrayEnteros;
       return menores;
   }//Fin del metodo organizar menores

    public static int [] organizarMayores (int [] organizarMenores){
        for (int i = 0; i < 10; i++) {
            
        }
        
        return null;
    }//Fin del metodo organizar mayores
}//Fin de la clase
