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
public class RutaCorta extends AlgoritmosRuta{

    public RutaCorta() {
        super();
    }
    

   
    @Override
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
//        System.out.println("Imprimir pesos");
//        for (int i=0; i<pesos.length; i++)
//        {
//            for (int j=0; j<pesos.length; j++)
//            {
//                System.out.print(pesos[i][j]+", ");
//                
//            }
//            System.out.println("");
//        }
    }    
}
