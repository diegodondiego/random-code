package org.isscorp.randomcode.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListFromScratchTest {

  private Node testNode;

  private LinkedListFromScratch linkedListFromScratch;

  @BeforeEach
  void setUp() {
    testNode = new Node(0);
    linkedListFromScratch = new LinkedListFromScratch(testNode);
  }

  @AfterEach
  void afterEach() {
    System.out.println(linkedListFromScratch);
  }

  @Test
  void instantiateWithNullHead() {
    var linkedListFromScratch = new LinkedListFromScratch(null);
    assertEquals(0, linkedListFromScratch.getSize());
  }

  @Test
  void instantiateWithHead() {
    assertEquals(1, linkedListFromScratch.getSize());
    assertEquals(testNode, linkedListFromScratch.getHead());
  }

  @Test
  void addAnotherNode() {
    linkedListFromScratch.addData(2);
    assertEquals(2, linkedListFromScratch.getSize());
    assertEquals(new Node(2), linkedListFromScratch.getHead());
  }

  @Test
  void getNodeByPositionWithInvalidPosition() {
    final var exceptionIndexBiggerThanSize = assertThrows(IndexOutOfBoundsException.class,
        () -> linkedListFromScratch.getByPosition(1));

    assertEquals("index 1 is higher or equal than list size (1). first position is 0 (zero)", exceptionIndexBiggerThanSize.getMessage());

    final var exceptionNegativeIndex = assertThrows(IndexOutOfBoundsException.class,
        () -> linkedListFromScratch.getByPosition(-1));
    assertEquals("index -1 is lower than zero", exceptionNegativeIndex.getMessage());
  }

  @Test
  void getNodeByPosition() {
    assertEquals(testNode, linkedListFromScratch.getByPosition(0));
    for (int i = 0; i < 100; i++) {
      linkedListFromScratch.addData(i);
    }
    assertEquals(new Node(99 - 42), linkedListFromScratch.getByPosition(42));
  }

}
