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

import static com.google.common.base.Preconditions.checkNotNull;

import io.github.drawmoon.saber.Expression;
import io.github.drawmoon.saber.ExpressionIterator;
import io.github.drawmoon.saber.Field;
import io.github.drawmoon.saber.Fields;
import io.github.drawmoon.saber.common.Sequence;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/** A field set expression. */
@SuppressWarnings("unused")
public class FieldsExpression implements Fields, Expression {

  List<Field> fields;

  @CheckForNull
  @Override
  public Field getField(String f) {
    Optional<Field> o = Sequence.it(this.fields).find(t -> f.equals(t.getName()));
    return o.orElse(null);
  }

  @Nonnull
  @Override
  public Fields append(@CheckForNull Field f) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public Fields insert(int index, @CheckForNull Field f) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void forEachField(Consumer<Field> action) {
    checkNotNull(action);

    for (Field f : this.fields) action.accept(f);
  }

  @Nonnull
  @Override
  public Iterator<Expression> iterator() {
    return ExpressionIterator.sameAsExpression(this.fields.toArray());
  }
}
