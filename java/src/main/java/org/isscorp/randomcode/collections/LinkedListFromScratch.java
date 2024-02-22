package org.isscorp.randomcode.collections;

import java.util.StringJoiner;

/**
 * simple implementation for data structures course
 */
public class LinkedListFromScratch {

  private Node head;

  private int count;

  public LinkedListFromScratch(final Node head) {
    this.head = head;
    if (head != null) {
      count++;
    }
  }

  public Node getHead() {
    return head;
  }

  /**
   * navigates through the nodes using the next one until reaches <code>index</code> amount of times.
   *
   * @param index the position in the list. first position is zero.
   * @return the object in the <code>index</code> position. throws {@link IndexOutOfBoundsException} in case the node is
   * <code>null</code> at the position requested.
   */
  public Node getByPosition(final int index) {

    if (index < 0) {
      throw new IndexOutOfBoundsException("index " + index + " is lower than zero");
    }

    if (index >= this.getSize()) {
      throw new IndexOutOfBoundsException("index " + index + " is higher or equal than list size (" + this.getSize() + "). first position "
          + "is 0 (zero)");
    }

    var pointer = index;

    var currNode = this.head;
    while (pointer > 0) {
      currNode = currNode.getNextNode();
      if (currNode == null) {
        throw new IndexOutOfBoundsException("index " + index + " is out of bounds! current size: " + this.getSize());
      }
      pointer--;
    }
    return currNode;
  }

  public int getSize() {
    return count;
  }

  /**
   * always add to the head of the table
   *
   * @param data the int to be added to the linked list
   */
  public void addData(final int data) {
    var newNode = new Node(data);
    if (this.head != null) {
      newNode.addNextNode(this.head);
    }
    this.head = newNode;
    count++;
  }

  @Override
  public String toString() {
    final var toString = new StringJoiner(" ");
    toString.add("CoolLinkedList [");

    if (this.head != null) {
      final var nodeStringJoiner = new StringJoiner(", ");
      nodeStringJoiner.add(this.head.toString());

      var nextNode = this.head.getNextNode();
      while (nextNode != null) {
        nodeStringJoiner.add(nextNode.toString());
        nextNode = nextNode.getNextNode();
      }

      toString.merge(nodeStringJoiner);
    }

    toString.add("]");

    return toString.toString();
  }

}
