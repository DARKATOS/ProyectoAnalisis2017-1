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
public class Arista implements Cloneable {

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private Componente x; //Componente d einicio de la arista
    private Componente y; //componente final e la arista
    private int velocidad;//depende del tipo de la via si es carretera o calle
    private int longitud;//tamaño de desplazamiento de un nodo al otro
    private int trafico; //Cantidad de trafico que existe en un momento en la arista
    private int direccion;////1 abajo-arriba;2arriba-abajo;3izq-Der;4der-izq;5doblehorizontal;6doblevertical
    private LinkedList<Componente> componentes; //Lista de componentes que conforman la arista

    public Arista() {
    }

    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("No se puede clonar");
        }
        return obj;
    }

    /**
     * 
     * @param x1 Puinto en x de inicio de la arista
     * @param x2 Punto en x final de la arista
     * @param y1 Punto en y de inicio de la arista
     * @param y2 Punto en y de final de la arista
     * @param velocidad Velocidad de la arista
     * @param direccion De un sentido o de doble sentido
     * @param componentes Componentes que conforma la arista
     */
    public Arista(int x1, int x2, int y1, int y2, int velocidad, int direccion, LinkedList<Componente> componentes) {
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
        this.componentes = componentes;
    }

    public int getDireccion() {
        return direccion;
    }

    public int getLongitud() {
        return longitud;
    }

    public int getTrafico() {
        return trafico;
    }

    public void setTrafico(int trafico) {
        this.trafico = trafico;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public Componente getX() {
        return x;
    }

    public Componente getY() {
        return y;
    }

    public void setY(Componente y) {
        this.y = y;
    }

    public void setX(Componente x) {
        this.x = x;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getVelocidad() {
        return velocidad;
    }
}
