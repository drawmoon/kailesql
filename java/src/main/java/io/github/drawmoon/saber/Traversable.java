/* Copyright 2024 drawmoon */

package io.github.drawmoon.saber;

import java.util.function.Function;

/**
 * An interface for inherently recursive, multi-valued data structures. The order of elements is
 * determined by {@link Iterable#iterator()}, which may vary each time it is called.
 */
public interface Traversable<T> extends Iterable<T> {

  /**
   * Collects all elements that are in the domain of the given {@code partialFunction} by mapping
   * the elements to type {@code R}.
   *
   * @param <R> the type of the result
   * @param function a function that is not necessarily defined of all elements of this traversable
   * @return a new <code>Traversable</code> instance containing elements of type <code>R</code>
   */
  <R> Traversable<R> collect(Function<? super T, ? extends R> function);
}
