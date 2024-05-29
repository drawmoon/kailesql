/* Copyright 2024 drawmoon */

package io.github.drawmoon.saber.impl;

import static io.github.drawmoon.saber.common.Preconditions.checkNotNull;
import static io.github.drawmoon.saber.common.Preconditions.checkNotWhiteSpace;
import static io.github.drawmoon.saber.common.Preconditions.ensureNull;

import com.google.common.collect.ImmutableList;
import io.github.drawmoon.saber.Asterisk;
import io.github.drawmoon.saber.Field;
import io.github.drawmoon.saber.JoinHint;
import io.github.drawmoon.saber.JoinType;
import io.github.drawmoon.saber.Schema;
import io.github.drawmoon.saber.Table;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** A base table. */
public final class BaseTable implements Table {

  String name;
  String alias;
  Schema schema;
  ImmutableList<Field> fields;

  @Override
  @CheckForNull
  public Schema schema() {
    return this.schema;
  }

  @Override
  @CheckForNull
  public ImmutableList<Field> fields() {
    return this.fields;
  }

  @Override
  @CheckForNull
  public Field field(String f) {
    checkNotWhiteSpace(f, "field cannot be null");

    if (this.fields == null) return null;
    return null;
  }

  @Override
  @Nonnull
  public Table as(String alias) {
    ensureNull(this.alias);
    checkNotWhiteSpace(alias, "alias cannot be null");

    this.alias = alias;
    return this;
  }

  @Override
  @Nonnull
  public Asterisk asterisk() {
    return TableAsterisk.of(this);
  }

  @Override
  @Nonnull
  public JoinTable Join(Table t, JoinType jt, @Nullable JoinHint jh) {
    checkNotNull(t, jt);

    return null;
  }

  @Override
  @Nonnull
  public Table useIndex(String... i) {
    throw new UnsupportedOperationException();
  }

  @Override
  @Nonnull
  public Table useIndexForJoin(String... i) {
    throw new UnsupportedOperationException();
  }

  @Override
  @Nonnull
  public Table useIndexForOrderBy(String... i) {
    throw new UnsupportedOperationException();
  }

  @Override
  @Nonnull
  public Table useIndexForGroupBy(String... i) {
    throw new UnsupportedOperationException();
  }

  @Override
  @Nonnull
  public Table ignoreIndex(String... i) {
    throw new UnsupportedOperationException();
  }

  @Override
  @Nonnull
  public Table ignoreIndexForJoin(String... i) {
    throw new UnsupportedOperationException();
  }

  @Override
  @Nonnull
  public Table ignoreIndexForOrderBy(String... i) {
    throw new UnsupportedOperationException();
  }

  @Override
  @Nonnull
  public Table ignoreIndexForGroupBy(String... i) {
    throw new UnsupportedOperationException();
  }

  @Override
  @Nonnull
  public Table forceIndex(String... i) {
    throw new UnsupportedOperationException();
  }

  @Override
  @Nonnull
  public Table forceIndexForJoin(String... i) {
    throw new UnsupportedOperationException();
  }

  @Override
  @Nonnull
  public Table forceIndexForOrderBy(String... i) {
    throw new UnsupportedOperationException();
  }

  @Override
  @Nonnull
  public Table forceIndexForGroupBy(String... i) {
    throw new UnsupportedOperationException();
  }
}
