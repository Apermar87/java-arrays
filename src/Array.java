import java.util.Random;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) throws Exception {
        int[] array = crearArray();

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        int posicion = 0;
        int opcion = 0;
        boolean comprobador = true;
        int numero = 0;
        int valor = 0;
        int posicionBuscar = 0;
        int posicionBuscar2 = 0;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            if (opcion >= 0 && opcion <= 7) {
                switch (opcion) {
                    case 0:
                        comprobador = false;
                        break;
                    case 1:
                        mostrarArray(posicion, array);
                        break;
                    case 2:
                        mostrarArrayInverso(posicion, array);
                        break;
                    case 3:
                        buscarMenor(array);
                        break;
                    case 4:
                        buscarMayor(array);
                        break;
                    case 5:
                        System.out.println("Introduzca un número a buscar: ");
                        numero = scanner.nextInt();
                        buscarNumero(array, numero, posicion);
                        break;
                    case 6:
                        System.out.println("Introduce la posición del número a cambiar: ");
                        posicionBuscar = scanner.nextInt() - 1;
                        System.out.println("Introduce el nuevo valor: ");
                        valor = scanner.nextInt();
                        cambiarValorNumero(array, valor, posicionBuscar);
                        break;
                    case 7:
                        System.out.println("Introduce las dos posiciones a intercambiar: ");
                        posicionBuscar = scanner.nextInt() - 1;
                        posicionBuscar2 = scanner.nextInt() - 1;
                        intercambiarNumeros(array, posicionBuscar, posicionBuscar2);
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("Porfavor introduzca un número válido");
            }
        } while (comprobador);
    }

    public static int[] crearArray() {
        int[] array = new int[50];

        int numero;

        Random r = new Random();

        for (int i = 0; i < 50; i++) {
            numero = r.nextInt(50);
            array[i] = numero;
        }
        return array;
    }

    public static void mostrarArray(int posicion, int array[]) {
        for (int i = 0; i < array.length; i++) {
            posicion = i + 1;
            System.out.println("Posición " + posicion + ": " + array[i] + "\n");
        }
    }

    public static void mostrarArrayInverso(int posicion, int array[]) {
        for (int i = array.length - 1; i >= 0; i--) {
            posicion = i + 1;
            System.out.println("Posición " + posicion + ": " + array[i]);
        }
    }

    public static void buscarMenor(int array[]) {
        int menor = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < menor)
                menor = array[i];
        }
        System.out.println("El menor es " + menor);
    }

    public static void buscarMayor(int array[]) {
        int mayor = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > mayor)
                mayor = array[i];
        }
        System.out.println("El mayor es " + mayor);
    }

    public static void buscarNumero(int array[], int numero, int posicion) {
        boolean salir = false;
        for (int i = 0; i < array.length && salir == false; i++) {
            posicion = i + 1;
            if (array[i] == numero) {
                System.out.println("El número introducido está en la posición " + posicion);
                salir = true;
            }
        }
        if (salir == false) {
            System.out.println("El número no se encuentra en el array");
        }
    }

    public static void cambiarValorNumero(int array[], int valor, int posicionBuscar) {
        array[posicionBuscar] = valor;
    }

    public static void intercambiarNumeros(int array[], int posicionBuscar, int posicionBuscar2) {
        int temporal;
        temporal = array[posicionBuscar];
        array[posicionBuscar] = array[posicionBuscar2];
        array[posicionBuscar2] = temporal;
    }

    public static void mostrarMenu() {
        System.out.println("----------------------------------------------");
        System.out.println("Menú:\n");
        System.out.println("1.- Mostrar el array.");
        System.out.println("2.- Mostrar el array en orden inverso");
        System.out.println("3.- Buscar el número menor.");
        System.out.println("4.- Buscar el número mayor.");
        System.out.println("5.- Comprobar si existe un número en el array.");
        System.out.println("6.- Cambiar el valor de un número.");
        System.out.println("7.- Cambiar dos números de posición. ");
        System.out.println("0.- Salir\n");
    }
}
