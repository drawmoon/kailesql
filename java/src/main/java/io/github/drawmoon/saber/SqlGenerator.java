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

import javax.annotation.Nonnull;

/** A SQL generator. */
public interface SqlGenerator<T> {

  /**
   * Render the SQL.
   *
   * @return the SQL
   */
  @Nonnull
  String render();

  /**
   * Visit a {@link Keyword}.
   *
   * @param keyword the keyword, not null
   * @return the result
   */
  @Nonnull
  T visitKeyword(Keyword keyword);

  /**
   * Visit a {@link Select}.
   *
   * @param select the select, not null
   * @return the result
   */
  @Nonnull
  T visitSubquery(Select select);
}
