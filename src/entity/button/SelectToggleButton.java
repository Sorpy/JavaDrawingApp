package entity.button;

import GUI.DrawView;
import entity.button.common.CustomToggleButton;
import entity.shape.PathShape;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import javax.swing.JToggleButton;
import processor.Processor;
import processor.RotateProcessor;

public class SelectToggleButton extends JToggleButton implements CustomToggleButton {

  private static PathShape selectedItem;
  private Point lastLocation;

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
    if (getSelectedItem() != null) {
      getSelectedItem().setSelected(false);
      setSelectedItem(null);
      Processor.deselectAll();
      RotateProcessor.currentlyRotatedShape = null;
      DrawView.setRotateSliderValue(0);
    }
    setSelectedItem(containsPoint(e.getPoint()));
    if (getSelectedItem() != null) {
      setLastLocation(e.getPoint());
      RotateProcessor.currentlyRotatedShape = selectedItem;
      //Processor.currentlySelectedShape = getSelectedItem();
    }
  }


  @Override
  public void onReleaseFunction(MouseEvent e) {
    setLastLocation(null);
    if (selectedItem != null) {
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

    if (getSelectedItem() != null) {
      translateTo(e.getPoint());
      setLastLocation(e.getPoint());
      RotateProcessor.currentlyRotatedShape = selectedItem;
    }
  }

  @Override
  public void onMoveFunction(MouseEvent e) {
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
    if (selectedItem != null) {
      AffineTransform affineTransform = new AffineTransform();
      affineTransform.translate(p.x - lastLocation.x,
          p.y - lastLocation.y);
      selectedItem.transform(affineTransform);
      selectedItem.getAffineTransform().translate(p.x - lastLocation.x,
          p.y - lastLocation.y);
      lastLocation = p;
    }
  }
}
