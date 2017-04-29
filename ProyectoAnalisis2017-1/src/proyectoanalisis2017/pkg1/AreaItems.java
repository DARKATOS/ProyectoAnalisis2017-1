/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class AreaItems implements Serializable{
    private ArrayList<Item>listaItems;
    private int anchoListaComponentesX1;
    private int anchoListaComponentesX2;

    public AreaItems(ArrayList<Item> listaItems, int anchoListaComponentesX1, int anchoListaComponentesX2) {
        this.listaItems = listaItems;
        this.anchoListaComponentesX1 = anchoListaComponentesX1;
        this.anchoListaComponentesX2 = anchoListaComponentesX2;
        cargarComponentes();
    }

    public int getAnchoListaComponentesX1() {
        return anchoListaComponentesX1;
    }

    public int getAnchoListaComponentesX2() {
        return anchoListaComponentesX2;
    }

    public ArrayList<Item> getListaItems() {
        return listaItems;
    }
    
    
    
    private void cargarComponentes() {
        int auxAltura = 100;
        LinkedList<Componente> auxLista= new LinkedList<>();
        auxLista.add(new Componente("X"));
        listaItems.add(new Item(0, auxLista, anchoListaComponentesX1 + 20, 0 * auxAltura));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("V.1"));
        auxLista.add(new Componente("V.2"));
        listaItems.add(new Item(1, auxLista, anchoListaComponentesX1 + 20, 1 * auxAltura+10));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("R.1"));
        auxLista.add(new Componente("R.2"));
        auxLista.add(new Componente("R.3"));
        auxLista.add(new Componente("R.4"));
        listaItems.add(new Item(2, auxLista, anchoListaComponentesX1 + 20, 2 * auxAltura+20));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("H.1"));
        auxLista.add(new Componente("H.2"));
        listaItems.add(new Item(3, auxLista, anchoListaComponentesX1 + 20, 3 * auxAltura+30));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("Y"));
       
        listaItems.add(new Item(4, auxLista, anchoListaComponentesX1 + 20, 4 * auxAltura+40));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("T.1"));
        auxLista.add(new Componente("T.2"));
        auxLista.add(new Componente("T.3"));
        auxLista.add(new Componente("T.4"));
        listaItems.add(new Item(4, auxLista, anchoListaComponentesX1 + 20, 5 * auxAltura+50));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("U"));
        listaItems.add(new Item(6, auxLista, anchoListaComponentesX1 + 20+80, 0 * auxAltura));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("I"));
        listaItems.add(new Item(7, auxLista, anchoListaComponentesX1 + 30+80, 1 * auxAltura+10));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("C"));
        listaItems.add(new Item(8, auxLista, anchoListaComponentesX1 + 30+80, 2 * auxAltura+20));       
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("A"));
        listaItems.add(new Item(9, auxLista, anchoListaComponentesX1 + 30+80, 3 * auxAltura+30));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("0"));
        listaItems.add(new Item(10, auxLista, anchoListaComponentesX1 + 30+80, 4 * auxAltura+40));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("XX"));
        listaItems.add(new Item(11, auxLista, anchoListaComponentesX1 + 30+80, 5 * auxAltura+40));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("YY"));
        listaItems.add(new Item(12, auxLista, anchoListaComponentesX1 + 30+80, 6 * auxAltura+40));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("XXX"));
        listaItems.add(new Item(13, auxLista, anchoListaComponentesX1 + 30+80, 7 * auxAltura+40));
        

    }
}
