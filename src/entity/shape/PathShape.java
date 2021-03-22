package entity.shape;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import processor.Processor;


//@JsonIgnoreProperties(value = { "bounds2D" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class PathShape extends Path2D.Double implements Cloneable, Serializable {

  AffineTransform affineTransform;
  @JsonTypeInfo(use = Id.CLASS,
      include = As.PROPERTY, property = "clazz")
  @JsonSubTypes({
      @Type(value = Rectangle2D.Double.class, name = "rectangle"),
      @Type(value = Ellipse2D.Double.class, name = "ellipse"),
      @Type(value = Line2D.Double.class, name = "line")
  })
  private Shape shape;
  private Long id;
  private boolean selected;
  private Color fillColor;
  private float strokeWidth;
  private Color strokeColor;
//TODO add rotation and scale field

  public PathShape()
  {
    super();
  }

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

  public PathShape(Shape s, AffineTransform at, Color color, Color strokeColor, float strokeSize) {
    super(s, at);
    this.shape = s;
    this.affineTransform = at;
    this.fillColor = color;
    this.strokeWidth = strokeSize;
    this.strokeColor = strokeColor;
    this.id=Processor.id++;
  }

  public PathShape(Shape s) {
    super(s);
  }

  public void setParameters(AffineTransform affineTransform,
      Color fillColor,
      Color strokeColor,
      boolean selected,
      float strokeWidth,
      Long id) {
    this.selected = selected;
    this.affineTransform = affineTransform;
    this.fillColor = fillColor;
    this.strokeWidth = strokeWidth;
    this.strokeColor = strokeColor;
    this.id = id;

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Shape getShape() {
    return shape;
  }

  public void setShape(Shape shape) {
    this.shape = shape;
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
    PathShape pathShape = new PathShape(this);
    pathShape.setAffineTransform(this.getAffineTransform());
    pathShape.setShape(this.getShape());
    pathShape.setFillColor(this.getFillColor());
    pathShape.setStrokeColor(this.getStrokeColor());
    pathShape.setStrokeWidth(this.getStrokeWidth());
    pathShape.setId(this.getId());
    return pathShape;
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
    if (strokeWidth > 0.00) {
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
