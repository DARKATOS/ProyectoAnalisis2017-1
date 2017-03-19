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
public class Ciudad implements Serializable {

    private Componente[][] matrizCiudad;
    private int n;//indica la canidad de columnas 
    private int m; //indica la cantidad de filas 
    private int anchoCampo;
    private int altoCampo;
    private int anchoCiudad;
    private int largoCiudad;
    private int cantidadCruces;

    public Ciudad() {
    }

    public Ciudad(Componente[][] matrizCiudad, int n, int m, int anchoCampo, int altoCampo) {
        this.matrizCiudad = matrizCiudad;
        this.n = n;
        this.m = m;
        this.cantidadCruces = 0;
        this.anchoCampo = anchoCampo;
        this.altoCampo = altoCampo;
        this.anchoCiudad = this.n * this.anchoCampo;
        this.largoCiudad = this.altoCampo * this.n;
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

    public Componente[][] getMatrizCiudad() {
        return matrizCiudad;
    }

    public Boolean esCalle(Componente componente) {
        boolean resultado = false;
        if (componente.getNombre().equals("1.1")) {
            componente.setTipo(6);
            resultado = true;
        } else if (componente.getNombre().equals("1.2")) {
            componente.setTipo(5);
            resultado = true;
        } else if (componente.getNombre().equals("2.1")) {
            componente.setTipo(1);
            resultado = true;
        } else if (componente.getNombre().equals("2.2")) {
            componente.setTipo(3);
            resultado = true;
        } else if (componente.getNombre().equals("2.3")) {
            componente.setTipo(2);
            resultado = true;
        } else if (componente.getNombre().equals("2.4")) {
            componente.setTipo(4);
            resultado = true;
        }
        return resultado;
    }

    public Boolean esCarretera(Componente componente) {
        boolean resultado = false;
        if (componente.getNombre().equals("3.1")) {
            componente.setTipo(6);
            resultado = true;
        } else if (componente.getNombre().equals("3.2")) {
            componente.setTipo(5);
            resultado = true;
        } else if (componente.getNombre().equals("6.1")) {
            componente.setTipo(1);
            resultado = true;
        } else if (componente.getNombre().equals("6.2")) {
            componente.setTipo(3);
            resultado = true;
        } else if (componente.getNombre().equals("6.3")) {
            componente.setTipo(2);
            resultado = true;
        } else if (componente.getNombre().equals("6.4")) {
            componente.setTipo(4);
            resultado = true;
        }
        return resultado;
    }

    public void actualizarCiudad() {
        this.cantidadCruces = 0;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                if (this.matrizCiudad[i][j] != null) {
                    if (esCruce(this.matrizCiudad[i][j])) {
                        matrizCiudad[i][j].setEsCruce(true);
                        matrizCiudad[i][j].setIdNodo(this.cantidadCruces);
                        this.cantidadCruces++;
                    } else if (esCalle(this.matrizCiudad[i][j])) {
                        matrizCiudad[i][j].setEsCalle(true);

                    } else if (esCarretera(this.matrizCiudad[i][j])) {
                        matrizCiudad[i][j].setEsCarretera(true);
                    }
                }
            }
        }
    }

    private boolean esCruce(Componente componente) {
        Boolean resultado = false;
        if (componente.getNombre().substring(0, 2).equals("4.") || componente.getNombre().substring(0, 2).equals("5.")) {
            resultado = true;
        }
        return resultado;

    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public int getCantidadCruces() {
        return cantidadCruces;
    }

}
