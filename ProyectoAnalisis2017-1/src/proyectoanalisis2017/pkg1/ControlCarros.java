/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class ControlCarros implements Runnable, Serializable {

    private LinkedList<Carro> carros;
    private Thread hiloCarros;

    public ControlCarros() {
        this.carros = new LinkedList<>();
    }

    public void start() {
        this.hiloCarros = new Thread(this);
        this.hiloCarros.start();
    }

    @Override
    public void run() {
        int velocidad = 0;
        while (true) {
            for (int i = 0; i < this.carros.size(); i++) {
                while (!this.carros.get(i).getCamino().isEmpty()) {
                    velocidad = this.carros.get(i).getCamino().getFirst().getVelocidad();
                    Boolean sentido = false;
                    if (this.carros.get(i).getCamino().getFirst().getX1() == this.carros.get(i).getCamino().getFirst().getX2()) {
                        int auxY = 0;
                        if (this.carros.get(i).getY() == this.carros.get(i).getCamino().getFirst().getY1()) {
                            auxY = this.carros.get(i).getCamino().getFirst().getY2();
                        } else {
                            auxY = this.carros.get(i).getCamino().getFirst().getY1();
                        }
                        if(this.carros.get(i).getY() < auxY) {
                            sentido = true;//incrementar
                        } else {
                            sentido = false;
                        }
                        if (sentido) {
                            while (this.carros.get(i).getY() < auxY) {
                                try {
                                    this.carros.get(i).setY(this.carros.get(i).getY() + 10);
                                    Thread.sleep(velocidad);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(ControlCarros.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            this.carros.get(i).setY(auxY);
                        } else {
                            while (this.carros.get(i).getY() > auxY) {
                                try {
                                    this.carros.get(i).setY(this.carros.get(i).getY() - 10);
                                    Thread.sleep(velocidad);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(ControlCarros.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            this.carros.get(i).setY(auxY);
                        }
                    } else {
                        int auxX = 0;

                        if (this.carros.get(i).getX() == this.carros.get(i).getCamino().getFirst().getX1()) {
                            auxX = this.carros.get(i).getCamino().getFirst().getX2();
                        } else {
                            auxX = this.carros.get(i).getCamino().getFirst().getX1();
                        }
                        if (this.carros.get(i).getX() < auxX) {
                            sentido = true;// invrementar
                        } else {
                            sentido = false;
                        }
                        if (sentido) {
                            while (this.carros.get(i).getX() < auxX) {
                                try {
                                    this.carros.get(i).setX(this.carros.get(i).getX() + 10);

                                    Thread.sleep(velocidad);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(ControlCarros.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            this.carros.get(i).setX(auxX);
                        } else {
                            while (this.carros.get(i).getX() > auxX) {
                                try {
                                    this.carros.get(i).setX(this.carros.get(i).getX() - 10);
                                    Thread.sleep(velocidad);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(ControlCarros.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            this.carros.get(i).setX(auxX);
                        }
                    }
                    this.carros.get(i).getCamino().removeFirst();
                }
            }
        }
    }

    public void setCarros(LinkedList<Carro> carros) {
        this.carros = carros;
    }

    public LinkedList<Carro> getCarros() {
        return carros;
    }

}
