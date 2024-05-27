/* Copyright 2024 drawmoon */

package io.github.drawmoon.saber;

/**
 * A select statement.
 *
 * <p>Example:
 *
 * <p>
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
   * @param alias
   * @return
   */
  Select as(String alias);

  /**
   * Sets the table to be queried.
   *
   * @param t
   * @return
   */
  Select from(Table t);

  /**
   * Sets the where clause.
   *
   * @param c
   * @return
   */
  Select where(Condition c);

  /**
   * Sets the having clause.
   *
   * @param c
   * @return
   */
  Select having(Condition c);

  /**
   * Sets the order by clause.
   *
   * @param f
   * @return
   */
  Select orderBy(OrderField... f);

  /**
   * Sets the group by clause.
   *
   * @param f
   * @return
   */
  Select groupBy(GroupField... f);
}
