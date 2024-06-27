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

import io.github.drawmoon.saber.Expression;
import io.github.drawmoon.saber.ExpressionIterator;
import io.github.drawmoon.saber.Table;
import io.github.drawmoon.saber.TableField;
import java.util.Iterator;
import javax.annotation.Nonnull;

/** A table field expression. */
public class TableFieldExpression implements TableField, Expression {

  String name;
  String alias;
  Table table;

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getAlias() {
    return this.alias;
  }

  @Nonnull
  @Override
  public Table getTable() {
    return this.table;
  }

  @Nonnull
  @Override
  public TableField as(String alias) {
    this.alias = alias;
    return this;
  }

  @Nonnull
  @Override
  public Iterator<Expression> iterator() {
    return ExpressionIterator.empty();
  }
}
