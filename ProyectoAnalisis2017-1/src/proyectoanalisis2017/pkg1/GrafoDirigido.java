/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class GrafoDirigido implements Serializable, Cloneable {

    //Matriz grafo de tipo arista, cada una de las filas representa un id de alguno de los cruces.
    Arista grafo[][];

    /**
     * Contructor para la matriz de aristas.
     *
     * @param numeroCruces Es el numero de cruces obtenido de la matriz de la
     * ciudad
     */
    public GrafoDirigido(int numeroCruces) {
        grafo = new Arista[numeroCruces][numeroCruces];
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

    /**
     * Inicializo la matriz del grafo en nulos.
     */

    public GrafoDirigido() {
    }

    public void iniciarlizarGrafo() {
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo.length; j++) {
                grafo[i][j] = null;
            }
        }
    }

    /**
     * Vamos ha representar el grafo mendiantes una matriz de adyacencias
     * dependiendo de la matriz de componentes de la ciudad mirando si es nodo y
     * que tenga via recoriendo hacia arriba,hacia abajo, hacia la derecha y
     * hacia la izquerda buscado un nodo y ahi se crea la arista y volviendo
     * null ese recorrido para que no se vuelva a repetir
     *
     * @param matrizCiudad matriz de la ciudad que tenemos diseñada
     */
    public void crearGrafo(Componente[][] matrizCiudad, int anchoCuadroCiudad, int altoCuadroCiudad) {
        for (int i = 0; i < matrizCiudad.length; i++) {
            for (int j = 0; j < matrizCiudad[i].length; j++) {
                if (matrizCiudad[i][j] != null && matrizCiudad[i][j].getIdNodo() != -1) {
                    if (j - 1 >= 0 && matrizCiudad[i][j - 1] != null && (matrizCiudad[i][j - 1].getTipoVia().equals("calle") || matrizCiudad[i][j - 1].getTipoVia().equals("carretera"))) {
                        verArista(matrizCiudad, i, j - 1, matrizCiudad[i][j].getIdNodo(), i, j, anchoCuadroCiudad, altoCuadroCiudad, 2);
                    }
                    if (j + 1 < matrizCiudad[i].length && matrizCiudad[i][j + 1] != null && (matrizCiudad[i][j + 1].getTipoVia().equals("calle") || matrizCiudad[i][j + 1].getTipoVia().equals("carretera"))) {

                        verArista(matrizCiudad, i, j + 1, matrizCiudad[i][j].getIdNodo(), i, j, anchoCuadroCiudad, altoCuadroCiudad, 1);
                    }
                    if (i - 1 >= 0 && matrizCiudad[i - 1][j] != null && (matrizCiudad[i - 1][j].getTipoVia().equals("calle") || matrizCiudad[i - 1][j].getTipoVia().equals("carretera"))) {
                        verArista(matrizCiudad, i - 1, j, matrizCiudad[i][j].getIdNodo(), i, j, anchoCuadroCiudad, altoCuadroCiudad, 3);
                    }
                    if (i + 1 < matrizCiudad.length && matrizCiudad[i + 1][j] != null && (matrizCiudad[i + 1][j].getTipoVia().equals("calle") || matrizCiudad[i + 1][j].getTipoVia().equals("carretera"))) {
                        verArista(matrizCiudad, i + 1, j, matrizCiudad[i][j].getIdNodo(), i, j, anchoCuadroCiudad, altoCuadroCiudad, 4);
                    }
                }
            }
        }
    }

    /**
     * Procedemos a crear la arista que se va asignar al grafo validado si es
     * carretera o caller para la velocidad
     *
     * @param x1 inicio de arista en x
     * @param y1 incio de arista en y
     * @param x2 fin de arrista en x
     * @param y2 fin de arista en y
     * @param lstComponentes los componente que contiene esa arista
     * @return arista creada con los todos sus paramentros
     */
    private Arista crearArista(int x1, int y1, int x2, int y2, LinkedList<Componente> lstComponentes) {
        Arista auxArista;
        if (lstComponentes.getFirst().getTipoVia().equals("carretera")) {
            auxArista = new Arista(x1, x2, y1, y2, 80, lstComponentes.getFirst().getTipo(), lstComponentes);
        } else {
            auxArista = new Arista(x1, x2, y1, y2, 60, lstComponentes.getFirst().getTipo(), lstComponentes);
        }

        return auxArista;
    }

    /**
     * Añade la arista al grafo dependiendo la direccion del de la arista se
     * agrega en la matriz del grafo
     *
     * @param x identificador del primero nodo
     * @param y identidicador del segundo nodo
     * @param arista arista a asignar
     */
    private void añadirArista(int x, int y, Arista arista) {
        if (arista.getDireccion() == 5 || arista.getDireccion() == 6) {
            arista.setX(x);
            arista.setY(y);
            this.grafo[x][y] = arista;
            Arista aris = (Arista) arista.clone();
            aris.setX(y);
            aris.setY(x);
            this.grafo[y][x] = aris;
        } else if (arista.getDireccion() == 1) {
            if (x < y) {
                arista.setX(y);
                arista.setY(x);
                this.grafo[y][x] = arista;

            } else {
                arista.setX(x);
                arista.setY(y);
                this.grafo[x][y] = arista;
            }
        } else if (arista.getDireccion() == 2) {
            if (x < y) {
                arista.setX(x);
                arista.setY(y);
                this.grafo[x][y] = arista;
            } else {
                arista.setX(y);
                arista.setY(x);
                this.grafo[y][x] = arista;
            }
        } else if (arista.getDireccion() == 3) {
            if (x < y) {
                arista.setX(x);
                arista.setY(y);
                this.grafo[x][y] = arista;
            } else {
                arista.setX(y);
                arista.setY(x);
                this.grafo[y][x] = arista;
            }
        } else if (arista.getDireccion() == 4) {
            if (x < y) {
                arista.setX(y);
                arista.setY(x);
                this.grafo[y][x] = arista;
            } else {
                arista.setX(x);
                arista.setY(y);
                this.grafo[x][y] = arista;
            }
        }
    }

    /**
     * Aqui es el recorrido buscando el otro nodo para hacer la arista y cada
     * que va encontrando un componen via y que nos es nodo va agregando en un
     * lista de componente y cuanod ya encuentra un nodo crea la arista y luego
     * añade al grafo
     *
     * @param matrizCiudad Matriz de la cidudad
     * @param i indice de fila donde empieza el recorrido no es del nodo si no
     * del siguente
     * @param j indice de columna donde empieza el recorrido no es del nodo si
     * no del siguente
     * @param origen indice de fila del nodo que se le va hacer el recorrido
     * @param tamaño indice de columna del nodo que se lava hacer el recorrido
     * @param opcion si es 1 busca hacia la derecha si es 2 busca a izquierda 3
     * busca hacia arriba y 4 busca hacia arriba
     */
    private void verArista(Componente[][] matrizCiudad, int i, int j, int idNodoorigen, int xOrigen, int yOrigen, int ancho, int alto, int opcion) {
        LinkedList<Componente> auxListaComponentes = new LinkedList<>();
        Arista auxArista;
        Boolean bandera = false;
        while (i >= 0 && i <= matrizCiudad.length - 1 && j >= 0 && j < matrizCiudad[0].length - 1 && matrizCiudad[i][j].getIdNodo() == -1) {
            bandera = true;
            auxListaComponentes.add(matrizCiudad[i][j]);
            matrizCiudad[i][j] = null;
            switch (opcion) {
                case 1:
                    j++;
                    break;
                case 2:
                    j--;
                    break;
                case 3:
                    i--;
                    break;
                case 4:
                    i++;
                    break;
            }
        }
        if (i < 0) {
            i = 0;
        } else if (i > matrizCiudad.length - 1) {
            i = matrizCiudad.length - 1;
        } else if (j < 0) {
            j = 0;
        } else if (j > matrizCiudad[0].length - 1) {
            j = matrizCiudad[0].length - 1;
        }
        if (bandera == false) {
            auxListaComponentes.add(matrizCiudad[i][j]);
        }
        auxArista = crearArista(yOrigen * ancho, xOrigen * alto, j * ancho, i * alto, auxListaComponentes);
        añadirArista(idNodoorigen, matrizCiudad[i][j].getIdNodo(), auxArista);
    }

    public void verGrafo() {
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[i].length; j++) {
                if (grafo[i][j] == null) {
                    System.out.print("-");
                } else {
                    System.out.print(this.grafo[i][j].getX1() + "," + this.grafo[i][j].getY1() + "," + this.grafo[i][j].getX2() + "," + this.grafo[i][j].getY2());
                }
            }
            System.out.println("");
        }
    }

    public Arista[][] getGrafo() {
        return grafo;
    }

}
