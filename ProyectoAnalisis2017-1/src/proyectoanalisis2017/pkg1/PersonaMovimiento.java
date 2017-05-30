/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.awt.Color;
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
public class PersonaMovimiento extends EntidadMovimiento implements Runnable {

    private PanelVentana panel;
    private Thread hilo;
    private GrafoNoDirigido grafo; //Grafo que reconoce el vehiculo y trabaja con la ciudad
    private Ciudad ciudad; //Ciudad que el vehiculo reconoce y trabaja en conjunto con el grafo
    private Componente ubicacion; //Ultima ubicacion conocida del vehiculo
    private LinkedList<Componente> destinos; //Lista de destinos del vedhiculo en una ruta especifica

    public PersonaMovimiento(int id, Ciudad ciudad, GrafoNoDirigido grafo, String ruta, LinkedList<Arista> camino, int tipo) {
        super(id, ciudad.getAnchoCampo(), ciudad.getAltoCampo(), ruta, camino, tipo);
        this.ciudad = ciudad;
        this.grafo = grafo;
        ubicacion = null;
        destinos = new LinkedList<>();
    }

    /**
     * Permite iniciar el hilo del carro
     */
    public void iniciar() {
        this.hilo = new Thread(this);
        this.hilo.start();
    }

    /**
     * Permite pausar el hilo del carro
     */
    public void parar() {
        this.hilo.stop();
    }

    public void setGrafo(GrafoNoDirigido grafo) {
        this.grafo = grafo;
    }

    public void setPanel(PanelVentana panel) {
        this.panel = panel;
    }

    /**
     * Permite el movimiento del carro en la ciudad segun su camino que es una
     * lista de aristas
     */
    @Override
    public void run() {
        int velocidad;
        Boolean sentido;
        while (!getCamino().isEmpty()) {
            //Se obtiene la velocidad del camino
            velocidad=40;
            sentido = false;
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
                            pasar((int) getArea().getX(), (int) getArea().getY() + (int) getArea().getHeight(), 1);
                            getArea().setLocation((int) getArea().getX(), (int) getArea().getY() + 10);
                            Thread.sleep((ciudad.getN() * ciudad.getM()) / velocidad + 100);
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
                            pasar((int) getArea().getX(), (int) getArea().getY(), 0);
                            getArea().setLocation((int) getArea().getX(), (int) getArea().getY() - 10);
                            Thread.sleep((ciudad.getN() * ciudad.getM()) / velocidad + 100);
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

                            Thread.sleep((ciudad.getN() * ciudad.getM()) / velocidad + 100);
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

                            Thread.sleep((ciudad.getN() * ciudad.getM()) / velocidad + 100);
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                        }
                        panel.repaint();
                    }
                    getArea().setLocation(auxX, (int) getArea().getY());

