package entity.button;

import GUI.DrawView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.button.SelectToggleButton.ShapeAnnotationSerializer;
import entity.button.common.CustomToggleButton;
import entity.shape.PathShape;
import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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
    DrawView.setRotateSliderValue(0);
    Processor.deselectAll();
    Processor.markRect = null;
    startPoint = e.getPoint();
    ObjectMapper mapper = new ObjectMapper();
    Processor.shapeList.forEach(System.out::println);
    PathShape[] tempList = null;
    try {
     // mapper.addMixIn(Shape.class, SelectToggleButton.ShapeAnnotationSerializer.class);
      //mapper.addMixIn(PathShape.class, PathShapeMixin.class);
      mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
      tempList =
          mapper.readValue(Paths.get("C:\\Users\\Lyubomir Proychev\\Desktop\\object.json").toFile(),PathShape[].class);
      List<PathShape> list = Arrays.asList(tempList);
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }

    System.out.println(tempList.length);
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

//  @JsonTypeInfo(use = Id.CLASS,
//      include = As.PROPERTY, property = "@class") @JsonSubTypes({
//
//      @JsonSubTypes.Type(value = Rectangle2D.Double.class, name = "rectangle"),
//      @JsonSubTypes.Type(value = Ellipse2D.Double.class, name = "ellipse"),
//      @JsonSubTypes.Type(value = Line2D.Double.class, name = "line")
//  })
//  public static interface ShapeAnnotationSerializer {
//  }

  public static class PathShapeMixin {
    @JsonIgnore
    String clazz;
  }
}
