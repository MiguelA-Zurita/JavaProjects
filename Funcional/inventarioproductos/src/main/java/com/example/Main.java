package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroProductos = 0;
        int opcionMenu = 0;
        Boolean salir = false;
        Boolean encontrado = false;
        String busquedaProducto = "a";
        System.out.println("Introduce el número de productos que hay en el inventario:");
        numeroProductos = sc.nextInt();
        int stockProductos[] = new int[numeroProductos];
        String nombreProductos[] = new String[numeroProductos];
        double precioProductos[] = new double[numeroProductos];
        for (int i = 0; i < numeroProductos; i++) {
            System.out.println("Introduce el nombre del producto");
            nombreProductos[i] = sc.next().toLowerCase();
            System.out.println("Introduce su precio:");
            precioProductos[i] = sc.nextDouble();
            System.out.println("Introduce el stock disponible:");
            stockProductos[i] = sc.nextInt();
        }
        do {
            System.out.println("Escoge una de las siguientes opciones:");
            System.out.println("1. Mostrar inventario");
            System.out.println("2. Buscar un producto");
            System.out.println("3. Actualizar stock de un producto");
            opcionMenu = sc.nextInt();
            switch (opcionMenu) {
                case 1:
                    System.out.println("Nombre  Precio  Stock" );
                    for (int i = 0; i < numeroProductos; i++) {                    
                        System.out.println(nombreProductos[i] + "   " + precioProductos[i] + "  " + stockProductos[i]);
                    }
                    break;
                case 2:
                    encontrado = false;
                    System.out.println("Introduce el nombre del producto");
                    busquedaProducto = sc.next().toLowerCase();
                    for (int i = 0; i < nombreProductos.length && !encontrado; i++) {
                        if (nombreProductos[i].equals(busquedaProducto)) {
                            System.out.println(nombreProductos[i] + "   " + precioProductos[i] + "    " + stockProductos[i]);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("El producto no se ha encontrado!");
                    }
                    break;
                case 3:
                    encontrado = false;
                    System.out.println("Qué producto deseas modificar su stock?");
                    busquedaProducto = sc.next().toLowerCase();
                    for(int i = 0; i<nombreProductos.length && !encontrado; i++){
                        if(nombreProductos[i].equals(busquedaProducto)){
                            System.out.println("El producto " + nombreProductos[i] + " tiene un stock de " + stockProductos[i]);
                            System.out.println("Introduce el stock del producto actual");
                            stockProductos[i] = sc.nextInt();
                            System.out.println("El stock actual de " + nombreProductos[i] + " es de " + stockProductos[i]);
                            encontrado = true;
                        }
                    }
                    break;
                default:
                    System.out.println("Has introducido una opción no valida! Vuelve a intentarlo");
            }
        } while (!salir);
        System.out.println("Hasta luego!");
        sc.close();
    }
}