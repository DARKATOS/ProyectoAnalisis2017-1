/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author root
 */
public class CarroMovimiento extends Carro implements Runnable {

    private PanelVentana panel;
    private Thread hilo;
    private GrafoDirigido grafo;

    public CarroMovimiento(int id, int x, int y, LinkedList<Arista> camino, int tipo) {
        super(id, x, y, camino, tipo);

    }

    public void start() {
        this.hilo = new Thread(this);
        this.hilo.start();
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
        int velocidad = 0;
        while (true) {
            while (!getCamino().isEmpty()) {
                velocidad = getCamino().getFirst().getVelocidad();
                Boolean sentido = false;
                if (getCamino().getFirst().getX1() == getCamino().getFirst().getX2()) {
                    int auxY = 0;
                    if (getY() == getCamino().getFirst().getY1()) {
                        auxY = getCamino().getFirst().getY2();
                    } else {
                        auxY = getCamino().getFirst().getY1();
                    }
                    if (getY() < auxY) {
                        sentido = true;//incrementar
                    } else {
                        sentido = false;
                    }
                    if (sentido) {
                        while (getY() < auxY) {
                            try {
                                setY(getY() + 10);
                                Thread.sleep(velocidad);
                            } catch (InterruptedException ex) {
                                System.out.println(ex.getMessage());
                            }
                            panel.repaint();
                        }
                        setY(auxY);
                        panel.repaint();
                    } else {
                        while (getY() > auxY) {
                            try {
                                setY(getY() - 10);
                                Thread.sleep(velocidad);
                            } catch (InterruptedException ex) {
                                System.out.println(ex.getMessage());
                            }
                            panel.repaint();
                        }
                        setY(auxY);
                        panel.repaint();
                    }
                } else {
                    int auxX;

                    if (getX() == getCamino().getFirst().getX1()) {
                        auxX = getCamino().getFirst().getX2();
                    } else {
                        auxX = getCamino().getFirst().getX1();
                    }
                    if (getX() < auxX) {
                        sentido = true;// invrementar
                    } else {
                        sentido = false;
                    }
                    if (sentido) {
                        while (getX() < auxX) {
                            try {
                                setX(getX() + 10);

                                Thread.sleep(velocidad);
                            } catch (InterruptedException ex) {
                                System.out.println(ex.getMessage());
                            }
                            panel.repaint();
                        }
                        setX(auxX);
                        panel.repaint();
                    } else {
                        while (getX() > auxX) {
                            try {
                                setX(getX() - 10);
                                Thread.sleep(velocidad);
                            } catch (InterruptedException ex) {
                                System.out.println(ex.getMessage());
                            }
                            panel.repaint();
                        }
                        setX(auxX);
                        panel.repaint();
                    }
                }
                int n = getCamino().getFirst().getX();
                int m = getCamino().getFirst().getY();
                getCamino().removeFirst();

                if (getTipo() == 1) {
                    buscarCamino(n, m);
                }
            }
        }
    }

    private void buscarCamino(int n, int m) {
        try {
            LinkedList<Arista> posiblesCaminos = new LinkedList<>();
            for (int i = 0; i < this.grafo.getGrafo()[m].length; i++) {
                if (this.grafo.getGrafo()[m][i] != null) {
                    posiblesCaminos.add(this.grafo.getGrafo()[m][i]);
                }
            }
            int numero = posiblesCaminos.size();
            Random rnd = new Random();
            int num = (int) (rnd.nextDouble() * numero + 0);
            this.getCamino().add(posiblesCaminos.get(num));
        } catch (Exception e) {
        }
    }

}
