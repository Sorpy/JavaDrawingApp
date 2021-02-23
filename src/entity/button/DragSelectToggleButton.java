package entity.button;

import entity.button.common.CustomToggleButton;
import entity.button.common.CustomToggleButtonImpl;
import entity.shape.common.ModelShape;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import processor.Processor;

public class DragSelectToggleButton extends CustomToggleButtonImpl implements CustomToggleButton {

  private boolean selected =false;
  private Point startPoint;
  private Point lastLocation;
  private Point topLeftPoint;
  private Point bottomRightPoint;
  private List<ModelShape> selectedShapeList = new ArrayList<>();

  public Point getLastLocation() {
    return lastLocation;
  }

  public void setLastLocation(Point lastLocation) {
    this.lastLocation = lastLocation;
  }

  @Override
  public void onClickFunction(MouseEvent e) {
    super.onClickFunction(e);
  }

  @Override
  public void onPressFunction(MouseEvent e) {
    super.onPressFunction(e);
    if (!selected) {
      startPoint = e.getPoint();
    }else {
      setLastLocation(e.getPoint());
    }
    Processor.markRect.setBounds(0,0,0,0);
  }

  @Override
  public void onReleaseFunction(MouseEvent e) {
    super.onReleaseFunction(e);

    if (selected){
      selectedShapeList = new ArrayList<>();
      setLastLocation(null);
    }
    selectedShapeList = findIntersect();
    //setLastLocation(e.getPoint());// get the center or edge of selected elements
    selected = selectedShapeList != null && !selectedShapeList.isEmpty();

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
    if (!selected) {
      makeSelection(startPoint.x, startPoint.y, e.getX(), e.getY());
    }
    translateTo(e.getPoint());
    setLastLocation(e.getPoint());
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
    Processor.markRect.setFillColor(new Color(105, 119, 172, 25));
  }

  public List<ModelShape> findIntersect() {
    List<ModelShape> shapeList = Processor.shapeList.stream()
        .filter(shape -> shape.intersects(Processor.markRect))
        .collect(Collectors.toList());
    return shapeList;
  }

  private void findEdges(List<ModelShape> returnShape) {
    if (returnShape != null && !returnShape.isEmpty()){
      topLeftPoint = new Point((int) returnShape.get(0).getBounds().getX(),
                               (int) returnShape.get(0).getBounds().getY());

      bottomRightPoint = new Point(
          ((int) returnShape.get(0).getBounds().getHeight() + (int)topLeftPoint.getX()),
          ((int) returnShape.get(0).getBounds().getHeight()) + (int)topLeftPoint.getY());

      for (ModelShape shape : returnShape) {
        if (shape.getBounds().getX() < topLeftPoint.getX()) {
          topLeftPoint.x = (int) shape.getBounds().getX();
        }
        if (shape.getBounds().getY() < topLeftPoint.getY()) {
          topLeftPoint.y = (int) shape.getBounds().getY();
        }
        if (shape.getBounds().getWidth() < topLeftPoint.getX()) {
          bottomRightPoint.x = (int) shape.getBounds().getWidth();
        }
        if (shape.getBounds().getX() < topLeftPoint.getX()) {
          bottomRightPoint.y = (int) shape.getBounds().getHeight();
        }
      }
    }
  }

  public void translateTo(Point p) {
    if (selectedShapeList != null && !selectedShapeList.isEmpty()) {
      selectedShapeList.forEach(modelShape -> modelShape.setLocation(new Point(
          modelShape.getLocation().x +p.x - lastLocation.x,
          modelShape.getLocation().y + p.y - lastLocation.y))
      );
      lastLocation = p;
    }
  }
}
