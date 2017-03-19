/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.util.LinkedList;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class Arista {

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int velocidad;//depende del tipo de la via si es carretera o calle
    private int longitud;//tamaño de desplazamiento de un nodo al otro
    private int direccion;////1 abajo-arriba;2arriba-abajo;3izq-Der;4der-izq;5doblehorizontal;6doblevertical
    private LinkedList<Componente> lstComponentes;

    public Arista() {
    }

    public Arista(int x1, int x2, int y1, int y2, int velocidad, int direccion, LinkedList<Componente> lstComponentes) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.velocidad = velocidad;
        if (x1 == x2) {
            if (y1 > y2) {
                this.longitud = y1 - y2;
            } else {
                this.longitud = y2 - y1;
            }
        } else {

            if (x1 > x2) {
                this.longitud = x1 - x2;
            } else {
                this.longitud = x2 - x1;
            }
        }

        this.direccion = direccion;
        this.lstComponentes = lstComponentes;
    }
    public int getDireccion() {
        return direccion;
    }

    public int getLongitud() {
        return longitud;
    }

}
