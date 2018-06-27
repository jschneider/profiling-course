package com.cedarsoft.course.profiling.sample4;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class ControlPanel extends JPanel {
  private final JLabel label;
  @Nullable
  private Connection currentConnection;

  public ControlPanel() {
    label = new JLabel("Current connection");
    add(label);
  }

  public void setActiveConnection(@Nonnull Connection connection) {
    this.currentConnection = connection;
    update();
  }

  private void update() {
    label.setText(String.valueOf(currentConnection));
  }

}
