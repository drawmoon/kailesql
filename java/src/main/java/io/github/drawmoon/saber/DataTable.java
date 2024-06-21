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

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.AbstractIterator;
import io.github.drawmoon.saber.common.Enumerable;
import io.github.drawmoon.saber.common.Sequence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.function.Function;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import org.checkerframework.checker.nullness.qual.Nullable;

/** A DataTable is a collection of DataRows. It is a collection of rows and columns. */
@SuppressWarnings("unused")
@JsonDeserialize(using = DataTable.DataTableJsonDeserializer.class)
public final class DataTable implements Enumerable<DataTable.DataRow> {

  private static final long serialVersionUID = -8492251942206794476L;

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

  public int rowCount() {
    return this.rowCount;
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

    row.setPosition(this.rowCount);
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
  public Iterator<DataRow> iterator() {
    return this.rows.iterator();
  }

  @Override
  @Nonnull
  public <R> Enumerable<R> collect(Function<? super DataRow, ? extends R> function) {
    return this.rows.collect(function);
  }

  @Override
  @Nonnull
  public ArrayList<DataRow> toList() {
    return this.rows.toList();
  }

  @SuppressWarnings("unused")
  @JsonSerialize(using = DataRowJsonSerializer.class)
  @JsonDeserialize(using = DataRowJsonDeserializer.class)
  public static final class DataRow implements Enumerable<Object> {
    private static final long serialVersionUID = -8492251942206794476L;

    private final DataTable table;
    private final DataColumnList columns;
    private int rowNumber = -1;

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

      DataColumn column = this.columns.get(columnName);
      column.add(value);
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

      return column.get(rowNumber);
    }

    @Override
    @Nonnull
    public <R> Enumerable<R> collect(Function<? super Object, ? extends R> function) {
      return Sequence.it(this).collect(function);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    @Nonnull
    public Iterator<Object> iterator() {
      Iterator<DataColumn> in = this.columns.iterator();

      return new AbstractIterator() {
        @Override
        protected @Nullable Object computeNext() {
          while (in.hasNext()) {
            DataColumn next = in.next();
            return next.get(rowNumber);
          }
          return endOfData();
        }
      };
    }

    @Override
    @Nonnull
    public ArrayList<Object> toList() {
      return Sequence.it(this).toList();
    }

    @Nonnull
    public LinkedHashMap<String, Object> toMap() {
      LinkedHashMap<String, Object> map = new LinkedHashMap<>();

      for (DataColumn column : this.columns) {
        map.put(column.name(), this.getObject(column));
      }
      return map;
    }

    private void setPosition(int rowNumber) {
      this.rowNumber = rowNumber;
    }
  }

  @SuppressWarnings("unused")
  public static final class DataColumn extends ArrayList<Object> implements Enumerable<Object> {
    private static final long serialVersionUID = -8492251942206794476L;

    private final String name;

    public DataColumn(String name) {
      checkNotWhiteSpace(name);
      this.name = name;
    }

    public String name() {
      return this.name;
    }

    public boolean isNullable() {
      throw new UnsupportedOperationException();
    }

    @Override
    @Nonnull
    public <R> Enumerable<R> collect(Function<? super Object, ? extends R> function) {
      return Sequence.it(this).collect(function);
    }

    @Override
    @Nonnull
    public ArrayList<Object> toList() {
      return this;
    }
  }

  static final class DataColumnList extends ArrayList<DataColumn>
      implements Enumerable<DataColumn> {
    @Nonnull
    public DataColumn get(@CheckForNull String columnName) {
      checkNotWhiteSpace(columnName);
      Optional<DataColumn> o = Sequence.it(this).single(x -> x.name.equals(columnName));
      return o.orElseThrow(() -> new IllegalArgumentException("Column not found: " + columnName));
    }

    @Override
    @Nonnull
    public <R> Enumerable<R> collect(Function<? super DataColumn, ? extends R> function) {
      return Sequence.it(this).collect(function);
    }

    @Override
    @Nonnull
    public ArrayList<DataColumn> toList() {
      return this;
    }
  }

  static final class DataRowList extends ArrayList<DataRow> implements Enumerable<DataRow> {
    @Override
    @Nonnull
    public <R> Enumerable<R> collect(Function<? super DataRow, ? extends R> function) {
      return Sequence.it(this).collect(function);
    }

    @Override
    @Nonnull
    public ArrayList<DataRow> toList() {
      return this;
    }
  }

  static final class DataTableJsonDeserializer extends JsonDeserializer<DataTable> {
    @Override
    public DataTable deserialize(JsonParser p, DeserializationContext ctxt)
        throws IOException, JacksonException {
      JsonToken token = p.getCurrentToken();
      if (token != JsonToken.START_ARRAY)
        throw new IOException("Expected start of array, got: " + token);

      boolean columnBeReady = false;
      DataTable table = new DataTable();
      while ((token = p.nextToken()) != JsonToken.END_ARRAY) {
        if (token == JsonToken.START_OBJECT) {
          DataRow row = table.newRow();
          while ((token = p.nextToken()) != JsonToken.END_OBJECT) {
            if (token == JsonToken.FIELD_NAME) {
              String columnName = p.getCurrentName();
              if (!columnBeReady) table.addColumn(new DataColumn(columnName));

              token = p.nextToken();
              if (token.isScalarValue()) {
                Object value;
                switch (token.id()) {
                  case JsonTokenId.ID_STRING:
                    value = p.getText();
                    break;
                  case JsonTokenId.ID_NUMBER_INT:
                    value = p.getNumberValue();
                    break;
                  case JsonTokenId.ID_NUMBER_FLOAT:
                    value = p.getNumberValue();
                    break;
                  case JsonTokenId.ID_TRUE:
                    value = Boolean.TRUE;
                    break;
                  case JsonTokenId.ID_FALSE:
                    value = Boolean.FALSE;
                    break;
                  default:
                    throw new IOException("Unsupported scalar token type: " + token);
                }
                row.setRowData(columnName, value);
              }
            } else {
              throw new IOException("Expected scalar value for field, got: " + token);
            }
          }
          if (token == JsonToken.END_OBJECT) {
            columnBeReady = true;
            table.addRow(row);
          }
        }
      }
      return table;
    }
  }

  static final class DataRowJsonSerializer extends JsonSerializer<DataRow> {
    @Override
    public void serialize(DataRow value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException {
      LinkedHashMap<String, Object> map = value.toMap();
      gen.writeObject(map);
    }
  }

  static final class DataRowJsonDeserializer extends JsonDeserializer<DataRow> {
    @Override
    public DataRow deserialize(JsonParser p, DeserializationContext ctxt)
        throws IOException, JacksonException {
      throw new UnsupportedOperationException();
    }
  }
}
