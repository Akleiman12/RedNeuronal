
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GUIRed extends javax.swing.JFrame 
{
    
    NeuralNetwork net;
    Red cerebro = new Red();
    double[][] initialValues = new double[3][3];
    
    FileInputStream fileInput;
    FileOutputStream fileOutput;
    XSSFWorkbook workbook;
    
    double valorPredecir;


    public GUIRed() throws Exception 
    {
        this.fileInput = new FileInputStream("data.xlsx");
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
        precioMercado1 = new javax.swing.JTextField();
        valorCirculacion1 = new javax.swing.JTextField();
        volumenMercado1 = new javax.swing.JTextField();
        botonPredecir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        noticias = new javax.swing.JTextArea();
        labelExclamacion = new javax.swing.JLabel();
        labelValorPredecido = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        volumenMercado2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        valorCirculacion2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        precioMercado2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        volumenMercado3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        valorCirculacion3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        precioMercado3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Prediccion de precio de BTC");

        jLabel2.setText("Valor de precio de mercado de BTC (USD)");

        jLabel3.setText("Valor total de USD Bitcoin suministro en circulación (USD)");

        jLabel4.setText("Volumen de cambios en las bolsas principales de BTC (USD)");

        precioMercado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                precioMercado1MouseClicked(evt);
            }
        });

        valorCirculacion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                valorCirculacion1MouseClicked(evt);
            }
        });

        volumenMercado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volumenMercado1MouseClicked(evt);
            }
        });

        botonPredecir.setBackground(new java.awt.Color(255, 153, 0));
        botonPredecir.setText("Predecir");
        botonPredecir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonPredecirMouseClicked(evt);
            }
        });
        botonPredecir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPredecirActionPerformed(evt);
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

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setText("Entrenar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("n-1");

        jLabel6.setText("n-1");

        jLabel8.setText("n-1");

        volumenMercado2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volumenMercado2MouseClicked(evt);
            }
        });

        jLabel10.setText("n-2");

        valorCirculacion2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                valorCirculacion2MouseClicked(evt);
            }
        });

        jLabel11.setText("n-2");

        precioMercado2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                precioMercado2MouseClicked(evt);
            }
        });

        jLabel12.setText("n-2");

        volumenMercado3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volumenMercado3MouseClicked(evt);
            }
        });

        jLabel13.setText("n-3");

        valorCirculacion3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                valorCirculacion3MouseClicked(evt);
            }
        });

        jLabel14.setText("n-3");

        precioMercado3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                precioMercado3MouseClicked(evt);
            }
        });

        jLabel15.setText("n-3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(labelExclamacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelValorPredecido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(volumenMercado1)
                                .addComponent(valorCirculacion1)
                                .addComponent(precioMercado1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(volumenMercado2)
                                .addComponent(valorCirculacion2)
                                .addComponent(precioMercado2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(volumenMercado3)
                                .addComponent(valorCirculacion3)
                                .addComponent(precioMercado3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonPredecir, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(precioMercado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(valorCirculacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(volumenMercado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precioMercado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorCirculacion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(volumenMercado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precioMercado3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorCirculacion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(volumenMercado3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
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
            if("".equals(this.precioMercado1.getText()) || "".equals(this.precioMercado2.getText()) || "".equals(this.precioMercado3.getText()) || "".equals(this.valorCirculacion1.getText()) || "".equals(this.valorCirculacion2.getText()) || "".equals(this.valorCirculacion3.getText()) || "".equals(this.volumenMercado1.getText()) || "".equals(this.volumenMercado2.getText()) || "".equals(this.volumenMercado3.getText()))
        {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos, excepto el de prediccion", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        else
        {      
            this.initialValues[0][0] = Double.parseDouble(this.precioMercado1.getText());
            this.initialValues[0][1] = Double.parseDouble(this.precioMercado2.getText());
            this.initialValues[0][2] = Double.parseDouble(this.precioMercado3.getText());
            this.initialValues[1][0] = Double.parseDouble(this.valorCirculacion1.getText());
            this.initialValues[1][1] = Double.parseDouble(this.valorCirculacion2.getText());
            this.initialValues[1][2] = Double.parseDouble(this.valorCirculacion3.getText());
            this.initialValues[2][0] = Double.parseDouble(this.volumenMercado1.getText());
            this.initialValues[2][1] = Double.parseDouble(this.volumenMercado2.getText());
            this.initialValues[2][2] = Double.parseDouble(this.volumenMercado3.getText());
            System.out.println("BIAS: "+this.cerebro.getBias());
            this.cerebro.inicioPredecir(this.initialValues,this.labelExclamacion, this.labelValorPredecido);
            this.precioMercado1.setText("");
            this.precioMercado2.setText("");
            this.precioMercado3.setText("");
            this.valorCirculacion1.setText("");
            this.valorCirculacion2.setText("");
            this.valorCirculacion3.setText("");
            this.volumenMercado1.setText("");
            this.volumenMercado2.setText("");
            this.volumenMercado3.setText("");
            this.noticias.setText("");
        }
    }//GEN-LAST:event_botonPredecirMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            this.workbook = new XSSFWorkbook(this.fileInput);
        } catch (IOException ex) {
            Logger.getLogger(GUIRed.class.getName()).log(Level.SEVERE, null, ex);
        }
            for(int i=1; i<=18; i++){
                System.out.println("");
                System.out.println("Ronda "+i+" de entrenamiento");
                this.readExcel("Entrenamiento", i);
                System.out.println("VALORES INICIALES:");
                for(int x=0; x<this.initialValues.length ; x++){
                    for(int y=0; y<this.initialValues[x].length; y++){
                        System.out.println(this.initialValues[x][y]+"  ");
                    }
                    System.out.println("");
                }
                this.cerebro.inicioEntrenar(this.initialValues, this.valorPredecir, this.noticias);
            }
            
            this.precioMercado1.setText("");
            this.precioMercado2.setText("");
            this.precioMercado3.setText("");
            this.valorCirculacion1.setText("");
            this.valorCirculacion2.setText("");
            this.valorCirculacion3.setText("");
            this.volumenMercado1.setText("");
            this.volumenMercado2.setText("");
            this.volumenMercado3.setText("");
            
            JOptionPane.showMessageDialog(null, "La red ha finalizado de entrenarse");
            
            /*try {
                net.guardar.crearArchivo(net.getCerebro());
            } catch (IOException ex) {
                Logger.getLogger(GUIRed.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void precioMercado1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_precioMercado1MouseClicked
        this.labelExclamacion.setVisible(false);
        this.labelValorPredecido.setVisible(false);
    }//GEN-LAST:event_precioMercado1MouseClicked

    private void valorCirculacion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_valorCirculacion1MouseClicked
        this.labelExclamacion.setVisible(false);
        this.labelValorPredecido.setVisible(false);
    }//GEN-LAST:event_valorCirculacion1MouseClicked

    private void volumenMercado1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volumenMercado1MouseClicked
        this.labelExclamacion.setVisible(false);
        this.labelValorPredecido.setVisible(false);
    }//GEN-LAST:event_volumenMercado1MouseClicked

    private void volumenMercado2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volumenMercado2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_volumenMercado2MouseClicked

    private void valorCirculacion2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_valorCirculacion2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_valorCirculacion2MouseClicked

    private void precioMercado2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_precioMercado2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_precioMercado2MouseClicked

    private void volumenMercado3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volumenMercado3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_volumenMercado3MouseClicked

    private void valorCirculacion3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_valorCirculacion3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_valorCirculacion3MouseClicked

    private void precioMercado3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_precioMercado3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_precioMercado3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonPredecirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPredecirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonPredecirActionPerformed
    
    public void readExcel(String sheet, int i){
            
            Sheet currentSheet = workbook.getSheet(sheet);

            
                Row currentRow = currentSheet.getRow(i);

                this.initialValues[0][0] = currentRow.getCell(1).getNumericCellValue();
                this.initialValues[0][1] = currentRow.getCell(2).getNumericCellValue();
                this.initialValues[0][2] = currentRow.getCell(3).getNumericCellValue();
                this.initialValues[1][0] = currentRow.getCell(4).getNumericCellValue();
                this.initialValues[1][1] = currentRow.getCell(5).getNumericCellValue();
                this.initialValues[1][2] = currentRow.getCell(6).getNumericCellValue();
                this.initialValues[2][0] = currentRow.getCell(7).getNumericCellValue();
                this.initialValues[2][1] = currentRow.getCell(8).getNumericCellValue();
                this.initialValues[2][2] = currentRow.getCell(9).getNumericCellValue();
                this.valorPredecir = currentRow.getCell(11).getNumericCellValue();
            
        
    
    }
    
    
    
    
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelExclamacion;
    private javax.swing.JLabel labelValorPredecido;
    private javax.swing.JTextArea noticias;
    private javax.swing.JTextField precioMercado1;
    private javax.swing.JTextField precioMercado2;
    private javax.swing.JTextField precioMercado3;
    private javax.swing.JTextField valorCirculacion1;
    private javax.swing.JTextField valorCirculacion2;
    private javax.swing.JTextField valorCirculacion3;
    private javax.swing.JTextField volumenMercado1;
    private javax.swing.JTextField volumenMercado2;
    private javax.swing.JTextField volumenMercado3;
    // End of variables declaration//GEN-END:variables
}
