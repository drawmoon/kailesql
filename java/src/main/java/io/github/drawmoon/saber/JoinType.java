/* Copyright 2024 drawmoon */

package io.github.drawmoon.saber;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/** The join type. */
public enum JoinType {

  // A self join is a regular join, but the table is joined with itself.
  SELF_JOIN("self join"),
  // The INNER JOIN keyword selects records that have matching values in both tables.
  INNER_JOIN("inner join"),

  // The LEFT JOIN keyword returns all records from the left table (table1), and the
  // matching records from the right table (table2). The result is 0 records from
  // the right side, if there is no match.
  LEFT_JOIN("left join"),
  LEFT_OUTER_JOIN("left outer join"),

  // The RIGHT JOIN keyword returns all records from the right table (table2), and the
  // matching records from the left table (table1). The result is 0 records from the
  // left side, if there is no match.
  RIGHT_JOIN("right join"),
  RIGHT_OUTER_JOIN("right outer join"),

  // The FULL OUTER JOIN keyword returns all records when there is a match in left (table1)
  // or right (table2) table records.
  FULL_JOIN("full join"),
  FULL_OUTER_JOIN("full outer join");

  private final Keyword keyword;

  /**
   * Constructor.
   *
   * @param keyword the keyword, not null
   */
  private JoinType(String keyword) {
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
