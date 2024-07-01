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
package io.github.drawmoon.saber.impl;

import static com.google.common.base.Preconditions.*;

import com.google.common.collect.ImmutableList;
import io.github.drawmoon.saber.*;
import io.github.drawmoon.saber.common.Sequence;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * A tables expression.
 *
 * <p>Regularly linked tables consisting of multiple tables, use {@link JoinExpression} if you have
 * a join type.
 */
@SuppressWarnings("unused")
public class TablesExpression implements Tables, Expression {

  List<Table> tables;
  ImmutableList<TableField> fields;

  // -----------------------------------------------------------------------
  @CheckForNull
  @Override
  public Schema getSchema() {
    List<Schema> list = Sequence.it(this.tables).map(Table::getSchema).toList();
    if (list.size() > 1) throw new IllegalStateException("More than one schema matches");

    return list.get(0);
  }

  @Override
  public String getName() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getAlias() {
    throw new UnsupportedOperationException();
  }

  @CheckForNull
  @Override
  public Table getTable(String t) {
    return null;
  }

  @CheckForNull
  @Override
  public List<TableField> getFields() {
    return this.fields;
  }

  @CheckForNull
  @Override
  public TableField getField(String f) {
    List<TableField> list = Sequence.it(this.fields).filter(t -> f.equals(t.getName())).toList();
    if (list.isEmpty()) return null;

    if (list.size() == 1) {
      return list.get(0);
    } else {
      throw new UnsupportedOperationException();
    }
  }

  @Nonnull
  @Override
  public Tables append(@CheckForNull Table t) {
    checkNotNull(t);

    if (t instanceof Tables) {
      Tables ts = (Tables) t;
      ts.forEachTable(this::append);
    } else {
      this.tables.add(t);
    }
    return this;
  }

  @Nonnull
  @Override
  public Tables insert(int index, @CheckForNull Table t) {
    checkNotNull(t);
    checkElementIndex(index, this.tables.size());

    if (t instanceof Tables) {
      Tables ts = (Tables) t;
      ts.forEachTable(e -> this.insert(index, e));
    } else {
      this.tables.add(index, t);
    }
    return this;
  }

  @Override
  public void forEachTable(Consumer<Table> action) {
    checkNotNull(action);

    for (Table t : this.tables) action.accept(t);
  }

  // -----------------------------------------------------------------------
  @Nonnull
  @Override
  public Table useIndex(String... i) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public Table useIndexForJoin(String... i) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public Table useIndexForOrderBy(String... i) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public Table useIndexForGroupBy(String... i) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public Table ignoreIndex(String... i) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public Table ignoreIndexForJoin(String... i) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public Table ignoreIndexForOrderBy(String... i) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public Table ignoreIndexForGroupBy(String... i) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public Table forceIndex(String... i) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public Table forceIndexForJoin(String... i) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public Table forceIndexForOrderBy(String... i) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public Table forceIndexForGroupBy(String... i) {
    throw new UnsupportedOperationException();
  }

  // -----------------------------------------------------------------------
  @Nonnull
  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitTables(this);
  }

  @Nonnull
  @Override
  public Iterator<Expression> iterator() {
    return ExpressionIterator.sameAsExpression(this.tables.toArray());
  }
}
