package io.github.drawmoon.saber.impl;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.collect.ImmutableList;

import io.github.drawmoon.saber.Condition;
import io.github.drawmoon.saber.Field;
import io.github.drawmoon.saber.Select;
import io.github.drawmoon.saber.Table;

import java.util.Arrays;

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
  public Select as(String alias) {
    checkArgument(alias != null && alias.trim() != "", "alias cannot be null");

    this.alias = alias;
    return this;
  }

  @Override
  public Select from(Table t) {
    checkArgument(t != null, "table cannot be null");

    this.table = t;
    return this;
  }

  @Override
  public Select where(Condition c) {
    checkArgument(c != null, "condition cannot be null");

    this.where = c;
    return this;
  }

  @Override
  public Select having(Condition c) {
    checkArgument(c != null, "condition cannot be null");

    this.having = c;
    return this;
  }

  @Override
  public Select orderBy(OrderField... f) {
    checkArgument(f != null && f.length > 0, "order fields cannot be null");

    this.orders = ImmutableList.copyOf(Arrays.asList(f));
    return this;
  }

  @Override
  public Select groupBy(GroupField... f) {
    checkArgument(f != null && f.length > 0, "group fields cannot be null");

    this.groups = ImmutableList.copyOf(Arrays.asList(f));
    return this;
  }
}
