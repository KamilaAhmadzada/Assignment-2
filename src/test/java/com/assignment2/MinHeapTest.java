package com.assignment2;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class MinHeapTest {

    @Test
    void emptyHeapThrows() {
        MinHeap heap = new MinHeap();
        assertThrows(IllegalStateException.class, heap::peekMin);
        assertThrows(IllegalStateException.class, heap::extractMin);
    }

    @Test
    void oneElement() {
        MinHeap heap = new MinHeap();
        heap.insert(5);
        assertEquals(5, heap.peekMin());
        assertEquals(5, heap.extractMin());
    }

    @Test
    void multipleElements() {
        MinHeap heap = new MinHeap();
        int[] values = {5, 3, 8, 1, 9, 2};
        for (int v : values) heap.insert(v);
        assertEquals(1, heap.peekMin());
    }

    @Test
    void duplicateValues() {
        MinHeap heap = new MinHeap();
        heap.insert(4); heap.insert(4); heap.insert(4);
        assertEquals(4, heap.extractMin());
        assertEquals(4, heap.extractMin());
        assertEquals(4, heap.extractMin());
    }

    @Test
    void extractsInNonDecreasingOrder() {
        MinHeap heap = new MinHeap();
        Random random = new Random(42);
        int n = 1000;
        for (int i = 0; i < n; i++) heap.insert(random.nextInt(10000));

        int previous = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int extracted = heap.extractMin();
            assertTrue(extracted >= previous);
            previous = extracted;
        }
    }

    @Test
    void largeInput() {
        MinHeap heap = new MinHeap();
        for (int i = 100000; i > 0; i--) heap.insert(i);
        assertEquals(1, heap.peekMin());
    }
}