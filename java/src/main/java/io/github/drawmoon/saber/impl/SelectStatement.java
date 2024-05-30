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

import com.google.common.collect.ImmutableList;
import io.github.drawmoon.saber.Condition;
import io.github.drawmoon.saber.Field;
import io.github.drawmoon.saber.GroupField;
import io.github.drawmoon.saber.OrderField;
import io.github.drawmoon.saber.Select;
import io.github.drawmoon.saber.Table;
import java.util.Arrays;
import java.util.LinkedList;
import javax.annotation.Nonnull;

/** A wrapper for a {@link Select}. */
final class SelectStatement implements Select {

  String alias;
  ImmutableList<Field> fields;
  Table table;
  Condition where;
  Condition having;
  ImmutableList<OrderField> orders;
  ImmutableList<GroupField> groups;

  @Override
  @Nonnull
  public Select as(String alias) {
    ensureNull(this.alias);
    checkNotWhiteSpace(alias, "alias cannot be null");

    this.alias = alias;
    return this;
  }

  @Override
  @Nonnull
  public Select from(Table t) {
    ensureNull(this.table);
    checkArgument(t != null, "table cannot be null");

    this.table = t;
    return this;
  }

  @Override
  @Nonnull
  public Select where(Condition c) {
    ensureNull(this.where);
    checkArgument(c != null, "condition cannot be null");

    this.where = c;
    return this;
  }

  @Override
  @Nonnull
  public Select having(Condition c) {
    ensureNull(this.having);
    checkArgument(c != null, "condition cannot be null");

    this.having = c;
    return this;
  }

  @Override
  @Nonnull
  public Select orderBy(OrderField... f) {
    ensureNull(this.orders);
    LinkedList<OrderField> fields =
        collectionNullClean(Arrays.asList(f), "order fields cannot be null");

    this.orders = ImmutableList.copyOf(fields);
    return this;
  }

  @Override
  @Nonnull
  public Select groupBy(GroupField... f) {
    ensureNull(this.groups);
    LinkedList<GroupField> fields =
        collectionNullClean(Arrays.asList(f), "group fields cannot be null");

    this.groups = ImmutableList.copyOf(fields);
    return this;
  }
}
