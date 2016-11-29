
package Promedios;

import ArchivosEnClasePD.Archivo;

public class PruebaArchPromedio {
    public static void main( String args[] )
   {
      ArchPromedio aplicacion = new ArchPromedio();

      aplicacion.abrirArchivo();
      aplicacion.leer_informacion();
      aplicacion.cerrarArchivo();
   } // fin de main
}
