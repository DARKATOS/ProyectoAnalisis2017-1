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
public class AreaItems {
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
        auxLista.add(new Componente("4.1"));
        auxLista.add(new Componente("4.2"));
        auxLista.add(new Componente("4.3"));
        auxLista.add(new Componente("4.4"));
  
        listaItems.add(new Item(0, auxLista, anchoListaComponentesX1 + 20, 0 * auxAltura, 70, 100));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("1.1"));
        auxLista.add(new Componente("1.2"));
        listaItems.add(new Item(1, auxLista, anchoListaComponentesX1 + 20, 1 * auxAltura+10, 70, 100));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("2.1"));
        auxLista.add(new Componente("2.2"));
        auxLista.add(new Componente("2.3"));
        auxLista.add(new Componente("2.4"));
        listaItems.add(new Item(2, auxLista, anchoListaComponentesX1 + 20, 2 * auxAltura+20, 70, 100));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("3.1"));
        auxLista.add(new Componente("3.2"));
        listaItems.add(new Item(3, auxLista, anchoListaComponentesX1 + 20, 3 * auxAltura+30, 70, 100));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("5.1"));
        auxLista.add(new Componente("5.2"));
        auxLista.add(new Componente("5.3"));
        auxLista.add(new Componente("5.4"));
        listaItems.add(new Item(4, auxLista, anchoListaComponentesX1 + 20, 4 * auxAltura+40, 70, 100));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("6.1"));
        auxLista.add(new Componente("6.2"));
        auxLista.add(new Componente("6.3"));
        auxLista.add(new Componente("6.4"));
        listaItems.add(new Item(4, auxLista, anchoListaComponentesX1 + 20, 5 * auxAltura+50, 70, 100));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("7.1"));
        auxLista.add(new Componente("7.2"));
        auxLista.add(new Componente("7.3"));
        auxLista.add(new Componente("7.4"));
        listaItems.add(new Item(6, auxLista, anchoListaComponentesX1 + 20+80, 0 * auxAltura, 70, 100));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("8.1"));
        auxLista.add(new Componente("8.2"));
        auxLista.add(new Componente("8.3"));
        auxLista.add(new Componente("8.4"));
        listaItems.add(new Item(7, auxLista, anchoListaComponentesX1 + 30+80, 1 * auxAltura, 70, 100));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("9.1"));
        auxLista.add(new Componente("9.2"));
        auxLista.add(new Componente("9.3"));
        auxLista.add(new Componente("9.4"));
        listaItems.add(new Item(8, auxLista, anchoListaComponentesX1 + 30+80, 2 * auxAltura, 70, 100));
       
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("11.1"));
        auxLista.add(new Componente("11.2"));
        auxLista.add(new Componente("11.3"));
        auxLista.add(new Componente("11.4"));
        listaItems.add(new Item(9, auxLista, anchoListaComponentesX1 + 30+80, 3 * auxAltura, 70, 100));
        auxLista= new LinkedList<>();
        auxLista.add(new Componente("0"));
        listaItems.add(new Item(10, auxLista, anchoListaComponentesX1 + 30+80, 4 * auxAltura, 70, 100));

    }
}
