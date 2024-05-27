/* Copyright 2024 drawmoon */

package io.github.drawmoon.saber.impl;

import io.github.drawmoon.saber.Asterisk;
import io.github.drawmoon.saber.Field;
import io.github.drawmoon.saber.JoinHint;
import io.github.drawmoon.saber.JoinType;
import io.github.drawmoon.saber.Table;
import javax.annotation.Nonnull;

/** A base table. */
public final class BaseTable implements Table {

  String name;
  String alias;
  String schema;

  @Override
  @Nonnull
  public Field field(String f) {
    return null;
  }

  @Override
  @Nonnull
  public Table as(String alias) {
    return null;
  }

  @Override
  @Nonnull
  public Asterisk asterisk() {
    return null;
  }

  @Override
  @Nonnull
  public JoinTable Join(Table t, JoinType jt, JoinHint jh) {
    return null;
  }

  @Override
  @Nonnull
  public Table useIndex(String... i) {
    return null;
  }

  @Override
  @Nonnull
  public Table useIndexForJoin(String... i) {
    return null;
  }

  @Override
  @Nonnull
  public Table useIndexForOrderBy(String... i) {
    return null;
  }

  @Override
  @Nonnull
  public Table useIndexForGroupBy(String... i) {
    return null;
  }

  @Override
  @Nonnull
  public Table ignoreIndex(String... i) {
    return null;
  }

  @Override
  @Nonnull
  public Table ignoreIndexForJoin(String... i) {
    return null;
  }

  @Override
  @Nonnull
  public Table ignoreIndexForOrderBy(String... i) {
    return null;
  }

  @Override
  @Nonnull
  public Table ignoreIndexForGroupBy(String... i) {
    return null;
  }

  @Override
  @Nonnull
  public Table forceIndex(String... i) {
    return null;
  }

  @Override
  @Nonnull
  public Table forceIndexForJoin(String... i) {
    return null;
  }

  @Override
  @Nonnull
  public Table forceIndexForOrderBy(String... i) {
    return null;
  }

  @Override
  @Nonnull
  public Table forceIndexForGroupBy(String... i) {
    return null;
  }
}
