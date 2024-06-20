/*
 *            _
 *  ___  __ _| |__   ___ _ __
 * / __|/ _` | '_ \ / _ \ '__|
 * \__ \ (_| | |_) |  __/ |
 * |___/\__,_|_.__/ \___|_|
 *
 * Copyright 2024 drash
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.drawmoon.saber;

import static com.google.common.base.Preconditions.checkElementIndex;
import static com.google.common.base.Preconditions.checkNotNull;
import static io.github.drawmoon.saber.common.Preconditions.checkNotWhiteSpace;

import io.github.drawmoon.saber.common.Enumerable;
import io.github.drawmoon.saber.common.Sequence;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/** A DataTable is a collection of DataRows. It is a collection of rows and columns. */
@SuppressWarnings("unused")
public final class DataTable implements Enumerable<DataTable.DataColumn> {

  private final DataColumnList columns;
  private final DataRowList rows;
  private int rowCount;

  public DataTable() {
    this.columns = new DataColumnList();
    this.rows = new DataRowList();
    this.rowCount = 0;
  }

  public Collection<DataColumn> columns() {
    return this.columns;
  }

  public Collection<DataRow> rows() {
    return this.rows;
  }

  /**
   * Creates a new row in the DataTable.
   *
   * @return The new row
   */
  @Nonnull
  public DataRow newRow() {
    return new DataRow(this);
  }

  /**
   * Adds a column to the DataTable.
   *
   * @param column The column to add
   */
  public void addColumn(@CheckForNull DataColumn column) {
    this.columns.add(checkNotNull(column));
  }

  /**
   * Adds a row to the DataTable.
   *
   * @param row The row to add
   * @throws IllegalArgumentException If the row is not from this table
   */
  public void addRow(@CheckForNull DataRow row) {
    if (row.table != this) throw new IllegalArgumentException("Row is not from this table");

    this.rows.add(row);
    this.rowCount++;
  }

  /**
   * Slices the DataTable.
   *
   * @param index The index to start at
   * @return the new DataTable
   */
  public DataTable slice(int index) {
    return this.slice(index, this.rowCount - index);
  }

  /**
   * Slices the DataTable.
   *
   * @param index The index to start at
   * @param length The length of the slice
   * @return the new DataTable
   */
  public DataTable slice(int index, int length) {
    throw new UnsupportedOperationException();
  }

  /** Prints the DataTable as a table. */
  public void printAsTable() {
    throw new UnsupportedOperationException();
  }

  @Override
  @Nonnull
  public Iterator<DataColumn> iterator() {
    return this.columns.iterator();
  }

  @Override
  @Nonnull
  public <R> Enumerable<R> collect(Function<? super DataColumn, ? extends R> function) {
    return Sequence.it(this.columns).map(function);
  }

  @Override
  @Nonnull
  public ArrayList<DataColumn> toList() {
    return this.columns.toList();
  }

  @SuppressWarnings("unused")
  public static final class DataRow implements Enumerable<Object> {
    private final DataTable table;
    private final DataColumnList columns;
    private int rowNumber = -1;
    private boolean hasNext = false;

    public DataRow(DataTable table) {
      this.table = table;
      this.columns = table.columns;
    }

    public DataTable table() {
      return this.table;
    }

    public Collection<DataColumn> columns() {
      return this.columns;
    }

    public void setRowData(@CheckForNull String columnName, Object value) {
      checkNotWhiteSpace(columnName);
      if (this.columns.isEmpty()) throw new IllegalStateException("No columns in table");

      throw new UnsupportedOperationException();
    }

    public boolean isNull(@CheckForNull String columnName) {
      checkNotWhiteSpace(columnName);
      if (this.columns.isEmpty()) throw new IllegalStateException("No columns in table");

      DataColumn column = this.columns.get(columnName);
      return this.isNull(column);
    }

    public boolean isNull(@CheckForNull int columnIndex) {
      checkElementIndex(columnIndex, this.columns.size());
      if (this.columns.isEmpty()) throw new IllegalStateException("No columns in table");

      DataColumn column = this.columns.get(columnIndex);
      return this.isNull(column);
    }

    public boolean isNull(@CheckForNull DataColumn column) {
      checkNotNull(column);
      if (this.columns.isEmpty()) throw new IllegalStateException("No columns in table");

      throw new UnsupportedOperationException();
    }

    public Object getObject(@CheckForNull String columnName) {
      checkNotWhiteSpace(columnName);
      if (this.columns.isEmpty()) throw new IllegalStateException("No columns in table");

      DataColumn column = this.columns.get(columnName);
      return this.getObject(column);
    }

    public Object getObject(int columnIndex) {
      checkElementIndex(columnIndex, this.columns.size());
      if (this.columns.isEmpty()) throw new IllegalStateException("No columns in table");

      DataColumn column = this.columns.get(columnIndex);
      return this.getObject(column);
    }

    public Object getObject(@CheckForNull DataColumn column) {
      checkNotNull(column);
      if (this.columns.isEmpty()) throw new IllegalStateException("No columns in table");

      throw new UnsupportedOperationException();
    }

    @Override
    @Nonnull
    public <R> Enumerable<R> collect(Function<? super Object, ? extends R> function) {
      return Sequence.it(this).map(function);
    }

    @Override
    @Nonnull
    public Iterator<Object> iterator() {
      return Sequence.it(this).iterator();
    }

    @Override
    @Nonnull
    public ArrayList<Object> toList() {
      return Sequence.it(this).toList();
    }
  }

  @SuppressWarnings("unused")
  public static final class DataColumn implements Enumerable<Object> {
    private final String name;

    public DataColumn(String name) {
      this.name = name;
    }

    @Nonnull
    public String name() {
      return this.name;
    }

    public boolean isNullable() {
      throw new UnsupportedOperationException();
    }

    @Override
    @Nonnull
    public Iterator<Object> iterator() {
      return Sequence.it(this).iterator();
    }

    @Override
    @Nonnull
    public <R> Enumerable<R> collect(Function<? super Object, ? extends R> function) {
      return Sequence.it(this).map(function);
    }

    @Override
    @Nonnull
    public ArrayList<Object> toList() {
      return Sequence.it(this).toList();
    }
  }

  static final class DataColumnList extends ArrayDeque<DataColumn>
      implements Enumerable<DataColumn> {
    @Nonnull
    public DataColumn get(int index) {
      throw new UnsupportedOperationException();
    }

    @Nonnull
    public DataColumn get(String columnName) {
      throw new UnsupportedOperationException();
    }

    @Override
    @Nonnull
    public <R> Enumerable<R> collect(Function<? super DataColumn, ? extends R> function) {
      return Sequence.it(this).map(function);
    }

    @Override
    @Nonnull
    public ArrayList<DataColumn> toList() {
      return Sequence.it(this).toList();
    }
  }

  static final class DataRowList extends ArrayDeque<DataRow> implements Enumerable<DataRow> {
    @Override
    @Nonnull
    public <R> Enumerable<R> collect(Function<? super DataRow, ? extends R> function) {
      return Sequence.it(this).map(function);
    }

    @Override
    @Nonnull
    public ArrayList<DataRow> toList() {
      return Sequence.it(this).toList();
    }
  }
}
