package entity.shape;

import entity.shape.common.ModelShape;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;

public class RectangleShape extends Rectangle implements ModelShape,Cloneable {



  private Color fillColor;
  private boolean selected;

  public RectangleShape() {
  }

  public RectangleShape(int x, int y, int width, int height) {
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
    Rectangle r = getBounds();
    g.setColor(getFillColor());
    g.fillRect(r.x, r.y, r.width, r.height);
    if (isSelected()){

       float dash1[] = { 10.0f };
       BasicStroke dashed = new BasicStroke(1.2f,
          BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
      Graphics2D graphics2D = (Graphics2D) g;
      graphics2D.setStroke(dashed);
      graphics2D.setColor(Color.BLACK);
      graphics2D.drawRect(r.x, r.y, r.width, r.height);
    }
  }
}
