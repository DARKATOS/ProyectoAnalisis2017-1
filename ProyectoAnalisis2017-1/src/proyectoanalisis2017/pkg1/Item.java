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
    private int id;
    private LinkedList<Componente> lstComponentes ;
    private Rectangle area;
    private int contador;
    
    public Item() {
    }

    public Item(int id, LinkedList<Componente> lstComponentes,int x, int y,int ancho,int alto) {
        this.id = id;
        this.lstComponentes = lstComponentes;
        this.area = new Rectangle(x,y,ancho,alto);
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
