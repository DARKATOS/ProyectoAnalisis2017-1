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
//    private int origen;

    public AlgoritmosRuta2(int cantidadNodos) {
//        this.origen=-1;
        this.cantidadNodos = cantidadNodos;
        this.pesos = new int [this.cantidadNodos][this.cantidadNodos];
        
    }
    
    public void llenarPesos(GrafoDirigido grafo) {

    }
    
    public int[][] floydWarshall() {
        int [][]matrizVertices=new int[pesos.length][pesos.length];
        for (int i = 0; i < cantidadNodos; i++) {
            pesos[i][i] = 0;
        }
        for (int i=0; i<cantidadNodos; i++)
        {
            for (int j=0; j<cantidadNodos; j++)
            {
                matrizVertices[j][i]=i;
            }
        }

        for (int i = 0; i < cantidadNodos; i++) {
            for (int j = 0; j < cantidadNodos; j++) {
                for (int k = 0; k < cantidadNodos; k++) {
                    int dt = pesos[j][i] + pesos[i][k];
                    if (pesos[j][k] > dt) {
                        pesos[j][k] = dt;
                        matrizVertices[j][k]=i;
                    }
                }
            }
            
        }
        return matrizVertices;
    }
    
    public LinkedList<Arista>obtenerCaminoFloydWarshall(int matrizVertices[][], int origen, int destino, GrafoDirigido grafo)
    {
        LinkedList<Integer>caminoNodos=new LinkedList<>();
        int origenV=origen;
        int destinoV=destino;
        boolean bandera=true;
        caminoNodos.addLast(destino);
        int nuevoOrigen=origen;
        
        while(bandera)
        {
            int nuevoDestino=matrizVertices[origenV][destinoV];
            if (nuevoOrigen==nuevoDestino)
            {
                bandera=false;
            }
            else
            {
                caminoNodos.addFirst(nuevoDestino);
                destinoV=nuevoDestino;
                nuevoOrigen=nuevoDestino;
            }
        }
        caminoNodos.addFirst(origen);
        LinkedList<Arista> camino = new LinkedList<>();
        for (int i = 0; i < caminoNodos.size() - 1; i++) {
            Arista arista = grafo.getGrafo()[caminoNodos.get(i)][caminoNodos.get(i + 1)];
            camino.add(arista);
        }
        return camino;
    }

    public void setCantidadNodos(int cantidadNodos) {
        this.cantidadNodos = cantidadNodos;
    }

//    public void setOrigen(int origen) {
//        this.origen = origen;
//    }

    public void setPesos(int[][] pesos) {
        this.pesos = pesos;
    }

    public int getCantidadNodos() {
        return cantidadNodos;
    }
//
//    public int getOrigen() {
//        return origen;
//    }

    public int[][] getPesos() {
        return pesos;
    }
    
    
}
