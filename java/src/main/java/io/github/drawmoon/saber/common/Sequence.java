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
package io.github.drawmoon.saber.common;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import javax.annotation.CheckForNull;

/** Utility methods pertaining to Collection instances. */
public final class Sequence<T> implements Enumerable<T> {

  private Sequence() {}

  public static <T> Sequence<T> it(Collection<T> coll) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns a {@link Sequence} containing only elements matching the given predicate.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("apple", "banana", "pear");
   * Sequence&lt;String&gt; seq = Sequence.it(list).filter(s -&gt s.startsWith("a"));</pre>
   *
   * @param predicate a non-interfering, stateless predicate to apply to each element to determine
   *     if it should be included
   * @return the filtered Sequence
   */
  public Sequence<T> filter(Predicate<? super T> predicate) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns a {@link Sequence} containing only elements matching the given predicate.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("apple", "banana", "pear");
   * Sequence&lt;String&gt; seq = Sequence.it(list).filter((s, i) -&gt s.startsWith("a") || i % 2 == 0);
   * </pre>
   *
   * @param predicate a non-interfering, stateless predicate to apply to each element to determine
   *     if it should be included
   * @return the new Sequence
   */
  public Sequence<T> filter(BiPredicate<? super T, Integer> predicate) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns a {@link Sequence} containing all elements not matching the given predicate.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("apple", "banana", "pear");
   * Sequence&lt;String&gt; seq = Sequence.it(list).filterNot(s -&gt s.startsWith("a"));</pre>
   *
   * @param predicate a non-interfering, stateless predicate to apply to each element to determine
   *     if it should be included
   * @return the new Sequence
   */
  public Sequence<T> filterNot(Predicate<? super T> predicate) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns a {@link Sequence} containing all elements not matching the given predicate.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("apple", "banana", "pear");
   * Sequence&lt;String&gt; seq = Sequence.it(list).filterNot((s, i) -&gt s.startsWith("a") || i % 2 == 0);
   * </pre>
   *
   * @param predicate a non-interfering, stateless predicate to apply to each element to determine
   *     if it should be included
   * @return the new Sequence
   */
  public Sequence<T> filterNot(BiPredicate<? super T, Integer> predicate) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns a Sequence containing all elements that are not <code>null</code>.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("apple", null, "pear");
   * Sequence&lt;String&gt; seq = Sequence.it(list).filterNotNull();</pre>
   *
   * @return the new Sequence
   */
  public Sequence<T> filterNotNull() {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns a Sequence containing the results of applying the given mapper function to each element
   * in the original Sequence.
   *
   * <p>Example usages:
   *
   * <pre>
   * Employee e1 = new Employee("John", 30);
   * Employee e2 = new Employee("Jane", 25);
   *
   * List&lt;Employee&gt; list = Arrays.asList(e1, e2);
   * Sequence&lt;String&gt; seq = Sequence.it(list).map(Employee::getName);</pre>
   *
   * @param <R> the type of the elements in the resulting Sequence
   * @param mapper the function to apply to each element
   * @return the new Sequence
   */
  public <R> Sequence<R> map(Function<? super T, ? extends R> mapper) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns a Sequence containing only the non-none results of applying the given mapper function
   * to each element in the original Sequence.
   *
   * <p>Example usages:
   *
   * <pre>
   * Employee e1 = new Employee("John", 30);
   * Employee e2 = new Employee(null, 25);
   *
   * List&lt;Employee&gt; list = Arrays.asList(e1, e2);
   * Sequence&lt;String&gt; seq = Sequence.it(list).mapNotNull(Employee::getName);</pre>
   *
   * @param <R> the type of the elements in the resulting Sequence
   * @param mapper the function to apply to each element
   * @return the new Sequence
   */
  public <R> Sequence<R> mapNotNull(Function<? super T, ? extends R> mapper) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns a Sequence containing the results of applying the given mapper function to each element
   * in the original Sequence.
   *
   * <p>Example usages:
   *
   * <pre>
   * Employee e1 = new Employee("John", 30);
   * Employee e2 = new Employee("Jane", 25);
   *
   * List&lt;Employee&gt; list = Arrays.asList(e1, e2);
   * Sequence&lt;String&gt; seq = Sequence.it(list).parallelMap(Employee::getName);</pre>
   *
   * @param <R> the type of the elements in the resulting Sequence
   * @param mapper the function to apply to each element
   * @return the new Sequence
   */
  public <R> Sequence<R> parallelMap(Function<? super T, ? extends R> mapper) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns a single list of all elements yielded from results of function being invoked on each
   * element of original collection.
   *
   * <p>Example usages:
   *
   * <pre>
   * String[] e1 = new String[]{"a", "b"};
   * String[] e2 = new String[]{"c", "d"};
   *
   * List&lt;String[]&gt; list = Arrays.asList(e1, e2);
   * Sequence&lt;String&gt; seq = Sequence.it(list).flatMap(x -> x);</pre>
   *
   * @param <R> the type of the elements in the resulting Sequence
   * @param mapper the function to apply to each element
   * @return the new Sequence
   */
  public <R> Sequence<R> flatMap(Function<? super T, ? extends R> mapper) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns the first element matching the given predicate.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("apple", "banana", "pear");
   * Optional&lt;String&gt; op = Sequence.it(list).find(s -&gt s.startsWith("a"));</pre>
   *
   * @param predicate a non-interfering, stateless predicate to apply to each element to determine
   *     if it should be included
   * @return returns the {@link Optional} instance
   */
  public Optional<T> find(Predicate<? super T> predicate) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns the last element matching the given predicate.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("apple", "banana", "pear");
   * Optional&lt;String&gt; op = Sequence.it(list).findLast(s -&gt s.startsWith("a"));</pre>
   *
   * @param predicate a non-interfering, stateless predicate to apply to each element to determine
   *     if it should be included
   * @return returns the {@link Optional} instance
   */
  public Optional<T> findLast(Predicate<? super T> predicate) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns the single element matching the given predicate.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("apple", "banana", "pear");
   * Optional&lt;String&gt; op = Sequence.it(list).single(s -&gt s.startsWith("a"));</pre>
   *
   * @param predicate a non-interfering, stateless predicate to apply to each element to determine
   *     if it should be included
   * @return returns the {@link Optional} instance
   * @throws IllegalStateException when there is more than one element that matches the predicate
   */
  public Optional<T> single(Predicate<? super T> predicate) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns the first element.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("apple", "banana", "pear");
   * String firstElement = Sequence.it(list).first();</pre>
   *
   * @return the first element
   * @throws NullPointerException if Sequence is empty or the selected element is null
   */
  public T first() {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns the first element.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList(null, "banana", "pear");
   * String firstElement = Sequence.it(list).firstNotNull();</pre>
   *
   * @return the first element
   * @throws NullPointerException if Sequence is empty or the selected element is null
   */
  public T firstNotNull() {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns the first element.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("apple", "banana", "pear");
   * String firstElement = Sequence.it(list).firstOrNull();</pre>
   *
   * @return returns null when Sequence is empty, or when the first element selected is null
   */
  @CheckForNull
  public T firstOrNull() {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns the first element, or the given default value if the Sequence is empty.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("apple", "banana", "pear");
   * String firstElement = Sequence.it(list).firstOrDefault("mango");</pre>
   *
   * @param defaultValue the default value
   * @return the first element, or the given default value
   */
  public T firstOrDefault(@CheckForNull T defaultValue) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns first index of element.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("apple", "banana", "pear");
   * int elementIndex = Sequence.it(list).indexOf("apple");</pre>
   *
   * @param element the element
   * @return the index of element
   */
  public int indexOf(T element) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns a Sequence containing all elements except first count elements.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("apple", "banana", "pear");
   * Sequence&lt;String&gt seq = Sequence.it(list).skip(2);</pre>
   *
   * @param count the skip count
   * @return the new Sequence
   */
  public Sequence<T> skip(int count) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns an Sequence containing first count elements.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("apple", "banana", "pear");
   * Sequence&lt;String&gt seq = Sequence.it(list).take(2);</pre>
   *
   * @param count the take count
   * @return the new Sequence
   */
  public Sequence<T> take(int count) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns an Sequence with elements in reversed order.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("apple", "banana", "pear");
   * Sequence&lt;String&gt seq = Sequence.it(list).reversed();</pre>
   *
   * @return the new Sequence
   */
  public Sequence<T> reversed() {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns an Sequence that yields elements of this Sequence sorted according to their natural
   * sort order.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("a", "b", "c");
   * Sequence&lt;String&gt seq = Sequence.it(list).sorted();</pre>
   *
   * @return the new Sequence
   */
  public Sequence<T> sorted() {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns an Sequence that yields elements of this sequence sorted according to natural sort
   * order of the value returned by specified function.
   *
   * <p>Example usages:
   *
   * <pre>
   * Employee e1 = new Employee("John", 30);
   * Employee e2 = new Employee("Jane", 25);
   *
   * List&lt;Employee&gt; list = Arrays.asList(e1, e2);
   * Sequence&lt;Employee&gt seq = Sequence.it(list).sorted(x -&gt x.getAge() &lt; 30);</pre>
   *
   * @param comparator a non-interfering, stateless {@link Comparator} to be used to compare stream
   *     elements
   * @return the new Sequence
   */
  public Sequence<T> sorted(Comparator<? super T> comparator) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns an Sequence of all elements sorted descending according to their natural sort order.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("a", "b", "c");
   * Sequence&lt;String&gt seq = Sequence.it(list).sortedDescending();</pre>
   *
   * @param comparator a non-interfering, stateless {@link Comparator} to be used to compare stream
   *     elements
   * @return the new Sequence
   */
  public Sequence<T> sortedDescending() {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns an Sequence that yields elements of this sequence sorted descending according to
   * natural sort order of the value returned by specified function.
   *
   * <p>Example usages:
   *
   * <pre>
   * Employee e1 = new Employee("John", 30);
   * Employee e2 = new Employee("Jane", 25);
   *
   * List&lt;Employee&gt; list = Arrays.asList(e1, e2);
   * Sequence&lt;Employee&gt seq = Sequence.it(list).sortedDescending(x -&gt x.getAge() &lt; 30);
   * </pre>
   *
   * @param comparator a non-interfering, stateless {@link Comparator} to be used to compare stream
   *     elements
   * @return the new Sequence
   */
  public Sequence<T> sortedDescending(Comparator<? super T> comparator) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns True if all elements of the Sequence satisfy the specified predicate function.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;Integer&gt; list = Arrays.asList(1, 2, 3);
   * boolean b = Sequence.it(list).all(x -&gt x &gt; 0);</pre>
   *
   * @param predicate a non-interfering, stateless predicate to apply to each element to determine
   *     if it should be included
   * @return true, or false
   */
  public boolean all(Predicate<T> predicate) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns True if any elements of the Sequence satisfy the specified predicate function.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;Integer&gt; list = Arrays.asList(1, 2, 3);
   * boolean b = Sequence.it(list).any(x -&gt x &gt; 0);</pre>
   *
   * @param predicate a non-interfering, stateless predicate to apply to each element to determine
   *     if it should be included
   * @return true, or false
   */
  public boolean any(Predicate<T> predicate) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns the number of elements in the Sequence that satisfy the specified predicate function.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;Integer&gt; list = Arrays.asList(1, 2, 3);
   * int num = Sequence.it(list).count(x -&gt x &gt; 0);</pre>
   *
   * @param predicate a non-interfering, stateless predicate to apply to each element to determine
   *     if it should be included
   * @return the count of elements that match the predicate
   */
  public int count(Predicate<T> predicate) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns True if the Sequence contains the specified value.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;Integer&gt; list = Arrays.asList(1, 2, 3);
   * boolean b = Sequence.it(list).contains(1);</pre>
   *
   * @param value the value
   * @return true, or false
   */
  public boolean contains(T value) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns the element at the specified index in the Sequence.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;Integer&gt; list = Arrays.asList(1, 2, 3);
   * Integer element = Sequence.it(list).elementAt(1);</pre>
   *
   * @param index index of the element to return
   * @return the element at the specified position in this Sequence
   * @throws IndexOutOfBoundsException if the index is out of range <code>
   *     (index &lt; 0 || index &gt;= size())</code>
   */
  public T elementAt(int index) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns the element at the specified index in the Sequence or the default value if the index is
   * out of bounds.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;Integer&gt; list = Arrays.asList(1, 2, 3);
   * Integer element = Sequence.it(list).elementAtOrElse(1, 1);</pre>
   *
   * @param index index of the element to return
   * @param defaultValue the default value to return if the index is out of bounds
   * @return the element at the specified position in this Sequence
   * @throws IndexOutOfBoundsException if the index is out of range <code>
   *     (index &lt; 0 || index &gt;= size())</code>
   */
  public T elementAtOrElse(int index, T defaultValue) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns the element at the specified index in the Sequence or the default value if the index is
   * out of bounds.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;Integer&gt; list = Arrays.asList(1, 2, 3);
   * Integer element = Sequence.it(list).elementAtOrElse(1, 1);</pre>
   *
   * @param index index of the element to return
   * @param function the callable function
   * @return the element at the specified position in this Sequence
   * @throws IndexOutOfBoundsException if the index is out of range <code>
   *     (index &lt; 0 || index &gt;= size())</code>
   */
  public T elementAtOrElse(int index, Function<? super T, ? extends T> function) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns a new Sequence containing the distinct elements of the given Sequence.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;Integer&gt; list = Arrays.asList(1, 1, 2, 3);
   * Sequence&lt;Integer&gt; seq = Sequence.it(list).distinct();</pre>
   *
   * @return the new Sequence
   */
  public Sequence<T> distinct() {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns the result of applying the specified function to the given Sequence's elements.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;Integer&gt; list = Arrays.asList(1, 2, 3);
   * Optional<Integer> op = Sequence.it(list).reduce((x, y) -> x + y);</pre>
   *
   * @param function the function to apply to each element
   * @return the result
   */
  public Optional<T> reduce(BiFunction<? super T, ? super T, ? extends T> function) {
    throw new UnsupportedOperationException();
  }

  /**
   * Returns a dictionary with keys being the result of function being invoked on each element of
   * original collection and values being the corresponding elements of original collection.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;Integer&gt; list = Arrays.asList(1, 2, 3, 4);
   * Sequence<Grouping<Integer, Integer>> seq = Sequence.it(list).groupBy(x -> x % 2);</pre>
   *
   * @param <K> the type of the keys
   * @param function the function mapping input elements to keys
   * @return the new Sequence
   */
  public <K> Sequence<Grouping<K, T>> groupBy(Function<? super T, ? extends K> function) {
    throw new UnsupportedOperationException();
  }

  /**
   * Invokes action function on each element of the given Sequence.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("a", "b", "c");
   * Sequence.it(list).forEach((i, x) -> {
   *   System.out.println(i + " " + x);
   * });</pre>
   *
   * @param action The action to be performed for each element
   */
  public void forEach(BiConsumer<Integer, ? super T> action) {
    throw new UnsupportedOperationException();
  }

  /**
   * Invokes action function on each element of the given Sequence in parallel.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("a", "b", "c");
   * Sequence.it(list).parallelForEach(x -> {
   *   System.out.println(x);
   * });</pre>
   *
   * @param action a non-interfering action to perform on the elements
   */
  public void parallelForEach(Consumer<? super T> action) {
    throw new UnsupportedOperationException();
  }

  /**
   * Invokes action function on each element of the given Sequence in parallel.
   *
   * <p>Example usages:
   *
   * <pre>
   * List&lt;String&gt; list = Arrays.asList("a", "b", "c");
   * Sequence.it(list).parallelForEach((i, x) -> {
   *   System.out.println(i + " " + x);
   * });</pre>
   *
   * @param action a non-interfering action to perform on the elements
   */
  public void parallelForEach(BiConsumer<Integer, ? super T> action) {
    throw new UnsupportedOperationException();
  }

  @Override
  public <R> Enumerable<R> collect(Function<? super T, ? extends R> function) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Iterator<T> iterator() {
    throw new UnsupportedOperationException();
  }

  public static final class Grouping<K, V> implements Enumerable<V> {

    K key;
    Sequence<V> values;

    @Override
    public <R> Enumerable<R> collect(Function<? super V, ? extends R> function) {
      throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<V> iterator() {
      throw new UnsupportedOperationException();
    }
  }
}
