/* Copyright 2024 drawmoon */

package io.github.drawmoon.saber.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static io.github.drawmoon.saber.common.Preconditions.checkNullOrWhiteSpace;
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
import javax.annotation.concurrent.Immutable;

/** A wrapper for a {@link Select}. */
@Immutable
final class SelectStatement implements Select {

  String alias;
  ImmutableList<Field> fields;
  Table table;
  Condition where;
  Condition having;
  ImmutableList<OrderField> orders;
  ImmutableList<GroupField> groups;

  @Override
  public Select as(String alias) {
    ensureNull(this.alias);
    checkNullOrWhiteSpace(alias, "alias cannot be null");

    this.alias = alias;
    return this;
  }

  @Override
  public Select from(Table t) {
    ensureNull(this.table);
    checkArgument(t != null, "table cannot be null");

    this.table = t;
    return this;
  }

  @Override
  public Select where(Condition c) {
    ensureNull(this.where);
    checkArgument(c != null, "condition cannot be null");

    this.where = c;
    return this;
  }

  @Override
  public Select having(Condition c) {
    ensureNull(this.having);
    checkArgument(c != null, "condition cannot be null");

    this.having = c;
    return this;
  }

  @Override
  public Select orderBy(OrderField... f) {
    ensureNull(this.orders);
    LinkedList<OrderField> fields =
        collectionNullClean(Arrays.asList(f), "order fields cannot be null");

    this.orders = ImmutableList.copyOf(fields);
    return this;
  }

  @Override
  public Select groupBy(GroupField... f) {
    ensureNull(this.groups);
    LinkedList<GroupField> fields =
        collectionNullClean(Arrays.asList(f), "group fields cannot be null");

    this.groups = ImmutableList.copyOf(fields);
    return this;
  }
}
