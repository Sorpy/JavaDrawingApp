package processor;

import entity.DrawingPanel;
import entity.shape.EllipseShape;
import entity.shape.RectangleShape;
import entity.shape.common.ModelShape;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Stack;

public class Processor {


  public static RectangleShape markRect = new RectangleShape();
  public static EllipseShape markEllipse= new EllipseShape();
  public static RectangleShape selectedArea = new RectangleShape();
  public static ArrayList<ModelShape> shapeList = new ArrayList<>();
  public static Stack<ArrayList<ModelShape>> canvasUndoList = new Stack<>();
  public static Stack<ArrayList<ModelShape>> canvasRedoList = new Stack<>();

  public static void addToUndoList() {
//    if (canvasUndoList.size() >= 10){
//      canvasUndoList.remove(0);
//      System.out.println("itemRemoved");
//  }
    ArrayList<ModelShape> tempList = new ArrayList<>();
    for (ModelShape shape : shapeList) {
      ModelShape tempShape = (ModelShape) shape.clone();
      tempList.add(tempShape);
    }
    canvasUndoList.push(tempList);
    canvasUndoList.forEach(System.out::println);
  }

  public void reDraw(Graphics g) {
    Graphics2D graphics = (Graphics2D) g;
    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    draw(graphics);
  }

  public void draw(Graphics2D g) {
    for (ModelShape modelShape : shapeList) {
      drawShape(g, modelShape);
    }
    drawShape(g, markRect);
    drawShape(g,markEllipse);
  }

  public static void deselectAll(){
    shapeList.forEach(modelShape -> modelShape.setSelected(false));
    selectedArea=new RectangleShape();
  }

  public void drawShape(Graphics2D g, ModelShape item) {
    item.DrawSelf(g);
  }


  public void repaint(DrawingPanel drawingPanel) {
    drawingPanel.repaint();
  }
}
