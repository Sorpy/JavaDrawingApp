package entity.shape;

import java.awt.Shape;
import java.io.Serializable;

public interface ShapeImpl extends Shape, Serializable {

  double getX();
  double getY();
  double getWidth();
  double getHeight();
}
