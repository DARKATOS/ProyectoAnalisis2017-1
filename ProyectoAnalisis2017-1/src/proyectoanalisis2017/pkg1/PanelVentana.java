/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Gianka
 */
public class PanelVentana extends javax.swing.JPanel implements KeyListener {

    /**
     * Creates new form pnlCiudad
     */
    Ciudad ciudad;
    AreaItems areaItems;
    private Boolean estaSelecionadoComponente;
    private Item itemSeleccionado;
    private int xImgSelecionada;
    private int yImgSelecionada;

    public PanelVentana() {
        initComponents();
        this.xImgSelecionada = 0;
        this.yImgSelecionada = 0;

        this.itemSeleccionado = new Item();
        this.estaSelecionadoComponente = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked
    /**
     * Evaluamos si el puntero del mouse esta en los limites del areaItem y si
     * presiona el click activamos la bandera estaSelecionadoComponente para
     * decir que ya estamos selecionado un item,seteamos el contador a cero para
     * que nos meustra la primera imagen de la lista de compoentes del item
     *
     * @param evt
     */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

        if (evt.getX() > areaItems.getAnchoListaComponentesX1() && evt.getX() < areaItems.getAnchoListaComponentesX2()) {
            for (int i = 0; i < areaItems.getListaItems().size(); i++) {
                if (areaItems.getListaItems().get(i).getArea().contains(new Point(evt.getX(), evt.getY()))) {
                    this.estaSelecionadoComponente = true;
                    areaItems.getListaItems().get(i).setContador(0);
                    this.itemSeleccionado = areaItems.getListaItems().get(i);
                }
            }
        }
    }//GEN-LAST:event_formMousePressed
    /**
     * Cuando se halla activado la bandera estaSelecionadoComponentes que es
     * cuando se preciona un item y ya cambiamos el X y Y de la imagen
     * selecionada para que la pinte de acuerdo donde va el puntero del mouse
     *
     * @param evt
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if (this.estaSelecionadoComponente) {

            this.xImgSelecionada = evt.getX();
            this.yImgSelecionada = evt.getY();
            repaint();
        }
    }//GEN-LAST:event_formMouseDragged
    /**
     * Cuando se suelta el click y adeas se tiene selecionado un item lo que
     * hace el release es que desactiva la bandera y posedemos a ubicar el
     * componente que se seleciono y ubicarlo en la matriz de la Ciudad
     *
     * @param evt
     */
    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if (this.estaSelecionadoComponente) {
            try {
                this.estaSelecionadoComponente = false;
                this.xImgSelecionada = 0;
                this.yImgSelecionada = 0;
                int auxN = evt.getY() / ciudad.getAltoCampo();
                int auxM = evt.getX() / ciudad.getAnchoCampo();
                Componente auxComponente = new Componente(itemSeleccionado.getLstComponentes().get(itemSeleccionado.getContador()).getNombre());
                ciudad.getMatrizCiudad()[auxN][auxM] = auxComponente;
            } catch (Exception e) {

            }
            repaint();
        }
    }//GEN-LAST:event_formMouseReleased

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_formKeyPressed

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        if (ciudad != null && areaItems != null) {
            g.drawImage(new ImageIcon(getClass().getResource("../ImgComponentes/Fondo.jpg")).getImage(), 0, 0, ciudad.getAnchoCiudad(), ciudad.getAltoCiudad(), this);
            g.setColor(Color.decode("#FC4600"));
            g.fillRect(areaItems.getAnchoListaComponentesX1(), 0, (areaItems.getAnchoListaComponentesX2() - ciudad.getAnchoCiudad()) * 2, ciudad.getAltoCiudad());
            g.setColor(Color.BLACK);
            pintarComponentes(g);
            // lineas de referencia de las areas de la aplicacion
            g.drawRect(0, 0, ciudad.getAnchoCiudad(), ciudad.getAltoCiudad());
            pintarCiudad(g);
            for (int i = 0; i < ciudad.getCarros().getCarros().size(); i++) {
                g.drawImage(new ImageIcon(getClass().getResource(ciudad.getCarros().getCarros().get(i).getRuta())).getImage(), ciudad.getCarros().getCarros().get(i).getX(), ciudad.getCarros().getCarros().get(i).getY(), ciudad.getAnchoCampo(), ciudad.getAltoCampo(), this);

            }

            //pinta la anamiacion de colocar imagen en el tablero
            //El 0 es el X1 de la ciudad.
            if (this.estaSelecionadoComponente && this.xImgSelecionada > 0 && this.xImgSelecionada < ciudad.getAnchoCiudad() && this.yImgSelecionada > 0 && this.yImgSelecionada < ciudad.getAltoCiudad()) {
                g.drawImage(new ImageIcon(getClass().getResource(itemSeleccionado.getLstComponentes().get(itemSeleccionado.getContador()).getRuta())).getImage(), this.xImgSelecionada, this.yImgSelecionada, 100, 100, this);
                int auxN = yImgSelecionada / ciudad.getAltoCampo();
                int auxM = xImgSelecionada / ciudad.getAnchoCampo();
                g.drawRect(auxM * ciudad.getAnchoCampo(), auxN * ciudad.getAltoCampo(), ciudad.getAnchoCampo(), ciudad.getAltoCampo());
            }
        }
        repaint();
    }

    /**
     * pintamos la lista de los item que podemos selecionar y poner en la ciudad
     *
     * @param g grafico del panel que sirve como lienzo
     */
    private void pintarComponentes(Graphics g) {
        for (int i = 0; i < areaItems.getListaItems().size(); i++) {
            Item auxComponente;
            auxComponente = areaItems.getListaItems().get(i);
            g.drawImage(new ImageIcon(getClass().getResource(auxComponente.getLstComponentes().getFirst().getRuta())).getImage(), auxComponente.getArea().x, auxComponente.getArea().y, auxComponente.getArea().width, auxComponente.getArea().height, this);
        }
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void setAreaItems(AreaItems areaItems) {
        this.areaItems = areaItems;
    }

    /**
     * Este metodos esta enfocado en recorrer la matriz de componentes y pintar
     * las difrentes imagenes asociadas ala posicion de la matriz en caso de que
     * sea null es que no hay ningun componentes entonces no se pinta nada
     *
     * @param g grafico del panel que sirve como lienzo
     */
    private void pintarCiudad(Graphics g) {
        for (int i = 0; i < this.ciudad.getN(); i++) {
            for (int j = 0; j < this.ciudad.getM(); j++) {
                if (ciudad.getMatrizCiudad()[i][j] != null && !ciudad.getMatrizCiudad()[i][j].getNombre().equals("0")) {
                    g.drawImage(new ImageIcon(getClass().getResource(ciudad.getMatrizCiudad()[i][j].getRuta())).getImage(), ciudad.getAnchoCampo() * j, ciudad.getAltoCampo() * i, ciudad.getAnchoCampo(), this.ciudad.getAltoCampo(), this);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    /**
     * detectamos que si se preciona las teclas ----- aumentamos el contador del
     * item para que cambie el componente y lo logre ubicar en la matriz de la
     * ciudad
     *
     * @param ke
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        if (itemSeleccionado.getContador() == itemSeleccionado.getLstComponentes().size() - 1) {
            this.itemSeleccionado.setContador(0);
        } else {
            itemSeleccionado.setContador(itemSeleccionado.getContador() + 1);
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    /**
     * mira si el componente es un cruce
     *
     * @param componente
     * @return true si es cruce o false si no lo es
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
