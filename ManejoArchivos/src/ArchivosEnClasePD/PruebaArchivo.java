package ArchivosEnClasePD;
import Promedios.ArchPromedio;
import escrituraArchivos.ArchivoTexto;
public class PruebaArchivo {
    public static void main( String args[] )
   {
       ArchPromedio aplicacion = new ArchPromedio();

      aplicacion.abrirArchivo();
      aplicacion.leer_informacion();
      aplicacion.cerrarArchivo();
   } // fin de main
}
