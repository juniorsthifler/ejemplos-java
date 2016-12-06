/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author SALAS
 */
public class ModificacionAlumno2 {
     private Formatter salida; // objeto usado para enviar texto al archivo
     
     LecturaAlumnos2 al = new LecturaAlumnos2(); 

    // permite al usuario abrir el archivo
    public void abrir_archivo() {
        try {
            salida = new Formatter("estudiantes-2-1.txt");
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
    public void agregar_informacion(ArrayList nombres) {
        // el archivo permite el ingreso
        // de edad, nombre, apellido de una persona
        
        Scanner entrada = new Scanner(System.in);
       
        
            try // envía valores al archivo
            {
                salida.format("%s|%s|%s\n", nombres.get(1),nombres.get(0),nombres.get(2));
                
            } // fin de try
            catch (FormatterClosedException formatterClosedException) {
                System.err.println("Error al escribir en el archivo.");
                return;
            } // fin de catch
            catch (NoSuchElementException elementException) {
                System.err.println("Entrada invalida. Intente de nuevo.");
                entrada.nextLine(); // descarta la entrada para que el usuario intente de nuevo
            } // fin de catch

    } // fin del método agregarRegistros

    // cierra el arrchivo
    public void cerrar_archivo() {
        if (salida != null) {
            salida.close();
        }
    } // fin del método cerrarArchivo
}
