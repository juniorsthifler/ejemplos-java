
package Promedios;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class ArchPromedio {
    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("EstudiantesPromedios.txt"));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrirArchivo

    // lee registro del archivo
    public void leer_informacion() {

        try // lee registros del archivo, usando el objeto Scanner
        {
            int promedio = 0;
            int suma = 0;
            int mayorPromedio = 0;
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                //System.out.println(linea);
                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split(";")));
                //System.out.println(linea_partes.get(0));
                suma = Integer.parseInt(linea_partes.get(2)) + Integer.parseInt(linea_partes.get(3));
                promedio = suma / 2;
                System.out.println("Con todas sus notas "+ linea_partes.get(0) +" " + linea_partes.get(1)+" "+ "obtiene un promedio de: " + promedio);
                if (promedio >= mayorPromedio) {
                    mayorPromedio = promedio;
                }
            }
            System.out.println("El mayor promedio es " + mayorPromedio);
        }
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
