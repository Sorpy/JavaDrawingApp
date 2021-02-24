/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entity.DrawingPanel;
import entity.button.DragSelectToggleButton;
import entity.button.EllipseToggleButton;
import entity.button.RectToggleButton;
import entity.button.SelectToggleButton;
import entity.button.common.CustomToggleButtonImpl;
import entity.shape.common.ModelShape;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.util.Enumeration;
import java.util.Iterator;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import processor.Processor;

/**
 *
 * @author Lubo
 */
public class DrawView extends JFrame {

    private static final int DEFAULT_BUTTON_SIZE= 16;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton colorChooserButton;
    private javax.swing.JMenuItem deleteButton;
    private javax.swing.JToggleButton dragSelectToggleButton;
    private javax.swing.JPanel drawPanel;
    private javax.swing.JMenu editMenu;
    private javax.swing.JToggleButton ellipseShapeToggleButton;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu imageMenu;
    private static javax.swing.JList<String> jList1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JToggleButton rectToggleButton;
    private javax.swing.JMenuItem redoButton;
    private javax.swing.JToggleButton selectToggleButton;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JMenuItem undoButton;
    // End of variables declaration//GEN-END:variables
    public Processor processor;
    public static Color currentColor = Color.RED;
    private JColorChooser colorChooser;
    private boolean toggled = false;
    private static DefaultListModel listModel;
    /**
     * Creates new form DrawView
     */
    public DrawView() {
        initComponents();
        initColorChooser();
        processor = new Processor();
    }

    private void initColorChooser() {
        colorChooser = new JColorChooser(Color.BLACK); // default color is black
        colorChooser.setBorder(null);
        colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                colorChanged();
            }
        });
        canvasMouseListener();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        toolBar = new javax.swing.JToolBar();
        selectToggleButton = new SelectToggleButton();
        dragSelectToggleButton = new DragSelectToggleButton();
        rectToggleButton = new RectToggleButton();
        ellipseShapeToggleButton = new EllipseToggleButton();
        drawPanel = new DrawingPanel(this);
        sidePanel = new javax.swing.JPanel();
        colorChooserButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        undoButton = new javax.swing.JMenuItem();
        redoButton = new javax.swing.JMenuItem();
        deleteButton = new javax.swing.JMenuItem();
        imageMenu = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();

        setMinimumSize(new java.awt.Dimension(10, 10));

        toolBar.setFloatable(false);
        toolBar.setRollover(true);
        toolBar.setBorderPainted(false);

        buttonGroup.add(selectToggleButton);
        selectToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/FreeMoveGliph.png"))); // NOI18N
        selectToggleButton.setSelected(true);
        selectToggleButton.setToolTipText("");
        selectToggleButton.setFocusable(false);
        selectToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        selectToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(selectToggleButton);

        buttonGroup.add(dragSelectToggleButton);
        dragSelectToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/DragSelectToolIcon.png"))); // NOI18N
        dragSelectToggleButton.setToolTipText("Drag Select Tool");
        dragSelectToggleButton.setFocusable(false);
        dragSelectToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dragSelectToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(dragSelectToggleButton);

        buttonGroup.add(rectToggleButton);
        rectToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/RectangleTool.png"))); // NOI18N
        rectToggleButton.setToolTipText("Draw Rectangle");
        rectToggleButton.setFocusable(false);
        rectToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rectToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(rectToggleButton);

        buttonGroup.add(ellipseShapeToggleButton);
        ellipseShapeToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/RectangleTool.png"))); // NOI18N
        ellipseShapeToggleButton.setToolTipText("Draw Elipse");
        ellipseShapeToggleButton.setFocusable(false);
        ellipseShapeToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ellipseShapeToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(ellipseShapeToggleButton);

        drawPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout drawPanelLayout = new javax.swing.GroupLayout(drawPanel);
        drawPanel.setLayout(drawPanelLayout);
        drawPanelLayout.setHorizontalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        drawPanelLayout.setVerticalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        sidePanel.setBackground(new java.awt.Color(153, 153, 153));

        colorChooserButton.setIcon(createIcon(currentColor));
        colorChooserButton.setToolTipText("color chooser");
        colorChooserButton.setAlignmentY(0.0F);
        colorChooserButton.setFocusable(false);
        colorChooserButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorChooserButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickedColorChooseButton(evt);
            }
        });

        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setItemListModel();
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addComponent(colorChooserButton)
                        .addGap(0, 147, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(colorChooserButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        fileMenu.setText("File");

        jMenuItem1.setText("jMenuItem1");
        fileMenu.add(jMenuItem1);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");

        undoButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        undoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/UndoIcon.png"))); // NOI18N
        undoButton.setText("Undo");
        undoButton.setToolTipText("");
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });
        editMenu.add(undoButton);

        redoButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        redoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/redo-icon.png"))); // NOI18N
        redoButton.setText("Redo");
        redoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoButtonActionPerformed(evt);
            }
        });
        editMenu.add(redoButton);

        deleteButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/delete-icon.png"))); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        editMenu.add(deleteButton);

        menuBar.add(editMenu);

        imageMenu.setText("Image");
        menuBar.add(imageMenu);

        helpMenu.setText("Help");
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clickedColorChooseButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickedColorChooseButton
        Color newColor = JColorChooser.showDialog(null, "Choose a color", currentColor);
        toggleColorChooser(newColor);
    }//GEN-LAST:event_clickedColorChooseButton

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        
    }//GEN-LAST:event_undoButtonActionPerformed

    private void redoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_redoButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        Processor.shapeList.removeIf(ModelShape::isSelected);
        processor.repaint((DrawingPanel)drawPanel);
        setItemListModel();
    }//GEN-LAST:event_deleteButtonActionPerformed

    public static void setItemListModel(){
        listModel = new DefaultListModel();
        for (ModelShape shape :
            Processor.shapeList) {
            listModel.addElement(shape);
        }
        jList1.setModel(listModel);
    }
    
