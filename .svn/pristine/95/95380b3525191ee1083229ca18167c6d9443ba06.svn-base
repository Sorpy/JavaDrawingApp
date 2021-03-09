package entity.button;

import GUI.DrawView;
import entity.button.common.CustomToggleButtonImpl;
import entity.shape.PathShape;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D.Double;
import processor.Processor;

public class RectToggleButton extends CustomToggleButtonImpl {
  private Point startPoint;


  @Override
  public void onClickFunction(MouseEvent e) {
    super.onClickFunction(e);
  }

  @Override
  public void onPressFunction(MouseEvent e) {
    super.onPressFunction(e);
    Processor.deselectAll();
    startPoint = e.getPoint();
  }

  @Override
  public void onReleaseFunction(MouseEvent e) {
    super.onReleaseFunction(e);
    drawRectangle(startPoint.x,startPoint.y,e.getX(),e.getY());
    Processor.markRect = null;
  }

  @Override
  public void onEnterFunction(MouseEvent e) {
    super.onEnterFunction(e);
  }

  @Override
  public void onExitFunction(MouseEvent e) {
    super.onExitFunction(e);
  }

  @Override
  public void onWheelMovedFunction(MouseEvent e) {
    super.onWheelMovedFunction(e);
  }

  @Override
  public void onDragFunction(MouseEvent e) {
    super.onDragFunction(e);
    Processor.makeSelection(
        startPoint.x,startPoint.y,
        e.getX(),e.getY(),
        new Color(105, 119, 172, 150)
    );
  }

  @Override
  public void onMoveFunction(MouseEvent e) {
    super.onMoveFunction(e);
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
    Processor.createShape(new Rectangle(x, y, width - x, height - y),affineTransform);
    DrawView.setItemListModel();
    Processor.addToUndoList();
  }
}
