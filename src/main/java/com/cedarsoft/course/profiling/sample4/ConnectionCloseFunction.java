package com.cedarsoft.course.profiling.sample4;

import javax.annotation.Nonnull;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
@FunctionalInterface
public interface ConnectionCloseFunction {
  void closeConnection(@Nonnull Connection connection);
}
