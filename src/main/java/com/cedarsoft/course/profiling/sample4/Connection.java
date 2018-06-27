package com.cedarsoft.course.profiling.sample4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.Nonnull;

import com.cedarsoft.course.profiling.sample3.VeryLargeObject;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Connection {
  @Nonnull
  private final String name;

  @Nonnull
  private final VeryLargeObject data = new VeryLargeObject();
  @Nonnull
  private final List<Listener> listeners = new CopyOnWriteArrayList<>();

  public Connection(@Nonnull String name) {
    this.name = name;
  }

  @Nonnull
  public String getName() {
    return name;
  }

  public void addListener(@Nonnull Listener listener) {
    this.listeners.add(listener);
  }

  public void removeListener(@Nonnull Listener listener) {
    this.listeners.remove(listener);
  }

  @Override
  public String toString() {
    return "Connection{" +
             "name='" + name + '\'' +
             '}';
  }

  @Nonnull
  public interface Listener {
    void somethingChanged();
  }
}
