/* Copyright 2024 drawmoon */

package io.github.drawmoon.saber.exceptions;

public class SaberException extends RuntimeException {

  public SaberException(String message) {
    this(message, null);
  }

  public SaberException(String message, Throwable cause) {
    super(message);
    if (cause != null) {
      super.initCause(cause);
    }
  }
}
