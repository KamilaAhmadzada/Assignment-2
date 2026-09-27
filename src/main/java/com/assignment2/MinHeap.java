package com.assignment2;

public class MinHeap {
    public static long comparisons = 0;
    private int[] data;
    private int size;

    public MinHeap() {
        data = new int[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public void insert(int x) {
        if (size == data.length) {
            resize();
        }
        data[size] = x;
        int current = size;
        size++;

        while (current > 0) {
            comparisons++;
            if (data[current] < data[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            } else {
                break;
            }
        }
    }

    private void resize() {
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    public int peekMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return data[0];
    }
    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = data[0];
        data[0] = data[size - 1];
        size--;
        siftDown(0);
        return min;
    }

    private void siftDown(int i) {
        while (true) {
            int left = leftChild(i);
            int right = rightChild(i);
            int smallest = i;

            if (left < size) {
                comparisons++;
                if (data[left] < data[smallest]) {
                    smallest = left;
                }
            }
            if (right < size) {
                comparisons++;
                if (data[right] < data[smallest]) {
                    smallest = right;
                }
            }

            if (smallest == i) {
                break;
            }

            swap(i, smallest);
            i = smallest;
        }
    }
}
