package processor;

import entity.shape.PathShape;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class RotateProcessor extends Processor {

  public static ArrayList<PathShape> rotatedShapes = new ArrayList<>();
  private static double centerX;
  private static double centerY;

  public static void addSelectedShapes(){
    rotatedShapes = new ArrayList<>();
    for (PathShape shape :
        Processor.shapeList) {
      if (shape.isSelected()) {
        rotatedShapes.add(shape);
      }
    }
  }

  public static void findCenterOfSelection(){
    centerX = findCenterX();
    centerY = findCenterY();
  }

  private static double findCenterX() {
    double x = Integer.MAX_VALUE;
    double width = 0;
    for (PathShape shape : shapeList) {
      if (shape.isSelected()) {
        if (shape.getBounds2D().getX() < x) {
          x = shape.getBounds2D().getX();
        }
        if ((shape.getBounds2D().getX() + shape.getBounds2D().getWidth()) > width) {
          width = shape.getBounds2D().getX() + shape.getBounds2D().getWidth();
        }
      }
    }
    System.out.println(x + ((width - x) / 2));
    return x + ((width - x) / 2);
  }

  private static double findCenterY() {
    double y = Integer.MAX_VALUE;
    double height = 0;
    for (PathShape shape : shapeList) {
      if (shape.isSelected()) {
        if (shape.getBounds2D().getY() < y) {
          y = shape.getBounds2D().getY();
        }
        if ((shape.getBounds2D().getY() + shape.getBounds2D().getHeight()) > height) {
          height = shape.getBounds2D().getY() + shape.getBounds2D().getHeight();
        }
      }
    }
    System.out.println(y + ((height-y) / 2));
    return y + ((height - y) / 2);
  }

  public void rotateShape(double rotateValue) {
    for (int i = 0; i < shapeList.size(); i++) {
      if (shapeList.get(i).isSelected()) {
        AffineTransform tx = new AffineTransform();
        tx.rotate(Math.toRadians(rotateValue),
            centerX,
            centerY);
        PathShape pathShape = rotatedShapes.get(i);
        PathShape rotated = pathShape.createTransformedShapeCustom(tx);
        rotated.setParameters(new AffineTransform(),
            pathShape.getFillColor(),
            pathShape.getStrokeColor(),
            pathShape.isSelected(),
            pathShape.getStrokeWidth(),
            pathShape.getId());
        shapeList.set(i, rotated);
      }
    }
  }

}
