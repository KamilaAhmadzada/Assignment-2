package com.assignment2;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class StandardCollectionsComparisonTest {

    @Test
    void dynamicArrayMatchesArrayList() {
        DynamicArray myArr = new DynamicArray();
        ArrayList<Integer> javaArr = new ArrayList<>();

        Random random = new Random(42);
        for (int i = 0; i < 1000; i++) {
            int v = random.nextInt(10000);
            myArr.add(v);
            javaArr.add(v);
        }

        for (int i = 0; i < 1000; i++) {
            assertEquals(javaArr.get(i), myArr.get(i));
        }
        assertEquals(javaArr.size(), myArr.size());
    }

    @Test
    void minHeapMatchesPriorityQueue() {
        MinHeap myHeap = new MinHeap();
        PriorityQueue<Integer> javaHeap = new PriorityQueue<>();

        Random random = new Random(42);
        for (int i = 0; i < 1000; i++) {
            int v = random.nextInt(10000);
            myHeap.insert(v);
            javaHeap.add(v);
        }

        while (!javaHeap.isEmpty()) {
            assertEquals(javaHeap.poll(), myHeap.extractMin());
        }
    }
}
