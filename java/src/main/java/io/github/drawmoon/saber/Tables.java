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

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.function.Consumer;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** A set of {@link Table}. */
@SuppressWarnings("unused")
public interface Tables extends Table {

  /**
   * Gets a table from this set.
   *
   * @param t the table name, not null
   * @return returns the table
   */
  @CheckForNull
  Table getTable(String t);

  /**
   * Appends the table.
   *
   * @param t the table, not null
   * @return the new tables, not null
   */
  @CanIgnoreReturnValue
  @Nonnull
  Tables append(@CheckForNull Table t);

  /**
   * Inserts the table.
   *
   * @param index the index
   * @param t the table, not null
   * @throws IndexOutOfBoundsException if index is negative or greater than {@code size()}, or
   *     offset or len are negative
   * @return the new tables, not null
   */
  @CanIgnoreReturnValue
  @Nonnull
  Tables insert(int index, @CheckForNull Table t);

  /**
   * Perform the given action for each {@link Table} until all elements have been processed.
   *
   * @param action the action
   */
  void forEachTable(Consumer<Table> action);

  @Nonnull
  @Override
  default Table as(String alias) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  default Asterisk asterisk() {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  default Table join(Table t, JoinType jt, @Nullable JoinHint jh) {
    throw new UnsupportedOperationException();
  }
}
