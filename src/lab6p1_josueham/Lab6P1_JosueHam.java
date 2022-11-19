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
                    int[] validacion = arrayDeNumEntero(num);

                    if (digitos.length() == 4 && Validacion4Digitos(validacion)) {
                        int resultado = Kaprekar(num);
                        System.out.println(resultado);
                        for (int i = 0; i < 8; i++) {
                            
                            if (resultado == 6174) {
                                break;
                            }
                            resultado = Kaprekar(resultado);
                            System.out.println(resultado);
                        }//Fin for i
                    }//Fin if
                    else {
                        System.out.println("El numero ingresado tiene que ser de 4 digitos");
                        System.out.println("Los 4 digitos del numero no pueden ser iguales");
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
            switch (cadena.charAt(i)) {
                //Fin if
                case 'R':
                    pos++;
                    break;
                //Fin else if
                case 'L':
                    pos--;
                    break;
                //Fin else
                case 'X':
                    res += arregloRandom[pos];
                    break;
                default:
                    break;
            }//Fin switch            
        }//Fin del for i
        return res;
    }//Fin del metodo cadenaInstrucciones

    public static int[] arrayDeNumEntero(int num) {
        String digitos = Integer.toString(num);
        int[] arrayEnteros = new int[digitos.length()];
        for (int i = 0; i < arrayEnteros.length; i++) {
            arrayEnteros[i] = digitos.charAt(i) - 48;
        }

        return arrayEnteros;
    }//Fin metodo pasar un num entero a array

    public static int[] organizarMenores(int[] arrayEnteros) { //Llamo como parametro mi arreglo de enteros para usarlo adentro del metodo
        int[] temp = arrayEnteros;//Le asigno a un arreglo nuevo mi arreglo de numeros enteros
        int[] menores = new int[arrayEnteros.length]; // Este sera el nuevo arreglo ordenado
        int pos = 0; //Inicializo mi contador en 0 que me servira como posicion inicial 

        while (pos < arrayEnteros.length) {
            int menor = arrayEnteros[pos];
            for (int i = pos; i < temp.length; i++) {
                if (temp[i] < menor) {
                    menor = temp[i]; // Encontrar el menor del arreglo temporal desde pos hasta length
                }
            }
            for (int i = pos; i < temp.length; i++) {
                if (temp[i] == menor) {
                    int aux = temp[pos];//Guarda el elemento del arreglo para no perder el valor al hacer el intercambio
                    temp[pos] = menor; //Hace el intercambio 
                    temp[i] = aux; //Hace el intercambio 
                }
            }
            menores[pos] = menor;//Se agrega el menor al arreglo final ordenado
            pos++; // Se incrementa pos para poder evaluar el resto de los numeros, descartando los anteriores a pos  
        }
        return menores;
    }

    public static int[] organizarMayores(int[] arrayEnteros) {

        int[] temp = arrayEnteros;
        int[] mayores = new int[arrayEnteros.length];
        int pos = 0;

        while (pos < arrayEnteros.length) {
            int mayor = arrayEnteros[pos];
            for (int i = pos; i < temp.length; i++) {
                if (temp[i] > mayor) {
                    mayor = temp[i];
                }
            }
            for (int i = pos; i < temp.length; i++) {
                if (temp[i] == mayor) {
                    int aux = temp[pos];
                    temp[pos] = mayor;
                    temp[i] = aux;
                }
            }
            mayores[pos] = mayor;
            pos++;
        }

        return mayores;
    }//Fin del metodo organizar mayores

    public static int PasarEnterosMayores(int[] mayores) {
        String StrNumMayores = "";
        for (int i = 0; i < mayores.length; i++) {
            StrNumMayores += mayores[i];
        }
        int numMayores = Integer.parseInt(StrNumMayores);
        return numMayores;
    }//Fin metodo de pasar los arrays a numero entero

    public static int PasarEnterosMenores(int[] menores) {
        String StrNumMenores = "";
        for (int i = 0; i < menores.length; i++) {
            StrNumMenores += menores[i];
        }
        int numMenores = Integer.parseInt(StrNumMenores);
        return numMenores;
    }//Fin metodo de pasar los arrays a numero entero

    public static boolean Validacion4Digitos(int[] arrayEnteros) {

        boolean valido = true;
        int cont = 0;

        for (int i = 0; i < arrayEnteros.length - 1; i++) {
            if (arrayEnteros[i] == arrayEnteros[i + 1]) {
                cont++;
            }
        }
        if (cont == 3) {
            valido = false;
        }
        return valido;
    }//Fin del metodo para validar si los 4 digitos son iguales

    public static int Kaprekar(int num) {
        int resta = 0;
        arrayDeNumEntero(num);
        int[] arreglo = arrayDeNumEntero(num);
        int[] arreglo1 = arrayDeNumEntero(num);
        //System.out.println("Arreglo organizado de menor a mayor: ");
        organizarMenores(arreglo1);
        System.out.println();
        //System.out.println("Arreglo organizado de mayor a menor: ");
        organizarMayores(arreglo);
        int mayores = PasarEnterosMayores(arreglo);
        int menores = PasarEnterosMenores(arreglo1);
        

        resta = mayores - menores;
        System.out.println(mayores + " - " + menores + " = " + resta);
        return resta;
    }//Fin metodo Kaprekar
}//Fin de la clase
