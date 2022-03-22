package org.example;

import java.lang.reflect.Array;

public class StackGeneric<T> {
  private final int maxSize;
  private final T[] items;
  private int top;

  public StackGeneric(int maxSize, Class<T> clazz) {
    this.maxSize = maxSize;
    this.items = this.createArray(clazz); // 通过元类实例化范型
    this.top = -1;
  }

  public boolean isFull() {
    return this.top == this.maxSize - 1;
  }

  public boolean isNull() {
    return this.top <= -1;
  }

  public void push(T value) {
    if (this.isFull()) {
      return;
    }
    this.items[++this.top] = value;
  }

  public T pop() {
    if (this.isNull()) {
      throw new RuntimeException("NULL STACK");
    }
    T value = this.items[top];
    --top;
    return value;
  }

  // 通过元类创建一个数组
  private T[] createArray(Class<T> tClass) {
    return (T[]) Array.newInstance(tClass, this.maxSize);
  }
}
