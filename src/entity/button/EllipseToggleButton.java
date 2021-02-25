package entity.button;

import GUI.DrawView;
import entity.button.common.CustomToggleButtonImpl;
import entity.shape.EllipseShape;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import processor.Processor;

public class EllipseToggleButton extends CustomToggleButtonImpl{

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
    drawEllipse(startPoint.x,startPoint.y,e.getX(),e.getY());
    Processor.markEllipse = new EllipseShape();
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
    makeSelection(startPoint.x,startPoint.y,e.getX(),e.getY());
  }



  @Override
  public void onMoveFunction(MouseEvent e) {
    super.onMoveFunction(e);
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

    Processor.markEllipse.setFrame(x,y,width-x,height-y);
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

    EllipseShape ellipse = new EllipseShape(x,y,width-x,height-y);
    ellipse.setFillColor(DrawView.currentColor);
    Processor.shapeList.add(ellipse);
    DrawView.setItemListModel();
    Processor.addToUndoList();
  }
}
