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
    private Ciudad ciudad;
    private boolean debug=false;
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
    public void stop() {
        this.hilo.stop();
    }

    public CarroMovimiento() {
    }

    public void setGrafo(GrafoDirigido grafo) {
        this.grafo = grafo;
    }

    public void setPanel(PanelVentana panel) {
        this.panel = panel;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    @Override
    public void run() {
        int velocidad;
        Boolean sentido;
        while (!getCamino().isEmpty()) {
//            if(debug)
//            {
//                System.out.println("");
//            }
            //Se obtiene la velocidad del camino
//            System.out.println("hola");
            velocidad = getCamino().getFirst().getVelocidad();
            sentido=false;
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
            if (getTipo() == 1) {
                int m = idNodoComponente((int) getArea().getX(), (int) getArea().getY());
                getCamino().removeFirst();
                buscarCamino(m);
            }
            else
            {
                
                getCamino().removeFirst();
                
            }
        }
        if (getTipo() == 0) {
            int m = idNodoComponente((int) getArea().getX(), (int) getArea().getY());
            buscarCamino(m);
            setTipo(1);
            start();
            setCiudad(panel.copiarCiudad(panel.getCiudad()));
            GrafoDirigido auxGrafo=new GrafoDirigido(ciudad.getCantidadNodos());
            auxGrafo.crearGrafo(ciudad);
            setGrafo(auxGrafo);
        }
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    
    public int idNodoComponente(int x, int y) {
        int auxX = y / this.panel.getCiudad().getAltoCampo();
        int auxY = x / this.panel.getCiudad().getAnchoCampo();
        return ciudad.getMatrizCiudad()[auxX][auxY].getIdNodo();
    }

    public void buscarCamino(int m) {
        try {
            LinkedList<Arista> posiblesCaminos = new LinkedList<>();
            for (int i = 0; i < grafo.getGrafo()[m].length; i++) {
                if (grafo.getGrafo()[m][i] != null) {
                    posiblesCaminos.add(grafo.getGrafo()[m][i]);
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

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

}
