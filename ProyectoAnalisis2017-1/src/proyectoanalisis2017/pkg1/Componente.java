/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.io.Serializable;

/**
 *
 * @author root
 */
public class Componente implements Serializable {

    private String tipoVia; //No sindica si es cruce, calle o carretera, null si no es ninguno.
    private int tipo;//1 abajo-arriba;2arriba-abajo;3izq-Der;4der-izq;5doblehorizontal;6doblevertical
    private String ruta; //nos indica donde esta la imagen para pintarla en el panel    
//    private Boolean esCruce;//nos indica si es cruce o no
//    private Boolean esCalle;//nos indica si es calle o no
//    private Boolean esCarretera;// nos indica si es carretera o no
    private String nombre;// nos indica el nombre del compoente 
    private int idNodo;//si es -1 no es nodo y >=0 si es un nodo y el valor es el identificador del nodo

    public Componente() {
    }

    public Componente(String nombre) {
        this.nombre = nombre;
        this.tipo = 0;
        this.ruta = "../ImgComponentes/" + nombre + ".png";
        this.idNodo = -1;
//        this.esCruce = false;
//        this.esCalle = false;
//        this.esCarretera = false;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
//
//    public void setEsCarretera(Boolean esCarretera) {
//        this.esCarretera = esCarretera;
//    }
//
//    public Boolean getEsCarretera() {
//        return esCarretera;
//    }
//
//    public void setEsCalle(Boolean esCalle) {
//        this.esCalle = esCalle;
//    }
//
//    public Boolean getEsCalle() {
//        return esCalle;
//    }

    public String getRuta() {
        return ruta;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setIdNodo(int idNodo) {
        this.idNodo = idNodo;
    }

    public int getIdNodo() {
        return idNodo;
    }

//    public void setEsCruce(Boolean esCruce) {
//        this.esCruce = esCruce;
//    }
//
//    public Boolean getEsCruce() {
//        return esCruce;
//    }

    public String getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }
    
    

   

}
