package com.cedarsoft.course.profiling.sample4;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class SwingSample {
  public static void main(String[] args) throws InterruptedException {
    ConnectionManager connectionManager = new ConnectionManager();

    JFrame frame = new JFrame();

    JTabbedPane tabbedPane = new JTabbedPane();

    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new BorderLayout());

    ControlPanel connectionControlPanel = new ControlPanel();

    contentPane.add(connectionControlPanel, BorderLayout.NORTH);
    contentPane.add(tabbedPane, BorderLayout.CENTER);
    contentPane.add(new JButton(new AbstractAction("New Connection") {
      private int index;

      @Override
      public void actionPerformed(ActionEvent e) {
        index++;
        connectionManager.createConnection("No " + index);
      }
    }), BorderLayout.SOUTH);


    connectionManager.addListener(new ConnectionManager.Listener() {
      @Override
      public void connectionCreated(@Nonnull ConnectionManager source, @Nonnull Connection connection) {
        tabbedPane.addTab(connection.getName(), new ConnectionPanel(connection, connectionManager::close));
      }

      @Override
      public void connectionClosed(@Nonnull ConnectionManager source, @Nonnull Connection connection) {
        //Find the tab
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
          if (tabbedPane.getTitleAt(i) == connection.getName()) {
            tabbedPane.removeTabAt(i);
            return;
          }
        }
      }
    });


    //Set the active connection
    tabbedPane.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        int selectedIndex = tabbedPane.getSelectedIndex();
        @Nullable Component selectedComponent = tabbedPane.getSelectedComponent();
        if (selectedComponent == null) {
          return;
        }

        Connection connection = ((ConnectionPanel) selectedComponent).getConnection();
        connectionControlPanel.setActiveConnection(connection);
      }
    });

    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);


    Thread.sleep(100000000000000L);

  }
}
