/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gianka
 */
public class FormVentana extends javax.swing.JFrame {

    Ciudad ciudadCarros;
    Ciudad ciudadPersonas;
    AreaItems areaItems;
    GraphicsDevice grafica;
    GrafoDirigido grafo;
    int cantidadCarros;

    public FormVentana() {
        initComponents();
        //Indica la cantidad de carros puestos
        this.cantidadCarros = 0;
        grafica = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        grafica.setFullScreenWindow(this);
        panelVentana.setFocusable(true);
        JOptionPane.showMessageDialog(rootPane, "OJO con copia de codigo(GIT HUB)!!!!");
        // Muestra un menu donde es posible seleccionar si se crea una ciudad nueva o se carga desde un archivo txt.
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingese \n 1 para cargar \n 2 para crear nueva ciudad", "Menu", JOptionPane.INFORMATION_MESSAGE));
        if (opcion == 1) {
            cargarCiudad();
        } else {
            crearCiudad();
        }
        //Permite redimensionar la ciudad en cuanto a ancho y alto de campos y obtener ancho y alto de ciudad como crear el area dew items
        graficarCiudad();
        graficarAreaItems();
        setResizable(false);
        setVisible(true);

    }

    private void graficarCiudad() {
        //Obtengo el ancho de campo de acuerdo al numero de columnas de la matriz ciudad.
        int anchoCampo = (int) ((this.getWidth() * 0.8) / ciudadCarros.getM());
        //obtengo el alto del campo de acuerdo al numero de filas de la matriz ciudad.
        int altoCampo = (int) ((this.getHeight() - 100) / ciudadCarros.getN());
        //Seteo el ancho del campo para la ciudad.
        ciudadCarros.setAnchoCampo(anchoCampo);
        ciudadPersonas.setAnchoCampo(anchoCampo);
        //Seteo el alto del campo para la ciudad
        ciudadCarros.setAltoCampo(altoCampo);
        ciudadPersonas.setAltoCampo(altoCampo);
        //El ancho de la ciudad es el numero de columnas por el ancho del campo.
        ciudadCarros.setAnchoCiudad(ciudadCarros.getM() * ciudadCarros.getAnchoCampo());
        //El alto de la ciudad es el numero de filas por el alto del campo.
        ciudadCarros.setAltoCiudad(ciudadCarros.getAltoCampo() * ciudadCarros.getN());
        ciudadPersonas.setAltoCiudad(ciudadCarros.getAltoCampo() * ciudadCarros.getN());
        //Seteo la ciudad.
        panelVentana.setCiudad(ciudadCarros);
        panelVentana.setCiudadPersonas(ciudadPersonas);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVentana = new proyectoanalisis2017.pkg1.PanelVentana();
        btnGuardarCiudad = new javax.swing.JButton();
        btnCrearGrafo = new javax.swing.JButton();
        btnIngresarCarro = new javax.swing.JButton();
        btnIniciarCarro = new javax.swing.JButton();
        btnCamino = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnIngresarP = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelVentana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelVentanaMouseReleased(evt);
            }
        });
        panelVentana.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelVentanaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                panelVentanaKeyReleased(evt);
            }
        });

        btnGuardarCiudad.setText("Guardar");
        btnGuardarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCiudadActionPerformed(evt);
            }
        });

        btnCrearGrafo.setText("Crear Grafo");
        btnCrearGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearGrafoActionPerformed(evt);
            }
        });

        btnIngresarCarro.setText("IngresarC");
        btnIngresarCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarCarroActionPerformed(evt);
            }
        });

        btnIniciarCarro.setText("Iniciar");
        btnIniciarCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarCarroActionPerformed(evt);
            }
        });

        btnCamino.setText("Camino");
        btnCamino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaminoActionPerformed(evt);
            }
        });

        jButton1.setText("Crear Grafo P");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnIngresarP.setText("IngresarP");
        btnIngresarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarPActionPerformed(evt);
            }
        });

        jButton2.setText("IniciarP");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelVentanaLayout = new javax.swing.GroupLayout(panelVentana);
        panelVentana.setLayout(panelVentanaLayout);
        panelVentanaLayout.setHorizontalGroup(
            panelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVentanaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrearGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIngresarCarro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIngresarP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIniciarCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCamino)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        panelVentanaLayout.setVerticalGroup(
            panelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVentanaLayout.createSequentialGroup()
                .addContainerGap(549, Short.MAX_VALUE)
                .addGroup(panelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarCiudad)
                    .addComponent(btnCrearGrafo)
                    .addComponent(btnIngresarCarro)
                    .addComponent(btnIniciarCarro)
                    .addComponent(btnCamino)
                    .addComponent(jButton1)
                    .addComponent(btnIngresarP)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVentana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVentana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCiudadActionPerformed
        //Se obtiene un nombre de archivo para almacenar el .txt
        String nombreArchivo = JOptionPane.showInputDialog("ingrese nombre archivo");
        GuardarCiudad(nombreArchivo);
    }//GEN-LAST:event_btnGuardarCiudadActionPerformed

    private void panelVentanaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelVentanaKeyReleased
        // TODO add your handling code here:sd
    }//GEN-LAST:event_panelVentanaKeyReleased

    private void panelVentanaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelVentanaKeyPressed
        //Realiza un rotacion de item
        panelVentana.girarItem();
    }//GEN-LAST:event_panelVentanaKeyPressed

    private void btnCrearGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearGrafoActionPerformed
        //Actualizo la ciudad para obtener los nodos.
        ciudadCarros.actualizarCiudadCarro();

    }//GEN-LAST:event_btnCrearGrafoActionPerformed

    private void btnIngresarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarCarroActionPerformed
        //Permite ingresar un carro en tipo automatico a la ciudad
        GrafoDirigido auxGrafo1 = new GrafoDirigido(ciudadCarros.getCantidadNodos());
        Ciudad auxCiudad1 = panelVentana.copiarCiudad(ciudadCarros);
        auxGrafo1.crearGrafo(auxCiudad1);
        LinkedList<Arista> camino1 = new LinkedList<>();
        boolean bandera = false;
        for (int i = 0; i < auxGrafo1.getGrafo().length && !bandera; i++) {
            for (int j = 0; j < auxGrafo1.getGrafo().length && !bandera; j++) {
                if (auxGrafo1.getGrafo()[i][j] != null) {
                    camino1.add(auxGrafo1.getGrafo()[i][j]);
                    bandera = true;
                }
            }
        }
        ingresarCarro(new CarroMovimiento(cantidadCarros, ciudadCarros, auxGrafo1, "../ImgComponentes/car_ari_abj1.png", camino1, 0));
        this.cantidadCarros++;
    }//GEN-LAST:event_btnIngresarCarroActionPerformed

    private void btnIniciarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarCarroActionPerformed
        //inicia el movimiento del carro
        panelVentana.getCarrosMovimiento().getLast().iniciar();
    }//GEN-LAST:event_btnIniciarCarroActionPerformed

    private void panelVentanaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVentanaMouseReleased

    }//GEN-LAST:event_panelVentanaMouseReleased

    private void btnCaminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaminoActionPerformed

        if (panelVentana.getOpciones() == 0) {
            //Seleccion del camino minimo en forma de camino mas corto, camino veloz, camiono de menor trafico
            int tipoCamino = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingese \n 1 camino corto \n 2 camino veloz \n 3 camino trafico", "Menu", JOptionPane.INFORMATION_MESSAGE));
            panelVentana.setOpciones(2);
            panelVentana.setTipoCamino(tipoCamino);
        } else if (panelVentana.getOpciones() == 3) {
            panelVentana.modificarGrafo();
            panelVentana.setOpciones(0);
        }
    }//GEN-LAST:event_btnCaminoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ciudadPersonas.actualizarCiudadPersona();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnIngresarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarPActionPerformed
        //Permite ingresar un carro en tipo automatico a la ciudad
        GrafoNoDirigido auxGrafo1 = new GrafoNoDirigido(ciudadPersonas.getCantidadNodos());
        Ciudad auxCiudad1 = panelVentana.copiarCiudad(ciudadPersonas);
        auxGrafo1.crearGrafo(auxCiudad1);
        Ciudad auxCiudad2 = panelVentana.copiarCiudad(ciudadPersonas);
        auxGrafo1.completarGrafo(auxCiudad2);
        LinkedList<Arista> camino1 = new LinkedList<>();
        boolean bandera = false;
        for (int i = 0; i < auxGrafo1.getGrafo().length && !bandera; i++) {
            for (int j = 0; j < auxGrafo1.getGrafo().length && !bandera; j++) {
                if (auxGrafo1.getGrafo()[i][j] != null) {
                    camino1.add(auxGrafo1.getGrafo()[i][j]);
                    bandera = true;
                }
            }
        }
        ingresarPersona(new PersonaMovimiento(cantidadCarros, ciudadCarros, auxGrafo1, "../ImgComponentes/per1.png", camino1, 0));
        this.cantidadCarros++;
    }//GEN-LAST:event_btnIngresarPActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //inicia el movimiento del carro
        panelVentana.getPersonasMovimiento().getLast().iniciar();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormVentana frame = new FormVentana();

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCamino;
    private javax.swing.JButton btnCrearGrafo;
    private javax.swing.JButton btnGuardarCiudad;
    private javax.swing.JButton btnIngresarCarro;
    private javax.swing.JButton btnIngresarP;
    private javax.swing.JButton btnIniciarCarro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private proyectoanalisis2017.pkg1.PanelVentana panelVentana;
    // End of variables declaration//GEN-END:variables

    /**
     * Permite guardar en un archivo txt la ciudad. Para que en otra ocasion
     * pueda ser cargada Se recorre la matriz de la ciudad y se almacenan los
     * nombres de cada uno de los componentes
     */
    private void GuardarCiudad(String nombreArchivo) {
        String linea;
        FileWriter fichero = null;
        PrintWriter pw;
        try {
            fichero = new FileWriter(nombreArchivo + ".txt");
            pw = new PrintWriter(fichero);
            linea = String.valueOf(ciudadCarros.getMatrizCiudad().length);
            pw.println(linea);
            linea = String.valueOf(ciudadCarros.getMatrizCiudad()[0].length);
            pw.println(linea);
            linea = "";
            for (int i = 0; i < ciudadCarros.getMatrizCiudad().length; i++) {
                for (int j = 0; j < ciudadCarros.getMatrizCiudad().length; j++) {
                    if (ciudadCarros.getMatrizCiudad()[i][j] == null) {
                        linea = linea + "-,";
                    } else {
                        linea = linea + ciudadCarros.getMatrizCiudad()[i][j].getNombre() + ",";
                    }
                }
                linea = linea.substring(0, linea.length() - 1);
                pw.println(linea);
                linea = "";
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }

    /**
     * Permite cargar desde un archivo txt la ciudad. Se recorre un archivo de
     * texto y de acuerdo a la nomeclatura de los componentes se reconstruyen en
     * la matriz de la ciudad
     */
    private void cargarCiudad() {
        String nombreArchivo = JOptionPane.showInputDialog("ingrese nombre archivo");
        File archivo;
        FileReader fr = null;
        BufferedReader br;
        int filas = 0;
        try {
            archivo = new File(nombreArchivo + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            Componente matrizCiudad[][] = new Componente[n][m];
            String linea;
            while ((linea = br.readLine()) != null) {
                String columnas[] = linea.split(",");
                for (int i = 0; i < columnas.length; i++) {
                    if ("-".equals(columnas[i])) {
                        matrizCiudad[filas][i] = null;
                    } else {
                        matrizCiudad[filas][i] = new Componente(columnas[i]);
                    }
                }
                filas++;
            }
            ciudadCarros = new Ciudad(matrizCiudad, n, m);
            ciudadPersonas = new Ciudad(matrizCiudad, n, m);
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }

    /**
     * Permite crear la ciudad desde un inicio.
     */
    private void crearCiudad() {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese n"));
        int m = Integer.parseInt(JOptionPane.showInputDialog("Ingrese m"));
        Componente matriz[][] = new Componente[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matriz[i][j] = null;
            }
        }
        ciudadCarros = new Ciudad(matriz, n, m);
        ciudadPersonas = new Ciudad(matriz, n, m);
    }

    /**
     * Grafica el area de items para construir la ciudad
     */
    private void graficarAreaItems() {
        int anchoAreaItemsX1 = ciudadCarros.getN() * ciudadCarros.getAnchoCampo();
        int anchoAreaItemsX2 = this.getWidth() - (int) (this.getWidth() * 0.05);
        areaItems = new AreaItems(anchoAreaItemsX1, anchoAreaItemsX2);
        areaItems.cargarComponentes();
        panelVentana.setAreaItems(areaItems);
    }

    /**
     * Permite añadir un carro a la lista de carros en movimiento y asignarle un
     * grafo.
     *
     * @param carro Vehiculo que se va a agregar a la lista de carros de
     * movimiento
     */
    private void ingresarCarro(CarroMovimiento carro) {
        panelVentana.getCarrosMovimiento().add(carro);
        panelVentana.getCarrosMovimiento().getLast().setPanel(panelVentana);
    }
    private void ingresarPersona(PersonaMovimiento persona) {
        panelVentana.getPersonasMovimiento().add(persona);
        panelVentana.getPersonasMovimiento().getLast().setPanel(panelVentana);
    }
}
