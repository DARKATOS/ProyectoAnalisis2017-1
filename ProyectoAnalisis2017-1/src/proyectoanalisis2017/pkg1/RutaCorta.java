/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class RutaCorta {
    private int pesos[][];
    private int[] ultimo;
    private int[] D;
    private boolean[] F;
    private int origen, cantidadNodos; // vértice origen y número de vértices

    public RutaCorta(int origen, int cantidadNodos) {
        this.origen=origen;
        this.cantidadNodos=cantidadNodos;
        pesos=new int[this.cantidadNodos][this.cantidadNodos];
        ultimo=new int[this.cantidadNodos];
        D=new int[this.cantidadNodos];
        F=new boolean[this.cantidadNodos];
        
    }
    
    public void llenarPesos(GrafoDirigido grafo)
    {
        for (int i=0; i<pesos.length; i++)
        {
            for (int j=0; j<pesos.length; j++)
            {
                if (grafo.getGrafo()[i][j]!=null)
                {
                    pesos[i][j]=grafo.getGrafo()[i][j].getLongitud();
                }
                else
                {
                    pesos[i][j]=214748364;
                }
                
            }
        }
        System.out.println("Imprimir pesos");
        for (int i=0; i<pesos.length; i++)
        {
            for (int j=0; j<pesos.length; j++)
            {
                System.out.print(pesos[i][j]+", ");
                
            }
            System.out.println("");
        }
    }
    
    public void caminosMinimos()
    {
        for (int i = 0; i < cantidadNodos; i++) {
            F[i] = false;
            D[i] = pesos[origen][i];
            ultimo[i] = origen;
        }
        F[origen] = true;
        D[origen] = 0;
        for (int i = 1; i < cantidadNodos; i++) {
            int v = minimo(); /* selecciona vértice no marcado
             de menor distancia */

            F[v] = true;
            // actualiza distancia de vértices no marcados
            for (int w = 0; w < cantidadNodos; w++) {
                if (!F[w]) {
                    if ((D[v] + pesos[v][w]) < D[w]) {
                        D[w] = D[v] + pesos[v][w];
                        ultimo[w] = v;
                    }
                }
            }
        }
    }
    
    public int minimo()
    {
        int mx = 214748364;
        int v = 1;
        for (int j = 0; j < cantidadNodos; j++) {
            if (!F[j] && (D[j] <= mx)) {
                mx = D[j];
                v = j;
            }
        }
        return v;
    }
    
    public LinkedList<Integer> obtenerCamino(int v)
    {
        LinkedList<Integer>recibido=recuperaCamino(v, new LinkedList<>());
        return recibido;
    }
    
    private LinkedList recuperaCamino(int v, LinkedList<Integer> camino) {
        int anterior = ultimo[v];
        if (v != origen) {
            recuperaCamino(anterior, camino);
            camino.add(v);
        } else {
            camino.add(origen);
        }
        return camino;
    }
    
    public LinkedList<Arista> convertirCamino(GrafoDirigido grafo, LinkedList<Integer>caminoNodos)
    {
        LinkedList<Arista> camino=new LinkedList<>();
        for (int i=0; i<caminoNodos.size()-1; i++)
        {
            Arista arista=grafo.getGrafo()[caminoNodos.get(i)][caminoNodos.get(i+1)];
            camino.add(arista);
        }
        return camino;
    }
    
}
