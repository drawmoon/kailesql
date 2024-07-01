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

import static io.github.drawmoon.saber.common.Preconditions.checkNotNull;
import static io.github.drawmoon.saber.common.Preconditions.checkNotWhiteSpace;
import static io.github.drawmoon.saber.common.Preconditions.ensureNull;

import com.google.common.collect.ImmutableList;
import io.github.drawmoon.saber.*;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A join expression.
 *
 * <p>A table consisting of two joined tables and possibly a join condition.
 */
public class JoinExpression implements Table, Expression {

  String alias;
  Table lhs;
  Table rhs;
  JoinType type;
  JoinHint hint;
  Condition condition;
  ImmutableList<TableField> fields;

  // -----------------------------------------------------------------------
  @Override
  @CheckForNull
  public Schema getSchema() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getName() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getAlias() {
    return this.alias;
  }

  @Override
  @CheckForNull
  public List<TableField> getFields() {
    return this.fields;
  }

  @Override
  @CheckForNull
  public TableField getField(String f) {
    checkNotWhiteSpace(f, "field cannot be null");

    if (this.fields == null) return null;
    return null;
  }

  @Nonnull
  @Override
  public Table as(String alias) {
    ensureNull(this.alias);
    checkNotWhiteSpace(alias, "alias cannot be null");

    this.alias = alias;
    return this;
  }

  @Nonnull
  @Override
  public Asterisk asterisk() {
    return AsteriskExpression.of(this);
  }

  @Nonnull
  @Override
  public JoinExpression join(Table t, JoinType jt, @Nullable JoinHint jh) {
    checkNotNull(t, jt);

    throw new UnsupportedOperationException();
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
    return visitor.visitJoin(this);
  }

  @Nonnull
  @Override
  public Iterator<Expression> iterator() {
    return ExpressionIterator.sameAsExpression(this.lhs, this.rhs, this.condition);
  }
}
