/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Diego Mendez
 */
public class MenuMostrar extends javax.swing.JFrame {

    /**
     * Creates new form MenuMostrar
     */
    public MenuMostrar() {
        initComponents();
        
         //cambia el icono de la aplicacion
        this.setIconImage(new ImageIcon(getClass().getResource("../img/logo.png")).getImage());
        //coloca la aplicacion al entro
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFactura = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnFactura1 = new javax.swing.JButton();
        btnCliente1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnFactura.setBackground(new java.awt.Color(255, 255, 255));
        btnFactura.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Factura.png"))); // NOI18N
        btnFactura.setToolTipText("Facturas");
        btnFactura.setBorder(null);
        btnFactura.setBorderPainted(false);
        btnFactura.setContentAreaFilled(false);
        btnFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFactura.setFocusable(false);
        btnFactura.setRolloverEnabled(false);
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });

        btnCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Clientes.png"))); // NOI18N
        btnCliente.setToolTipText("Clientes");
        btnCliente.setBorder(null);
        btnCliente.setBorderPainted(false);
        btnCliente.setContentAreaFilled(false);
        btnCliente.setFocusable(false);
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel8.setText("Consultar");

        btnFactura1.setBackground(new java.awt.Color(255, 255, 255));
        btnFactura1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnFactura1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dinero.png"))); // NOI18N
        btnFactura1.setToolTipText("Facturas pendientes de pago");
        btnFactura1.setBorder(null);
        btnFactura1.setBorderPainted(false);
        btnFactura1.setContentAreaFilled(false);
        btnFactura1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFactura1.setFocusable(false);
        btnFactura1.setRolloverEnabled(false);
        btnFactura1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFactura1ActionPerformed(evt);
            }
        });

        btnCliente1.setBackground(new java.awt.Color(255, 255, 255));
        btnCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Anulada.png"))); // NOI18N
        btnCliente1.setToolTipText("Facturas anuladas");
        btnCliente1.setBorder(null);
        btnCliente1.setBorderPainted(false);
        btnCliente1.setContentAreaFilled(false);
        btnCliente1.setFocusable(false);
        btnCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliente1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFactura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFactura1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCliente1)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFactura1)
                    .addComponent(btnCliente1)
                    .addComponent(btnFactura)
                    .addComponent(btnCliente))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed
       MostrarFacturas p;
        
        try {
            p = new MostrarFacturas();
            p.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFacturaActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        MostrarClientes p;
        
        try {
            p = new MostrarClientes();
            p.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnFactura1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFactura1ActionPerformed
       
        MostrarPendientePago p;
        
        p = new MostrarPendientePago();
        p.setVisible(true);
        
    }//GEN-LAST:event_btnFactura1ActionPerformed

    private void btnCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliente1ActionPerformed
        
        MostrarAnuladas p;
        
        p = new MostrarAnuladas();
        p.setVisible(true);
    }//GEN-LAST:event_btnCliente1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuMostrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnCliente1;
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnFactura1;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
