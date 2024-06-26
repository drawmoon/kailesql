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

import static com.google.common.base.Preconditions.checkArgument;
import static io.github.drawmoon.saber.common.Preconditions.checkNotWhiteSpace;
import static io.github.drawmoon.saber.common.Preconditions.collectionNullClean;
import static io.github.drawmoon.saber.common.Preconditions.ensureNull;

import io.github.drawmoon.saber.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nonnull;

/** A wrapper for a {@link Select}. */
final class SelectStatement implements Select {

  String alias;
  Field field;
  Table table;
  Condition where;
  Condition having;
  List<OrderField> orders;
  List<GroupField> groups;

  @Nonnull
  @Override
  public Select as(String alias) {
    ensureNull(this.alias);
    checkNotWhiteSpace(alias, "alias cannot be null");

    this.alias = alias;
    return this;
  }

  @Nonnull
  @Override
  public Select from(Table t) {
    checkArgument(t != null, "table cannot be null");

    if (this.table == null) this.table = t;
    else {
      if (this.table instanceof Tables) {
        Tables tables = (Tables) this.table;
        tables.append(t);

        this.table = tables;
      }
      throw new IllegalStateException();
    }
    return this;
  }

  @Nonnull
  @Override
  public Select where(Condition c) {
    checkArgument(c != null, "condition cannot be null");

    if (this.where == null) this.where = c;
    else this.where = this.where.and(c);
    return this;
  }

  @Nonnull
  @Override
  public Select having(Condition c) {
    checkArgument(c != null, "condition cannot be null");

    if (this.having == null) this.having = c;
    else this.having = this.having.and(c);
    return this;
  }

  @Nonnull
  @Override
  public Select orderBy(OrderField... f) {
    LinkedList<OrderField> fields =
        collectionNullClean(Arrays.asList(f), "order fields cannot be null");

    if (this.orders == null) this.orders = fields;
    else this.orders.addAll(fields);
    return this;
  }

  @Nonnull
  @Override
  public Select groupBy(GroupField... f) {
    LinkedList<GroupField> fields =
        collectionNullClean(Arrays.asList(f), "group fields cannot be null");

    if (this.groups == null) this.groups = fields;
    else this.groups.addAll(fields);
    return this;
  }
}
