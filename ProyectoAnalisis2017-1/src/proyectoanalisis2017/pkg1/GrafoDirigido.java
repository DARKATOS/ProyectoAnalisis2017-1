/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class GrafoDirigido {
    //Matriz grafo de tipo arista, cada una de las filas representa un id de alguno de los cruces.
    Arista grafo[][];

    /**
     * Contructor para la matriz de aristas.
     * @param numeroCruces Es el numero de cruces obtenido de la matriz de la ciudad
     */
    public GrafoDirigido(int numeroCruces) {
        grafo=new Arista[numeroCruces][numeroCruces];
    }
    
    /**
     * Inicializo la matriz del grafo en nulos.
     */
    public void iniciarlizarGrafo()
    {
        for (int i=0; i<grafo.length; i++)
        {
            for (int j=0; j<grafo.length; j++)
            {
                grafo[i][j]=null;
            }
        }
    }
    
    /**
     * 
     * @param a Es el cruce que actuara como nodo dentro del grafo
     * @param b Es el otro cruce que actuara como nodo dentro del grafo
     * @param arista Es el objeto tipo arista que se guardara en la adyacencia entre los dos nodos
     */
    public void añadirAdyacencia(Item a, Item  b, Arista arista)
    {
        grafo[a.getId()][b.getId()]=arista;
    }
}
