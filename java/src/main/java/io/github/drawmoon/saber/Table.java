/* Copyright 2024 drawmoon */

package io.github.drawmoon.saber;

import io.github.drawmoon.saber.impl.JoinTable;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/** A table. */
public interface Table {

  /**
   * Gets a field from this table.
   *
   * @param f the field name, not null
   * @return returns the field, not null
   */
  @Nonnull
  Field field(@CheckForNull String f);

  /**
   * Sets the alias for the table.
   *
   * @param alias the alias, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table as(@CheckForNull String alias);

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
  JoinTable Join(@CheckForNull Table t, @CheckForNull JoinType jt, @CheckForNull JoinHint jh);

  // -----------------------------------------------------------------------
  /**
   * Use the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.UseIndex("index1", "index2")</pre></code>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table useIndex(@CheckForNull String... i);

  /**
   * Use the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.UseIndexForJoin("index1", "index2")</pre></code>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table useIndexForJoin(@CheckForNull String... i);

  /**
   * Use the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.UseIndexForOrderBy("index1", "index2")</pre></code>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table useIndexForOrderBy(@CheckForNull String... i);

  /**
   * Use the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.UseIndexForGroupBy("index1", "index2")</pre></code>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table useIndexForGroupBy(@CheckForNull String... i);

  /**
   * Ignore the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.IgnoreIndex("index1", "index2")</pre></code>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table ignoreIndex(@CheckForNull String... i);

  /**
   * Ignore the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.IgnoreIndexForJoin("index1", "index2")</pre></code>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table ignoreIndexForJoin(@CheckForNull String... i);

  /**
   * Ignore the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.IgnoreIndexForOrderBy("index1", "index2")</pre></code>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table ignoreIndexForOrderBy(@CheckForNull String... i);

  /**
   * Ignore the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.IgnoreIndexForGroupBy("index1", "index2")</pre></code>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table ignoreIndexForGroupBy(@CheckForNull String... i);

  /**
   * Ignore the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.ForceIndex("index1", "index2")</pre></code>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table forceIndex(@CheckForNull String... i);

  /**
   * Ignore the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.ForceIndexForJoin("index1", "index2")</pre></code>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table forceIndexForJoin(@CheckForNull String... i);

  /**
   * Ignore the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.ForceIndexForOrderBy("index1", "index2")</pre></code>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table forceIndexForOrderBy(@CheckForNull String... i);

  /**
   * Ignore the index hints for this table.
   *
   * <p>Examples:
   *
   * <pre><code>table.ForceIndexForGroupBy("index1", "index2")</pre></code>
   *
   * @param i the index hints, not null
   * @return returns the table, not null
   */
  @Nonnull
  Table forceIndexForGroupBy(@CheckForNull String... i);
}
