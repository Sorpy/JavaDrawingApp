package entity.shape;

import entity.shape.common.ModelShape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class CustomShape extends Path2D.Double implements ModelShape {

  ModelShape shape;
  AffineTransform affineTransform;

  public CustomShape(ModelShape s, AffineTransform at) {
    super(s, at);
    this.shape = s;
    this.affineTransform = at;

  }

  @Override
  public Color getFillColor() {
    return null;
  }

  @Override
  public void setFillColor(Color fillColor) {

  }

  @Override
  public Point getLocation() {
    return null;
  }

  @Override
  public void setLocation(Point point) {

  }

  @Override
  public boolean isSelected() {
    return false;
  }

  @Override
  public void setSelected(boolean selected) {

  }

  @Override
  public void DrawSelf(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    Path2D.Double path = new Path2D.Double(shape,affineTransform);
    g2.setColor(Color.RED);
    g2.fill(path);
    //g2.draw(path);

  }
}
