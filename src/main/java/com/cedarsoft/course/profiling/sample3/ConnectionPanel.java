package com.cedarsoft.course.profiling.sample3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.annotation.Nonnull;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class ConnectionPanel extends JPanel {
  @Nonnull
  private final Connection connection;

  public ConnectionPanel(@Nonnull Connection connection) {
    this.connection = connection;

    setLayout(new BorderLayout());
    add(new JLabel("Connection " + connection.getName()), BorderLayout.NORTH);
    add(new JButton(new AbstractAction("Close connection " + connection.getName()) {
      @Override
      public void actionPerformed(ActionEvent e) {
        JTabbedPane parent = (JTabbedPane) getParent();

        //Find my tab
        for (int i = 0; i < parent.getTabCount(); i++) {
          if (parent.getComponentAt(i) == ConnectionPanel.this) {
            parent.removeTabAt(i);
            return;
          }
        }
      }
    }), BorderLayout.SOUTH);
  }

  @Nonnull
  public Connection getConnection() {
    return connection;
  }
}
