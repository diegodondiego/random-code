package org.isscorp.randomcode.collections;

import java.util.Objects;

/**
 * A node in a linked list
 */
public class Node {

  private final int data;

  private Node next;

  public Node(int data) {
    this.data = data;
  }

  public int getData() {
    return this.data;
  }

  public void addNextNode(final Node nextNode) {
    this.next = nextNode;
  }

  public Node getNextNode() {
    return this.next;
  }

  @Override
  public String toString() {
    return "Node{" +
        "data=" + data +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return this.hashCode() == o.hashCode();
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }
}
