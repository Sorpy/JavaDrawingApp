package processor;

import GUI.DrawView;
import entity.DrawingPanel;
import entity.shape.PathShape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Stack;

public class Processor {


  public static PathShape markRect;
  public static PathShape markEllipse;
  public static PathShape markLine;
  public static ArrayList<PathShape> shapeList = new ArrayList<>();
  public static Stack<ArrayList<PathShape>> canvasUndoList = new Stack<>();
  public static Stack<ArrayList<PathShape>> canvasRedoList = new Stack<>();

  public static void addToUndoList() {
    if (canvasUndoList.size() >= 10){
      canvasUndoList.remove(0);
      System.out.println("itemRemoved");
  }
    ArrayList<PathShape> tempList = new ArrayList<>();
    for (PathShape shape : shapeList) {
      PathShape tempShape =shape.clonePath();
      tempShape.setAffineTransform(shape.getAffineTransform());
      tempShape.setFillColor(shape.getFillColor());
      tempShape.setStrokeWidth(shape.getStrokeWidth());
      tempShape.setStrokeColor(shape.getStrokeColor());
        tempList.add(tempShape);
      }
    canvasUndoList.push(tempList);
  }

  public static void createShape(Shape shape, AffineTransform affineTransform){
    PathShape pathShape =
        new PathShape(shape,
            affineTransform,
            DrawView.currentFillColor,
            DrawView.currentStrokeColor,
            DrawView.currentStrokeSize);
    Processor.shapeList.add(pathShape);
  }

  public static void makeSelection(int x, int y, int width, int height,Color color) {
    if (x > width) {
      int temp = x;
      x = width;
      width = temp;
    }
    if (y > height) {
      int temp = y;
      y = height;
      height = temp;
    }

    Processor.markRect = new PathShape(new Double(x, y, width - x, height - y), new AffineTransform());
    Processor.markRect.setFillColor(color);
  }

  public void reDraw(Graphics g) {
    Graphics2D graphics = (Graphics2D) g;
    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    draw(graphics);
  }

  public void draw(Graphics2D g) {
    for (PathShape pathShape : shapeList) {
      drawShape(g, pathShape);
    }
    drawShape(g, markRect);
    drawShape(g,markEllipse);
    drawShape(g,markLine);
  }

  public static void deselectAll(){
    shapeList.forEach(modelShape -> modelShape.setSelected(false));
  }

  public void drawShape(Graphics2D g, PathShape item) {
    if (item!=null) {
      item.DrawSelf(g);
    }
  }


  public void repaint(DrawingPanel drawingPanel) {
    drawingPanel.repaint();
  }
}
