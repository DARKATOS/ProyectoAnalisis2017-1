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

    private int tipo;//1 abajo-arriba;2arriba-abajo;3izq-Der;4der-izq;5doblehorizontal;6doblevertical
    private String ruta;
    private Boolean esCruce;
    private Boolean esCalle;
    private Boolean esCarretera;
    private String nombre;
    private int idNodo;//si es -1 no es nodo

    public Componente() {
    }

    public Componente(String nombre) {
        this.nombre = nombre;
        this.tipo = 0;
        this.ruta = "../ImgComponentes/" + nombre + ".png";
        this.idNodo = -1;
        this.esCruce = false;
        this.esCalle = false;
        this.esCarretera = false;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEsCarretera(Boolean esCarretera) {
        this.esCarretera = esCarretera;
    }

    public Boolean getEsCarretera() {
        return esCarretera;
    }

    public void setEsCalle(Boolean esCalle) {
        this.esCalle = esCalle;
    }

    public Boolean getEsCalle() {
        return esCalle;
    }

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

    public void setEsCruce(Boolean esCruce) {
        this.esCruce = esCruce;
    }

    public Boolean getEsCruce() {
        return esCruce;
    }

   

}
