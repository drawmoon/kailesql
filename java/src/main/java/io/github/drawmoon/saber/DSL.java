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
package io.github.drawmoon.saber;

import static com.google.common.base.Preconditions.*;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.github.drawmoon.saber.impl.*;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/** */
public class DSL implements SqlGenerator<DSL>, Visitor<DSL> {

  final DSLContext context;

  /**
   * Constructor.
   *
   * @param context The context, not null
   */
  private DSL(@CheckForNull DSLContext context) {
    checkNotNull(context);
    this.context = context;
  }

  /**
   * Create a new DSL.
   *
   * @param catalog the catalog, not null
   * @return the new DSL
   */
  public static DSL create(Catalog catalog) {
    throw new UnsupportedOperationException();
  }

  /**
   * Create a new DSL.
   *
   * @param catalog the catalog, not null
   * @param options the options, not null
   * @return the new DSL
   */
  public static DSL create(Catalog catalog, DSLOptions options) {
    throw new UnsupportedOperationException();
  }

  /**
   * Create a new DSL.
   *
   * @param dialect the dialect, not null
   * @return the new DSL
   */
  public static DSL create(SqlDialect dialect) {
    throw new UnsupportedOperationException();
  }

  /**
   * Create a new DSL.
   *
   * @param dialect the dialect, not null
   * @param options the options, not null
   * @return the new DSL
   */
  public static DSL create(SqlDialect dialect, DSLOptions options) {
    throw new UnsupportedOperationException();
  }

  // -----------------------------------------------------------------------
  /**
   * Gets a keyword.
   *
   * @param keyword The keyword string, not null
   * @return The {@link Keyword} object, not null
   */
  @Nonnull
  public static Keyword keyword(@CheckForNull String keyword) {
    return Keyword.of(keyword);
  }

  /**
   * Gets a variable.
   *
   * @param <T> the type of the value.
   * @param val the value.
   * @return the new variable.
   */
  public static <T> Variable<T> val(T val) {
    throw new UnsupportedOperationException();
  }

  // -----------------------------------------------------------------------
  @Nonnull
  @Override
  public String render() {
    return context.render();
  }

  @Nonnull
  @Override
  public DSL visitKeyword(Keyword keyword) {
    context.writeKeyword(keyword);
    return this;
  }

  @Nonnull
  @Override
  public DSL visitSubquery(Select select) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public DSL visitDistinct(DistinctExpression distinct) {
    return this;
  }

  @Nonnull
  @Override
  public DSL visitAsterisk(AsteriskExpression asterisk) {
    context.writeSql(" ").writeSql("*");
    return this;
  }

  @Nonnull
  @Override
  public DSL visitFields(FieldsExpression fields) {
    return this;
  }

  @Nonnull
  @Override
  public DSL visitTableField(TableFieldExpression tableField) {
    return this;
  }

  @Nonnull
  @Override
  public DSL visitTables(TablesExpression tables) {
    return this;
  }

  @Nonnull
  @Override
  public DSL visitTable(TableExpression table) {
    return this;
  }

  @Nonnull
  @Override
  public DSL visitJoin(JoinExpression join) {
    return this;
  }

  @Nonnull
  @Override
  public DSL visitComparison(ComparisonExpression comparison) {
    return this;
  }

  @Nonnull
  @Override
  public DSL visitLogical(LogicalExpression logical) {
    return this;
  }

  // -----------------------------------------------------------------------
  public static final class DSLContext {
    final StringBuilder sqlBuilder = new StringBuilder();
    final SqlDialect dialect;
    final DSLOptions options;
    DSLContext superCtx;
    DSLContext subCtx;

    private DSLContext(SqlDialect dialect, DSLOptions options) {
      this.dialect = dialect;
      this.options = options;
    }

    public static DSLContext create(SqlDialect dialect) {
      return create(dialect, null);
    }

    public static DSLContext create(SqlDialect dialect, DSLOptions options) {
      throw new UnsupportedOperationException();
    }

    public DSLContext createSubCtx() {
      DSLContext subCtx = new DSLContext(this.dialect, this.options);
      subCtx.superCtx = this;

      this.subCtx = subCtx;
      return subCtx;
    }

    @Nonnull
    @CanIgnoreReturnValue
    public DSLContext writeKeyword(Keyword keyword) {
      this.writeSql(keyword.upper()); // TODO: 根据 DSLOptions 确定使用大写还是小写
      return this;
    }

    @Nonnull
    @CanIgnoreReturnValue
    public DSLContext writeSql(String sql) {
      return this.autoFormatAppend(sql);
    }

    @Nonnull
    public String render() {
      return this.sqlBuilder.toString();
    }

    private DSLContext autoFormatAppend(String sql) {
      this.sqlBuilder.append(sql);
      return this;
    }
  }

  public static final class DSLOptions {}
}
