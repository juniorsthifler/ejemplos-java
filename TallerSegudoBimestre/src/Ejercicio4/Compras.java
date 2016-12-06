/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author SALAS
 */
public class Compras {

    private Formatter salida; // objeto usado para enviar texto al archivo

    // permite al usuario abrir el archivo
    public void abrir_archivo() {
        try {
            salida = new Formatter("Facturas.txt");
        } // fin de try
        catch (SecurityException securityException) {
            System.err.println(
                    "No tiene acceso de escritura a este archivo.");
            System.exit(1);
        } // fin de catch
        catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrir_archivo

    // agrega registros al archivo
    public void agregar_informacion() {
        // el archivo permite el ingreso
        // de edad, nombre, apellido de una persona

        Scanner entrada = new Scanner(System.in);
        Scanner teclado = new Scanner(System.in);
        boolean bandera = true;

        try // envía valores al archivo
        {
            double precio = 0, subtotal = 0, iva = 0, total=0;
            String cadena ="";
            int cant = 0;

            System.out.println("COMERCIAL VENTAS Y REVENTAS");
            System.out.print("Ingrese su nombre: ");
            String nombre = teclado.nextLine();
            System.out.print("Ingrese Ciudad: ");
            String ciudad = teclado.nextLine();
            while (bandera) // itera hasta que bandera sea false
            {
                System.out.println("*****PRODUCTOS****");
                System.out.println("1. Arroz (kilo $2,50)");
                System.out.println("2. Azucar (kilo $1,50)");
                System.out.println("3. Aceite (Unidad $1,30)");
                System.out.println("4. Tallaries (Unidad $1,50)");
                System.out.println("5. Sal (kilo $1,00)");
                System.out.println("Ingrese opcion: ");
                int op = teclado.nextInt();
                System.out.println("Cantidad a llevar: ");
                cant = teclado.nextInt();
                switch (op) {
                    case 1:
                        precio = 2.50 * cant;
                        cadena = "ARROZ";
                        break;
                    case 2:
                        precio = 1.50 * cant;
                        cadena = "AZUCAR";
                        break;
                    case 3:
                        precio = 1.30 * cant;
                        cadena = "ACEITE";
                        break;
                    case 4:
                        precio = 1.50 * cant;
                        cadena = "TALLARINES";
                        break;
                    case 5:
                        precio = 1.0 * cant;
                        cadena = "SAL";
                        break;
                }
                subtotal += precio;
                iva = subtotal * 0.14;
                total = subtotal + iva;

                System.out.println("Desea ingresar más datos si (1), no(2)");
                int valor = entrada.nextInt();
                if (valor == 2) {
                    bandera = false;
                }
            }
            salida.format("**********Comercial Ventas y Reventas**********"
                    + "\nNombre: %s\nCiudad: %s\n"
                    + "----------------------------------------\n"
                    + "Producto       Cant       Precio\n"
                    + "%s              %d         %.2f\n"
                    + "----------------------------------------\n"
                    + "Subtotal: %.2f\n"
                    + "IVA: %.2f\n"
                    + "TOTAL: %.2f\n", nombre, ciudad,cadena,cant,
                    precio,subtotal, iva, total);

        } // fin de try
        catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error al escribir en el archivo.");
            return;
        } // fin de catch
        catch (NoSuchElementException elementException) {
            System.err.println("Entrada invalida. Intente de nuevo.");
            entrada.nextLine(); // descarta la entrada para que el usuario intente de nuevo
        } // fin de catch

        // fin de while
    } // fin del método agregarRegistros

    // cierra el arrchivo
    public void cerrar_archivo() {
        if (salida != null) {
            salida.close();
        }
    } // fin del método cerrarArchivo
}
