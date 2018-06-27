package com.cedarsoft.course.profiling.sample2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class AnObservable {
  @Nonnull
  private final List<Listener> listeners = new CopyOnWriteArrayList<>();

  public void addListener(@Nonnull Listener listener) {
    this.listeners.add(listener);
  }

  public void removeListener(@Nonnull Listener listener) {
    this.listeners.add(listener);
  }
}
