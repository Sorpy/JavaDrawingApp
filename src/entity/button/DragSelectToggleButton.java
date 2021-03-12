package entity.button;

import entity.button.common.CustomToggleButton;
import entity.shape.PathShape;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JToggleButton;
import processor.Processor;

public class DragSelectToggleButton extends JToggleButton implements CustomToggleButton {

  public static boolean selected = false;
  private Point startPoint;
  private Point lastLocation;
  public static List<PathShape> selectedShapeList = new ArrayList<>();

  public Point getLastLocation() {
    return lastLocation;
  }

  public void setLastLocation(Point lastLocation) {
    this.lastLocation = lastLocation;
  }

  @Override
  public void onClickFunction(MouseEvent e) {
  }

  @Override
  public void onPressFunction(MouseEvent e) {
    if (!selectedShapeList.isEmpty() && containsPoint(e.getPoint())) {
      setLastLocation(e.getPoint());
    } else {
      selectedShapeList.forEach(shape -> shape.setSelected(false));
      selectedShapeList = new ArrayList<>();
      setLastLocation(null);
    }
    if (!selected) {
      Processor.deselectAll();
      startPoint = e.getPoint();
    } else {
      setLastLocation(e.getPoint());
    }
    Processor.markRect = null;
  }

  @Override
  public void onReleaseFunction(MouseEvent e) {
    if (!selected) {
      selectedShapeList = findIntersect();
    } else {
      Processor.addToUndoList();
    }
    selected = selectedShapeList != null && !selectedShapeList.isEmpty();
    if (selected) {
      selectedShapeList.forEach(modelShape -> modelShape.setSelected(true));
    }

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

    if (selected) {
      translateTo(e.getPoint());
      setLastLocation(e.getPoint());
    }
    if (!selected) {
      Processor.makeSelection(startPoint.x, startPoint.y,
          e.getX(), e.getY(),
          new Color(105, 119, 172, 25)
      );
    }
  }

  @Override
  public void onMoveFunction(MouseEvent e) {

  }

  public List<PathShape> findIntersect() {
    return Processor.shapeList.stream()
        .filter(shape -> shape.intersects(Processor.markRect.getBounds2D()))
        .collect(Collectors.toList());
  }

  public boolean containsPoint(Point point) {
    for (PathShape shape : selectedShapeList) {
      if (shape.contains(point)) {
        return true;
      }
    }
    return false;
  }

  public void translateTo(Point p) {
    if (selectedShapeList != null && !selectedShapeList.isEmpty()) {
      for (PathShape shape : selectedShapeList) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(p.x - lastLocation.x,
            p.y - lastLocation.y);
        shape.transform(affineTransform);
        shape.getAffineTransform().translate(p.x - lastLocation.x,
            p.y - lastLocation.y);
      }
      lastLocation = p;
    }
  }
}
