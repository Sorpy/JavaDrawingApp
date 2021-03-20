package entity.button;

import GUI.DrawView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import entity.button.common.CustomToggleButton;
import entity.shape.PathShape;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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
    //RotateProcessor.findCenterOfSelection();

    if (!selectedShapeList.isEmpty()) {
      setLastLocation(e.getPoint());
      //RotateProcessor.addSelectedShapes();
      //Processor.currentlySelectedShape = getSelectedItem();
      Processor.shapeList.get(0);
    }
    ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    try {
      objectMapper.addMixIn(Rectangle2D.class, Rectangle2DJsonIgnore.class);
//      objectMapper.addMixIn(Color.class, ColorJsonIgnore.class);
//      objectMapper.addMixIn(AffineTransform.class, TransformerJsonIgnore.class);
      objectMapper.writeValue(Paths.get("C:\\Users\\Lyubomir Proychev\\Desktop\\object.json").toFile(),Processor.shapeList);

    } catch(Exception exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public void onReleaseFunction(MouseEvent e) {
    if (!selectedShapeList.isEmpty()) {
      Processor.addToUndoList();
    }
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

    if (!selectedShapeList.isEmpty()) {
      translateTo(e.getPoint());
      setLastLocation(e.getPoint());
      RotateProcessor.addSelectedShapes();
    }
  }

  @Override
  public void onMoveFunction(MouseEvent e) {
  }

  private void checkShapeSelection(MouseEvent e) {
//    if (containsPointFromSelected(e.getPoint())){
//      setLastLocation(e.getPoint());
//    }
    if(containsPoint(e.getPoint())!=null) {
      Processor.deselectAll();
      selectedShapeList = new ArrayList<>();
      setLastLocation(null);
      DrawView.setRotateSliderValue(0);
      selectedShapeList.add(containsPoint(e.getPoint()));
    }
    else {
      Processor.deselectAll();
      selectedShapeList = new ArrayList<>();
      setLastLocation(null);
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

  public static interface Rectangle2DJsonIgnore {
    @JsonIgnore
    String getBounds2D();
  }

  public static interface TransformerJsonIgnore {
    @JsonIgnore
    boolean isIdentity();
    @JsonIgnore
    double getDeterminant();
  }

  public static interface ColorJsonIgnore {
    @JsonIgnore
    int getTransparency();
    @JsonIgnore
    Color getRGB();
    @JsonIgnore
    ColorSpace getColorSpace();
  }

}
