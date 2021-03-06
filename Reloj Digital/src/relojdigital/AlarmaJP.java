/*
 * La clase AlarmaJP contiene la interfaz con la que el usuario puede
 * interacturar con el objeto alarma
 */
package relojdigital;

import java.util.Date;

/**
 *
 * @author juang <juangmuelas@gmail.com>
 * @since 30/12/2021
 * @version 1
 */
public class AlarmaJP extends javax.swing.JPanel {

    /**
     * Creates new form AlarmaJP
     */
    public AlarmaJP() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        alarmajS = new javax.swing.JSpinner();
        alarmajL = new javax.swing.JLabel();
        activarjL = new javax.swing.JLabel();
        activarJCB = new javax.swing.JCheckBox();

        setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        alarmajS.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));
        alarmajS.setToolTipText("Seleccione hora de alarma");

        alarmajL.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        alarmajL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alarmajL.setText("ALARMA");

        activarjL.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        activarjL.setText("Activar");
        activarjL.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        activarJCB.setAlignmentY(0.0F);
        activarJCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activarJCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(activarjL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(activarJCB))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(alarmajS)
                        .addComponent(alarmajL, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(alarmajL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alarmajS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(activarJCB)
                    .addComponent(activarjL))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void activarJCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activarJCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_activarJCBActionPerformed


    public Alarma getSelectedValue(){
        Date alarma = (Date)alarmajS.getValue();
        boolean activar = activarJCB.isSelected();
        return new Alarma(alarma,activar);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox activarJCB;
    private javax.swing.JLabel activarjL;
    private javax.swing.JLabel alarmajL;
    private javax.swing.JSpinner alarmajS;
    // End of variables declaration//GEN-END:variables
}//fin clase AlarmaJP
