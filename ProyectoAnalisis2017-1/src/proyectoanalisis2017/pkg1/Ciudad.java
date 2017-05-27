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
 * @author Gianka
 */
public class Ciudad implements Cloneable {

    private Componente[][] matrizCiudad;
    private int n;//indica la canidad de columnas 
    private int m; //indica la cantidad de filas 
    private int anchoCampo;//indica el ancho del rectangulo de representacion de un componente
    private int altoCampo;//indica el alto del rectangulo de representacion de un componente
    private int anchoCiudad;//indica el ancho del area de la ciudad 
    private int altoCiudad;//indica el alto del area de la ciudad
    private int cantidadNodos;//contiene la cantidad de nodos que tiene la ciudad
    private LinkedList<Interrupcion> interrupciones;

    public Ciudad() {
    }

    /**
     * Permite inicializar la matriz de la ciudad y su tamaño
     * @param matrizCiudad matriz de componentes de la ciudad
     * @param n Tamaño en filas de la ciudad
     * @param m Tamaño en columnas de la ciudad
     */
    public Ciudad(Componente[][] matrizCiudad, int n, int m) {
        this.matrizCiudad = matrizCiudad;
        this.n = n;
        this.m = m;
        this.cantidadNodos = 0;
        this.anchoCampo = 0;
        this.altoCampo = 0;
        this.anchoCiudad = 0;
        this.altoCiudad = 0;
        this.interrupciones = new LinkedList<>();
    }

    public void setMatrizCiudad(Componente[][] matrizCiudad) {
        this.matrizCiudad = matrizCiudad;
    }

    public int getAltoCampo() {
        return altoCampo;
    }

    public int getAnchoCampo() {
        return anchoCampo;
    }

    public void setAltoCampo(int altoCampo) {
        this.altoCampo = altoCampo;
    }

    public void setAnchoCampo(int anchoCampo) {
        this.anchoCampo = anchoCampo;
    }

    public void setAltoCiudad(int altoCiudad) {
        this.altoCiudad = altoCiudad;
    }

    public int getAnchoCiudad() {
        return anchoCiudad;
    }

    public int getAltoCiudad() {
        return altoCiudad;
    }

    public void setAnchoCiudad(int anchoCiudad) {
        this.anchoCiudad = anchoCiudad;
    }

    public Componente[][] getMatrizCiudad() {
        return matrizCiudad;
    }

    /**
     * Nos indica si el componente es una calle que validamos con el nombre
     *
     * @param componente componente a verificar
     * @return resutaldo true es calle,false no es calle
     */
    public Boolean esCalle(Componente componente) {
        boolean resultado = false;
        if (componente.getNombre().equals("V.1")) {
            componente.setTipo(6);
            resultado = true;
        } else if (componente.getNombre().equals("V.2")) {
            componente.setTipo(5);
            resultado = true;
        } else if (componente.getNombre().equals("R.1")) {
            componente.setTipo(1);
            resultado = true;
        } else if (componente.getNombre().equals("R.2")) {
            componente.setTipo(3);
            resultado = true;
        } else if (componente.getNombre().equals("R.3")) {
            componente.setTipo(2);
            resultado = true;
        } else if (componente.getNombre().equals("R.4")) {
            componente.setTipo(4);
            resultado = true;
        }
        return resultado;
    }

    /**
     * Nos indica si el componente es una carretera que validamos con el nombre
     *
     * @param componente componente a validar
     * @return true es carretera, false no es carretera
     */
    public Boolean esCarretera(Componente componente) {
        boolean resultado = false;
        if (componente.getNombre().equals("H.1")) {
            componente.setTipo(6);
            resultado = true;
        } else if (componente.getNombre().equals("H.2")) {
            componente.setTipo(5);
            resultado = true;
        } else if (componente.getNombre().equals("T.1")) {
            componente.setTipo(1);
            resultado = true;
        } else if (componente.getNombre().equals("T.2")) {
            componente.setTipo(3);
            resultado = true;
        } else if (componente.getNombre().equals("T.3")) {
            componente.setTipo(2);
            resultado = true;
        } else if (componente.getNombre().equals("T.4")) {
            componente.setTipo(4);
            resultado = true;
        }
        return resultado;
    }

    /**
     * Permite marcar los nodos adyacentes a una interrupcion, i y j es la
     * posicion de la interrupcion
     *
     * @param i
     * @param j
     */
    public void marcarNodosAdyacentes(int i, int j) {
        if ((j - 1) >= 0 && this.matrizCiudad[i][j - 1] != null && esVia(this.matrizCiudad[i][j - 1])) {

            if (this.matrizCiudad[i][j - 1].getIdNodo() == -1) {
                marcarNodo(this.matrizCiudad[i][j - 1]);
            }
        }
        if ((j + 1) < this.m && this.matrizCiudad[i][j + 1] != null && esVia(this.matrizCiudad[i][j + 1])) {
            if (this.matrizCiudad[i][j + 1].getIdNodo() == -1) {
                marcarNodo(this.matrizCiudad[i][j + 1]);
            }
        }
        if ((i - 1) >= 0 && this.matrizCiudad[i - 1][j] != null && esVia(this.matrizCiudad[i - 1][j])) {
            if (this.matrizCiudad[i - 1][j].getIdNodo() == -1) {
                marcarNodo(this.matrizCiudad[i - 1][j]);
            }
        }
        if ((i + 1) < this.n && this.matrizCiudad[i + 1][j] != null && esVia(this.matrizCiudad[i + 1][j])) {
            if (this.matrizCiudad[i + 1][j].getIdNodo() == -1) {
                marcarNodo(this.matrizCiudad[i + 1][j]);
            }
        }

    }

