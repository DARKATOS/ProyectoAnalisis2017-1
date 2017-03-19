/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.util.LinkedList;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class GrafoDirigido {

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

    /**
     * Inicializo la matriz del grafo en nulos.
     */
    public void iniciarlizarGrafo() {
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo.length; j++) {
                grafo[i][j] = null;
            }
        }
    }

    /**
     * Vamos ha representar el grafo mendiantes una matriz de adyasiencias
     * dependiendo de la matriz de componentes de la ciudad
     *
     * @param matrizCiudad matriz de la ciudad que tenemos diseñada
     */
    public void crearGrafo(Componente[][] matrizCiudad, int anchoCuadroCiudad, int altoCuadroCiudad) {
        for (int i = 0; i < matrizCiudad.length; i++) {
            for (int j = 0; j < matrizCiudad[i].length; j++) {
                if (matrizCiudad[i][j] != null) {
                    if (matrizCiudad[i][j].getEsCruce()) {
                        if (matrizCiudad[i][j - 1] != null && (matrizCiudad[i][j - 1].getEsCalle() || matrizCiudad[i][j - 1].getEsCarretera())) {
                            verArista(matrizCiudad, i, j - 1, matrizCiudad[i][j].getIdNodo(), i, j, anchoCuadroCiudad, altoCuadroCiudad, 2);
                        }
                        if (matrizCiudad[i][j + 1] != null && (matrizCiudad[i][j + 1].getEsCalle() || matrizCiudad[i][j + 1].getEsCarretera())) {
                            verArista(matrizCiudad, i, j + 1, matrizCiudad[i][j].getIdNodo(), i, j, anchoCuadroCiudad, altoCuadroCiudad, 1);
                        }
                        if (matrizCiudad[i - 1][j] != null && (matrizCiudad[i - 1][j].getEsCalle() || matrizCiudad[i - 1][j].getEsCarretera())) {
                            verArista(matrizCiudad, i - 1, j, matrizCiudad[i][j].getIdNodo(), i, j, anchoCuadroCiudad, altoCuadroCiudad, 3);
                        }
                        if (matrizCiudad[i + 1][j] != null && (matrizCiudad[i + 1][j].getEsCalle() || matrizCiudad[i + 1][j].getEsCarretera())) {
                            verArista(matrizCiudad, i + 1, j, matrizCiudad[i][j].getIdNodo(), i, j, anchoCuadroCiudad, altoCuadroCiudad, 4);
                        }

                    }
                }
            }
        }
    }

    private Arista crearArista(int x1, int y1, int x2, int y2, LinkedList<Componente> lstComponentes) {
        Arista auxArista;
        if (lstComponentes.getFirst().getEsCarretera()) {
            auxArista = new Arista(x1, x2, y1, y2, 80, lstComponentes.getFirst().getTipo(), lstComponentes);
        } else {
            auxArista = new Arista(x1, x2, y1, y2, 60, lstComponentes.getFirst().getTipo(), lstComponentes);
        }

        return auxArista;
    }

    private void añadirArista(int x, int y, Arista arista) {
        System.out.println(arista.getDireccion());
        if (arista.getDireccion() == 5 || arista.getDireccion() == 6) {
            this.grafo[x][y] = arista;
            this.grafo[y][x] = arista;
        } else if (arista.getDireccion() == 1) {
            if (x < y) {
                this.grafo[y][x] = arista;
            } else {
                this.grafo[x][y] = arista;
            }
        } else if (arista.getDireccion() == 2) {
            if (x < y) {
                this.grafo[x][y] = arista;
            } else {
                this.grafo[y][x] = arista;
            }
        } else if (arista.getDireccion() == 3) {
            if (x < y) {
                this.grafo[x][y] = arista;
            } else {
                this.grafo[y][x] = arista;
            }
        } else if (arista.getDireccion() == 4) {
            if (x < y) {
                this.grafo[y][x] = arista;
            } else {
                this.grafo[x][y] = arista;
            }
        }
    }

    /**
     *
     * @param matrizCiudad
     * @param i
     * @param j
     * @param origen
     * @param tamaño
     * @param opcion si es 1 busca hacia la derecha si es 2 busca a izquierda 3
     * busca hacia arriba y 4 busca hacia arriba
     */
    private void verArista(Componente[][] matrizCiudad, int i, int j, int idNodoorigen, int xOrigen, int yOrigen, int ancho, int alto, int opcion) {
        LinkedList<Componente> auxListaComponentes = new LinkedList<>();
        Arista auxArista = new Arista();
        Boolean bandera = false;

        while (!matrizCiudad[i][j].getEsCruce()) {
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
        if (bandera == false) {
            auxListaComponentes.add(matrizCiudad[i][j]);
        }
        auxArista = crearArista(xOrigen * alto, yOrigen * ancho, i * alto, j * ancho, auxListaComponentes);
        añadirArista(idNodoorigen, matrizCiudad[i][j].getIdNodo(), auxArista);
    }

    public void verGrafo() {
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[i].length; j++) {
                if (grafo[i][j] == null) {
                    System.out.print("-");
                } else {
                    System.out.print(this.grafo[i][j].getLongitud());
                }
            }
            System.out.println("");
        }
    }

}
