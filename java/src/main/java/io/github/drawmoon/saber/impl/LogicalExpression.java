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

import io.github.drawmoon.saber.*;
import java.util.Iterator;
import javax.annotation.Nonnull;

/**
 * A logical expression.
 *
 * <p>Combine this condition with another condition using the specified operator.
 */
public class LogicalExpression implements Condition {

  Condition left;
  Condition right;
  Operator operator;

  // -----------------------------------------------------------------------
  @Nonnull
  @Override
  public Condition and(Expression expr) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public Condition or(Expression expr) {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visitLogical(this);
  }

  @Nonnull
  @Override
  public Iterator<Expression> iterator() {
    return ExpressionIterator.sameAsExpression(this.left, this.right);
  }
}
