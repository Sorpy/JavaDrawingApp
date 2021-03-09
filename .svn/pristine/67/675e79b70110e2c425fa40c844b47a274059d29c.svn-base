package processor;

import entity.DrawingPanel;
import entity.shape.RectangleShape;
import entity.shape.common.ModelShape;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

public class Processor {


  public static RectangleShape markRect = new RectangleShape();
  public static ModelShape currentlySelectedShape;
  public static RectangleShape selectedArea = new RectangleShape();
  public static ArrayList<ModelShape> shapeList = new ArrayList<>();

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
    drawShape(g, selectedArea);
  }

  public void drawShape(Graphics2D g, ModelShape item) {
    item.DrawSelf(g);
  }


  public void repaint(DrawingPanel drawingPanel) {
    drawingPanel.repaint();
  }
}
