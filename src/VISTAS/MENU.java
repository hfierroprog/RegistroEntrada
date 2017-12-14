/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTAS;

import PRINCIPAL.Conexion;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class MENU extends javax.swing.JFrame {
    
    private int usuario;
    private Conexion conec;
    
    public MENU(int usuario,Conexion conec) {
        initComponents();
        this.usuario = usuario;
        this.conec = conec;
        this.setTitle("MENU");
        this.setLocationRelativeTo(null);
    }

    public MENU() {
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnENTRADA = new javax.swing.JButton();
        btnVERENTRADA = new javax.swing.JButton();
        Salir = new javax.swing.JButton();

        btnENTRADA.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnENTRADA.setText("ENTRADA");
        btnENTRADA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnENTRADAActionPerformed(evt);
            }
        });

        btnVERENTRADA.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnVERENTRADA.setText("VER ENTRADA");
        btnVERENTRADA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVERENTRADAActionPerformed(evt);
            }
        });

        Salir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Salir)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnENTRADA, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVERENTRADA, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnENTRADA, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVERENTRADA, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Salir)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnENTRADAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnENTRADAActionPerformed
        if(conec.verificar(usuario)){
            int hora,min;
            String fechatxt,horatxt;
            Calendar calendario = new GregorianCalendar();
            
            hora = calendario.getTime().getHours();
            min = calendario.getTime().getMinutes();
            
            Date fecha = calendario.getTime();
            
            fechatxt = convertirFecha(fecha);
            horatxt = hora+":"+min;
            
            System.out.println(fechatxt+" - "+horatxt+" - "+usuario);
            
            conec.insertarReg(fechatxt, horatxt, usuario);
            JOptionPane.showMessageDialog(null, "ENTRADA AGREGADA CORRECTAMENTE!");
        }else{
            JOptionPane.showMessageDialog(null, "ERROR: No puedes agregar 2 entradas en 1 mismo dia!");
        }
    }//GEN-LAST:event_btnENTRADAActionPerformed

    private void btnVERENTRADAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVERENTRADAActionPerformed
        FormEntrada entrada = new FormEntrada(conec);
        entrada.show();
    }//GEN-LAST:event_btnVERENTRADAActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    public String convertirFecha(Date fecha){
           Format formatter = new SimpleDateFormat("dd/MM/yyyy");	
           return formatter.format(fecha);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salir;
    private javax.swing.JButton btnENTRADA;
    private javax.swing.JButton btnVERENTRADA;
    // End of variables declaration//GEN-END:variables
}
