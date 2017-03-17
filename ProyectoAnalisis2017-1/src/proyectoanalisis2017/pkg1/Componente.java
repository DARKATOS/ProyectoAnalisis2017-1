/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

/**
 *
 * @author root
 */
public class Componente {
    private String tipo;
    private String ruta;

    public Componente() {
    }

    public Componente(String tipo) {
        this.tipo = tipo;
        this.ruta = "../ImgComponentes/"+this.tipo+".png";
    }

    public String getRuta() {
        return ruta;
    }

    public String getTipo() {
        return tipo;
    }
    
    
    
}
