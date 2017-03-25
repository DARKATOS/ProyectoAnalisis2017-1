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
    private int anchoCampo;//indica el ancho del rectangulo de representacion de un componente
    private int altoCampo;//indica el alto del rectangulo de representacion de un componente
    private int anchoCiudad;//indica el ancho del area de la ciudad 
    private int altoCiudad;//indica el alto del area de la ciudad
    private int cantidadNodos;//contiene la cantidad de nodos que tiene la ciudad

    public Ciudad() {
    }
    
    public Ciudad(Componente[][] matrizCiudad, int n, int m) {
        this.matrizCiudad = matrizCiudad;
        this.n = n;
        this.m = m;
        this.cantidadNodos = 0;
        this.anchoCampo = 0;
        this.altoCampo = 0;
        this.anchoCiudad = 0;
        this.altoCiudad = 0;
    }

    public int getAltoCampo() {
        return altoCampo;
    }

    public void setAltoCiudad(int altoCiudad) {
        this.altoCiudad = altoCiudad;
    }
    
    

    public int getAnchoCampo() {
        return anchoCampo;
    }

    public int getAnchoCiudad() {
        return anchoCiudad;
    }

    public int getAltoCiudad() {
        return altoCiudad;
    }

    public void setAnchoCampo(int anchoCampo) {
        this.anchoCampo = anchoCampo;
    }

    public void setAnchoCiudad(int anchoCiudad) {
        this.anchoCiudad = anchoCiudad;
    }

    public void setAltoCampo(int altoCampo) {
        this.altoCampo = altoCampo;
    }
    
    

    

    public Componente[][] getMatrizCiudad() {
        return matrizCiudad;
    }
    /**
     * Nos indica si el componente es una calle quqe validamos con el nombre 
     * @param componente componente a verificar
     * @return resutaldo true es calle,false no es calle
     */
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
    /**
     * Nos indica si el componente es una carretera que validamos con el nombre 
     * @param componente componente a validar
     * @return true es carretera, false no es carretera
     */
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
   /**
    * Este metodo nos recorre toda la ciduad,marcando si es cruce,calle o carretera 
    * ademas va asigandole si es es nodo el id del nodo que va tener en el grafo
    */
    public void actualizarCiudad() {
        this.cantidadNodos = 0;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                if (this.matrizCiudad[i][j] != null) {

                    if (esCruce(this.matrizCiudad[i][j])) {
                        matrizCiudad[i][j].setTipoVia("cruce");
                        marcarNodo(matrizCiudad[i][j]);
                    } else {
                        if (esCalle(this.matrizCiudad[i][j])) {
                            matrizCiudad[i][j].setTipoVia("calle");
                        } else if (esCarretera(this.matrizCiudad[i][j])) {
                            matrizCiudad[i][j].setTipoVia("carretera");
                        }
                    }
                    if (esViaCortada(i, j)) {
                            marcarNodo(matrizCiudad[i][j]);
                        }
                }
            }
        }
    }
 /**
  * Analizamos si es l componente es via osea si es carretera,calle,o cruce
  * @param componente componente a validar
  * @return true es via,false no es via
  */
    private Boolean esVia(Componente componente) {
        Boolean resultado = false;
        if (componente.getTipoVia().equals("calle") || componente.getTipoVia().equals("carretera") || componente.getTipoVia().equals("cruce")) {
            resultado = true;
        }
        return resultado;
    }
    /**
     * En este metodo validamos si es una via que no finaliza en un cruce o si esta al tope de la ciudad
     * los componente que van a entrar es si son calle o carretera
     * @param i indice de fila donde esta el componente a validar
     * @param j indice de columna donde esta el componente a validar
     * @return  true es via cortada, false no es via cortada
     */
    private Boolean esViaCortada(int i, int j) {
        Boolean resultado = false;
        int contador = 0;

        if (j + 1 < m && this.matrizCiudad[i][j + 1] != null && esVia(this.matrizCiudad[i][j + 1])) {
            contador++;
        }

        if (j - 1 >= 0 && this.matrizCiudad[i][j - 1] != null && esVia(this.matrizCiudad[i][j - 1])) {
            contador++;
        }

        if (i + 1 < n && this.matrizCiudad[i + 1][j] != null && esVia(this.matrizCiudad[i + 1][j])) {
            contador++;
        }

        if (i - 1 >= 0 && this.matrizCiudad[i - 1][j] != null && esVia(this.matrizCiudad[i - 1][j])) {
            contador++;
        }

        if (contador == 1) {
            resultado = true;
        }
        return resultado;
    }
    /**
     * Al componente que va se un nodo le asigna un id e incrimente la cantidad de nodos 
     * de la ciudads
     * @param componente componente a marcar
     */
    private void marcarNodo(Componente componente) {
        componente.setIdNodo(this.cantidadNodos);
        this.cantidadNodos++;
    }
    /**
     * Validamos si el componente es una cruce que tambiem lo comprobamos con el nombre 
     * @param componente componente a verificar
     * @return true es cruce, false no es cruce
     */
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

    public int getCantidadNodos() {
        return cantidadNodos;
    }

   

}
