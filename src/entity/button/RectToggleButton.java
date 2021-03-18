package entity.button;

import GUI.DrawView;
import entity.button.common.CustomToggleButton;
import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.JToggleButton;
import processor.Processor;

public class RectToggleButton extends JToggleButton implements CustomToggleButton {
  private Point startPoint;


  @Override
  public void onClickFunction(MouseEvent e) {

  }

  @Override
  public void onPressFunction(MouseEvent e) {
    DrawView.setRotateSliderValue(0);
    Processor.deselectAll();
    startPoint = e.getPoint();
  }

  @Override
  public void onReleaseFunction(MouseEvent e) {

    drawRectangle(startPoint.x,startPoint.y,e.getX(),e.getY());
    Processor.markRect = null;
  }

  @Override
  public void onEnterFunction(MouseEvent e) {

  }

  @Override
  public void onExitFunction(MouseEvent e) {

  }

  @Override
  public void onWheelMovedFunction(MouseEvent e) {

  }

  @Override
  public void onDragFunction(MouseEvent e) {

    Processor.makeSelection(
        startPoint.x,startPoint.y,
        e.getX(),e.getY(),
        new Color(105, 119, 172, 150)
    );
  }

  @Override
  public void onMoveFunction(MouseEvent e) {

  }

  public void drawRectangle(int x, int y, int width, int height) {
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

    AffineTransform affineTransform = new AffineTransform();
    if (Math.abs(x-width)>0 && Math.abs(y-height)>0 ) {
      Processor.createShape(new Double(x, y, width - x, height - y), affineTransform);
      DrawView.setItemListModel();
      Processor.addToUndoList();
    }
  }
}
