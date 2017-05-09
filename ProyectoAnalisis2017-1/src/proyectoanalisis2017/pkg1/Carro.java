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
    private Rectangle area;
    private LinkedList<Arista> camino;
    private int tipo;
    public Carro() {
    }

    
    public Carro(int id, int ancho,int alto, LinkedList<Arista> camino,int tipo) {
        this.id = id;
        this.camino = camino;
        this.ruta = "../ImgComponentes/car_ari_abj1.png";
        this.tipo=tipo;
        this.area= new Rectangle(camino.getFirst().getX1(),camino.getFirst().getY1() , ancho, alto);
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
    

    public String getRuta() {
        return ruta;
    }

    public void setArea(Rectangle area) {
        this.area = area;
    }

    public Rectangle getArea() {
        return area;
    }

    public void setCamino(LinkedList<Arista> camino) {
        this.camino = camino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
