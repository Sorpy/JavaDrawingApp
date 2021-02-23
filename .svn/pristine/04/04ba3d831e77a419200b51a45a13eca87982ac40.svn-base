package entity.button;

import entity.button.common.CustomToggleButton;
import entity.button.common.CustomToggleButtonImpl;
import entity.shape.common.ModelShape;
import java.awt.Point;
import java.awt.event.MouseEvent;
import processor.Processor;

public class SelectToggleButton extends CustomToggleButtonImpl implements CustomToggleButton {

  private ModelShape selectedItem;
  private Point lastLocation;

  public ModelShape getSelectedItem() {
    return selectedItem;
  }

  public void setSelectedItem(ModelShape selectedItem) {
    this.selectedItem = selectedItem;
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
    setSelectedItem(containsPoint(e.getPoint()));
    if (getSelectedItem() != null) {
      setLastLocation(e.getPoint());
    }
  }

  @Override
  public void onReleaseFunction(MouseEvent e) {
    super.onReleaseFunction(e);
    selectedItem = null;
    setLastLocation(null);

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
    if (selectedItem != null) {
      translateTo(e.getPoint());
      setLastLocation(e.getPoint());
    }
  }

  @Override
  public void onMoveFunction(MouseEvent e) {
    super.onMoveFunction(e);
  }

  public ModelShape containsPoint(Point point) {
    ModelShape currentLastShape = null;
    for (ModelShape shape : Processor.shapeList) {
      if (shape.contains(point)) {
        currentLastShape = shape;
      }
    }
    return currentLastShape;
  }

  private void translateTo(Point p) {
    if (selectedItem != null) {
      selectedItem.setLocation(new Point(selectedItem.getLocation().x + p.x - lastLocation.x,
          selectedItem.getLocation().y + p.y - lastLocation.y));
      lastLocation = p;
    }
  }
}
