package entity.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class PathShape extends Path2D.Double implements Cloneable {

  AffineTransform affineTransform;
  private Shape shape;
  private boolean selected;
  private Color fillColor;
  private float strokeWidth;
  private Color strokeColor;


  public PathShape(Shape s, AffineTransform at) {
    super(s, at);
    this.shape = s;
    this.affineTransform = at;
  }

  public PathShape(Shape s, AffineTransform at, Color color) {
    super(s, at);
    this.shape = s;
    this.affineTransform = at;
    this.fillColor = color;
  }

  public PathShape(Shape s, AffineTransform at, Color color, Color strokeColor,float strokeSize) {
    super(s, at);
    this.shape = s;
    this.affineTransform = at;
    this.fillColor = color;
    this.strokeWidth = strokeSize;
    this.strokeColor = strokeColor;
  }

  public PathShape(Shape s) {
    super(s);
  }

  public float getStrokeWidth() {
    return strokeWidth;
  }

  public void setStrokeWidth(float strokeWidth) {
    this.strokeWidth = strokeWidth;
  }

  public Color getStrokeColor() {
    return strokeColor;
  }

  public void setStrokeColor(Color strokeColor) {
    this.strokeColor = strokeColor;
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
    g2.setColor(getFillColor());
    g2.fill(this);
    if (strokeWidth>0.00) {
      g2.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
      g2.setColor(getStrokeColor());
      g2.draw(this);
    }
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
