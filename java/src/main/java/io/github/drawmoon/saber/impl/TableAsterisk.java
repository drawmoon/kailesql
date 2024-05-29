/* Copyright 2024 drawmoon */

package io.github.drawmoon.saber.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import io.github.drawmoon.saber.Asterisk;
import io.github.drawmoon.saber.Field;
import io.github.drawmoon.saber.Table;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/** A wrapper for a {@link Asterisk}. */
public final class TableAsterisk implements Asterisk {

  final Table table;
  final ImmutableList<Field> fields;

  /**
   * Constructor.
   *
   * @param table not null
   */
  private TableAsterisk(@CheckForNull Table table) {
    checkNotNull(table, "table cannot be null");

    this.table = table;
    this.fields = table.fields();
  }

  /**
   * Returns an instance of {@link Asterisk} with the {@link Table} and {@link Field} collections.
   *
   * @param table the table
   * @return an instance of {@link Asterisk}, not null
   */
  @Nonnull
  public static TableAsterisk of(@CheckForNull Table table) {
    return new TableAsterisk(table);
  }
}
