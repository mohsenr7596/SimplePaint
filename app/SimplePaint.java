package app;

import java.awt.*;
import java.util.List;

public class SimplePaint extends javax.swing.JFrame {

    private final String[] command = {"Black", "Line"};
    private final BackendPaint bPaint;
    private final List<Shape> shapes;
    private int startX = -1;
    private int startY = -1;

    public SimplePaint(String username) {
        initComponents();
        initFrame();
        this.bPaint = new BackendPaint(username);
        this.shapes = bPaint.getList();
        paintPanel.paint(paintPanel.getGraphics());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rectangleButton = new javax.swing.JButton();
        circleButton = new javax.swing.JButton();
        lineButton = new javax.swing.JButton();
        paintPanel = new javax.swing.JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                for (Shape s : shapes) {
                    bPaint.drawShape(s, g);
                }
            }
        };
        exitButton = new javax.swing.JButton();
        colorComboBox = new javax.swing.JComboBox<>();
        zoomButton = new javax.swing.JButton();
        colorChangeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rectangleButton.setText("Rectangle");
        rectangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangleButtonActionPerformed(evt);
            }
        });

        circleButton.setText("Circle");
        circleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circleButtonActionPerformed(evt);
            }
        });

        lineButton.setText("Line");
        lineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineButtonActionPerformed(evt);
            }
        });

        paintPanel.setBackground(java.awt.Color.white);
        paintPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        paintPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paintPanelMousePressed(evt);
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                paintPanelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout paintPanelLayout = new javax.swing.GroupLayout(paintPanel);
        paintPanel.setLayout(paintPanelLayout);
        paintPanelLayout.setHorizontalGroup(
                paintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 500, Short.MAX_VALUE)
        );
        paintPanelLayout.setVerticalGroup(
                paintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 500, Short.MAX_VALUE)
        );

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        colorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Black", "Red", "Green", "Blue"}));
        colorComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                colorComboBoxItemStateChanged(evt);
            }
        });

        zoomButton.setText("Zoom");
        zoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomButtonActionPerformed(evt);
            }
        });

        colorChangeButton.setText("Change Color");
        colorChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorChangeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(paintPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(circleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rectangleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                        .addComponent(colorComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(zoomButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(colorChangeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lineButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(circleButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rectangleButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(colorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(228, 228, 228)
                                                .addComponent(colorChangeButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(zoomButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(exitButton))
                                        .addComponent(paintPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        if (bPaint.exitConfirm()) {
            dispose();
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void rectangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectangleButtonActionPerformed
        lineButton.setEnabled(true);
        circleButton.setEnabled(true);
        rectangleButton.setEnabled(false);
        command[1] = "Rectangle";
    }//GEN-LAST:event_rectangleButtonActionPerformed

    private void circleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circleButtonActionPerformed
        lineButton.setEnabled(true);
        circleButton.setEnabled(false);
        rectangleButton.setEnabled(true);
        command[1] = "Circle";
    }//GEN-LAST:event_circleButtonActionPerformed

    private void lineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineButtonActionPerformed
        lineButton.setEnabled(false);
        circleButton.setEnabled(true);
        rectangleButton.setEnabled(true);
        command[1] = "Line";
    }//GEN-LAST:event_lineButtonActionPerformed

    private void paintPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paintPanelMouseReleased

        Shape shape;
        switch (command[1]) {
            case "Line":
                shape = new Line(startX, startY, evt.getX(), evt.getY(), command[0]);
                break;

            case "Circle":
                shape = new Circle(startX, startY, evt.getX(), evt.getY(), command[0]);
                break;

            case "Rectangle":
                shape = new Rectangle(startX, startY, evt.getX(), evt.getY(), command[0]);
                break;

            default:
                return;
        }
        shapes.add(shape);
        bPaint.addShape(shape);
        repaint();

    }//GEN-LAST:event_paintPanelMouseReleased

    private void colorComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_colorComboBoxItemStateChanged
        command[0] = colorComboBox.getItemAt(colorComboBox.getSelectedIndex());
    }//GEN-LAST:event_colorComboBoxItemStateChanged

    private void colorChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorChangeButtonActionPerformed
        command[1] = "cColor";
        setAllButtonEnable();
    }//GEN-LAST:event_colorChangeButtonActionPerformed

    private void zoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomButtonActionPerformed
        command[1] = "zoom";
        setAllButtonEnable();
    }//GEN-LAST:event_zoomButtonActionPerformed

    private void paintPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paintPanelMousePressed
        startX = evt.getX();
        startY = evt.getY();

        if ("cColor".equals(command[1])) {
            for (int i = 0; i < shapes.size(); i++) {
                if (shapes.get(i).containShape(startX, startY)) {
                    shapes.get(i).setColor(command[0]);
                    break;
                }
            }
            repaint();
        } else if ("zoom".equals(command[1])) {
//          TODO

            repaint();
        }
    }//GEN-LAST:event_paintPanelMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton circleButton;
    private javax.swing.JButton colorChangeButton;
    private javax.swing.JComboBox<String> colorComboBox;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton lineButton;
    private javax.swing.JPanel paintPanel;
    private javax.swing.JButton rectangleButton;
    private javax.swing.JButton zoomButton;

    // End of variables declaration//GEN-END:variables
    private void initFrame() {
        setResizable(false);
        setLocationRelativeTo(null);
        lineButton.setEnabled(false);
    }

    private void setAllButtonEnable() {
        lineButton.setEnabled(true);
        circleButton.setEnabled(true);
        rectangleButton.setEnabled(true);
    }
}
