package entity.shape;

import entity.shape.common.ModelShape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Stroke;

public class RectangleShape extends Rectangle implements ModelShape {

  private Color fillColor;

  public Stroke getBorder() {
    return border;
  }

  public void setBorder(Stroke border) {
    this.border = border;
  }

  private Stroke border;

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
  public void DrawSelf(Graphics grfx) {
    Rectangle r = getBounds();
    grfx.setColor(getFillColor());
    grfx.fillRect(r.x, r.y, r.width, r.height);
//    grfx.setColor(Color.RED);
//    grfx.drawRect(r.x, r.y, r.width, r.height);
  }
}
