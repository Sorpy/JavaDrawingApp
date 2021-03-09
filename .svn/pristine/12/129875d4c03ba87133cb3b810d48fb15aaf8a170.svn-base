package entity.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class PathShape extends Path2D.Double implements Cloneable {

  //  ModelShape shape;
  private Shape shape;
  AffineTransform affineTransform;
  private boolean selected;
  private Color fillColor;

  public double getRotation() {
    return rotation;
  }

  public void setRotation(double rotation) {
    this.rotation = rotation;
  }

  public Point getTranslate() {
    return translate;
  }

  public void setTranslate(Point translate) {
    this.translate = translate;
  }

  private double rotation;
  private Point translate;

  public PathShape(Shape s, AffineTransform at) {
    super(s, at);
    this.shape = s;
    this.affineTransform = at;
  }

  public PathShape(Shape s, AffineTransform at,Color color) {
    super(s, at);
    this.shape = s;
    this.affineTransform = at;
    this.fillColor = color;
  }

  public PathShape(Shape s) {
    super(s);
  }

  public PathShape clonePath() {
    return new PathShape(this);
  }

  public Color getFillColor() {
    return fillColor;
  }

  public void setFillColor(Color fillColor) {
    this.fillColor = fillColor;
  }

  public Point getLocation() {
    //return new Point(shape.getLocation());
    return null;
  }

  public void setLocation(Point point) {
//    shape.setLocation(point);
  }

  public boolean isSelected() {
    return selected;
  }

  public void setSelected(boolean selected) {
    this.selected = selected;
  }

  public AffineTransform getAffineTransform() {
    return affineTransform;
  }

  public void setAffineTransform(AffineTransform affineTransform) {
    this.affineTransform = affineTransform;
  }

  public final synchronized PathShape createTransformedShapeCustom(AffineTransform at) {
    PathShape p2d = clonePath();
    if (at != null) {
      p2d.transform(at);
    }
    return p2d;
  }

  public void DrawSelf(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
//    AffineTransform saveTransform = g2.getTransform();
//    AffineTransform identity = affineTransform;
//    g2.setTransform(identity);
    //PathShape path = new PathShape(shape);
    //path.clonePath();
    g2.setColor(getFillColor());
    g2.fill(this);
    if (isSelected()) {

      float[] dash1 = {10.0f};
      BasicStroke dashed = new BasicStroke(1.2f,
          BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
      Graphics2D graphics2D = (Graphics2D) g;
      graphics2D.setStroke(dashed);
      graphics2D.setColor(Color.BLACK);
      graphics2D.draw(this);
    }
    //g2.setTransform(saveTransform);
  }
}
