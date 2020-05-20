/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gps.ui;

import gps.Grafos.ControladorDeRutas;
import gps.Grafos.Ruta;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author sergio
 */
public class InfoRuta extends JPanel {

    public static final int ANCHO = 250;
    public static final int ALTO = 90;
    public static final String DISTANCIA = "Distancia: ";
    public static final String TIEMPO = "Tiempo: ";
    public static final String DESGASTE = "Desgaste: ";
    public static final String GASOLINA = "Gasolina: ";
    public static final String MEJOR = "Mejor ";
    public static final String PEOR = "Peor ";
    public static final String PROMEDIO = "Promedio ";
    public static final String M_DISTANCIA = "Distancia ";
    public static final String M_DESGASTE = "Desgaste ";
    public static final String M_GASOLINA = "Consumo de Gas ";
    public static final String AND = "& ";
    public static final String ID = "#ID: ";
    private boolean seleccionado=false;
    private String index;
    private ControladorDeRutas cdr;
private Ruta ruta;
    public String getIndex() {
        return index;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setCdr(ControladorDeRutas cdr) {
        this.cdr = cdr;
    }
    /**
     * Creates new form InfoRuta
     *
     * @param distancia
     */
    public InfoRuta(Ruta ruta, boolean enVehiculo,ControladorDeRutas cdr,String index) {
        initComponents();
        this.ruta=ruta;
        this.cdr=cdr;
        this.index=index;
        this.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        lblDistancia.setText(DISTANCIA + String.valueOf(ruta.getDistanciaTotal()));
        if (enVehiculo) {
            lblTiempo.setText(TIEMPO + String.valueOf(ruta.getTiempoEnVehiculoTotal()));
            lblDesgaste.setText(GASOLINA + String.valueOf(ruta.getGasolinaTotal()));
        } else {
            lblTiempo.setText(TIEMPO + String.valueOf(ruta.getTiempoAPieTotal()));
            lblDesgaste.setText(DESGASTE + String.valueOf(ruta.getDesgasteTotal()));
        }
        lblID.setText(ID+ruta.getId());
        String descripcion = "";
        boolean agregar = false;
        if (ruta.isMejorPromedio()) {
            descripcion += MEJOR + PROMEDIO;
            agregar = true;
        }
        if (ruta.isMejorDistancia()) {
            if (!agregar) {
                descripcion += MEJOR;
            }else{
                descripcion +=AND;
            }
            descripcion += M_DISTANCIA;
        }
        if (ruta.isMejorDesgaste()) {
            if (!agregar) {
                descripcion += MEJOR;
            }else{
                descripcion +=AND;
            }
            if (enVehiculo) {
                descripcion+=M_GASOLINA;
            } else {
                descripcion+=M_DESGASTE;
            }
        }
        lblMejores.setText(descripcion);
        descripcion="";
        agregar=false;
        
        if (ruta.isPeorPromedio()) {
            descripcion += PEOR + PROMEDIO;
            agregar = true;
        }
        if (ruta.isPeorDistancia()) {
            if (!agregar) {
                descripcion += PEOR;
            }else{
                descripcion +=AND;
            }
            descripcion += M_DISTANCIA;
        }
        if (ruta.isPeorDesgaste()) {
            if (!agregar) {
                descripcion += PEOR;
            }else{
                descripcion +=AND;
            }
            if (enVehiculo) {
                descripcion+=M_GASOLINA;
            } else {
                descripcion+=M_DESGASTE;
            }
        }
        lblPeores.setText(descripcion);
        
        agregarMouseLiseners();
        
        
        
    }

    
    private void agregarMouseLiseners(){
        this.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cambiarBackground(false);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cambiarBackground(true);
            }
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClick();
            }
            
        });
        
    }
    
    private void mouseClick(){
        cdr.seleccionarRuta(this,index);
    }
    private void cambiarBackground(boolean selecionado){
        if (selecionado) {
            setBackground(Color.LIGHT_GRAY);
        }else{
            setBackground(Color.WHITE);
        }
            
    }
    
    
    
    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
        if (seleccionado) {
            this.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLUE,2));
        }else{
            this.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK,1));
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

        lblMejores = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        lblDistancia = new javax.swing.JLabel();
        lblPeores = new javax.swing.JLabel();
        lblDesgaste = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 254, 254));

        lblMejores.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        lblMejores.setForeground(new java.awt.Color(34, 255, 0));
        lblMejores.setText("jLabel1");

        lblTiempo.setForeground(new java.awt.Color(1, 1, 1));
        lblTiempo.setText("Tiempo:");

        lblDistancia.setForeground(new java.awt.Color(1, 1, 1));
        lblDistancia.setText("Distancia");

        lblPeores.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        lblPeores.setForeground(new java.awt.Color(255, 15, 0));
        lblPeores.setText("jLabel1");

        lblDesgaste.setForeground(new java.awt.Color(1, 1, 1));
        lblDesgaste.setText("Desgaste:");

        lblID.setForeground(new java.awt.Color(1, 1, 1));
        lblID.setText("#ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMejores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPeores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDesgaste)
                            .addComponent(lblTiempo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDistancia)
                                .addGap(43, 43, 43)
                                .addComponent(lblID)))
                        .addGap(0, 102, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblMejores)
                .addGap(3, 3, 3)
                .addComponent(lblPeores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDistancia)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTiempo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDesgaste))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDesgaste;
    private javax.swing.JLabel lblDistancia;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMejores;
    private javax.swing.JLabel lblPeores;
    private javax.swing.JLabel lblTiempo;
    // End of variables declaration//GEN-END:variables
}
