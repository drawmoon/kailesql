/* Copyright 2024 drawmoon */

package io.github.drawmoon.saber;

import javax.annotation.Nonnull;

/**
 * A select statement.
 *
 * <p>Example:
 *
 * <pre><code>
 * DSL.create(SqlDialect.MY_SQL)
 *   .select(fields)
 *   .from(table)
 *   .where(condition)
 *   .orderBy(field1)
 *   .groupBy(field2);
 * </code></pre>
 */
public interface Select {

  /**
   * Sets the alias for the select statement.
   *
   * @param alias the alias, not null
   * @return the select, not null
   */
  @Nonnull
  Select as(String alias);

  /**
   * Sets the table to be queried.
   *
   * @param t the table, not null
   * @return the select, not null
   */
  @Nonnull
  Select from(Table t);

  /**
   * Sets the where clause.
   *
   * @param c the condition, not null
   * @return the select, not null
   */
  @Nonnull
  Select where(Condition c);

  /**
   * Sets the having clause.
   *
   * @param c the condition, not null
   * @return the select, not null
   */
  @Nonnull
  Select having(Condition c);

  /**
   * Sets the order by clause.
   *
   * @param f the order fields, not null
   * @return the select, not null
   */
  @Nonnull
  Select orderBy(OrderField... f);

  /**
   * Sets the group by clause.
   *
   * @param f the group fields, not null
   * @return the select, not null
   */
  @Nonnull
  Select groupBy(GroupField... f);
}