    /**
     * Permite eliminar los nodos adyacentes a una interrupcion que se acaba de
     * eliminar i y j es la posicion de la interrupcion
     *
     * @param i
     * @param j
     */
    public void eliminarNodosAdyacentes(int i, int j) {
        if ((j - 1) >= 0 && this.matrizCiudad[i][j - 1] != null && esVia(this.matrizCiudad[i][j - 1])) {
            if (!esCruce(this.matrizCiudad[i][j - 1])) {
                this.matrizCiudad[i][j - 1].setIdNodo(-1);
            }
        }
        if ((j + 1) < this.m && this.matrizCiudad[i][j + 1] != null && esVia(this.matrizCiudad[i][j + 1])) {
            if (!esCruce(this.matrizCiudad[i][j + 1])) {
                this.matrizCiudad[i][j + 1].setIdNodo(-1);

            }
        }
        if ((i - 1) >= 0 && this.matrizCiudad[i - 1][j] != null && esVia(this.matrizCiudad[i - 1][j])) {
            if (!esCruce(this.matrizCiudad[i - 1][j])) {
                this.matrizCiudad[i - 1][j].setIdNodo(-1);
            }
        }
        if ((i + 1) < this.n && this.matrizCiudad[i + 1][j] != null && esVia(this.matrizCiudad[i + 1][j])) {

            if (!esCruce(this.matrizCiudad[i + 1][j])) {
                this.matrizCiudad[i + 1][j].setIdNodo(-1);
            }
        }

    }

    /**
     * Este metodo nos recorre toda la ciduad,marcando si es cruce,calle o
     * carretera ademas va asigandole si es es nodo el id del nodo que va tener
     * en el grafo
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
                            if (esViaCortada(i, j)) {
                                marcarNodo(matrizCiudad[i][j]);
                            }
                        } else if (esCarretera(this.matrizCiudad[i][j])) {
                            matrizCiudad[i][j].setTipoVia("carretera");
                            if (esViaCortada(i, j)) {
                                marcarNodo(matrizCiudad[i][j]);
                            }
                        }
                    }
                    Rectangle area = new Rectangle(anchoCampo * j, altoCampo * i, anchoCampo, altoCampo);
                    matrizCiudad[i][j].setArea(area);
                }
            }
        }
    }

    /**
     * Reorganiza los identificadores de los nodos existentes en la ciudad
     */
    public void modificarNodos() {
        int contador = 0;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                if (this.matrizCiudad[i][j] != null && this.matrizCiudad[i][j].getIdNodo() != -1) {
                    this.matrizCiudad[i][j].setIdNodo(contador);
                    contador++;
                }
            }
        }
    }

    /**
     * Analizamos si el componente es via es decir si es carretera,calle,o cruce
     *
     * @param componente componente a validar
     * @return true es via,false no es via
     */
    public Boolean esVia(Componente componente) {
        Boolean resultado = false;
        if (esCarretera(componente) || esCalle(componente) || esCruce(componente)) {
            resultado = true;
        }
        return resultado;
    }

    /**
     * En este metodo validamos si es una via que no finaliza en un cruce o si
     * esta al tope de la ciudad los componente que van a entrar es si son calle
     * o carretera
     *
     * @param i indice de fila donde esta el componente a validar
     * @param j indice de columna donde esta el componente a validar
     * @return true es via cortada, false no es via cortada
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
     * Al componente que va a ser un nodo se le asigna un identificados y se
     * incrementa el numero de nodos.
     *
     * @param componente componente a marcar
     */
    public void marcarNodo(Componente componente) {
        if (componente.getIdNodo() == -1) {
            componente.setIdNodo(this.cantidadNodos);
            this.cantidadNodos++;
        }

    }

    /**
     * Validamos si el componente es una cruce que lo comprobamos con el nombre
     * del componente
     *
     * @param componente componente a verificar
     * @return true es cruce, false no es cruce
     */
    private boolean esCruce(Componente componente) {
        Boolean resultado = false;
        if (componente.getNombre().equals("X") || componente.getNombre().equals("Y")) {
            resultado = true;
        }
        return resultado;

    }
    
    /**
     * Muestra los nodos existentes en la ciudad
     * recorriendo la matriz y obteniendo el id de nodo de cada componente
     */
    public void mostrarMatrizCiudad() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrizCiudad[i][j] != null) {
                    System.out.print(matrizCiudad[i][j].getIdNodo() + "\t");
                } else {
                    System.out.print("-\t");
                }
            }
            System.out.println("");
        }
    }

    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("No se puede clonar");
        }
        return obj;
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

    public LinkedList<Interrupcion> getInterrupciones() {
        return interrupciones;
    }
}
