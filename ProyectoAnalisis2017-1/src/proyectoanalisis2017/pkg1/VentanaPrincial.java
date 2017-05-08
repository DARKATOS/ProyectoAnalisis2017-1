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
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gianka
 */
public class VentanaPrincial extends javax.swing.JFrame {

    Ciudad ciudad;
    AreaItems areaItems;
    GraphicsDevice grafica;
    GrafoDirigido grafo;
    int cantidadCarros;

    public VentanaPrincial() {
        initComponents();

        //Indica la cantidad de carros puestos
        this.cantidadCarros = 0;
        grafica = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        grafica.setFullScreenWindow(this);
        pnlVentana1.setFocusable(true);
        JOptionPane.showMessageDialog(rootPane, "OJO con copia de codigo(GIT HUB)!!!!");
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
        int anchoCampo = (int) ((this.getWidth() * 0.8) / ciudad.getM());
        //obtengo el alto del campo de acuerdo al numero de filas de la matriz ciudad.
        int altoCampo = (int) ((this.getHeight() - 100) / ciudad.getN());
        //Seteo el ancho del campo para la ciudad.
        ciudad.setAnchoCampo(anchoCampo);
        //Seteo el alto del campo para la ciudad
        ciudad.setAltoCampo(altoCampo);
        //El ancho de la ciudad es el numero de columnas por el ancho del campo.
        ciudad.setAnchoCiudad(ciudad.getM() * ciudad.getAnchoCampo());
        //El alto de la ciudad es el numero de filas por el alto del campo.
        ciudad.setAltoCiudad(ciudad.getAltoCampo() * ciudad.getN());
        //Seteo la ciudad.
        pnlVentana1.setCiudad(ciudad);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlVentana1 = new proyectoanalisis2017.pkg1.PanelVentana();
        btnGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlVentana1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnlVentana1MouseReleased(evt);
            }
        });
        pnlVentana1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pnlVentana1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pnlVentana1KeyReleased(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton1.setText("Crear Grafo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("IngresarC");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Iniciar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton2.setText("Camino");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVentana1Layout = new javax.swing.GroupLayout(pnlVentana1);
        pnlVentana1.setLayout(pnlVentana1Layout);
        pnlVentana1Layout.setHorizontalGroup(
            pnlVentana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentana1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(438, Short.MAX_VALUE))
        );
        pnlVentana1Layout.setVerticalGroup(
            pnlVentana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentana1Layout.createSequentialGroup()
                .addContainerGap(549, Short.MAX_VALUE)
                .addGroup(pnlVentana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(jButton1)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlVentana1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlVentana1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombreArchivo = JOptionPane.showInputDialog("ingrese nombre archivo");
        GuardarCiudad(nombreArchivo);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void pnlVentana1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnlVentana1KeyReleased
        // TODO add your handling code here:sd
    }//GEN-LAST:event_pnlVentana1KeyReleased

    private void pnlVentana1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnlVentana1KeyPressed
       pnlVentana1.girarItem();
    }//GEN-LAST:event_pnlVentana1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Actualizo la ciudad para obtener los nodos.
        ciudad.actualizarCiudad();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        GrafoDirigido auxGrafo1=new GrafoDirigido(ciudad.getCantidadNodos());
        Ciudad auxCiudad1 = pnlVentana1.copiarCiudad(ciudad);
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
        ingresarCarro(new CarroMovimiento(this.cantidadCarros, ciudad.getAnchoCampo(), ciudad.getAltoCampo(), camino1, 1), auxGrafo1, ciudad);
        this.cantidadCarros++;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        pnlVentana1.getCarrosMovimiento().getLast().start();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void pnlVentana1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlVentana1MouseReleased
      
    }//GEN-LAST:event_pnlVentana1MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if (pnlVentana1.getOpciones() == 0) {
            int tipoCamino = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingese \n 1 camino corto \n 2 camino veloz \n 3 camino trafico", "Menu", JOptionPane.INFORMATION_MESSAGE));
            pnlVentana1.setOpciones(2);
            pnlVentana1.setTipoCamino(tipoCamino);
        } else if (pnlVentana1.getOpciones() == 3) {
            pnlVentana1.ModificarGrafo();
            pnlVentana1.setOpciones(0);
        }
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
            java.util.logging.Logger.getLogger(VentanaPrincial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaPrincial frame = new VentanaPrincial();

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private proyectoanalisis2017.pkg1.PanelVentana pnlVentana1;
    // End of variables declaration//GEN-END:variables

    /**
     * Permite guardar en un archivo txt la ciudad. Para que en otra ocasion pueda ser cargada
     */
    private void GuardarCiudad(String nombreArchivo) {
        String linea;
        FileWriter fichero = null;
        PrintWriter pw;
        try {
            fichero = new FileWriter(nombreArchivo + ".txt");
            pw = new PrintWriter(fichero);
            linea = String.valueOf(ciudad.getMatrizCiudad().length);
            pw.println(linea);
            linea = String.valueOf(ciudad.getMatrizCiudad()[0].length);
            pw.println(linea);
            linea = "";
            for (int i = 0; i < ciudad.getMatrizCiudad().length; i++) {
                for (int j = 0; j < ciudad.getMatrizCiudad().length; j++) {
                    if (ciudad.getMatrizCiudad()[i][j] == null) {
                        linea = linea + "-,";
                    } else {
                        linea = linea + ciudad.getMatrizCiudad()[i][j].getNombre() + ",";
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
     * Permite cargar desde un archivo txt la ciudad.
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
            ciudad = new Ciudad(matrizCiudad, n, m);
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
        ciudad = new Ciudad(matriz, n, m);
    }

    /**
     * 
     */
    private void graficarAreaItems() {
        int anchoAreaItemsX1 = ciudad.getN() * ciudad.getAnchoCampo();
        int anchoAreaItemsX2 = this.getWidth() - (int) (this.getWidth() * 0.05);
        areaItems = new AreaItems(anchoAreaItemsX1, anchoAreaItemsX2);
        areaItems.cargarComponentes();
        pnlVentana1.setAreaItems(areaItems);
    }
    
    /**
     * Permite añadir un carro a la lista de carros en movimiento y asignarle un
     * grafo.
     * @param carroAuto
     * @param auxGrafo1
     */
    private void ingresarCarro(CarroMovimiento carroAuto, GrafoDirigido auxGrafo1, Ciudad auxCiudad1) {
        pnlVentana1.getCarrosMovimiento().add(carroAuto);
        pnlVentana1.getCarrosMovimiento().getLast().setPanel(pnlVentana1);
        pnlVentana1.getCarrosMovimiento().getLast().setGrafo(auxGrafo1);
        pnlVentana1.getCarrosMovimiento().getLast().setCiudad(auxCiudad1);
    }

//    private void mostrarMatrizCiudad() {
//        for (int i = 0; i < ciudad.getN(); i++) {
//            for (int j = 0; j < ciudad.getM(); j++) {
//                if (ciudad.getMatrizCiudad()[i][j] != null) {
//                    System.out.println(ciudad.getMatrizCiudad()[i][j].getIdNodo());
//                }
//            }
//        }
//    }
}
