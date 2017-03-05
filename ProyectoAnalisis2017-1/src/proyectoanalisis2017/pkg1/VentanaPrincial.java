/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanalisis2017.pkg1;

//import com.sun.webkit.CursorManager;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    int nCiudad;
    int mCiudad;
    String matriz[][];
    GraphicsDevice grafica;

    public VentanaPrincial() {
        initComponents();
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingese \n 1 para cargar \n 2 para crear nueva ciudad", "Menu", JOptionPane.INFORMATION_MESSAGE));
        if (opcion == 1) {
            cargarCiudad();
        } else {
            crearCiudad();
        }
        grafica = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        grafica.setFullScreenWindow(this);
        setResizable(false);
        setVisible(true);
        this.pnlVentana1.addKeyListener(this.pnlVentana1);
        this.pnlVentana1.setFocusable(true);
        //pnlVentana1.setBounds(0, 0, (int) (this.getWidth() * 0.9), this.getHeight());
        pnlVentana1.setX2Ciudad((int) (this.getWidth() * 0.8));
        pnlVentana1.setX1Componente((int) (this.getWidth() * 0.8));
        pnlVentana1.setX2Componete(this.getWidth() - (int) (this.getWidth() * 0.1));
        pnlVentana1.setAltura(this.getHeight());
        pnlVentana1.crearComponentes();
        this.ciudad = new Ciudad(matriz, this.nCiudad, this.mCiudad, (int) ((this.getWidth() * 0.8) / this.mCiudad), (int) ((this.getHeight()) / this.nCiudad));
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

        pnlVentana1 = new proyectoanalisis2017.pkg1.pnlVentana();
        btnGuardar = new javax.swing.JButton();

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

        javax.swing.GroupLayout pnlVentana1Layout = new javax.swing.GroupLayout(pnlVentana1);
        pnlVentana1.setLayout(pnlVentana1Layout);
        pnlVentana1Layout.setHorizontalGroup(
            pnlVentana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVentana1Layout.createSequentialGroup()
                .addGap(0, 798, Short.MAX_VALUE)
                .addComponent(btnGuardar))
        );
        pnlVentana1Layout.setVerticalGroup(
            pnlVentana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVentana1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar)
                .addContainerGap(591, Short.MAX_VALUE))
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
            GuardarCiudad(JOptionPane.showInputDialog("iingrese nombre archivo"), ciudad);
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
    private proyectoanalisis2017.pkg1.pnlVentana pnlVentana1;
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
            this.ciudad = (Ciudad) ois.readObject();
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
        this.nCiudad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese n"));
        this.mCiudad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese m"));
        matriz = new String[this.nCiudad][this.mCiudad];
        for (int i = 0; i < this.nCiudad; i++) {
            for (int j = 0; j < this.mCiudad; j++) {
                matriz[i][j] = "";
            }
        }
    }
}
