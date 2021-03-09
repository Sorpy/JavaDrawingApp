package processor;

import GUI.DrawView;
import entity.shape.PathShape;
import java.awt.geom.AffineTransform;

public class RotateProcessor extends Processor {

  public static PathShape currentlyRotatedShape;

  public void rotateShape(double rotateValue) {

    for (int i = 0; i < shapeList.size(); i++) {
      if (shapeList.get(i).isSelected() && currentlyRotatedShape!=null) {
        AffineTransform tx = new AffineTransform();
        tx.rotate(Math.toRadians(rotateValue),
            (currentlyRotatedShape.getBounds2D().getX()
                + (currentlyRotatedShape.getBounds2D().getWidth()) / 2),
            (currentlyRotatedShape.getBounds2D().getY()
                + (currentlyRotatedShape.getBounds2D().getHeight()) / 2));
        PathShape pathShape = currentlyRotatedShape;
        PathShape rotated = pathShape.createTransformedShapeCustom(tx);
        rotated.setAffineTransform(new AffineTransform());
        shapeList.set(i, rotated);
        shapeList.get(i).setSelected(true);
        shapeList.get(i).setFillColor(DrawView.currentFillColor);
        break;
      }
    }
  }

}
