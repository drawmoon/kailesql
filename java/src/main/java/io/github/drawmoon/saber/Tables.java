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

import com.google.errorprone.annotations.DoNotCall;
import io.github.drawmoon.saber.common.Enumerable;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/** A set of {@link Table}. */
public interface Tables extends Table {

    /**
     * Gets the tables.
     * @return returns the tables, not null
     */
    @Nonnull
    List<Table> getTables();

    /**
     * Gets a table from this set.
     * @param t the table name, not null
     * @return returns the table, not null
     */
    @CheckForNull
    Table getTable(String t);

    /**
     * Appends the table.
     * @param t the table, not null
     * @return the new tables, not null
     */
    @Nonnull
    Tables append(@CheckForNull Table t);

    /**
     * Inserts the table.
     * @param index the index
     * @param t the table, not null
     *
     * @throws IndexOutOfBoundsException if index is negative or greater than {@code size()}, or offset or len are negative
     * @return the new tables, not null
     */
    @Nonnull
    Tables insert(int index, @CheckForNull Table t);

    @DoNotCall
    @Nonnull
    @Override
    default Table as(String alias) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall
    @Nonnull
    @Override
    default Asterisk asterisk() {
        throw new UnsupportedOperationException();
    }

    @DoNotCall
    @Nonnull
    @Override
    default Table join(Table t, JoinType jt, @Nullable JoinHint jh) {
        throw new UnsupportedOperationException();
    }
}
