/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author root
 */
public class Carro  {
    private int id; //identificador de vehiculo
    private String ruta; //Ruta de la imagen del vehiculo
    private Rectangle area; //Area del vehiculo dentro de la ciudad
    private LinkedList<Arista> camino; //Lista de aristas que corresponden al camino que recorre el vehiculo
    private LinkedList<Arista> caminoPintar; //Traza la ruta del camino que recorre el vehiculo
    private Color color; //Color de la traza de la ruta
    private int tipo; //Determina si el carro esta en tipo automatico o con ruta especifica
    public Carro() {
    }

    public LinkedList<Arista> getCaminoPintar() {
        return caminoPintar;
    }

    public void setCaminoPintar(LinkedList<Arista> caminoPintar) {
        this.caminoPintar = caminoPintar;
    }


    /**
     * 
     * @param id Indentificador del vbehiculo
     * @param ancho Ancho de la imagen del vehiculo
     * @param alto Alto de la imagen del vehiculo
     * @param camino Lista de aristas que recorrera el vehiculo
     * @param tipo Tipo automatico o con ruta especifica
     */
    public Carro(int id, int ancho,int alto,String ruta, LinkedList<Arista> camino,int tipo) {
        this.id = id;
        this.camino = camino;
        this.ruta = ruta;
        this.tipo=tipo;
        this.area= new Rectangle(camino.getFirst().getX1(),camino.getFirst().getY1() , ancho, alto);
        caminoPintar=new LinkedList<>();
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
    
}
