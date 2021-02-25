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
    if (!selectedShapeList.isEmpty() && containsPoint(e.getPoint())) {
      setLastLocation(e.getPoint());
    }else {
      selectedShapeList.forEach(shape -> shape.setSelected(false));
      selectedShapeList = new ArrayList<>();
      setLastLocation(null);
    }
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
    if (!selected){
      selectedShapeList = findIntersect();
    }else {
      Processor.addToUndoList();
    }
    selected = selectedShapeList != null && !selectedShapeList.isEmpty();
    if (selected){
      selectedShapeList.forEach(modelShape -> modelShape.setSelected(true));
    }

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
    if(selected){
      translateTo(e.getPoint());
      setLastLocation(e.getPoint());
    }
    if (!selected) {
      makeSelection(startPoint.x, startPoint.y, e.getX(), e.getY());
    }
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
    return Processor.shapeList.stream()
        .filter(shape -> shape.intersects(Processor.markRect))
        .collect(Collectors.toList());
  }

  public boolean containsPoint(Point point) {
    for (ModelShape shape : selectedShapeList) {
      if (shape.contains(point)){
        return true;
      }
    }
    return false;
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
