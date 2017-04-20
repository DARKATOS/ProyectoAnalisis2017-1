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
 * @author root
 */
public class Carro  {
    private int id;
    private String ruta;
    private int x;
    private int y;
    private Rectangle area;
    private LinkedList<Arista> camino;
    private int tipo;
    public Carro() {
    }

    public Carro(int id, int x, int y, LinkedList<Arista> camino,int tipo) {
        this.id = id;
        this.camino = camino;
        this.ruta = "../ImgComponentes/car_ari_abj1.png";
        this.x = x;
        this.y = y;
        this.tipo=tipo;
        this.area=null;
    }

    public LinkedList<Arista> getCamino() {
        return camino;
    }

    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getRuta() {
        return ruta;
    }

    public void setArea(Rectangle area) {
        this.area = area;
    }

    public Rectangle getArea() {
        return area;
    }
    
    
}
