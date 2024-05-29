/* Copyright 2024 drawmoon */

package io.github.drawmoon.saber;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/** An operator used for combining conditions. */
public enum Operator {
  AND("and"),
  OR("or");

  private final Keyword keyword;

  /**
   * Constructor.
   *
   * @param keyword the keyword, not null
   */
  private Operator(String keyword) {
    this.keyword = Keyword.keyword(keyword);
  }

  /**
   * Accept a {@link SqlGenerator} object in order to render a SQL string or to bind its variables.
   *
   * @param gen The {@link SqlGenerator} object to accept, not null
   * @return The rendered SQL string, not null
   */
  @Nonnull
  public String accept(@CheckForNull SqlGenerator gen) {
    return this.keyword.accept(gen);
  }
}
