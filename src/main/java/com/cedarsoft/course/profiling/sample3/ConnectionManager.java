package com.cedarsoft.course.profiling.sample3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class ConnectionManager {
  @Nonnull
  private final List<Connection> connections = new ArrayList<>();
  @Nonnull
  private final List<Listener> listeners = new CopyOnWriteArrayList<>();

  public Connection createConnection(@Nonnull String name) {
    Connection connection = new Connection(name);
    connections.add(connection);

    for (Listener listener: listeners) {
      listener.connectionCreated(this, connection);
    }

    return connection;
  }

  public void close(@Nonnull Connection connection) {
    connections.remove(connection);

    for (Listener listener: listeners) {
      listener.connectionClosed(this, connection);
    }
  }

  @Nonnull
  public List<Connection> getConnections() {
    return connections;
  }

  public void addListener(@Nonnull Listener listener) {
    this.listeners.add(listener);
  }

  public void removeListener(@Nonnull Listener listener) {
    this.listeners.remove(listener);
  }

  /**
   * Listener for the connection manager
   */
  public interface Listener {
    void connectionCreated(@Nonnull ConnectionManager source, @Nonnull Connection connection);

    void connectionClosed(@Nonnull ConnectionManager source, @Nonnull Connection connection);
  }
}
