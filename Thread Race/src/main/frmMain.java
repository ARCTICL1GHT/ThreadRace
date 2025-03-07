/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author migu_
 */
public class frmMain extends javax.swing.JFrame {
    
    int contador = 1;
    // Procesos
    Proceso hilo1;
    Proceso hilo2;
    Proceso hilo3;
    
    // Región Crítica
    int[] regionCritica = new int[3];
    int posicion = 0;
    // Semáforo para exclusión mutua
    private static Semaphore mutex = new Semaphore(1, true); // Controla el acceso a la región crítica

    /**
     * Creates new form frmMain
     */
    
    public frmMain() {
        initComponents();
        this.hilo1 = new Proceso(lblNumeroHilo1);
        this.hilo2 = new Proceso(lblNumeroHilo2);
        this.hilo3 = new Proceso(lblNumeroHilo3);
    }

                        public synchronized void Monitor(int numero, JLabel mon){
                           mon.setText(String.valueOf(numero));
                            // Región crítica
                            regionCritica[posicion] = numero;
                            String contenidoRC = "[" + String.valueOf(regionCritica[0]) + "]";
                            contenidoRC += "[" + String.valueOf(regionCritica[1]) + "]";
                            contenidoRC += "[" + String.valueOf(regionCritica[2]) + "]";
                            lblRegionCritica.setText(contenidoRC);
                            
                            posicion++;
                            // Operaciones post región crítica
                            System.out.println("Proceso finalizado con status: 0");
                }
            
    public class Proceso extends Thread {
        int numeroAGenerar;
        JLabel miEtiqueta;
        String status;

        public Proceso(JLabel etiqueta) {
            numeroAGenerar = 0;
            this.miEtiqueta = etiqueta;
        }
        
        @Override
            public void run() {
                                 // Operaciones pre región crítica
                this.numeroAGenerar=(int)(Math.random()*9+1);
                Monitor(numeroAGenerar, miEtiqueta);
            }   
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRegionCritica = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNumeroHilo1 = new javax.swing.JLabel();
        lblNumeroHilo2 = new javax.swing.JLabel();
        lblNumeroHilo3 = new javax.swing.JLabel();
        lblStatus1 = new javax.swing.JLabel();
        lblStatus2 = new javax.swing.JLabel();
        lblStatus3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnPosicion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRegionCritica.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblRegionCritica.setText("[0][0][0]");

        jLabel1.setText("Hilo 1");

        jLabel2.setText("Hilo 2");

        jLabel3.setText("Hilo 3");

        lblNumeroHilo1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblNumeroHilo1.setText("?");

        lblNumeroHilo2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblNumeroHilo2.setText("?");

        lblNumeroHilo3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblNumeroHilo3.setText("?");

        lblStatus1.setText("Hilo creado");

        lblStatus2.setText("Hilo creado");

        lblStatus3.setText("Hilo creado");

        jLabel4.setText("Región crítica");

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnPosicion.setText("Posición");
        btnPosicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosicionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(lblRegionCritica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPosicion))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNumeroHilo1)
                                    .addComponent(jLabel1))
                                .addGap(133, 133, 133)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNumeroHilo2)
                                    .addComponent(jLabel2))
                                .addGap(151, 151, 151)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblNumeroHilo3))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(lblStatus1)
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIniciar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStatus2)
                        .addGap(122, 122, 122)
                        .addComponent(lblStatus3)))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRegionCritica)
                    .addComponent(btnPosicion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroHilo1)
                    .addComponent(lblNumeroHilo2)
                    .addComponent(lblNumeroHilo3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus1)
                    .addComponent(lblStatus2)
                    .addComponent(lblStatus3))
                .addGap(18, 18, 18)
                .addComponent(btnIniciar)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        hilo1.start();
        hilo2.start();
        hilo3.start();
        /*if (contador == 1)
            hilo1.start();
        if (contador == 2)
            hilo2.start();
        if (contador == 3)
            hilo3.start();*/
        contador++;
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnPosicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosicionActionPerformed
        System.out.println("La posición actual libre para Región crítica es: " + posicion);
    }//GEN-LAST:event_btnPosicionActionPerformed

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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnPosicion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblNumeroHilo1;
    private javax.swing.JLabel lblNumeroHilo2;
    private javax.swing.JLabel lblNumeroHilo3;
    private javax.swing.JLabel lblRegionCritica;
    private javax.swing.JLabel lblStatus1;
    private javax.swing.JLabel lblStatus2;
    private javax.swing.JLabel lblStatus3;
    // End of variables declaration//GEN-END:variables
}
