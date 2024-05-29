/* Copyright 2024 drawmoon */

package io.github.drawmoon.saber;

/**
 * A condition or predicate.
 *
 * <p>Conditions can be used in a variety of SQL clauses. They're mainly used in a Select
 * statement's WHERE clause.
 */
public interface Condition extends Expression {

  /**
   * Performs a logical AND operation between this Condition and the specified expression.
   *
   * @param expr The expression to be logically ANDed with this Condition.
   * @return return a new Condition representing the logical AND operation.
   */
  Condition and(Expression expr);

  /**
   * Performs a logical OR operation between this Condition and the specified expression.
   *
   * @param expr The expression to be logically ORed with this Condition.
   * @return return a new Condition representing the logical OR operation.
   */
  Condition or(Expression expr);
}
