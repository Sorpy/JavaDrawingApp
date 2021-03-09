package entity.button;

import entity.button.common.CustomToggleButton;
import entity.button.common.CustomToggleButtonImpl;
import entity.shape.PathShape;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import processor.Processor;
import processor.RotateProcessor;

public class SelectToggleButton extends CustomToggleButtonImpl implements CustomToggleButton {

  private PathShape selectedItem;
  private Point lastLocation;

  public PathShape getSelectedItem() {
    return selectedItem;
  }

  public void setSelectedItem(PathShape selectedItem) {
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
    if (getSelectedItem() != null) {
      //selectedItem.setAffineTransform(new AffineTransform());
      getSelectedItem().setSelected(false);
      setSelectedItem(null);
      RotateProcessor.currentlyRotatedShape = null;
    }
    setSelectedItem(containsPoint(e.getPoint()));
    if (getSelectedItem() != null) {
      setLastLocation(e.getPoint());
      RotateProcessor.currentlyRotatedShape =selectedItem;
      //Processor.currentlySelectedShape = getSelectedItem();
    }
  }


  @Override
  public void onReleaseFunction(MouseEvent e) {
    super.onReleaseFunction(e);
    setLastLocation(null);
    Processor.addToUndoList();
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

    if (getSelectedItem() != null) {
      translateTo(e.getPoint());
      setLastLocation(e.getPoint());
      RotateProcessor.currentlyRotatedShape =selectedItem;
    }
  }

  @Override
  public void onMoveFunction(MouseEvent e) {
    super.onMoveFunction(e);
  }

  public PathShape containsPoint(Point point) {
    PathShape currentLastShape = null;
    for (int i = Processor.shapeList.size(); i-- > 0; ) {
      if (Processor.shapeList.get(i).contains(point)) {
        currentLastShape = (PathShape) Processor.shapeList.get(i);
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
