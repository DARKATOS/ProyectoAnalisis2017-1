/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.util.LinkedList;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class GrafoNoDirigido implements Cloneable {

    //Matriz grafo de tipo arista, cada una de las filas representa un id de alguno de los cruces.
    Arista grafo[][];

    /**
     * Contructor para la matriz de aristas.
     *
     * @param numeroCruces Es el numero de cruces obtenido de la matriz de la
     * ciudad
     */
    public GrafoNoDirigido(int numeroCruces) {
        grafo = new Arista[numeroCruces][numeroCruces];
    }

    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("No se puede clonar");
        }
        return obj;
    }

    public GrafoNoDirigido() {
    }

    /**
     * Inicializo la matriz del grafo en nulos.
     */
    public void iniciarlizarGrafo() {
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo.length; j++) {
                grafo[i][j] = null;
            }
        }
    }

    /**
     * Vamos ha representar el grafo mendiantes una matriz de adyacencias
     * dependiendo de la matriz de componentes de la ciudad mirando si es nodo y
     * que tenga via recoriendo hacia arriba,hacia abajo, hacia la derecha y
     * hacia la izquerda buscado un nodo y ahi se crea la arista y volviendo
     * null ese recorrido para que no se vuelva a repetir
     *
     * @param matrizCiudad matriz de la ciudad que tenemos diseñada
     */
    public void crearGrafo(Ciudad auxCiudad) {
        Componente[][] matrizCiudad = auxCiudad.getMatrizCiudad();
        for (int i = 0; i < matrizCiudad.length; i++) {
            for (int j = 0; j < matrizCiudad[i].length; j++) {
                if (matrizCiudad[i][j] != null && matrizCiudad[i][j].getIdNodo() != -1) {
//                    if (j - 1 >= 0 && matrizCiudad[i][j - 1] != null && (matrizCiudad[i][j - 1].getTipoVia().equals("calle") || matrizCiudad[i][j - 1].getTipoVia().equals("carretera") || matrizCiudad[i][j - 1].getTipoVia().equals("cebra"))) {
//                        verArista(matrizCiudad, i, j - 1, matrizCiudad[i][j], i, j, auxCiudad.getAnchoCampo(), auxCiudad.getAltoCampo(), 2);
//                    }
                    if (j + 1 < matrizCiudad[i].length && matrizCiudad[i][j + 1] != null && (matrizCiudad[i][j + 1].getTipoVia().equals("calle") || matrizCiudad[i][j + 1].getTipoVia().equals("carretera") || matrizCiudad[i][j + 1].getTipoVia().equals("cebra") || matrizCiudad[i][j + 1].getTipoVia().equals("cruce"))) {

                        verArista(matrizCiudad, i, j + 1, matrizCiudad[i][j], i, j, auxCiudad.getAnchoCampo(), auxCiudad.getAltoCampo(), 1);
                    }
//                    if (i - 1 >= 0 && matrizCiudad[i - 1][j] != null && (matrizCiudad[i - 1][j].getTipoVia().equals("calle") || matrizCiudad[i - 1][j].getTipoVia().equals("carretera") || matrizCiudad[i - 1][j].getTipoVia().equals("cebra"))) {
//                        verArista(matrizCiudad, i - 1, j, matrizCiudad[i][j], i, j, auxCiudad.getAnchoCampo(), auxCiudad.getAltoCampo(), 3);
//                    }
                    if (i + 1 < matrizCiudad.length && matrizCiudad[i + 1][j] != null && (matrizCiudad[i + 1][j].getTipoVia().equals("calle") || matrizCiudad[i + 1][j].getTipoVia().equals("carretera") || matrizCiudad[i + 1][j].getTipoVia().equals("cebra") || matrizCiudad[i + 1][j].getTipoVia().equals("cruce"))) {
                        verArista(matrizCiudad, i + 1, j, matrizCiudad[i][j], i, j, auxCiudad.getAnchoCampo(), auxCiudad.getAltoCampo(), 4);
                    }
                }
            }
        }
    }

    public void completarGrafo(Ciudad auxCiudad) {
        Componente[][] matrizCiudad = auxCiudad.getMatrizCiudad();
        for (int i = 0; i < matrizCiudad.length; i++) {
            for (int j = 0; j < matrizCiudad[i].length; j++) {
                if (matrizCiudad[i][j] != null && matrizCiudad[i][j].getIdNodo() != -1 && matrizCiudad[i][j].getTipoVia().equals("cruce")) {
                    if (j - 1 < 0 || matrizCiudad[i][j - 1] == null || (!matrizCiudad[i][j - 1].getTipoVia().equals("calle") && !matrizCiudad[i][j - 1].getTipoVia().equals("carretera") && !matrizCiudad[i][j - 1].getTipoVia().equals("cebra") && !matrizCiudad[i - 1][j].getTipoVia().equals("cebra"))) {
                        añadirArista( new Arista((int) matrizCiudad[i][j].getArea().getX(), (int) matrizCiudad[i][j].getArea().getX(), (int) matrizCiudad[i][j].getArea().getY(), (int) matrizCiudad[i][j].getArea().getY() + auxCiudad.getAltoCampo(), -1, -1, new LinkedList<>()), matrizCiudad[i][j].getIdNodo(), matrizCiudad[i][j].getIdNodo() + 2);
                    }
                    if (j + 1 >= matrizCiudad[i].length || matrizCiudad[i][j + 1] == null || (!matrizCiudad[i][j + 1].getTipoVia().equals("calle") && !matrizCiudad[i][j + 1].getTipoVia().equals("carretera") && !matrizCiudad[i][j + 1].getTipoVia().equals("cebra") && !matrizCiudad[i][j + 1].getTipoVia().equals("cruce"))) {

                        añadirArista(new Arista((int) matrizCiudad[i][j].getArea().getX() + auxCiudad.getAnchoCampo(), (int) matrizCiudad[i][j].getArea().getX() + auxCiudad.getAnchoCampo(), (int) matrizCiudad[i][j].getArea().getY(), (int) matrizCiudad[i][j].getArea().getY() + auxCiudad.getAltoCampo(), -1, -1, new LinkedList<>()), matrizCiudad[i][j].getIdNodo() + 1, matrizCiudad[i][j].getIdNodo() + 3);
                    }
                    if (i - 1 < 0 || matrizCiudad[i - 1][j] == null || (!matrizCiudad[i - 1][j].getTipoVia().equals("calle") && !matrizCiudad[i - 1][j].getTipoVia().equals("carretera") && !matrizCiudad[i - 1][j].getTipoVia().equals("cebra"))) {
                        añadirArista( new Arista((int) matrizCiudad[i][j].getArea().getX(), (int) matrizCiudad[i][j].getArea().getX() + auxCiudad.getAnchoCampo(), (int) matrizCiudad[i][j].getArea().getY(), (int) matrizCiudad[i][j].getArea().getY(), -1, -1, new LinkedList<>()), matrizCiudad[i][j].getIdNodo(), matrizCiudad[i][j].getIdNodo() + 1);
                    }
                    if (i + 1 >= matrizCiudad.length || matrizCiudad[i + 1][j] == null || (!matrizCiudad[i + 1][j].getTipoVia().equals("calle") && !matrizCiudad[i + 1][j].getTipoVia().equals("carretera") && !matrizCiudad[i + 1][j].getTipoVia().equals("cebra") && !matrizCiudad[i + 1][j].getTipoVia().equals("cruce"))) {
                        añadirArista(new Arista((int) matrizCiudad[i][j].getArea().getX(), (int) matrizCiudad[i][j].getArea().getX() + auxCiudad.getAnchoCampo(), (int) matrizCiudad[i][j].getArea().getY() + auxCiudad.getAltoCampo(), (int) matrizCiudad[i][j].getArea().getY() + auxCiudad.getAltoCampo(), -1, -1, new LinkedList<>()), matrizCiudad[i][j].getIdNodo() + 2, matrizCiudad[i][j].getIdNodo() + 3);
                    }
                }
                if (matrizCiudad[i][j] != null && matrizCiudad[i][j].getIdNodo() != -1 && matrizCiudad[i][j].getTipoVia().equals("cebra")) {

                    if (matrizCiudad[i][j].getNombre().equals("B.1")) {
                        añadirArista( new Arista((int) matrizCiudad[i][j].getArea().getX(), (int) matrizCiudad[i][j].getArea().getX() + auxCiudad.getAnchoCampo(), (int) matrizCiudad[i][j].getArea().getY(), (int) matrizCiudad[i][j].getArea().getY(), -1, -1, new LinkedList<>()), matrizCiudad[i][j].getIdNodo(), matrizCiudad[i][j].getIdNodo() + 1);

                    } else {
                        añadirArista( new Arista((int) matrizCiudad[i][j].getArea().getX(), (int) matrizCiudad[i][j].getArea().getX(), (int) matrizCiudad[i][j].getArea().getY(), (int) matrizCiudad[i][j].getArea().getY() + auxCiudad.getAltoCampo(), -1, -1, new LinkedList<>()), matrizCiudad[i][j].getIdNodo(), matrizCiudad[i][j].getIdNodo() + 1);

                    }
                }
            }

        }
    }
    //    public void crearGrafo(Componente[][] matrizCiudad, int anchoCuadroCiudad, int altoCuadroCiudad) {
    //        for (int i = 0; i < matrizCiudad.length; i++) {
    //            for (int j = 0; j < matrizCiudad[i].length; j++) {
    //                if (matrizCiudad[i][j] != null && matrizCiudad[i][j].getIdNodo() != -1) {
    //                    if (j - 1 >= 0 && matrizCiudad[i][j - 1] != null && (matrizCiudad[i][j - 1].getTipoVia().equals("calle") || matrizCiudad[i][j - 1].getTipoVia().equals("carretera"))) {
    //                        verArista(matrizCiudad, i, j - 1, matrizCiudad[i][j], i, j, anchoCuadroCiudad, altoCuadroCiudad, 2);
    //                    }
    //                    if (j + 1 < matrizCiudad[i].length && matrizCiudad[i][j + 1] != null && (matrizCiudad[i][j + 1].getTipoVia().equals("calle") || matrizCiudad[i][j + 1].getTipoVia().equals("carretera"))) {
    //
    //                        verArista(matrizCiudad, i, j + 1, matrizCiudad[i][j], i, j, anchoCuadroCiudad, altoCuadroCiudad, 1);
    //                    }
    //                    if (i - 1 >= 0 && matrizCiudad[i - 1][j] != null && (matrizCiudad[i - 1][j].getTipoVia().equals("calle") || matrizCiudad[i - 1][j].getTipoVia().equals("carretera"))) {
    //                        verArista(matrizCiudad, i - 1, j, matrizCiudad[i][j], i, j, anchoCuadroCiudad, altoCuadroCiudad, 3);
    //                    }
    //                    if (i + 1 < matrizCiudad.length && matrizCiudad[i + 1][j] != null && (matrizCiudad[i + 1][j].getTipoVia().equals("calle") || matrizCiudad[i + 1][j].getTipoVia().equals("carretera"))) {
    //                        verArista(matrizCiudad, i + 1, j, matrizCiudad[i][j], i, j, anchoCuadroCiudad, altoCuadroCiudad, 4);
    //                    }
    //                }
    //            }
    //        }
    //    }

    /**
     * Procedemos a crear la arista que se va asignar al grafo validado si es
     * carretera o caller para la velocidad
     *
     * @param x1 inicio de arista en x
     * @param y1 incio de arista en y
     * @param x2 fin de arrista en x
     * @param y2 fin de arista en y
     * @param lstComponentes los componente que contiene esa arista
     * @return arista creada con los todos sus paramentros
     */
    private Arista crearArista(int x1, int y1, int x2, int y2, LinkedList<Componente> lstComponentes) {
        Arista auxArista;
        if (lstComponentes.getFirst().getTipoVia().equals("carretera")) {
            auxArista = new Arista(x1, x2, y1, y2, 80, lstComponentes.getFirst().getTipo(), lstComponentes);
        } else {
            auxArista = new Arista(x1, x2, y1, y2, 60, lstComponentes.getFirst().getTipo(), lstComponentes);
        }

        return auxArista;
    }

    /**
     * Añade la arista al grafo dependiendo la direccion del de la arista se
     * agrega en la matriz del grafo
     *
     * @param x identificador del primero nodo
     * @param y identidicador del segundo nodo
     * @param arista arista a asignar
     */
    private void añadirArista (Arista arista, int idOrigen, int idDestino) {

        arista.setX(idOrigen);
        arista.setY(idDestino);
        this.grafo[idOrigen][idDestino] = arista;
        Arista aris = (Arista) arista.clone();
        aris.setX(idDestino);
        aris.setY(idOrigen);
        this.grafo[idDestino][idOrigen] = aris;

    }

    /**
     * Aqui es el recorrido buscando el otro nodo para hacer la arista y cada
     * que va encontrando un componen via y que nos es nodo va agregando en un
     * lista de componente y cuanod ya encuentra un nodo crea la arista y luego
     * añade al grafo
     *
     * @param matrizCiudad Matriz de la cidudad
     * @param i indice de fila donde empieza el recorrido no es del nodo si no
     * del siguente
     * @param j indice de columna donde empieza el recorrido no es del nodo si
     * no del siguente
     * @param origen indice de fila del nodo que se le va hacer el recorrido
     * @param tamaño indice de columna del nodo que se lava hacer el recorrido
     * @param opcion si es 1 busca hacia la derecha si es 2 busca a izquierda 3
     * busca hacia arriba y 4 busca hacia arriba
     */
    private void verArista(Componente[][] matrizCiudad, int i, int j, Componente idNodoorigen, int xOrigen, int yOrigen, int ancho, int alto, int opcion) {
        LinkedList<Componente> auxListaComponentes = new LinkedList<>();
        Arista auxArista;
        Arista auxArista1;
        Boolean bandera = false;
        while (i >= 0 && i <= matrizCiudad.length - 1 && j >= 0 && j < matrizCiudad[0].length - 1 && matrizCiudad[i][j].getIdNodo() == -1) {
            bandera = true;
            auxListaComponentes.add(matrizCiudad[i][j]);
            matrizCiudad[i][j] = null;
            switch (opcion) {
                case 1:
                    j++;
                    break;
                case 4:
                    i++;
                    break;
            }
        }
        if (i < 0) {
            i = 0;
        } else if (i > matrizCiudad.length - 1) {
            i = matrizCiudad.length - 1;
        } else if (j < 0) {
            j = 0;
        } else if (j > matrizCiudad[0].length - 1) {
            j = matrizCiudad[0].length - 1;
        }
        if (bandera == false) {
            auxListaComponentes.add(matrizCiudad[i][j]);
        }
        Componente destino = matrizCiudad[i][j];
        int auxOrigen = 0;
        int auxDestino = 0;
        int auxOrigen1 = 0;
        int auxDestino1 = 0;
        int x1, y1, x2, y2 = 0;
        int x3, y3, x4, y4 = 0;
        if (esVertical(yOrigen * ancho, j * ancho)) {
            if (destinoCalle(idNodoorigen)) {
                x1 = (int) idNodoorigen.getArea().getX();
                y1 = (int) idNodoorigen.getArea().getY();
                x2 = x1 + ancho;
                y2 = y1;
                auxOrigen = idNodoorigen.getIdNodo();
                auxOrigen1 = idNodoorigen.getIdNodo() + 1;
                if (destino.getTipoVia().equals("cebra") || destino.getTipoVia().equals("cruce")) {
                    x3 = (int) destino.getArea().getX();
                    y3 = (int) destino.getArea().getY();
                    x4 = x3 + ancho;
                    y4 = y3;
                    auxDestino = destino.getIdNodo();
                    auxDestino1 = destino.getIdNodo() + 1;
                    auxArista = new Arista(x1, x3, y1, y3, -1, -1, auxListaComponentes);
                    auxArista1 = new Arista(x2, x4, y2, y4, -1, -1, auxListaComponentes);
                    añadirArista(auxArista, auxOrigen, auxDestino);
                    añadirArista(auxArista1, auxOrigen1, auxDestino1);
                } else {
                    x3 = (int) destino.getArea().getX();
                    y3 = (int) destino.getArea().getY() + alto;
                    x4 = x3 + ancho;
                    y4 = y3 + alto;
                    auxDestino = destino.getIdNodo();
                    auxDestino1 = destino.getIdNodo() + 1;
                    auxArista = new Arista(x1, x3, y1, y3, -1, -1, auxListaComponentes);
                    auxArista1 = new Arista(x2, x4, y2, y4, -1, -1, auxListaComponentes);
                    añadirArista(auxArista, auxOrigen, auxDestino);
                    añadirArista( auxArista1, auxOrigen1, auxDestino1);
                }

            } else {
                x1 = (int) idNodoorigen.getArea().getX();
                y1 = (int) idNodoorigen.getArea().getY() + alto;
                x2 = x1 + ancho;
                y2 = y1;
                auxOrigen = idNodoorigen.getIdNodo() + 2;
                auxOrigen1 = idNodoorigen.getIdNodo() + 3;
                if (destino.getTipoVia().equals("cebra") || destino.getTipoVia().equals("cruce")) {
                    x3 = (int) destino.getArea().getX();
                    y3 = (int) destino.getArea().getY();
                    x4 = x3 + ancho;
                    y4 = y3;
                    auxDestino = destino.getIdNodo();
                    auxDestino1 = destino.getIdNodo() + 1;
                    auxArista = new Arista(x1, x3, y1, y3, -1, -1, auxListaComponentes);
                    auxArista1 = new Arista(x2, x4, y2, y4, -1, -1, auxListaComponentes);
                    añadirArista( auxArista, auxOrigen, auxDestino);
                    añadirArista( auxArista1, auxOrigen1, auxDestino1);
                } else {
                    x3 = (int) destino.getArea().getX();
                    y3 = (int) destino.getArea().getY() + alto;
                    x4 = x3 + ancho;
                    y4 = y3;
                    auxDestino = destino.getIdNodo();
                    auxDestino1 = destino.getIdNodo() + 1;
                    auxArista = new Arista(x1, x3, y1, y3, -1, -1, auxListaComponentes);
                    auxArista1 = new Arista(x2, x4, y2, y4, -1, -1, auxListaComponentes);
                    añadirArista(auxArista, auxOrigen, auxDestino);
                    añadirArista(auxArista1, auxOrigen1, auxDestino1);
                }

            }
            //        if (yOrigen * ancho == j * ancho) {
//            auxArista1 = crearArista(yOrigen * ancho, (xOrigen * alto) + alto, j * ancho, (i * alto) + alto, auxListaComponentes);
//        } else {
//            auxArista1 = crearArista((yOrigen * ancho) + ancho, xOrigen * alto, (j * ancho) + ancho, i * alto, auxListaComponentes);
//        }

        } else {
            if (destinoCalle(idNodoorigen)) {
                x1 = (int) idNodoorigen.getArea().getX();
                y1 = (int) idNodoorigen.getArea().getY();
                x2 = x1;
                y2 = y1 + alto;
                auxOrigen = idNodoorigen.getIdNodo();
                auxOrigen1 = idNodoorigen.getIdNodo() + 1;
                if (destino.getTipoVia().equals("cebra")) {
                    x3 = (int) destino.getArea().getX();
                    y3 = (int) destino.getArea().getY();
                    x4 = x3;
                    y4 = y3 + alto;
                    auxDestino = destino.getIdNodo();
                    auxDestino1 = destino.getIdNodo() + 1;
                    auxArista = new Arista(x1, x3, y1, y3, -1, -1, auxListaComponentes);
                    auxArista1 = new Arista(x2, x4, y2, y4, -1, -1, auxListaComponentes);
                    añadirArista( auxArista, auxOrigen, auxDestino);
                    añadirArista(auxArista1, auxOrigen1, auxDestino1);
                } else if (destino.getTipoVia().equals("cruce")) {
                    x3 = (int) destino.getArea().getX();
                    y3 = (int) destino.getArea().getY();
                    x4 = x3;
                    y4 = y3 + alto;
                    auxDestino = destino.getIdNodo();
                    auxDestino1 = destino.getIdNodo() + 2;
                    auxArista = new Arista(x1, x3, y1, y3, -1, -1, auxListaComponentes);
                    auxArista1 = new Arista(x2, x4, y2, y4, -1, -1, auxListaComponentes);
                    añadirArista(auxArista, auxOrigen, auxDestino);
                    añadirArista( auxArista1, auxOrigen1, auxDestino1);
                } else {
                    x3 = (int) destino.getArea().getX() + ancho;
                    y3 = (int) destino.getArea().getY();
                    x4 = x3;
                    y4 = y3 + alto;
                    auxDestino = destino.getIdNodo();
                    auxDestino1 = destino.getIdNodo() + 1;
                    auxArista = new Arista(x1, x3, y1, y3, -1, -1, auxListaComponentes);
                    auxArista1 = new Arista(x2, x4, y2, y4, -1, -1, auxListaComponentes);
                    añadirArista(auxArista, auxOrigen, auxDestino);
                    añadirArista( auxArista1, auxOrigen1, auxDestino1);
                }

            } else {
                x1 = (int) idNodoorigen.getArea().getX() + ancho;
                y1 = (int) idNodoorigen.getArea().getY();
                x2 = x1;
                y2 = y1 + alto;
                auxOrigen = idNodoorigen.getIdNodo() + 1;
                auxOrigen1 = idNodoorigen.getIdNodo() + 3;
                if (destino.getTipoVia().equals("cebra")) {
                    x3 = (int) destino.getArea().getX();
                    y3 = (int) destino.getArea().getY();
                    x4 = x3;
                    y4 = y3 + alto;
                    auxDestino = destino.getIdNodo();
                    auxDestino1 = destino.getIdNodo() + 1;
                    auxArista = new Arista(x1, x3, y1, y3, -1, -1, auxListaComponentes);
                    auxArista1 = new Arista(x2, x4, y2, y4, -1, -1, auxListaComponentes);
                    añadirArista( auxArista, auxOrigen, auxDestino);
                    añadirArista( auxArista1, auxOrigen1, auxDestino1);
                } else if (destino.getTipoVia().equals("cruce")) {
                    x3 = (int) destino.getArea().getX();
                    y3 = (int) destino.getArea().getY();
                    x4 = x3;
                    y4 = y3 + alto;
                    auxDestino = destino.getIdNodo();
                    auxDestino1 = destino.getIdNodo() + 2;
                    auxArista = new Arista(x1, x3, y1, y3, -1, -1, auxListaComponentes);
                    auxArista1 = new Arista(x2, x4, y2, y4, -1, -1, auxListaComponentes);
                    añadirArista( auxArista, auxOrigen, auxDestino);
                    añadirArista( auxArista1, auxOrigen1, auxDestino1);
                } else {
                    x3 = (int) destino.getArea().getX() + ancho;
                    y3 = (int) destino.getArea().getY();
                    x4 = x3;
                    y4 = y3 + alto;
                    auxDestino = destino.getIdNodo();
                    auxDestino1 = destino.getIdNodo() + 1;
                    auxArista = new Arista(x1, x3, y1, y3, -1, -1, auxListaComponentes);
                    auxArista1 = new Arista(x2, x4, y2, y4, -1, -1, auxListaComponentes);
                    añadirArista(auxArista, auxOrigen, auxDestino);
                    añadirArista(auxArista1, auxOrigen1, auxDestino1);
                }

            }
        }
    }

    public Boolean destinoCalle(Componente destino) {
        if (destino.getTipoVia().equals("carretera") || destino.getTipoVia().equals("calle") || destino.getTipoVia().equals("cebra")) {
            return true;
        }
        return false;
    }

    public Boolean esVertical(int x1, int x2) {
        if (x1 == x2) {
            return true;
        }
        return false;
    }

    public Arista[][] getGrafo() {
        return grafo;
    }

}
