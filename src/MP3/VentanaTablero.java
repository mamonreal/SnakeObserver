/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MP3;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

/**
 *
 * @author MiguelÁngel
 */
public class VentanaTablero extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form VentanaTablero
     */
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTablero = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnlTableroLayout = new javax.swing.GroupLayout(pnlTablero);
        pnlTablero.setLayout(pnlTableroLayout);
        pnlTableroLayout.setHorizontalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );
        pnlTableroLayout.setVerticalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlTablero;
    // End of variables declaration//GEN-END:variables
    private final int ROWS;
    private final int COLUMNS;
    private JPanel [][] matriz ;
    private Color colorSnake, colorFood, colorBackground;

    public VentanaTablero(Modelo modelo) {
        this.ROWS = modelo.getROWS();
        this.COLUMNS = modelo.getCOLUMNS();
        this.colorSnake = Color.red;
        this.colorFood = Color.green;
        this.colorBackground = Color.white;
        matriz = new JPanel[ROWS][COLUMNS];
        pnlTablero = new JPanel();
        rellenarTablero(pnlTablero, matriz, ROWS, COLUMNS, colorBackground);
        Punto head = modelo.getHead();
        matriz[head.getY()][head.getX()].setBackground(colorSnake);
        setFocusable(true);
        pnlTablero.setVisible(true);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Modelo modelo = (Modelo) o;
        String msg = arg.toString();
        
        if (msg.contains("Move")) {
            Punto head = modelo.getHead();
            matriz[head.getY()][head.getX()].setBackground(colorSnake);
            Punto tail = modelo.getTail();
            matriz[tail.getY()][tail.getX()].setBackground(colorBackground);
        }
        
        if (msg.contains("Food")) {
            Punto food = modelo.getFood();
            matriz[food.getY()][food.getX()].setBackground(colorFood);
        }
    }
    
    public static void rellenarTablero(JPanel tablero, JPanel[][] matriz, int ROWS, int COLUMNS, Color colorBackground) {
        GridLayout gridLayout = new GridLayout(ROWS, COLUMNS);
        tablero = new JPanel();
        tablero.setLayout(gridLayout);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++){
                JPanel p = new JPanel();
                p.setBackground(colorBackground);
                matriz[i][j] = p;
                tablero.add(p);
            }
        }
    }
}
