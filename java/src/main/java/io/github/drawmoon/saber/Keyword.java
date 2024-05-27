/* Copyright 2024 drawmoon */

package io.github.drawmoon.saber;

import static io.github.drawmoon.saber.common.Preconditions.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/** A SQL keyword. */
public final class Keyword {

  private final String keyword;

  private Keyword(@CheckForNull String keyword) {
    checkNotWhiteSpace(keyword);

    this.keyword = keyword;
  }

  /**
   * Create a {@link Keyword} object.
   *
   * @param keyword The keyword string, not null
   * @return The {@link Keyword} object, not null
   */
  @Nonnull
  public static Keyword keyword(@CheckForNull String keyword) {
    return new Keyword(keyword);
  }

  /**
   * Accept a {@link SqlGenerator} object in order to render a SQL string or to bind its variables.
   *
   * @param gen The {@link SqlGenerator} object to accept, not null
   * @return The rendered SQL string, not null
   */
  @Nonnull
  public String accept(@CheckForNull SqlGenerator gen) {
    return null;
  }
}
