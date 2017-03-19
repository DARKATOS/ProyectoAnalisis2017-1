/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

//import com.sun.webkit.CursorManager;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gianka
 */
public class VentanaPrincial extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincial
     */
    Ciudad ciudad;
    AreaItems areaItems;
    GraphicsDevice grafica;
    GrafoDirigido grafo;

    public VentanaPrincial() {
        initComponents();
        grafica = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        grafica.setFullScreenWindow(this);
        pnlVentana1.setFocusable(true);
        pnlVentana1.addKeyListener(pnlVentana1);

        int opcion = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingese \n 1 para cargar \n 2 para crear nueva ciudad", "Menu", JOptionPane.INFORMATION_MESSAGE));
        if (opcion == 1) {
            cargarCiudad();
        } else {
            crearCiudad();
        }
        pnlVentana1.setCiudad(ciudad);
        crearAreaItem(ciudad);
        pnlVentana1.setAreaItems(areaItems);
        setResizable(false);
        setVisible(true);

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
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jButton2.setText("Ver Grafo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVentana1Layout = new javax.swing.GroupLayout(pnlVentana1);
        pnlVentana1.setLayout(pnlVentana1Layout);
        pnlVentana1Layout.setHorizontalGroup(
            pnlVentana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVentana1Layout.createSequentialGroup()
                .addGap(0, 775, Short.MAX_VALUE)
                .addGroup(pnlVentana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(pnlVentana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))))
        );
        pnlVentana1Layout.setVerticalGroup(
            pnlVentana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentana1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(519, Short.MAX_VALUE))
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
        try {
            String nombreArchivo = JOptionPane.showInputDialog("ingrese nombre archivo");
            GuardarCiudad(nombreArchivo, ciudad);
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void pnlVentana1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnlVentana1KeyReleased
        // TODO add your handling code here:sd
    }//GEN-LAST:event_pnlVentana1KeyReleased

    private void pnlVentana1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnlVentana1KeyPressed
        // TODO add your handling code   here:
    }//GEN-LAST:event_pnlVentana1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        crearGrafo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        grafo.verGrafo();
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
    private proyectoanalisis2017.pkg1.PanelVentana pnlVentana1;
    // End of variables declaration//GEN-END:variables

    private void GuardarCiudad(String nombre, Ciudad objeto) throws FileNotFoundException, IOException {
        File archivo = new File(nombre);
        FileOutputStream archivo1 = new FileOutputStream(archivo);
        ObjectOutputStream oos = new ObjectOutputStream(archivo1);
        oos.writeObject(objeto);
        oos.close();
    }

    private void cargarCiudad() {
        FileInputStream fis = null;
        try {
            String nombre = JOptionPane.showInputDialog("Ingresar nombre");
            ObjectInputStream ois;
            File f = new File(nombre);
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ciudad = (Ciudad) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error no se encontro el archivo");
        } catch (IOException ex) {
            System.out.println("Error en el archivo de entrada");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error no se encontro la clase");
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar el archivo");
            }
        }
    }

    private void crearCiudad() {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese n"));
        int m = Integer.parseInt(JOptionPane.showInputDialog("Ingrese m"));
        Componente matriz[][] = new Componente[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matriz[i][j] = null;
            }
        }
        int anchoCampo = (int) ((this.getWidth() * 0.8) / m);
        int altoCampo = (int) ((this.getHeight() - 100) / n);
        ciudad = new Ciudad(matriz, n, m, anchoCampo, altoCampo);

    }

    private void crearAreaItem(Ciudad ciudad) {
        int anchoAreaItemsX1 = ciudad.getN() * this.ciudad.getAnchoCampo();
        int anchoAreaItemsX2 = this.getWidth() - (int) (this.getWidth() * 0.05);
        areaItems = new AreaItems(new ArrayList<>(), anchoAreaItemsX1, anchoAreaItemsX2);
    }

    private void crearGrafo() {
        ciudad.actualizarCiudad();
        grafo = new GrafoDirigido(ciudad.getCantidadCruces());
        Componente[][] matrizCopia = new Componente[ciudad.getN()][ciudad.getM()];
        for (int i = 0; i < ciudad.getN(); i++) {
            for (int j = 0; j < ciudad.getM(); j++) {
                matrizCopia[i][j]=ciudad.getMatrizCiudad()[i][j];
            }
        }
        System.out.println(ciudad.getAnchoCampo()+"---"+ ciudad.getAltoCampo());
        grafo.crearGrafo(matrizCopia, ciudad.getAnchoCampo(), ciudad.getAltoCampo());
    }

    private void mostrarMatrizCiudad() {
        for (int i = 0; i < ciudad.getN(); i++) {
            for (int j = 0; j < ciudad.getM(); j++) {
                if (ciudad.getMatrizCiudad()[i][j] != null) {
                    System.out.println(ciudad.getMatrizCiudad()[i][j].getIdNodo());
                }
            }
        }
    }
}
