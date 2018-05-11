
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GUIRed extends javax.swing.JFrame 
{
    
    NeuralNetwork net;
    Red cerebro = new Red();

    public GUIRed() throws Exception 
    {
        initComponents();
        this.setTitle("Prediccion del valor de mercado del Bitcoin");
        this.setLocationRelativeTo(null);
        //net = new NeuralNetwork();
        this.labelExclamacion.setVisible(false);
        this.labelValorPredecido.setVisible(false);
        //this.net.guardar.crearArchivo(this.net.getCerebro());
        //System.out.println("BIAS: "+net.getCerebro().getBias());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        precioMercado = new javax.swing.JTextField();
        valorCirculacion = new javax.swing.JTextField();
        volumenMercado = new javax.swing.JTextField();
        botonPredecir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        noticias = new javax.swing.JTextArea();
        labelExclamacion = new javax.swing.JLabel();
        labelValorPredecido = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        valorAPredecir = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Prediccion de precio de BTC");

        jLabel2.setText("Valor de precio de mercado de BTC (USD)");

        jLabel3.setText("Valor total de USD Bitcoin suministro en circulación (USD)");

        jLabel4.setText("Volumen de cambios en las bolsas principales de BTC (USD)");

        precioMercado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                precioMercadoMouseClicked(evt);
            }
        });

        valorCirculacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                valorCirculacionMouseClicked(evt);
            }
        });

        volumenMercado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volumenMercadoMouseClicked(evt);
            }
        });

        botonPredecir.setText("Predecir");
        botonPredecir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonPredecirMouseClicked(evt);
            }
        });

        noticias.setEditable(false);
        noticias.setColumns(20);
        noticias.setRows(5);
        jScrollPane1.setViewportView(noticias);

        labelExclamacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelExclamacion.setText("El precio de BTC en USD es: $");

        labelValorPredecido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelValorPredecido.setText("X");

        jLabel7.setText("Valor de precio de mercado de BTC para entrenamiento (USD)");

        valorAPredecir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                valorAPredecirMouseClicked(evt);
            }
        });

        jButton1.setText("Entrenar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelExclamacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelValorPredecido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(botonPredecir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel7)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(valorAPredecir)
                                            .addComponent(volumenMercado)
                                            .addComponent(valorCirculacion)
                                            .addComponent(precioMercado, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
                                    .addComponent(jLabel1)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(precioMercado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(valorCirculacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(volumenMercado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(valorAPredecir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonPredecir)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelExclamacion)
                    .addComponent(labelValorPredecido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPredecirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPredecirMouseClicked
        if("".equals(this.precioMercado.getText()) || "".equals(this.valorCirculacion.getText()) || "".equals(this.volumenMercado.getText()))
        {
            JOptionPane.showMessageDialog(null, "Debes introducir la temperatura media, la humedad relativa y la velocidad del viento", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            System.out.println("BIAS: "+this.cerebro.getBias());
            this.cerebro.inicioPredecir(Double.parseDouble(this.precioMercado.getText()), Double.parseDouble(this.valorCirculacion.getText()), Double.parseDouble(this.volumenMercado.getText()),this.labelExclamacion, this.labelValorPredecido);
            this.precioMercado.setText("");
            this.valorCirculacion.setText("");
            this.volumenMercado.setText("");
            this.noticias.setText("");
        }
    }//GEN-LAST:event_botonPredecirMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if("".equals(this.precioMercado.getText()) || "".equals(this.valorCirculacion.getText()) || "".equals(this.volumenMercado.getText()) || "".equals(this.valorAPredecir.getText()))
        {
            JOptionPane.showMessageDialog(null, "Debes introducir la temperatura media, la humedad relativa, la velocidad del viento y la temperatura a predecir", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            this.cerebro.inicioEntrenar(Double.parseDouble(this.precioMercado.getText()), Double.parseDouble(this.valorCirculacion.getText()), Double.parseDouble(this.volumenMercado.getText()), Double.parseDouble(this.valorAPredecir.getText()), this.noticias);
            this.precioMercado.setText("");
            this.valorCirculacion.setText("");
            this.volumenMercado.setText("");
            this.valorAPredecir.setText("");
            JOptionPane.showMessageDialog(null, "La red ha finalizado de entrenarse");
            /*try {
                net.guardar.crearArchivo(net.getCerebro());
            } catch (IOException ex) {
                Logger.getLogger(GUIRed.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void valorAPredecirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_valorAPredecirMouseClicked
        this.labelExclamacion.setVisible(false);
        this.labelValorPredecido.setVisible(false);
    }//GEN-LAST:event_valorAPredecirMouseClicked

    private void precioMercadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_precioMercadoMouseClicked
        this.labelExclamacion.setVisible(false);
        this.labelValorPredecido.setVisible(false);
    }//GEN-LAST:event_precioMercadoMouseClicked

    private void valorCirculacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_valorCirculacionMouseClicked
        this.labelExclamacion.setVisible(false);
        this.labelValorPredecido.setVisible(false);
    }//GEN-LAST:event_valorCirculacionMouseClicked

    private void volumenMercadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volumenMercadoMouseClicked
        this.labelExclamacion.setVisible(false);
        this.labelValorPredecido.setVisible(false);
    }//GEN-LAST:event_volumenMercadoMouseClicked

    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(GUIRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try {
                    new GUIRed().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(GUIRed.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonPredecir;
    private javax.swing.JTextField valorCirculacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelExclamacion;
    private javax.swing.JLabel labelValorPredecido;
    private javax.swing.JTextArea noticias;
    private javax.swing.JTextField valorAPredecir;
    private javax.swing.JTextField precioMercado;
    private javax.swing.JTextField volumenMercado;
    // End of variables declaration//GEN-END:variables
}
