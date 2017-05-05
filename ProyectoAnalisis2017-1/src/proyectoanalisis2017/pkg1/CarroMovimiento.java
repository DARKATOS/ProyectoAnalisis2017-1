/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class CarroMovimiento extends Carro implements Runnable {

    private PanelVentana panel;
    private Thread hilo;
    private GrafoDirigido grafo;
//    private Boolean esperando;

    public CarroMovimiento(int id, int ancho, int alto, LinkedList<Arista> camino, int tipo) {
        super(id, ancho, alto, camino, tipo);
//        this.esperando = false;
    }

    /**
     * Permite iniciar el hilo del carro
     */
    public void start() {
        this.hilo = new Thread(this);
        this.hilo.start();
    }

    /**
     * Permite pausar el hilo del carro
     */
    public void pause() {
        this.hilo.suspend();
    }

    public CarroMovimiento() {
    }

    public void setGrafo(GrafoDirigido grafo) {
        this.grafo = grafo;
    }

    public void setPanel(PanelVentana panel) {
        this.panel = panel;
    }

    @Override
    public void run() {
        int m = 0;
        int n = 0;
        int auxN = 0;
        int auxM = 0;
        int velocidad;
        //Siempre esta corriendo el hilo
//        while (true) {    CAMBIO MIO
        //Mientras exista un camino
        while (!getCamino().isEmpty()) {
            //Se obtiene la velocidad del camino
            velocidad = getCamino().getFirst().getVelocidad();
            Boolean sentido;
            if (getCamino().getFirst().getX1() == getCamino().getFirst().getX2()) {
                int auxY;
                if ((int) getArea().getY() == getCamino().getFirst().getY1()) {
                    auxY = getCamino().getFirst().getY2();
                } else {
                    auxY = getCamino().getFirst().getY1();
                }
                if ((int) getArea().getY() < auxY) {
                    sentido = true;//incrementar
                } else {
                    sentido = false;
                }
                if (sentido) {
                    while ((int) getArea().getY() < auxY) {
                        try {
                            getArea().setLocation((int) getArea().getX(), (int) getArea().getY() + 10);
                            Thread.sleep(velocidad);
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                        }
                        panel.repaint();
                    }
                    getArea().setLocation((int) getArea().getX(), auxY);
                    panel.repaint();
                } else {
                    while ((int) getArea().getY() > auxY) {
                        try {
                            getArea().setLocation((int) getArea().getX(), (int) getArea().getY() - 10);

                            Thread.sleep(velocidad);
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                        }
                        panel.repaint();
                    }
                    getArea().setLocation((int) getArea().getX(), auxY);

                    panel.repaint();
                }
            } else {
                int auxX;

                if ((int) getArea().getX() == getCamino().getFirst().getX1()) {
                    auxX = getCamino().getFirst().getX2();
                } else {
                    auxX = getCamino().getFirst().getX1();
                }
                if ((int) getArea().getX() < auxX) {
                    sentido = true;// invrementar
                } else {
                    sentido = false;
                }
                if (sentido) {
                    while ((int) getArea().getX() < auxX) {
                        try {
                            getArea().setLocation((int) getArea().getX() + 10, (int) getArea().getY());

                            Thread.sleep(velocidad);
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                        }
                        panel.repaint();
                    }
                    getArea().setLocation(auxX, (int) getArea().getY());

                    panel.repaint();
                } else {
                    while ((int) getArea().getX() > auxX) {
                        try {
                            getArea().setLocation((int) getArea().getX() - 10, (int) getArea().getY());

                            Thread.sleep(velocidad);
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                        }
                        panel.repaint();
                    }
                    getArea().setLocation(auxX, (int) getArea().getY());

                    panel.repaint();
                }
            }

            m = idNodoComponente((int) getArea().getX(), (int) getArea().getY());
//            auxN = getCamino().getFirst().getX1();
//            auxM = getCamino().getFirst().getY1();
            getCamino().removeFirst();
            if (getTipo() == 1) {
                buscarCamino(m);
            }
        }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(CarroMovimiento.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            m = idNodoComponente((int) getArea().getX(), (int) getArea().getY());
//            setTipo(1);
//            buscarCamino(m, auxN, auxM);
//        }
    }

    public int idNodoComponente(int x, int y) {
        int auxX = y / this.panel.getCiudad().getAltoCampo();
        int auxY = x / this.panel.getCiudad().getAnchoCampo();
        return this.panel.getCiudad().getMatrizCiudad()[auxX][auxY].getIdNodo();
    }

    public int buscarNodo(int x, int y, int anchoCampoCiudad, int altoCampoCiudad) {
        int auxN = y / altoCampoCiudad;
        int auxM = x / anchoCampoCiudad;
        Componente auxComponente = panel.getCiudad().getMatrizCiudad()[auxN][auxM];

        return auxComponente.getIdNodo();
    }

    public Componente buscarComponente(int x, int y) {
        int auxN = y / panel.getCiudad().getAltoCampo();
        int auxM = x / panel.getCiudad().getAnchoCampo();
        return panel.getCiudad().getMatrizCiudad()[auxN][auxM];
    }

    public void buscarCamino(int m) {
        try {
            LinkedList<Arista> posiblesCaminos = new LinkedList<>();
            for (int i = 0; i < this.grafo.getGrafo()[m].length; i++) {
                if (this.grafo.getGrafo()[m][i] != null) {
                    posiblesCaminos.add(this.grafo.getGrafo()[m][i]);
                }
            }
            if (!posiblesCaminos.isEmpty()) {
                int numero = posiblesCaminos.size();
                Random rnd = new Random();
                int num = (int) (rnd.nextDouble() * numero + 0);
                this.getCamino().add(posiblesCaminos.get(num));
            }
        } catch (Exception e) {
            System.out.println("eeeeeeoorro");
        }
    }

    public GrafoDirigido getGrafo() {
        return grafo;
    }

    private void esperandoCamino(int n) {
//        this.esperando = true;
//        while (this.esperando) {
//            System.out.println("esperando");
//        }
        Componente auxComponenteEsperando = buscarComponente((int) getArea().getX(), (int) getArea().getY());
        Componente auxComponenteDestino = new Componente();
        LinkedList<Arista> posiblesCaminos = new LinkedList<>();
        for (int i = 0; i < this.grafo.getGrafo()[n].length; i++) {
            if (this.grafo.getGrafo()[n][i] != null) {
                posiblesCaminos.add(this.grafo.getGrafo()[n][i]);
            }
        }
        int destino = 0;
        for (int i = 0; i < posiblesCaminos.size(); i++) {
            Rectangle auxRectangulo = new Rectangle(posiblesCaminos.get(i).getX1(), posiblesCaminos.get(i).getY1(), posiblesCaminos.get(i).getY2() - posiblesCaminos.get(i).getY().getIdNodo(), 10);
            if (auxRectangulo.contains(new Point((int) getArea().getX(), (int) getArea().getY())));
            {
                destino = posiblesCaminos.get(i).getY().getIdNodo();
            }
        }
        for (int i = 0; i < panel.getCiudad().getN(); i++) {
            for (int j = 0; j < panel.getCiudad().getM(); j++) {
                if (panel.getCiudad().getMatrizCiudad()[i][j] != null && panel.getCiudad().getMatrizCiudad()[i][j].getIdNodo() == destino) {
                    auxComponenteDestino = panel.getCiudad().getMatrizCiudad()[i][j];
                }
            }
        }
        getCamino().add(new Arista((int) auxComponenteEsperando.getArea().getX(), (int) auxComponenteDestino.getArea().getX(), (int) auxComponenteEsperando.getArea().getY(), (int) auxComponenteDestino.getArea().getY(), 60, 0, auxComponenteDestino));
    }

//    public Boolean getEsperando() {
//        return esperando;
//    }
//
//    public void setEsperando(Boolean esperando) {
//        this.esperando = esperando;
//    }

}
