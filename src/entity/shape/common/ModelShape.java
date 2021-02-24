package entity.shape.common;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;

public interface ModelShape extends Shape {

  void DrawSelf(Graphics g);
  Color getFillColor();
  void setFillColor(Color fillColor);
  Point getLocation();
  void  setLocation(Point point);
  boolean isSelected();
  void  setSelected(boolean selected);
}
