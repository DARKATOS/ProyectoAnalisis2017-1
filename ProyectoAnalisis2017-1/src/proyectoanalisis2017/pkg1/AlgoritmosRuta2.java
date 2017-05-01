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
public class AlgoritmosRuta2 {
    protected int pesos[][];
    private int cantidadNodos;

    public AlgoritmosRuta2(int cantidadNodos) {
        this.cantidadNodos = cantidadNodos;
        this.pesos = new int [this.cantidadNodos][this.cantidadNodos];
        
    }
    
    public void llenarPesos(GrafoDirigido grafo) {

    }
    
    /**
     * Permite obtener los pesos minimos y los caminos minimos de cada nodo a todos los nodos. 
     * @return int[][] matrizVertices con la matriz de nodos que permiten obtener el camino minimo.
     */
    public int[][] floydWarshall() {
        int [][]matrizNodos=new int[pesos.length][pesos.length];
        for (int i = 0; i < cantidadNodos; i++) {
            pesos[i][i] = 0;
        }
        for (int i=0; i<cantidadNodos; i++)
        {
            for (int j=0; j<cantidadNodos; j++)
            {
                matrizNodos[j][i]=i;
            }
        }

        for (int i = 0; i < cantidadNodos; i++) {
            for (int j = 0; j < cantidadNodos; j++) {
                for (int k = 0; k < cantidadNodos; k++) {
                    int dt = pesos[j][i] + pesos[i][k];
                    if (pesos[j][k] > dt) {
                        pesos[j][k] = dt;
                        matrizNodos[j][k]=i;
                    }
                }
            }
            
        }
        return matrizNodos;
    }
    
    
    /**
     * Permite obtener el camino minimo a traves de un nodo origen y un nodo destino
     * @param matrizNodos Matriz que contienen los nodos de caminos minimos
     * @param origen nodo origen
     * @param destino nodo destino
     * @param grafo Permite obtener la matriz de adyacencia que contienen las aristas
     * @return LinkedList aristas que conforman el camino minimo
     */
    public LinkedList<Arista>obtenerCaminoFloydWarshall(int matrizNodos[][], int origen, int destino, GrafoDirigido grafo)
    {
        mostrarMatrizNodos(matrizNodos);
        System.out.println("");
        mostrarGrafo(grafo);
        System.out.println("");
        LinkedList<Integer>caminoNodos=new LinkedList<>();
        boolean bandera=true;
        int nuevoOrigen=origen;
        
        while(bandera)
        {
            int nuevoDestino=matrizNodos[nuevoOrigen][destino];
            if (destino==nuevoDestino)
            {
                bandera=false;
            }
            else
            {
                caminoNodos.add(nuevoDestino);
                nuevoOrigen=nuevoDestino;
            }
        }
        caminoNodos.addFirst(origen);
        caminoNodos.addLast(destino);
        System.out.println("Origen: "+origen);
        System.out.println("Destino: "+destino);
        mostrarCaminoNodos(caminoNodos);
        LinkedList<Arista> camino = new LinkedList<>();
        for (int i = 0; i < caminoNodos.size() - 1; i++) {
            Arista arista = grafo.getGrafo()[caminoNodos.get(i)][caminoNodos.get(i + 1)];
            //Si la arista es nula no se agrega
            if (arista!=null)
            {
                camino.add(arista);
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
    
    private void mostrarGrafo(GrafoDirigido grafo)
    {
        for (int i = 0; i < grafo.getGrafo().length; i++) {
            for (int j = 0; j < grafo.getGrafo()[i].length; j++) {
                if (grafo.getGrafo()[i][j] == null) {
                    System.out.print("-\t");
                } else {
                    System.out.print(i+":"+j+"\t");
                }
            }
            System.out.println("");
        }
    }
    private void mostrarMatrizNodos(int matrizNodos[][])
    {
        for(int i=0; i<cantidadNodos; i++)
        {
            for (int j=0; j<cantidadNodos; j++)
            {
                System.out.print(matrizNodos[i][j]+"\t");
            }
            System.out.println("");
        }
    }
    
    private void mostrarCaminoNodos(LinkedList<Integer>caminoNodos)
    {
        for(int i=0; i<caminoNodos.size(); i++)
        {
            System.out.println(caminoNodos.get(i));
        }
        
    }
}
