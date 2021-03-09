package entity.button.common;

import java.awt.event.MouseEvent;

public interface CustomToggleButton {
  void onClickFunction(MouseEvent e);
  void onPressFunction(MouseEvent e);
  void onReleaseFunction(MouseEvent e);
  void onEnterFunction(MouseEvent e);
  void onExitFunction(MouseEvent e);
  void onWheelMovedFunction(MouseEvent e);
  void onDragFunction(MouseEvent e);
  void onMoveFunction(MouseEvent e);
}