                    panel.repaint();
                }
            }
            if (getTipo() == 0) {
                int m = getCamino().getFirst().getY();
                getCamino().removeFirst();
                buscarCamino(m);
            } else {
                getCamino().removeFirst();
            }
        }
        if (getTipo() != 0) {
            int m = idNodoComponente((int) getArea().getX(), (int) getArea().getY());
            buscarCamino(m);
            setTipo(0);
            destinos = new LinkedList<>();
            setCiudad(panel.copiarCiudad(panel.getCiudad()));
            GrafoNoDirigido auxGrafo = new GrafoNoDirigido(ciudad.getCantidadNodos());
            auxGrafo.crearGrafo(panel.copiarCiudad(ciudad));
            setGrafo(auxGrafo);
            iniciar();
        }
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    /**
     * Permite obtener el id de un nodo de la matriz de la ciudad
     *
     * @param x
     * @param y Posicion de la matriz al que se quiere obtener el id de nodo
     * @return id de nodo
     */
    public int idNodoComponente(int x, int y) {
        x=x-5;
        int auxX = y / this.panel.getCiudad().getAltoCampo();
        int auxY = x / this.panel.getCiudad().getAnchoCampo();
        return ciudad.getMatrizCiudad()[auxX][auxY].getIdNodo();
    }

    /**
     * Permite establecer cual vehiculo puede pasar en un cruce (Semaforos
     * inteligentes)
     *
     * @param x
     * @param y
     * @param tipo
     */
    public void pasar(int x, int y, int tipo) {
        int auxI;
        int auxJ;
        if (tipo == 0) {
            auxI = (y) / ciudad.getAltoCampo();
            auxJ = (x) / ciudad.getAnchoCampo();
        } else {
            auxI = (y - 1) / ciudad.getAltoCampo();
            auxJ = (x) / ciudad.getAnchoCampo();
        }
        Boolean paso = false;

        if (tipo == 1) {
            if (auxI + 1 < ciudad.getMatrizCiudad()[auxI].length && ciudad.getMatrizCiudad()[auxI + 1][auxJ] != null && ciudad.getMatrizCiudad()[auxI + 1][auxJ].getTipoVia().equals("cruce")) {
                while (!paso) {
                    paso = true;
                    if (paso && auxJ - 1 >= 0 && auxI + 1 < ciudad.getN() && ciudad.getMatrizCiudad()[auxI + 1][auxJ - 1] != null && (ciudad.getMatrizCiudad()[auxI + 1][auxJ - 1].getTipoVia().equals("calle") || ciudad.getMatrizCiudad()[auxI + 1][auxJ - 1].getTipoVia().equals("carretera"))) {
                        paso = existeCarro(auxI + 1, auxJ - 1);
                    }
//                    if (auxI + 2 < ciudad.getM() && ciudad.getMatrizCiudad()[auxI + 2][auxJ] != null && (ciudad.getMatrizCiudad()[auxI + 2][auxJ].getTipoVia().equals("calle") || ciudad.getMatrizCiudad()[auxI + 2][auxJ].getTipoVia().equals("carretera"))) {
//                        paso = hayCarro(auxI + 2, auxJ);
//                    }
                    if (paso && auxI + 1 < ciudad.getN() && auxJ + 1 < ciudad.getM() && ciudad.getMatrizCiudad()[auxI + 1][auxJ + 1] != null && (ciudad.getMatrizCiudad()[auxI + 1][auxJ + 1].getTipoVia().equals("calle") || ciudad.getMatrizCiudad()[auxI + 1][auxJ + 1].getTipoVia().equals("carretera"))) {
                        paso = existeCarro(auxI + 1, auxJ + 1);
                    }
                    if (paso && auxI + 1 < ciudad.getN() && ciudad.getMatrizCiudad()[auxI + 1][auxJ] != null && (ciudad.getMatrizCiudad()[auxI + 1][auxJ].getTipoVia().equals("calle") || ciudad.getMatrizCiudad()[auxI + 1][auxJ].getTipoVia().equals("carretera"))) {
                        paso = existeCarro(auxI + 1, auxJ);
                    }
                    if (!paso) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(PersonaMovimiento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        } else {
            if (auxI - 1 >= 0 && ciudad.getMatrizCiudad()[auxI - 1][auxJ] != null && ciudad.getMatrizCiudad()[auxI - 1][auxJ].getTipoVia().equals("cruce")) {
                while (!paso) {

                    paso = true;
                    if (auxJ - 1 >= 0 && auxI - 1 < ciudad.getN() && ciudad.getMatrizCiudad()[auxI - 1][auxJ - 1] != null && (ciudad.getMatrizCiudad()[auxI - 1][auxJ - 1].getTipoVia().equals("calle") || ciudad.getMatrizCiudad()[auxI - 1][auxJ - 1].getTipoVia().equals("carretera"))) {
                        paso = existeCarro(auxI - 1, auxJ - 1);
                    }
                    if (paso && auxI - 1 < ciudad.getN() && auxJ + 1 < ciudad.getM() && ciudad.getMatrizCiudad()[auxI - 1][auxJ + 1] != null && (ciudad.getMatrizCiudad()[auxI - 1][auxJ + 1].getTipoVia().equals("calle") || ciudad.getMatrizCiudad()[auxI - 1][auxJ + 1].getTipoVia().equals("carretera"))) {
                        paso = existeCarro(auxI - 1, auxJ + 1);
                    }
                    if (paso && auxI - 1 >= 0 && ciudad.getMatrizCiudad()[auxI - 1][auxJ] != null && (ciudad.getMatrizCiudad()[auxI - 1][auxJ].getTipoVia().equals("calle") || ciudad.getMatrizCiudad()[auxI - 1][auxJ].getTipoVia().equals("carretera"))) {
                        paso = existeCarro(auxI - 1, auxJ);
                    }
                    if (!paso) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(PersonaMovimiento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

    }

    /**
     * Permite buscar un camino aleatorio cuando un vehiculo queda sin aristas
     * por recorrer
     *
     * @param m Posicion del vehiculo en el grafo
     */
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

    /**
     * Permite seleccionar un color para trazar el camino de un vehiculo
     *
     * @param color
     */
    public void obtenerCaminoPintar(String color) {
        if ("amarillo".equals(color)) {
            setColor(Color.YELLOW);
        } else if ("azul".equals(color)) {
            setColor(Color.BLUE);
        } else if ("verde".equals(color)) {
            setColor(Color.GREEN);
        } else {
            setColor(Color.RED);
        }
        for (int i = 0; i < getCamino().size(); i++) {
            getCaminoPintar().add((Arista) getCamino().get(i).clone());
        }
    }

    /**
     * Obtiene la ubicacion actual del vehiculo
     */
    public void reconstruirUbicacion() {
        int auxN = (int) (getArea().getY() / ciudad.getAltoCampo());
        int auxM = (int) (getArea().getX() / ciudad.getAnchoCampo());
        ubicacion = ciudad.getMatrizCiudad()[auxN][auxM];
    }

    /**
     * Permite reconstruir los destinos marcados en una ciudad luego de una
     * interrupcion Recorriendo la matriz de la ciudad y los destinos
     * verificando que las posiciones x y y sean igual y posteriormente marcando
     * como nodo el componente en la ciudad
     */
    public void recuperarDestinos() {
        for (int k = 0; k < destinos.size(); k++) {
            for (int i = 0; i < ciudad.getMatrizCiudad().length; i++) {
                for (int j = 0; j < ciudad.getMatrizCiudad()[i].length; j++) {
                    if (ciudad.getMatrizCiudad()[i][j] != null) {
                        if (destinos.get(k).getArea().getX() == ciudad.getMatrizCiudad()[i][j].getArea().getX() && destinos.get(k).getArea().getY() == ciudad.getMatrizCiudad()[i][j].getArea().getY()) {
                            ciudad.marcarNodo(ciudad.getMatrizCiudad()[i][j]);
                        }
                    }

                }
            }
        }
    }

    /**
     * Permite reconstruir la lista de destinos luego de alguna interrupcion
     * recorriendo la ciudad y los destinos verificando que sus posiciones en x
     * y y sean iguales y posteriormente añadiendo a la lista de destinos el
     * componente
     */
    public void reconstruirDestinos() {
        LinkedList<Componente> auxDestinos = new LinkedList<>();
        for (int k = 0; k < destinos.size(); k++) {
            for (int i = 0; i < ciudad.getMatrizCiudad().length; i++) {
                for (int j = 0; j < ciudad.getMatrizCiudad()[i].length; j++) {
                    if (ciudad.getMatrizCiudad()[i][j] != null) {
                        if (destinos.get(k).getArea().getX() == ciudad.getMatrizCiudad()[i][j].getArea().getX() && destinos.get(k).getArea().getY() == ciudad.getMatrizCiudad()[i][j].getArea().getY()) {
                            auxDestinos.add(ciudad.getMatrizCiudad()[i][j]);
                        }
                    }

                }
            }
        }
        destinos = auxDestinos;
    }

    public void setDestinos(LinkedList<Componente> destinos) {
        this.destinos = destinos;
    }

    public GrafoNoDirigido getGrafo() {
        return grafo;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Permite verificar si en alguna posición determinada de la matriz existe
     * un carro.
     *
     * @param i
     * @param j Posiciones de la matriz en donde se verifica si en ese momento
     * existe un carro
     * @return true o false si existe un carro en la posicion de la matriz
     */
    private Boolean existeCarro(int i, int j) {
        Boolean respuesta = true;
        for (int k = 0; k < panel.getCarrosMovimiento().size() && respuesta; k++) {
            if (ciudad.getMatrizCiudad()[i][j].getArea().contains(new Point((int) panel.getCarrosMovimiento().get(k).getArea().getX(), (int) panel.getCarrosMovimiento().get(k).getArea().getY()))) {
                respuesta = false;
            }
        }
        return respuesta;
    }

    public LinkedList<Componente> getDestinos() {
        return destinos;
    }

    public void setUbicacion(Componente ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Componente getUbicacion() {
        return ubicacion;
    }
}
