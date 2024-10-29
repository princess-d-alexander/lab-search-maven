package edu.grinnell.csc207;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.util.SearchUtils;

/**
 * Tests of our search methods.
 *
 * @author Princess Alexander
 * @author Sal Karki
 * @author Samuel A. Rebelsky
 */
public class TestSearch {
  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * A string version of a call to binary search.
   *
   * @param values
   *   The array.
   * @param val
   *   The value we're searching for.
   *
   * @return
   *   The string "binarySearch(values, val)"
   */
  String bsCall(int[] values, int val) {
    return String.format("binarySearch(%s, %d)", Arrays.toString(values), val);
  } // bsCall

  /**
   * Assert that a search for a particular value finds the value at that
   * index.
   *
   * @param expected
   *   The expected index.
   * @param values
   *   The array we're searching.
   * @param val
   *   The value we're searching for.
   */
  void assertBinarySearchFinds(int expected, int[] values, int val) 
      throws Exception {
    assertEquals(expected, SearchUtils.binarySearch(values, val),
        () -> bsCall(values, val));
  } // assertBinarySearchFinds(int, int[], int)

  /**
   * Assert that a search for a particular value fails (hopefully, because 
   * the value * is not in the array).
   *
   * @param values
   *   The array we're searching.
   * @param val
   *   The value we're searching for.
   */
  void assertBinarySearchFails(int[] values, int val) throws Exception {
    assertThrows(Exception.class,
        () -> SearchUtils.binarySearch(values, val),
        () -> bsCall(values, val));
  } // assertBinarySearchFails()

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * Searching the empty array should fail.
   */
  @Test
  void testBinarySearchEmpty() throws Exception {
    assertBinarySearchFails(new int[] { }, 0);
  } // testSearchEmpty()

  /**
   * Searching in a one-element array.
   */
  @Test
  void testBinarySearchOne() throws Exception {
    assertBinarySearchFinds(0, new int[] { 5 }, 5);
    assertBinarySearchFails(new int[] { 5 }, 0);
    assertBinarySearchFails(new int[] { 5 }, 10);
  } // testBinarySearchOne()

  /**
   * Searching in a two-element array.
   */
  @Test
  void testBinarySearchTwo() throws Exception {
    assertBinarySearchFinds(0, new int[] { 7, 11 }, 7);
    assertBinarySearchFinds(1, new int[] { 7, 11 }, 11);
    assertBinarySearchFails(new int[] { 7, 11 }, 0);
    assertBinarySearchFails(new int[] { 7, 11 }, 10);
    assertBinarySearchFails(new int[] { 7, 11 }, 20);
  } // testBinarySearchTwo()

  /**
   * Searching in a one-element array with negative numbers.
   */
  @Test
  void testBinarySearchNegativeOne() throws Exception {
    assertBinarySearchFinds(0, new int[] { -6 }, -6);
    assertBinarySearchFails(new int[] { -6 }, 0);
    assertBinarySearchFails(new int[] { -6 }, 10);
  } // testBinarySearchNegativeOne()


  /**
   * Searching an five-element array
   */
  @Test
  void testBinarySearchFive() throws Exception {
    assertBinarySearchFinds(0, new int[] { 5, 4, 3, 2, 1}, 5);
    assertBinarySearchFinds(0, new int[] { 5, 4, 3, 2, 1}, 4);
    assertBinarySearchFinds(0, new int[] { 5, 4, 3, 2, 1}, 3);
    assertBinarySearchFinds(0, new int[] { 5, 4, 3, 2, 1}, 2);
    assertBinarySearchFinds(0, new int[] { 5, 4, 3, 2, 1}, 1);
    assertBinarySearchFails(new int[] { 5, 4, 3, 2, 1}, 0);
    assertBinarySearchFails(new int[] { 5, 4, 3, 2, 1}, 10);
    assertBinarySearchFails(new int[] { 5, 4, 3, 2, 1}, 20);
    assertBinarySearchFails(new int[] { 5, 4, 3, 2, 1}, 30);
    assertBinarySearchFails(new int[] { 5, 4, 3, 2, 1}, 40);
    assertBinarySearchFails(new int[] { 5, 4, 3, 2, 1}, 50);
  } // testBinarySearchFive()

} // class TestSearch
