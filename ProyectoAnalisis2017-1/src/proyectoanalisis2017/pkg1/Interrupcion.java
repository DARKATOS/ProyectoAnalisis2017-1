/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

/**
 *
 * @author root
 */
public class Interrupcion {
    Componente componenteAnterior;
    int i;
    int j;

    public Interrupcion() {
    }

    /**
     * Permite guardar el estado anterior a la interrupcion
     * @param componenteAnterior Componente anterior a la interrupcion
     * i y j es la posicion de la interrupcion y del componente anterior
     * @param i
     * @param j 
     */
    public Interrupcion(Componente componenteAnterior, int i, int j) {
        this.componenteAnterior = componenteAnterior;
        this.i = i;
        this.j = j;
    }

    
    public Componente getComponenteAnterior() {
        return componenteAnterior;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
     
 
    
}
