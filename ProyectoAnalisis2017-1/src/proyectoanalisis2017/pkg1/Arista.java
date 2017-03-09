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
public class Arista {
    
    private Item listaItems[];

    public Arista(int numeroItems) {
        this.listaItems = new Item[numeroItems];
    }

    public Item[] getListaItems() {
        return listaItems;
    }

    public void setListaItems(Item[] listaItems) {
        this.listaItems = listaItems;
    }
}
