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
import io.github.drawmoon.saber.*;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/** A asterisk expression. */
@SuppressWarnings("unused")
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
    List<TableField> fields = table.getFields();

    this.table = table;
    this.fields = fields == null ? ImmutableList.of() : ImmutableList.copyOf(fields);
  }

  /**
   * Returns an instance of {@link Asterisk} with the {@link Table} and {@link Field} collections.
   *
   * @param table the table
   * @return an instance of {@link Asterisk}, not null
   */
  @Nonnull
  public static Asterisk of(@CheckForNull Table table) {
    return new AsteriskExpression(table);
  }

  @Nonnull
  @Override
  public Iterator<Expression> iterator() {
    return ExpressionIterator.empty();
  }
}
