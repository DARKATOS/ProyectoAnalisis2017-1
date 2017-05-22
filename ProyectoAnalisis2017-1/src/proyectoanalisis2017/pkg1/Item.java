/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author Gianka
 */
public class Item{
    private int id; //Identificador del componente
    private LinkedList<Componente> lstComponentes ; //Cada una de las rotaciones del componente conforman esta lista
    private Rectangle area; //area que forma el item
    private int contador;
    
    public Item() {
    }

    /**
     * 
     * @param id identificador del item
     * @param lstComponentes lista de componentes del item (Rotaciones)
     * @param x
     * @param y
     * Posicion x y y del item
     */
    public Item(int id, LinkedList<Componente> lstComponentes, int x, int y) {
        this.id = id;
        this.lstComponentes = lstComponentes;
        this.area = new Rectangle(x,y,70,100);
        this.contador=1;
    }

    public Rectangle getArea() {
        return area;
    }

    public int getContador() {
        return contador;
    }

    public int getId() {
        return id;
    }

    public LinkedList<Componente> getLstComponentes() {
        return lstComponentes;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
