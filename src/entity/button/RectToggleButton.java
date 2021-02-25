package entity.button;

import GUI.DrawView;
import entity.button.common.CustomToggleButtonImpl;
import entity.shape.RectangleShape;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
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
    Processor.markRect.setBounds(0,0,0,0);
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

  public void makeSelection(int x, int y, int width, int height) {
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

    Processor.markRect.setBounds(x, y, width - x, height - y);
    Processor.markRect.setFillColor(new Color(105, 119, 172, 255));
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

    RectangleShape rect = new RectangleShape(x, y, width - x, height - y);
    rect.setFillColor(DrawView.currentColor);
    System.out.println(
        rect.getX() + "  " + rect.getY() + "  " + rect.getWidth() + "  " + rect.getHeight() + "  "
            + rect.getLocation());
    Processor.shapeList.add(rect);
    DrawView.setItemListModel();
    System.out.println("currently in redo before addin new one " + Processor.canvasUndoList);
    Processor.addToUndoList();
  }
}
