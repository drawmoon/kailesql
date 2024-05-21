package io.github.drawmoon.saber.common;

import java.io.Serializable;
import java.time.ZonedDateTime;

public final class DateTime implements Serializable {

  private static final long serialVersionUID = -8492251942206794476L;

  final ZonedDateTime dateTime;

  private DateTime(ZonedDateTime dateTime) {
    this.dateTime = dateTime;
  }
}
