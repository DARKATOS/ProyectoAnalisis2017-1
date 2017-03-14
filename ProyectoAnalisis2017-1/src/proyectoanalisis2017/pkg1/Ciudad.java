/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.io.Serializable;

/**
 *
 * @author Gianka
 */
public class Ciudad implements Serializable{
    private String [][] matrizCiudad;
    private int n;//indica la canidad de columnas 
    private int m; //indica la cantidad de filas 
    private int anchoCampo;
    private int altoCampo;
    private int anchoCiudad;
    private int largoCiudad;
    
    
    public Ciudad() {
    }

    public Ciudad(String [][] matrizCiudad, int n, int m, int anchoCampo, int altoCampo) {
        this.matrizCiudad = matrizCiudad;
        this.n = n;
        this.m = m;
        this.anchoCampo = anchoCampo;
        this.altoCampo = altoCampo;
        this.anchoCiudad=this.n*this.anchoCampo;
        this.largoCiudad=this.altoCampo * this.n;
    }

    public int getAltoCampo() {
        return altoCampo;
    }

    public int getAnchoCampo() {
        return anchoCampo;
    }

    public int getAnchoCiudad() {
        return anchoCiudad;
    }

    public int getLargoCiudad() {
        return largoCiudad;
    }

    public String[][] getMatrizCiudad() {
        return matrizCiudad;
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }
    
    
}

  
