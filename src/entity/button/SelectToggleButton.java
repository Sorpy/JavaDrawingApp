package entity.button;

import GUI.DrawView;
import entity.button.common.CustomToggleButton;
import entity.shape.PathShape;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JToggleButton;
import processor.Processor;
import processor.RotateProcessor;

public class SelectToggleButton extends JToggleButton implements CustomToggleButton {

  private static PathShape selectedItem;
  private Point lastLocation;

  public static boolean selected = false;
  public static List<PathShape> selectedShapeList = new ArrayList<>();

  public static PathShape getSelectedItem() {
    return selectedItem;
  }

  public void setSelectedItem(PathShape selectedItem) {
    SelectToggleButton.selectedItem = selectedItem;
  }

  public void setLastLocation(Point lastLocation) {
    this.lastLocation = lastLocation;
  }

  @Override
  public void onClickFunction(MouseEvent e) {
  }

  @Override
  public void onPressFunction(MouseEvent e) {
    checkShapeSelection(e);

    if (!selectedShapeList.isEmpty()) {
      setLastLocation(e.getPoint());
      RotateProcessor.currentlyRotatedShape = selectedShapeList.get(0);
      //Processor.currentlySelectedShape = getSelectedItem();
    }
  }

  @Override
  public void onReleaseFunction(MouseEvent e) {
    if (!selectedShapeList.isEmpty()) {
      Processor.addToUndoList();
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

    if (!selectedShapeList.isEmpty()) {
      translateTo(e.getPoint());
      setLastLocation(e.getPoint());
      RotateProcessor.currentlyRotatedShape = selectedShapeList.get(0);
    }
  }

  @Override
  public void onMoveFunction(MouseEvent e) {
  }

  private void checkShapeSelection(MouseEvent e) {
    if (containsPointFromSelected(e.getPoint())){
      setLastLocation(e.getPoint());
    }
    else if(containsPoint(e.getPoint())!=null) {
      selectedShapeList.add(containsPoint(e.getPoint()));
    }
    else {
      Processor.deselectAll();
      selectedShapeList = new ArrayList<>();
      setLastLocation(null);
      RotateProcessor.currentlyRotatedShape = null;
      DrawView.setRotateSliderValue(0);
    }
  }

  public PathShape containsPoint(Point point) {
    PathShape currentLastShape = null;
    for (int i = Processor.shapeList.size(); i-- > 0; ) {
      if (Processor.shapeList.get(i).intersects(
          (int)point.getX()-3,
          (int)point.getY()-3,
          3,
          3)) {
        currentLastShape = Processor.shapeList.get(i);
        currentLastShape.setSelected(true);
        break;
      }
    }
    return currentLastShape;
  }

  private void translateTo(Point p) {

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

    //  public boolean containsPoint(Point point) {
//    for (PathShape shape : selectedShapeList) {
//      if (shape.contains(point)) {
//        return true;
//      }
//    }
//    return false;
//  }

//    if (selectedItem != null) {
//      AffineTransform affineTransform = new AffineTransform();
//      affineTransform.translate(p.x - lastLocation.x,
//          p.y - lastLocation.y);
//      selectedItem.transform(affineTransform);
//      selectedItem.getAffineTransform().translate(p.x - lastLocation.x,
//          p.y - lastLocation.y);
//      lastLocation = p;
//    }
  }

    public boolean containsPointFromSelected(Point point) {
    for (PathShape shape : selectedShapeList) {
      if (shape.contains(point)) {
        return true;
      }
    }
    return false;
  }
}
