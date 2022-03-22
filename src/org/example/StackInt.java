package org.example;

public class StackInt {
  private final int maxSize;
  private final int[] items;
  private int top;

  public StackInt(int maxSize) {
    this.maxSize = maxSize;
    this.items = new int[maxSize];
    this.top = -1;
  }

  public boolean isFull() {
    return this.top == this.maxSize - 1;
  }

  public boolean isNull() {
    return this.top <= -1;
  }

  public void push(int value) {
    if (this.isFull()) {
      return;
    }
    this.items[++this.top] = value;
  }

  public int pop() {
    if (this.isNull()) {
      throw new RuntimeException("NULL STACK");
    }
    int value = this.items[top];
    --top;
    return value;
  }
}
