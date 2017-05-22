/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class RutaVeloz extends AlgoritmoRuta {
    
    public RutaVeloz(int cantidadNodos) {
        super(cantidadNodos);
    }

    /**
     * Permite llenar la matriz de pesos con las velocidades de las aristas
     * @param grafo con el que se va a obtener el peso de las aristas para llenar la matriz
     */
    @Override
    public void llenarPesos(GrafoDirigido grafo) {
        for (int i=0; i<pesos.length; i++)
        {
            for (int j=0; j<pesos.length; j++)
            {
                if (grafo.getGrafo()[i][j]!=null)
                {
                    pesos[i][j]=grafo.getGrafo()[i][j].getVelocidad();
                }
                else
                {
                    pesos[i][j]=214748364;
                }
                
            }
        }
    }
    
    
    
}
