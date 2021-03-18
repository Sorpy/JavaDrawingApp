package entity.button;

import GUI.DrawView;
import entity.button.common.CustomToggleButton;
import entity.shape.PathShape;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import javax.swing.JToggleButton;
import processor.Processor;

public class EllipseToggleButton extends JToggleButton implements CustomToggleButton {

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
    drawEllipse(startPoint.x,startPoint.y,e.getX(),e.getY());
    Processor.markEllipse = null;
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
        makeSelection(startPoint.x,startPoint.y,e.getX(),e.getY());
  }



  @Override
  public void onMoveFunction(MouseEvent e) {
      }

  private void makeSelection(int x, int y, int width, int height) {
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

    Processor.markEllipse = new PathShape(new Double(x,y,width-x,height-y), new AffineTransform());
    Processor.markEllipse.setFillColor(new Color(105, 119, 172, 255));
  }

  private void drawEllipse(int x, int y, int width, int height) {
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
    Processor.createShape(new Ellipse2D.Double(x,y,width-x,height-y),affineTransform);
    DrawView.setItemListModel();
    Processor.addToUndoList();
  }
}
