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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import io.github.drawmoon.saber.Asterisk;
import io.github.drawmoon.saber.Expression;
import io.github.drawmoon.saber.Field;
import io.github.drawmoon.saber.Table;
import io.github.drawmoon.saber.common.Enumerable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/** A asterisk expression. */
public class AsteriskExpression implements Asterisk, Expression {

  final Table table;
  final ImmutableList<Field> fields;

  /**
   * Constructor.
   *
   * @param table not null
   */
  private AsteriskExpression(@CheckForNull Table table) {
    checkNotNull(table, "table cannot be null");

    this.table = table;
    this.fields = table.getFields();
  }

  /**
   * Returns an instance of {@link Asterisk} with the {@link Table} and {@link Field} collections.
   *
   * @param table the table
   * @return an instance of {@link Asterisk}, not null
   */
  @Nonnull
  public static AsteriskExpression of(@CheckForNull Table table) {
    return new AsteriskExpression(table);
  }

  @Nonnull
  @Override
  public <R> Enumerable<R> collect(Function<? super Expression, ? extends R> function) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public ArrayList<Expression> toList() {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public Iterator<Expression> iterator() {
    throw new UnsupportedOperationException();
  }
}
