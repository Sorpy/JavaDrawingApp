package entity.button;

import GUI.DrawView;
import entity.button.common.CustomToggleButton;
import entity.shape.PathShape;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import javax.swing.JToggleButton;
import processor.Processor;

public class LineToggleButton extends JToggleButton implements CustomToggleButton {

  private Point startPoint;

  @Override
  public void onClickFunction(MouseEvent e) {

  }

  @Override
  public void onPressFunction(MouseEvent e) {
    Processor.deselectAll();
    startPoint = e.getPoint();
  }

  @Override
  public void onReleaseFunction(MouseEvent e) {
    drawLine(startPoint,e.getPoint());
    Processor.markLine = null;
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
    markLine(startPoint,e.getPoint());
  }

  @Override
  public void onMoveFunction(MouseEvent e) {

  }

  private void drawLine(Point startPoint, Point point) {
    AffineTransform affineTransform = new AffineTransform();
    Processor.createShape(new Double(startPoint,point),affineTransform);
    DrawView.setItemListModel();
    Processor.addToUndoList();
  }

  private void markLine(Point startPoint, Point point) {
    Processor.markLine = new PathShape(new Double(startPoint,point),new AffineTransform());
    Processor.markLine.setStrokeColor(Color.BLUE);
    Processor.markLine.setStrokeWidth(2f);
  }
}
