package com.cedarsoft.course.profiling.sample1;

import javax.annotation.Nonnull;

/**
 * Represents a message
 */
public class Message {
  @Nonnull
  private final String content;

  public Message(@Nonnull String content) {
    this.content = content;
  }

  @Nonnull
  public String getContent() {
    return content;
  }
}
