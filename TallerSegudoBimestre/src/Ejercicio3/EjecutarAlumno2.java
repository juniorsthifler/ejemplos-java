/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

/**
 *
 * @author SALAS
 */
public class EjecutarAlumno2 {
    public static void main(String[] args) {
        LecturaAlumnos2 mo = new LecturaAlumnos2();
        mo.abrirArchivo();
        mo.leer_informacion();
        mo.cerrarArchivo();
       
    }
}
