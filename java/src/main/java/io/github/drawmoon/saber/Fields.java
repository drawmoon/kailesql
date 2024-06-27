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

/** A set of {@link Field}. */
@SuppressWarnings("unused")
public interface Fields extends Field {

  /**
   * Gets a field from this set.
   *
   * @param f the field name, not null
   * @return returns the field
   */
  @CheckForNull
  Field getField(String f);

  /**
   * Appends the table.
   *
   * @param f the field, not null
   * @return the new fields, not null
   */
  @CanIgnoreReturnValue
  @Nonnull
  Fields append(@CheckForNull Field f);

  /**
   * Inserts the table.
   *
   * @param index the index
   * @param f the field, not null
   * @throws IndexOutOfBoundsException if index is negative or greater than {@code size()}, or
   *     offset or len are negative
   * @return the new fields, not null
   */
  @CanIgnoreReturnValue
  @Nonnull
  Fields insert(int index, @CheckForNull Field f);

  /**
   * Perform the given action for each {@link Field} until all elements have been processed.
   *
   * @param action the action
   */
  void forEachField(Consumer<Field> action);

  @Override
  default String getName() {
    throw new UnsupportedOperationException();
  }
}
