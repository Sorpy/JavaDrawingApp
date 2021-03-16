/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entity.DrawingPanel;
import entity.button.DragSelectToggleButton;
import entity.button.EllipseToggleButton;
import entity.button.LineToggleButton;
import entity.button.RectToggleButton;
import entity.button.SelectToggleButton;
import entity.button.common.CustomToggleButton;
import entity.shape.PathShape;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import processor.ItemsListCellRenderer;
import processor.Processor;
import processor.RotateProcessor;

/**
 *
 * @author Lubo
 */
public class DrawView extends JFrame {

    private static final int DEFAULT_BUTTON_SIZE= 16;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JPopupMenu canvasRightClickPopup;
    private javax.swing.JMenuItem deleteButton;
    private javax.swing.JToggleButton dragSelectToggleButton;
    private javax.swing.JPanel drawPanel;
    private javax.swing.JMenu editMenu;
    private javax.swing.JToggleButton ellipseShapeToggleButton;
    private javax.swing.JMenu fileMenu;
    private static javax.swing.JButton fillColorChooserButton;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu imageMenu;
    private static javax.swing.JList<PathShape> itemsList;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JOptionPane jOptionPane;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton lineToggleButton;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JToggleButton rectToggleButton;
    private javax.swing.JMenuItem redoButton;
    private javax.swing.JMenuItem rightClickDeleteMenu;
    private static javax.swing.JSlider rotateSlider;
    private javax.swing.JLabel rotateSliderLabel;
    private javax.swing.JLabel rotateSliderLabel1;
    private javax.swing.JToggleButton selectToggleButton;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JTextField sliderValueInput;
    private static javax.swing.JButton strokeColorChooserButton;
    private javax.swing.JComboBox strokeWidthComboBox;
    private javax.swing.JTextField strokeWidthInputValue;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JMenuItem undoButton;
    // End of variables declaration//GEN-END:variables
    public Processor processor;
    public static Color currentFillColor = Color.RED;
    public static Color currentStrokeColor = Color.BLACK;
    public static int currentStrokeSize = 0;
    private JColorChooser colorChooser;
    private boolean toggled = false;
    private static DefaultListModel<PathShape> listModel;
    private static final ItemsListCellRenderer itemsListCellRenderer = new ItemsListCellRenderer();

    public static void setRotateSliderValue(int value) {
        DrawView.rotateSlider.setValue(value);
    }

