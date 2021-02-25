package entity.shape;

import entity.shape.common.ModelShape;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class EllipseShape extends Ellipse2D.Double implements ModelShape,Cloneable {

  private Color fillColor;
  private boolean selected;

  public EllipseShape(){

  }
  public EllipseShape(int x, int y, int width, int height) {
    super(x, y, width, height);
  }


  @Override
  public Color getFillColor() {
    return fillColor;
  }

  @Override
  public void setFillColor(Color fillColor) {
    this.fillColor = fillColor;
  }

  @Override
  public Point getLocation() {
    return new Point((int)x,(int)y);
  }

  @Override
  public void setLocation(Point point) {
    this.x = point.getX();
    this.y = point.getY();
  }

  @Override
  public boolean isSelected() {
    return selected;
  }

  @Override
  public void setSelected(boolean selected) {
    this.selected = selected;
  }

  public Object clone() {
    return super.clone();
  }

  @Override
  public void DrawSelf(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(getFillColor());
    g2.fill(new Ellipse2D.Double(x,y,width,height));
    if (isSelected()){
      float dash1[] = { 10.0f };
      BasicStroke dashed = new BasicStroke(1.2f,
          BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
      Graphics2D graphics2D = (Graphics2D) g;
      graphics2D.setStroke(dashed);
      g2.setColor(Color.BLACK);
      g2.draw(new Ellipse2D.Double(x,y,width,height));
    }
  }
}
