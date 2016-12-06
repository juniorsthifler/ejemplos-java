/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author SALAS
 */
public class LecturaAlumnos2 {
    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("estudiantes.txt"));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrirArchivo

    // lee registro del archivo
    public void leer_informacion() {
        ArrayList<String> linea_partes = null;

        try // lee registros del archivo, usando el objeto Scanner
        {
            ModificacionAlumno2 mo = new ModificacionAlumno2();
            mo.abrir_archivo();
            while (entrada.hasNext()) {//el has es para que lea todas las lineas escritas

                String linea = entrada.nextLine();
                
                linea_partes = new ArrayList<String>(Arrays.asList(linea.split("\\|")));
                int edad = 2016-Integer.parseInt(linea_partes.get(2));
                linea_partes.remove(2);
                String cadena = Integer.toString(edad);
                linea_partes.add(2, cadena); 
                mo.agregar_informacion(linea_partes);
            } // fin de while 
            mo.cerrar_archivo();
        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del metodo leerRegistros
    // cierra el archivo y termina la aplicación

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del metodo cerrarArchivo
}
    