    public DrawView() {
        listModel = new DefaultListModel<>();
        initComponents();
        processor = new Processor();
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
        canvasRightClickPopup = new javax.swing.JPopupMenu();
        rightClickDeleteMenu = new javax.swing.JMenuItem();
        jOptionPane = new javax.swing.JOptionPane();
        toolBar = new javax.swing.JToolBar();
        selectToggleButton = new SelectToggleButton();
        dragSelectToggleButton = new DragSelectToggleButton();
        rectToggleButton = new RectToggleButton();
        ellipseShapeToggleButton = new EllipseToggleButton();
        lineToggleButton = new LineToggleButton();
        drawPanel = new DrawingPanel(this);
        sidePanel = new javax.swing.JPanel();
        fillColorChooserButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemsList = new javax.swing.JList<PathShape>();
        rotateSlider = new javax.swing.JSlider();
        rotateSliderLabel = new javax.swing.JLabel();
        sliderValueInput = new javax.swing.JTextField();
        strokeWidthComboBox = new javax.swing.JComboBox();
        strokeColorChooserButton = new javax.swing.JButton();
        strokeWidthInputValue = new javax.swing.JTextField();
        rotateSliderLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        undoButton = new javax.swing.JMenuItem();
        redoButton = new javax.swing.JMenuItem();
        deleteButton = new javax.swing.JMenuItem();
        imageMenu = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();

        canvasRightClickPopup.setBackground(new java.awt.Color(255, 255, 255));
        canvasRightClickPopup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        rightClickDeleteMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/delete-icon.png"))); // NOI18N
        rightClickDeleteMenu.setText("Delete");
        rightClickDeleteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightClickDeleteMenuAction(evt);
            }
        });
        canvasRightClickPopup.add(rightClickDeleteMenu);

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
        selectToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeOtherButtonsActions(evt);
            }
        });
        toolBar.add(selectToggleButton);

        buttonGroup.add(dragSelectToggleButton);
        dragSelectToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/DragSelectToolIcon.png"))); // NOI18N
        dragSelectToggleButton.setToolTipText("Drag Select Tool");
        dragSelectToggleButton.setFocusable(false);
        dragSelectToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dragSelectToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        dragSelectToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeOtherButtonsActions(evt);
            }
        });
        toolBar.add(dragSelectToggleButton);

        buttonGroup.add(rectToggleButton);
        rectToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/RectangleTool.png"))); // NOI18N
        rectToggleButton.setToolTipText("Draw Rectangle");
        rectToggleButton.setFocusable(false);
        rectToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rectToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rectToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeOtherButtonsActions(evt);
            }
        });
        toolBar.add(rectToggleButton);

        buttonGroup.add(ellipseShapeToggleButton);
        ellipseShapeToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ellipse-draw-icon.png"))); // NOI18N
        ellipseShapeToggleButton.setToolTipText("Draw Elipse");
        ellipseShapeToggleButton.setFocusable(false);
        ellipseShapeToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ellipseShapeToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ellipseShapeToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeOtherButtonsActions(evt);
            }
        });
        toolBar.add(ellipseShapeToggleButton);

        buttonGroup.add(lineToggleButton);
        lineToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/line-draw-icon.png"))); // NOI18N
        lineToggleButton.setToolTipText("Draw Line");
        lineToggleButton.setFocusable(false);
        lineToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lineToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lineToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeOtherButtonsActions(evt);
            }
        });
        toolBar.add(lineToggleButton);

        drawPanel.setBackground(new java.awt.Color(255, 255, 255));
        drawPanel.setComponentPopupMenu(canvasRightClickPopup);

        javax.swing.GroupLayout drawPanelLayout = new javax.swing.GroupLayout(drawPanel);
        drawPanel.setLayout(drawPanelLayout);
        drawPanelLayout.setHorizontalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );
        drawPanelLayout.setVerticalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );

        sidePanel.setBackground(new java.awt.Color(153, 153, 153));

        fillColorChooserButton.setIcon(createFillColorIcon(currentFillColor,true));
        fillColorChooserButton.setToolTipText("color chooser");
        fillColorChooserButton.setAlignmentY(0.0F);
        fillColorChooserButton.setFocusable(false);
        fillColorChooserButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fillColorChooserButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        fillColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickedColorChooseButton(evt);
            }
        });

        itemsList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setItemListModel();
        itemsList.setCellRenderer(itemsListCellRenderer);
        itemsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                itemsListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(itemsList);

        rotateSlider.setMajorTickSpacing(60);
        rotateSlider.setMaximum(180);
        rotateSlider.setMinimum(-180);
        rotateSlider.setMinorTickSpacing(15);
        rotateSlider.setPaintTicks(true);
        rotateSlider.setValue(0);
        rotateSlider.setName("rotate"); // NOI18N
        rotateSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rotateSliderStateChanged(evt);
            }
        });
        rotateSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rotateSliderMouseReleased(evt);
            }
        });

        rotateSliderLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rotateSliderLabel.setText("Rotate Slider");

        sliderValueInput.setText("0");
        sliderValueInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sliderValueInputKeyPressed(evt);
            }
        });

        strokeWidthComboBox.setModel(loadBrushSizeIcons());
        strokeWidthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strokeWidthComboBoxActionPerformed(evt);
            }
        });

        strokeColorChooserButton.setIcon(createFillColorIcon(currentStrokeColor,false));
        strokeColorChooserButton.setToolTipText("color chooser");
        strokeColorChooserButton.setAlignmentY(0.0F);
        strokeColorChooserButton.setFocusable(false);
        strokeColorChooserButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        strokeColorChooserButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        strokeColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strokeColorChooserButtonOnClick(evt);
            }
        });

        strokeWidthInputValue.setText("0");
        strokeWidthInputValue.setPreferredSize(new java.awt.Dimension(12, 24));
        strokeWidthInputValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                strokeWidthInputValueKeyPressed(evt);
            }
        });

        rotateSliderLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rotateSliderLabel1.setText("Stroke Size");

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(sidePanelLayout.createSequentialGroup()
                                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(strokeWidthInputValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sliderValueInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(sidePanelLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(rotateSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                            .addComponent(strokeWidthComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(sidePanelLayout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(rotateSliderLabel1)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                        .addGap(0, 63, Short.MAX_VALUE)
                        .addComponent(rotateSliderLabel)
                        .addGap(69, 69, 69))
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addComponent(fillColorChooserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addComponent(strokeColorChooserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fillColorChooserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(strokeColorChooserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rotateSliderLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(strokeWidthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strokeWidthInputValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rotateSliderLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sliderValueInput)
                    .addComponent(rotateSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
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
                    .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        Processor.canvasRedoList.push(Processor.canvasUndoList.pop());
        if (!Processor.canvasUndoList.empty()) {
            ArrayList<PathShape> tempList = new ArrayList<>();
            for (PathShape shape : Processor.canvasUndoList.peek()) {
                PathShape tempShape = shape.clonePath();
                tempList.add(tempShape);
            }
            Processor.shapeList = tempList;
        }else if (Processor.shapeList.size()==1){
            Processor.shapeList = new ArrayList<>();
        }
        setItemListModel();
        processor.repaint((DrawingPanel) drawPanel);

    }//GEN-LAST:event_undoButtonActionPerformed

    private void redoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoButtonActionPerformed
        Processor.canvasUndoList.push(Processor.canvasRedoList.peek());
        if (!Processor.canvasRedoList.empty()){
            ArrayList<PathShape> tempList = new ArrayList<>();
            for (PathShape shape : Processor.canvasRedoList.pop()) {
                PathShape tempShape = shape.clonePath();
                tempList.add(tempShape);
            }
            Processor.shapeList = tempList;
        }
        processor.repaint((DrawingPanel) drawPanel);
        setItemListModel();
    }//GEN-LAST:event_redoButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        Processor.shapeList.removeIf(PathShape::isSelected);
        processor.repaint((DrawingPanel)drawPanel);
        setItemListModel();
        Processor.addToUndoList();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void removeOtherButtonsActions(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeOtherButtonsActions
        Processor.deselectAll();
        Processor.markRect = null;
        processor.repaint((DrawingPanel)drawPanel);
    }//GEN-LAST:event_removeOtherButtonsActions

    private void rightClickDeleteMenuAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightClickDeleteMenuAction
        deleteButtonActionPerformed(evt);
    }//GEN-LAST:event_rightClickDeleteMenuAction

    private void rotateSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rotateSliderMouseReleased
        Processor.addToUndoList();
    }//GEN-LAST:event_rotateSliderMouseReleased

    private void rotateSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rotateSliderStateChanged
        double sliderValue = rotateSlider.getValue();
        RotateProcessor rotateProcessor = new RotateProcessor();
        rotateProcessor.rotateShape(sliderValue);
        sliderValueInput.setText(String.valueOf((int)sliderValue));
        processor.repaint((DrawingPanel)drawPanel);
    }//GEN-LAST:event_rotateSliderStateChanged

    private void clickedColorChooseButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickedColorChooseButton
        Color newColor = JColorChooser.showDialog(null, "Choose a fill color", currentFillColor);
        toggleFillColorChooser(newColor);
    }//GEN-LAST:event_clickedColorChooseButton

    private void sliderValueInputKeyPressed(
        java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sliderValueKeyPressed
        if (SelectToggleButton.getSelectedItem() != null) {
            sliderValueInput.setEditable(Character.isDigit(evt.getKeyChar()) || evt.getKeyCode() == '-'
                || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE);
            checkRotationValue(evt);
        }else sliderValueInput.setEditable(false);
    }//GEN-LAST:event_sliderValueKeyPressed

    private void strokeColorChooserButtonOnClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strokeColorChooserButtonOnClick
        Color newColor = JColorChooser.showDialog(null, "Choose a stroke color", currentStrokeColor);
        toggleStrokeColorChooser(newColor);
    }//GEN-LAST:event_strokeColorChooserButtonOnClick



    private void strokeWidthInputValueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_strokeWidthInputValueKeyPressed
        strokeWidthInputValue.setEditable
            (Character.isDigit(evt.getKeyChar()) ||
                evt.getKeyCode() == KeyEvent.VK_BACK_SPACE
            );
        int strokeWidth =strokeWidthInputValue.getText().isEmpty() ?
            0 : Integer.parseInt(strokeWidthInputValue.getText());
        checkStrokeValue(strokeWidth);
    }//GEN-LAST:event_strokeWidthInputValueKeyPressed

    private void checkStrokeValue(int strokeWidth) {
        if (strokeWidth >150){
            JOptionPane.showMessageDialog(this,
                "Maximum size of stroke 150",
                "Stroke Width Error",
                JOptionPane.ERROR_MESSAGE);
            strokeWidthInputValue.setText("150");
        }else {
            currentStrokeSize = strokeWidth;
        }
    }

    private void strokeWidthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strokeWidthComboBoxActionPerformed
        currentStrokeSize = (int) Math.pow(strokeWidthComboBox.getSelectedIndex()+1,2);
        System.out.println(strokeWidthComboBox.getSelectedIndex()+1);
        strokeWidthInputValue.setText(String.valueOf(currentStrokeSize));
    }//GEN-LAST:event_strokeWidthComboBoxActionPerformed

    private void itemsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_itemsListValueChanged
        Processor.shapeList.forEach(pathShape -> pathShape.setSelected(false));
        itemsList.getSelectedValuesList().forEach(shape -> shape.setSelected(true));
        selectToggleButton.setSelected(true);
        SelectToggleButton.selectedShapeList = itemsList.getSelectedValuesList();
        processor.repaint((DrawingPanel)drawPanel);
    }//GEN-LAST:event_itemsListValueChanged

    private void checkRotationValue(KeyEvent evt) {
        String regex = "(-?[0-9]{1,3})";
        if (evt.getKeyCode()== KeyEvent.VK_ENTER){
            if (!sliderValueInput.getText().matches(regex) ||
                (Integer.parseInt(sliderValueInput.getText())>180 ||
                Integer.parseInt(sliderValueInput.getText())<-180)){
                JOptionPane.showMessageDialog(this,
                    "Rotation must be between -180 and 180 degrees",
                    "Rotation Error",
                    JOptionPane.ERROR_MESSAGE);
                sliderValueInput.setText("0");
            }
            else {
                rotateSlider.setValue(Integer.parseInt(sliderValueInput.getText()));
            }
        }
    }

    public static void setItemListModel(){
        itemsList.removeAll();
        listModel.removeAllElements();
        itemsList.clearSelection();
        for (PathShape shape : Processor.shapeList) {
            System.out.println(shape.getShape());
            listModel.addElement(shape);
        }
        itemsList.setModel(listModel);
        itemsList.setCellRenderer(itemsListCellRenderer);
    }

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

