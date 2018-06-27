package com.cedarsoft.course.profiling.sample3;

import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class Connection {
  @Nonnull
  private final String name;
  @Nonnull
  private final VeryLargeObject data = new VeryLargeObject();

  public Connection(@Nonnull String name) {
    this.name = name;
  }

  @Nonnull
  public String getName() {
    return name;
  }
}
