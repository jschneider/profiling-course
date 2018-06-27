package com.cedarsoft.course.profiling.sample1;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class SampleSingleton {
  @Nonnull
  private static final SampleSingleton INSTANCE = new SampleSingleton();
  @Nonnull
  private final List<Message> messages = new ArrayList<>();

  public static void main(String[] args) throws InterruptedException {

    for (int i = 0; i < 100000; i++) {
      SampleSingleton.getInstance().addMessage(new Message("Message " + i));
    }

    System.out.println("Waiting...");
    Thread.sleep(10000000L);
  }

  @Nonnull
  public static SampleSingleton getInstance() {
    return INSTANCE;
  }

  private void addMessage(Message message) {
    this.messages.add(message);
  }

  @Nonnull
  public List<Message> getMessages() {
    return messages;
  }

}
