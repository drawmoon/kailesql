/* Copyright 2024 drawmoon */

package io.github.drawmoon.saber.impl;

import io.github.drawmoon.saber.Condition;
import io.github.drawmoon.saber.Operator;

/**
 * The logical expression.
 *
 * <p>Combine this condition with another condition using the specified operator.
 */
public final class Logical {

  Condition Left;
  Condition Right;
  Operator Operator;
}
