/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.awt.Rectangle;

/**
 *
 * @author Gianka
 */
public class Componente {
    int id;
    int tipo;
    String ruta;
    Rectangle area;

    public Componente() {
    }

    public Componente(int id, int tipo, String ruta, int x, int y,int ancho,int alto) {
        this.id = id;
        this.tipo = tipo;
        this.ruta = ruta;
        this.area= new Rectangle(x, y, ancho,alto);
    }
    
}
