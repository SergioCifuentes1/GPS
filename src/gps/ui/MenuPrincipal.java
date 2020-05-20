/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps.ui;

import gps.ArbolB.ControladorArbolB;
import gps.Entrada.ManejadorEntrada;
import gps.Grafos.ControladorGrafos;
import gps.Grafos.Ubicacion;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author sergio
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private ControladorGrafos controladorGrafos;
    private ControladorArbolB controladorArbolB;
    private File file;

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        controladorGrafos = new ControladorGrafos(this);
        lblMensajeError.setVisible(false);
        btnSiguiente.setEnabled(false);
        btnTerminar.setEnabled(false);
        controladorArbolB = new ControladorArbolB();

    }

    public ControladorArbolB getControladorArbolB() {
        return controladorArbolB;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comBoxOrigen = new javax.swing.JComboBox<>();
        comBoxDestino = new javax.swing.JComboBox<>();
        vehiculoBtn = new javax.swing.JRadioButton();
        pieBtn = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        lblMensajeError = new javax.swing.JLabel();
        scrollMejores = new javax.swing.JScrollPane();
        panelCaminos = new javax.swing.JPanel();
        btnSiguiente = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelGrafo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelArbol = new javax.swing.JPanel();
        btnTerminar = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Origen:");

        jLabel2.setText("Destino:");

        vehiculoBtn.setText("Vehiculo");
        vehiculoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehiculoBtnActionPerformed(evt);
            }
        });

        pieBtn.setText("Pie");
        pieBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblMensajeError.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblMensajeError.setForeground(new java.awt.Color(255, 0, 3));
        lblMensajeError.setText("Error");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(comBoxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(comBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vehiculoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pieBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addComponent(lblMensajeError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(comBoxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addComponent(vehiculoBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pieBtn)))
                .addGap(0, 0, 0)
                .addComponent(lblMensajeError)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout panelCaminosLayout = new javax.swing.GroupLayout(panelCaminos);
        panelCaminos.setLayout(panelCaminosLayout);
        panelCaminosLayout.setHorizontalGroup(
            panelCaminosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );
        panelCaminosLayout.setVerticalGroup(
            panelCaminosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        scrollMejores.setViewportView(panelCaminos);

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGrafoLayout = new javax.swing.GroupLayout(panelGrafo);
        panelGrafo.setLayout(panelGrafoLayout);
        panelGrafoLayout.setHorizontalGroup(
            panelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
        );
        panelGrafoLayout.setVerticalGroup(
            panelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelGrafo);

        jTabbedPane1.addTab("GPS", jScrollPane1);

        javax.swing.GroupLayout panelArbolLayout = new javax.swing.GroupLayout(panelArbol);
        panelArbol.setLayout(panelArbolLayout);
        panelArbolLayout.setHorizontalGroup(
            panelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
        );
        panelArbolLayout.setVerticalGroup(
            panelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(panelArbol);

        jTabbedPane1.addTab("ArbolB", jScrollPane2);

        btnTerminar.setText("Terminar");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        jMenu3.setText("Archivo");

        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Reset");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Ayuda");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollMejores, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSiguiente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTerminar))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollMejores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSiguiente)
                            .addComponent(btnTerminar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        file = null;
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.showOpenDialog(this);
        file = jfc.getSelectedFile();
        if (file != null) {
            ManejadorEntrada me = new ManejadorEntrada();
            me.abrirArchivo(controladorGrafos, file);
            
            agregarUbicaciones();
            controladorGrafos.dibujarGrafo(this);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void vehiculoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehiculoBtnActionPerformed
        pieBtn.setSelected(false);
    }//GEN-LAST:event_vehiculoBtnActionPerformed

    private void pieBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieBtnActionPerformed
        vehiculoBtn.setSelected(false);
    }//GEN-LAST:event_pieBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        btnTerminar.setEnabled(false);
        btnSiguiente.setEnabled(false);
        lblMensajeError.setVisible(false);
        if (comBoxOrigen.getSelectedItem().equals(comBoxDestino.getSelectedItem())) {
            lblMensajeError.setText("Origen y Destino Son iguales");
            lblMensajeError.setVisible(true);
        } else {
            if (vehiculoBtn.isSelected() || pieBtn.isSelected()) {
                controladorGrafos.agregarRutas(comBoxOrigen.getSelectedIndex(), comBoxDestino.getSelectedIndex(), this, vehiculoBtn.isSelected());
                btnTerminar.setEnabled(true);
                btnSiguiente.setEnabled(true);
            } else {
                lblMensajeError.setText("Debe Selecionar Vehiculo o A Pie");
                lblMensajeError.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        mostrarLLegarADestino();
        

    }//GEN-LAST:event_btnTerminarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        controladorGrafos.moverALaSiguienteUbicacion();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        panelArbol.removeAll();
        panelCaminos.removeAll();
        panelGrafo.removeAll();
        comBoxDestino.removeAllItems();
        comBoxOrigen.removeAllItems();
        controladorGrafos.resetUbicacion();
        this.validate();
        this.repaint();
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    private void agregarUbicaciones() {
        comBoxOrigen.removeAllItems();
        comBoxDestino.removeAllItems();
        for (int i = 0; i < controladorGrafos.getUbicaciones().size(); i++) {
            comBoxOrigen.addItem(controladorGrafos.getUbicaciones().get(i).toString());
            comBoxDestino.addItem(controladorGrafos.getUbicaciones().get(i).toString());
        }
        if (comBoxDestino.getItemCount() > 1) {
            comBoxDestino.setSelectedIndex(1);
        }
    }

    public void mostrarLLegarADestino() {
        JOptionPane.showMessageDialog(this, "Llegaste a tu Destino " + controladorGrafos.getDestino().getNombre() + ", \n Gracias por Utilizar la App", "Destino Alcanzado", JOptionPane.INFORMATION_MESSAGE);
        panelCaminos.removeAll();
        panelGrafo.removeAll();
        panelArbol.removeAll();
        this.repaint();
        this.validate();
    }

    public void setImageGrafos(ImageIcon im) {
        panelGrafo.removeAll();
        JLabel fondo = new JLabel();
        fondo.setSize(im.getIconWidth(), im.getIconHeight());
        panelGrafo.setPreferredSize(new Dimension(im.getIconWidth(), im.getIconHeight()));
        fondo.setLocation(0, 0);
        fondo.setIcon(im);
        panelGrafo.add(fondo);
        fondo.setVisible(true);
        this.repaint();
        this.validate();
        panelGrafo.repaint();
        panelCaminos.validate();
        fondo.repaint();
        fondo.validate();
    }

    public void setImageArbol(ImageIcon im) {
        panelArbol.removeAll();
        JLabel fondo = new JLabel();
        fondo.setSize(im.getIconWidth(), im.getIconHeight());
        panelArbol.setPreferredSize(new Dimension(im.getIconWidth(), im.getIconHeight()));
        fondo.setLocation(0, 0);
        fondo.setIcon(im);
        panelArbol.add(fondo);
        fondo.setVisible(true);
        this.repaint();
        this.validate();
        panelArbol.repaint();
        panelCaminos.validate();
        fondo.repaint();
        fondo.validate();
    }

    public JPanel getPanelRutas() {
        return panelCaminos;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnTerminar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> comBoxDestino;
    private javax.swing.JComboBox<String> comBoxOrigen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblMensajeError;
    private javax.swing.JPanel panelArbol;
    private javax.swing.JPanel panelCaminos;
    private javax.swing.JPanel panelGrafo;
    private javax.swing.JRadioButton pieBtn;
    private javax.swing.JScrollPane scrollMejores;
    private javax.swing.JRadioButton vehiculoBtn;
    // End of variables declaration//GEN-END:variables
}