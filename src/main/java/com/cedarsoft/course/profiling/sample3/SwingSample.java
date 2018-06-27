package com.cedarsoft.course.profiling.sample3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.annotation.Nonnull;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

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
    contentPane.add(tabbedPane, BorderLayout.CENTER);
    contentPane.add(new JButton(new AbstractAction("New Connection") {
      private int index = 0;

      @Override
      public void actionPerformed(ActionEvent e) {
        index++;
        connectionManager.createConnection("No " + index);
      }
    }), BorderLayout.SOUTH);


    connectionManager.addListener(new ConnectionManager.Listener() {
      @Override
      public void connectionCreated(@Nonnull ConnectionManager source, @Nonnull Connection connection) {
        tabbedPane.addTab(connection.getName(), new ConnectionPanel(connection));
      }

      @Override
      public void connectionClosed(@Nonnull ConnectionManager source, @Nonnull Connection connection) {
      }
    });


    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);


    Thread.sleep(100000000000000L);

  }
}
