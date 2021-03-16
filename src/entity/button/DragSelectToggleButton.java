package entity.button;

import entity.button.common.CustomToggleButton;
import entity.shape.PathShape;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JToggleButton;
import processor.Processor;
import processor.RotateProcessor;

public class DragSelectToggleButton extends JToggleButton implements CustomToggleButton {

  private Point startPoint;
  private final Color SELECT_BOX_COLOR = new Color(105, 119, 172, 25);

  @Override
  public void onClickFunction(MouseEvent e) {
  }

  @Override
  public void onPressFunction(MouseEvent e) {
    Processor.deselectAll();
    Processor.markRect = null;
    startPoint = e.getPoint();


  }

  @Override
  public void onReleaseFunction(MouseEvent e) {
    SelectToggleButton.selectedShapeList = findIntersect();
    if (SelectToggleButton.selectedShapeList != null &&
        !SelectToggleButton.selectedShapeList.isEmpty()) {
      SelectToggleButton.selectedShapeList.forEach(modelShape -> modelShape.setSelected(true));
    }
    RotateProcessor.addSelectedShapes();
    Processor.markRect = null;
    RotateProcessor.findCenterOfSelection();
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
    Processor.makeSelection(startPoint.x, startPoint.y,
        e.getX(), e.getY(),
        SELECT_BOX_COLOR);
  }

  @Override
  public void onMoveFunction(MouseEvent e) {

  }

  public List<PathShape> findIntersect() {
    return Processor.shapeList.stream()
        .filter(shape -> shape.intersects(Processor.markRect.getBounds2D()))
        .collect(Collectors.toList());
  }
}
