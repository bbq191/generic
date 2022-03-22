package org.example;

public class StackObject {
  private final int maxSize;
  private final Object[] items;
  private int top;

  public StackObject(int maxSize) {
    this.maxSize = maxSize;
    this.items = new Object[maxSize];
    this.top = -1;
  }

  public boolean isFull() {
    return this.top == this.maxSize - 1;
  }

  public boolean isNull() {
    return this.top <= -1;
  }

  public void push(Object value) {
    if (this.isFull()) {
      return;
    }
    this.items[++this.top] = value;
  }

  public Object pop() {
    if (this.isNull()) {
      throw new RuntimeException("NULL STACK");
    }
    Object value = this.items[top];
    --top;
    return value;
  }
}
