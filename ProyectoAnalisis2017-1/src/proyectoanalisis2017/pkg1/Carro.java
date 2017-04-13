/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.util.LinkedList;

/**
 *
 * @author root
 */
public class Carro {

    private int id;
    private String ruta;
    private int x;
    private int y;
    private LinkedList<Arista> camino;

    public Carro() {
    }

    public Carro(int id, int x, int y, LinkedList<Arista> camino) {
        this.id = id;
        this.camino = camino;
        this.ruta = "../ImgComponentes/car_ari_abj1.png";
        this.x = x;
        this.y = y;
    }

    public LinkedList<Arista> getCamino() {
        return camino;
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
    
    
 
}
