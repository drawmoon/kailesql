/* Copyright 2024 drawmoon */

package io.github.drawmoon.saber;

import com.google.common.collect.ImmutableList;
import io.github.drawmoon.saber.impl.JoinTable;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** A table. */
public interface Table {

  /**
   * Gets the schema of this table.
   *
   * @return returns the schema, not null
   */
  @CheckForNull
  Schema schema();

  /**
   * Gets the fields of this table.
   *
   * @return returns the fields, not null
   */
  @CheckForNull
  ImmutableList<Field> fields();

  /**
   * Gets a field from this table.
   *
   * @param f the field name, not null
   * @return returns the field, not null
   */
  @CheckForNull
  Field field(String f);

  /**
   * Sets the alias for the table.
   *
   * @param alias the alias, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table as(String alias);

  /**
   * Create a qualified asterisk expression from this table, table.* for use with SELECT.
   *
   * @return returns the asterisk instance, not null
   */
  @Nonnull
  Asterisk asterisk();

  /**
   * Join a table to this table.
   *
   * @param t the table to join, not null
   * @param jt the join type, not null
   * @param jh the join hint, not null
   * @return returns the join table, not null
   */
  @Nonnull
  JoinTable Join(Table t, JoinType jt, @Nullable JoinHint jh);

  // -----------------------------------------------------------------------
  /**
   * Use the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.UseIndex("index1", "index2")</code></pre>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table useIndex(String... i);

  /**
   * Use the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.UseIndexForJoin("index1", "index2")</code></pre>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table useIndexForJoin(String... i);

  /**
   * Use the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.UseIndexForOrderBy("index1", "index2")</code></pre>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table useIndexForOrderBy(String... i);

  /**
   * Use the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.UseIndexForGroupBy("index1", "index2")</code></pre>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table useIndexForGroupBy(String... i);

  /**
   * Ignore the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.IgnoreIndex("index1", "index2")</code></pre>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table ignoreIndex(String... i);

  /**
   * Ignore the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.IgnoreIndexForJoin("index1", "index2")</code></pre>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table ignoreIndexForJoin(String... i);

  /**
   * Ignore the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.IgnoreIndexForOrderBy("index1", "index2")</code></pre>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table ignoreIndexForOrderBy(String... i);

  /**
   * Ignore the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.IgnoreIndexForGroupBy("index1", "index2")</code></pre>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table ignoreIndexForGroupBy(String... i);

  /**
   * Ignore the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.ForceIndex("index1", "index2")</code></pre>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table forceIndex(String... i);

  /**
   * Ignore the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.ForceIndexForJoin("index1", "index2")</code></pre>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table forceIndexForJoin(String... i);

  /**
   * Ignore the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.ForceIndexForOrderBy("index1", "index2")</code></pre>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table forceIndexForOrderBy(String... i);

  /**
   * Ignore the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.ForceIndexForGroupBy("index1", "index2")</code></pre>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table forceIndexForGroupBy(String... i);
}