//    protected void colorChanged() {
//        fillColorChooserButton.setIcon(createFillColorIcon(colorChooser.getSelectionModel().getSelectedColor()));
//    }

    private void toggleStrokeColorChooser(Color newColor) {
        if (newColor == null) return;
        currentStrokeColor = newColor;
        strokeColorChooserButton.setIcon(createFillColorIcon(currentStrokeColor,false));
        repaint();
    }



    protected void toggleFillColorChooser(Color newColor) {
        if (newColor == null) return;
        currentFillColor = newColor;
        fillColorChooserButton.setIcon(createFillColorIcon(currentFillColor,true));
        repaint();
    }



    public static  ImageIcon createFillColorIcon(Color main,boolean isFill) {
        BufferedImage image = new BufferedImage(DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE, java.awt.image.BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(main);
        graphics.fillRect(0, 0, DEFAULT_BUTTON_SIZE, DEFAULT_BUTTON_SIZE);
        //graphics.setXORMode(Color.BLACK);
        graphics.drawRect(0, 0, DEFAULT_BUTTON_SIZE-1, DEFAULT_BUTTON_SIZE-1);
        if (!isFill){
            graphics.setColor(new Color(195, 195, 208));
            graphics.fillRect(3,3,DEFAULT_BUTTON_SIZE-6,DEFAULT_BUTTON_SIZE-6);
        }
        image.flush();
        return new ImageIcon(image);
    }

    public CustomToggleButton getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return (CustomToggleButton)button;
            }
        }

        return null;
    }

    private DefaultComboBoxModel<Icon> loadBrushSizeIcons() {
        DefaultComboBoxModel<Icon> model = new DefaultComboBoxModel<>();
        model.addElement(new ImageIcon(getClass().getResource("/resources/strokes/size-1-stroke.png")));
        model.addElement(new ImageIcon(getClass().getResource("/resources/strokes/size-2-stroke.png")));
        model.addElement(new ImageIcon(getClass().getResource("/resources/strokes/size-3-stroke.png")));
        model.addElement(new ImageIcon(getClass().getResource("/resources/strokes/size-4-stroke.png")));
        return model;
    }
}
