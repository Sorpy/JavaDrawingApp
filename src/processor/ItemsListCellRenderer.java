package processor;

import entity.shape.PathShape;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.border.Border;
import sun.swing.DefaultLookup;

public class ItemsListCellRenderer extends DefaultListCellRenderer {

  @Override
  public Component getListCellRendererComponent(JList<?> list, Object value, int index,
      boolean isSelected, boolean cellHasFocus) {

    this.setText(getName((PathShape) value));
    this.setIcon(createFillColorIcon((PathShape) value));
    setComponentOrientation(list.getComponentOrientation());

    Color bg = null;
    Color fg = null;

    JList.DropLocation dropLocation = list.getDropLocation();
    if (dropLocation != null
        && !dropLocation.isInsert()
        && dropLocation.getIndex() == index) {

      bg = DefaultLookup.getColor(this, ui, "List.dropCellBackground");
      fg = DefaultLookup.getColor(this, ui, "List.dropCellForeground");

      isSelected = true;
    }

    if (isSelected) {
      setBackground(bg == null ? list.getSelectionBackground() : bg);
      setForeground(fg == null ? list.getSelectionForeground() : fg);
    }
    else {
      setBackground(list.getBackground());
      setForeground(list.getForeground());
    }

    setEnabled(list.isEnabled());
    setFont(list.getFont());

    Border border = null;
    if (cellHasFocus) {
      if (isSelected) {
        border = DefaultLookup.getBorder(this, ui, "List.focusSelectedCellHighlightBorder");
      }
      if (border == null) {
        border = DefaultLookup.getBorder(this, ui, "List.focusCellHighlightBorder");
      }
    }
    setBorder(border);
    return this;
  }

  private String getName(PathShape value) {
    return value.getShape().getClass().getName()
        .replace("java.awt.geom.","")
        .replace("2D$Double"," ") + value.getId();
  }

  private ImageIcon createFillColorIcon(PathShape value) {
    BufferedImage rawImage = createEmptyImage(value);
    BufferedImage image = new BufferedImage(35, 35, java.awt.image.BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = image.createGraphics();
    graphics.drawImage(rawImage,0,0,25,25,null);
    image.flush();
    return new ImageIcon(image);
  }

  private BufferedImage createEmptyImage(PathShape value){
    int shapeWidth = (int) value.getShape().getBounds2D().getWidth();
    int shapeHeight = (int) value.getShape().getBounds2D().getHeight();
    BufferedImage image;
    if (shapeWidth > shapeHeight) {
      image = new BufferedImage(shapeWidth + shapeWidth/10,
          shapeWidth + shapeWidth/10,
          java.awt.image.BufferedImage.TYPE_INT_RGB);
    } else {
      image = new BufferedImage(shapeHeight + shapeHeight/10,
          shapeHeight + shapeHeight/10,
          java.awt.image.BufferedImage.TYPE_INT_RGB);
    }
    AffineTransform affineTransform = new AffineTransform();
    affineTransform.translate(0 - value.getShape().getBounds2D().getX(),
        0 - value.getShape().getBounds2D().getY());

    Graphics2D graphics = image.createGraphics();
    graphics.setBackground(Color.WHITE);
    graphics.setTransform(affineTransform);
    graphics.setColor(value.getFillColor());
    graphics.fill(value.getShape());
    graphics.setColor(value.getStrokeColor());
    graphics.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    graphics.draw(value.getShape());

    image.flush();
    return image;
  }
}