//    private DefaultListModel<ModelShape> createDefaultModel(){
//        DefaultListModel<ModelShape> model = new DefaultListModel<ModelShape>();
//        for (ModelShape shape :
//            Processor.shapeList) {
//            model.addElement(shape);
//        }
//        return model;
//    }

    private void canvasMouseListener(){
        drawPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                getSelectedButtonText(buttonGroup).onClickFunction(e);
                processor.repaint((DrawingPanel)drawPanel);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                getSelectedButtonText(buttonGroup).onPressFunction(e);
                processor.repaint((DrawingPanel)drawPanel);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                getSelectedButtonText(buttonGroup).onReleaseFunction(e);
                processor.repaint((DrawingPanel)drawPanel);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                getSelectedButtonText(buttonGroup).onEnterFunction(e);
                processor.repaint((DrawingPanel)drawPanel);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                getSelectedButtonText(buttonGroup).onExitFunction(e);
                processor.repaint((DrawingPanel)drawPanel);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
                getSelectedButtonText(buttonGroup).onWheelMovedFunction(e);
                processor.repaint((DrawingPanel)drawPanel);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                getSelectedButtonText(buttonGroup).onDragFunction(e);
                processor.repaint((DrawingPanel)drawPanel);
            }

//            @Override
//            public void mouseMoved(MouseEvent e) {
//                super.mouseMoved(e);
//                getSelectedButtonText(buttonGroup).onMoveFunction(e);
//                draw();
//            }

        });
        drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                getSelectedButtonText(buttonGroup).onDragFunction(e);
                processor.repaint((DrawingPanel)drawPanel);
            }
        });
    }

    protected void colorChanged() {
        colorChooserButton.setIcon(createIcon(colorChooser.getSelectionModel().getSelectedColor()));
    }

    protected void toggleColorChooser(Color newColor) {
        if (newColor == null) return;
        currentColor = newColor;
        colorChooserButton.setIcon(createIcon(currentColor));
        repaint();
    }

    public static  ImageIcon createIcon(Color main) {
        BufferedImage image = new BufferedImage(DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE, java.awt.image.BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(main);
        graphics.fillRect(0, 0, DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE);
        graphics.setXORMode(Color.BLACK);
        graphics.drawRect(0, 0, DEFAULT_BUTTON_SIZE-1, DEFAULT_BUTTON_SIZE-1);
        image.flush();
        return new ImageIcon(image);
    }

    public CustomToggleButtonImpl getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return (CustomToggleButtonImpl)button;
            }
        }

        return null;
    }
}
