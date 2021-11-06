package com.erotourtes.qeues;

import java.util.Arrays;

public class ArrayQueue<T> {
    private T[] array;
    private int front, rear;
    private int count;

    public ArrayQueue(int capacity) {
        array = (T[])new Object[capacity];
    }

    public T enqueue(T item) {
        if(isFull())
            throw new QueueOverflowError("queue is full");
        //[0, 0, 0, 1, 2, 3, 4]
        ///circular array
        // [0, 0, 2, 3, 4]
        //                 R
        //5->0  6->1; when length = 5
        //10->0 11->1;
        array[rear] = item;
        rear = (rear + 1) % array.length;
        count++;
        return item;
    }

    public T dequeue() {
        if(isEmpty())
            throw new IllegalStateException();
        T tempValue = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        count--;
        return tempValue;
    }

    public T peek() {
        return array[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array) + "\n Front = " + front;
    }
}
