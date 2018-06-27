package com.cedarsoft.course.profiling.sample2;

import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class SampleListener {

  @Nonnull
  private final AnObservable anObservable = new AnObservable();

  public static void main(String[] args) throws InterruptedException {
    SampleListener sampleListener = new SampleListener();
    sampleListener.run();

    System.out.println("Sleeping");
    Thread.sleep(100000000000000L);
  }

  private void run() {
    anObservable.addListener(new Listener() {
      @Override
      public void somethingHappened() {
        System.out.println("Sample2Listener.somethingHappened");
      }
    });
  }
}
