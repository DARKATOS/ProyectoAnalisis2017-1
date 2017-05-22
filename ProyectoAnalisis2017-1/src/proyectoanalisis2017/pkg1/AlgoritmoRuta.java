/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class AlgoritmoRuta {

    protected int pesos[][];
    private int cantidadNodos;

    public AlgoritmoRuta(int cantidadNodos) {
        this.cantidadNodos = cantidadNodos;
        this.pesos = new int[this.cantidadNodos][this.cantidadNodos];

    }

    /**
     * Metodo que se sobreescribe en cada una de la rutas para la matriz de
     * pesos
     *
     * @param grafo para obt5ener el peso de las aristas.
     */
    public void llenarPesos(GrafoDirigido grafo) {

    }

    /**
     * Permite obtener los pesos minimos y los caminos minimos de cada nodo a
     * todos los nodos.
     *
     * @return int[][] matrizVertices con la matriz de nodos que permiten
     * obtener el camino minimo
     */
    public int[][] floydWarshall() {
        int[][] matrizNodos = new int[cantidadNodos][cantidadNodos];
        for (int i = 0; i < cantidadNodos; i++) {
            for (int j = 0; j < cantidadNodos; j++) {
                matrizNodos[i][j] = j;
            }
        }

        for (int k = 0; k < cantidadNodos; k++) {
            for (int i = 0; i < cantidadNodos; i++) {
                for (int j = 0; j < cantidadNodos; j++) {
                    if ((pesos[i][k] != 214748364) && (pesos[k][j] != 214748364) && (Math.min(pesos[i][j], pesos[i][k] + pesos[k][j]) != pesos[i][j])) {
                        pesos[i][j] = pesos[i][k] + pesos[k][j];
                        matrizNodos[i][j] = matrizNodos[i][k];
                    }
                }
            }
        }

        return matrizNodos;
    }

    /**
     * Permite mostrar a traves de consola el estado de la matriz de pesos
     */
    public void mostrarPesos() {
        for (int i = 0; i < pesos.length; i++) {
            for (int j = 0; j < pesos[i].length; j++) {
                System.out.print(pesos[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    /**
     * Permite obtener el camino minimo a traves de un nodo origen y un nodo
     * destino
     *
     * @param matrizNodos Matriz que contienen los nodos de caminos minimos
     * @param origen nodo origen
     * @param destino nodo destino
     * @param grafo Permite obtener la matriz de adyacencia que contienen las
     * aristas
     * @return LinkedList aristas que conforman el camino minimo
     */
    public LinkedList<Arista> obtenerCamino(int matrizNodos[][], int origen, int destino, GrafoDirigido grafo) {
//        mostrarMatrizNodos(matrizNodos);
//        System.out.println("");
        mostrarGrafo(grafo);
        System.out.println("");
        LinkedList<Integer> caminoNodos = new LinkedList<>();
        boolean bandera = true;
        int nuevoOrigen = origen;

        while (bandera) {
            int nuevoDestino = matrizNodos[nuevoOrigen][destino];
            if (destino == nuevoDestino) {
                bandera = false;
            } else {
                caminoNodos.add(nuevoDestino);
                nuevoOrigen = nuevoDestino;
            }
        }
        caminoNodos.addFirst(origen);
        caminoNodos.addLast(destino);
        System.out.println("Origen: " + origen);
        System.out.println("Destino: " + destino);
        mostrarCaminoNodos(caminoNodos);
        LinkedList<Arista> camino = new LinkedList<>();
        for (int i = 0; i < caminoNodos.size() - 1; i++) {
            Arista arista = grafo.getGrafo()[caminoNodos.get(i)][caminoNodos.get(i + 1)];
            //Si la arista es nula no se agrega
            if (arista != null) {
                camino.add(arista);
            } else {
                camino = new LinkedList<>();
                JOptionPane.showMessageDialog(null, "No existe un camino disponible", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return camino;

    }

    public void setCantidadNodos(int cantidadNodos) {
        this.cantidadNodos = cantidadNodos;
    }

    public void setPesos(int[][] pesos) {
        this.pesos = pesos;
    }

    public int getCantidadNodos() {
        return cantidadNodos;
    }

    public int[][] getPesos() {
        return pesos;
    }

    /**
     * Permite mostrar a traves de consola el estado de un grafo
     * @param grafo que se va a mostrar por consola
     */
    private void mostrarGrafo(GrafoDirigido grafo) {
        for (int i = 0; i < grafo.getGrafo().length; i++) {
            for (int j = 0; j < grafo.getGrafo()[i].length; j++) {
                if (grafo.getGrafo()[i][j] == null) {
                    System.out.print("-\t");
                } else {
                    System.out.print(i + ":" + j + "\t");
                }
            }
            System.out.println("");
        }
    }

    /**
     * Permite mostrar la matriz de nodos de caminos obtenida al realizar el algoritmo de camino minimo.
     * @param matrizNodos que se va a mostrar.
     */
    private void mostrarMatrizNodos(int matrizNodos[][]) {
        for (int i = 0; i < cantidadNodos; i++) {
            for (int j = 0; j < cantidadNodos; j++) {
                System.out.print(matrizNodos[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    /**
     * Muestra un camino de nodos desde un nodo origen hasta un destino
     * @param caminoNodos Lista de nodos a mostrar
     */
    private void mostrarCaminoNodos(LinkedList<Integer> caminoNodos) {
        for (int i = 0; i < caminoNodos.size(); i++) {
            System.out.println(caminoNodos.get(i));
        }

    }
}
