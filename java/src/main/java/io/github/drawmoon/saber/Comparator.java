/* Copyright 2024 drawmoon */

package io.github.drawmoon.saber;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/** A comparator to be used in conditions to form comparison predicates. */
public enum Comparator {
  EQ("eq"),
  NE("ne"),
  LT("lt"),
  GT("gt"),
  LE("le"),
  GE("ge"),
  IN("in"),
  NOT_IN("not in"),
  LIKE("like"),
  NOT_LIKE("not like"),
  BETWEEN("between"),
  NOT_BETWEEN("not between"),
  IS_NULL("is null"),
  IS_NOT_NULL("is not null");

  private final Keyword keyword;

  /**
   * Constructor.
   *
   * @param keyword the keyword, not null
   */
  private Comparator(String keyword) {
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
