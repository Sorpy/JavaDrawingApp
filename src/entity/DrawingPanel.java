package entity;

import GUI.DrawView;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

  private final DrawView parent;

  public DrawingPanel(DrawView view) {
    super();
    parent = view;
  }

  @Override
  public Dimension getPreferredSize() {
    Dimension layoutSize = super.getPreferredSize();
    int max = Math.max(layoutSize.width, layoutSize.height);
    return new Dimension(max + 100, max + 100);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    parent.processor.reDraw(g);
  }
}
