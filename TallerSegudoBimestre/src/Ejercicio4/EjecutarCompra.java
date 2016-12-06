/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

/**
 *
 * @author SALAS
 */
public class EjecutarCompra {
    public static void main(String[] args) {
        Compras c = new Compras();
        c.abrir_archivo();
        c.agregar_informacion();
        c.cerrar_archivo();
    }
}
