package com.assignment2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTest {

    @Test
    void emptyStructure() {
        DynamicArray arr = new DynamicArray();
        assertEquals(0, arr.size());
        assertFalse(arr.contains(1));
    }

    @Test
    void oneElement() {
        DynamicArray arr = new DynamicArray();
        arr.add(5);
        assertEquals(1, arr.size());
        assertEquals(5, arr.get(0));
    }

    @Test
    void multipleElements() {
        DynamicArray arr = new DynamicArray();
        for (int i = 0; i < 20; i++) arr.add(i);
        assertEquals(20, arr.size());
        assertEquals(10, arr.get(10));
    }

    @Test
    void duplicateValues() {
        DynamicArray arr = new DynamicArray();
        arr.add(7); arr.add(7); arr.add(7);
        assertTrue(arr.contains(7));
        assertEquals(3, arr.size());
    }

    @Test
    void boundaryIndices() {
        DynamicArray arr = new DynamicArray();
        arr.add(1); arr.add(2); arr.add(3);
        assertEquals(1, arr.get(0));
        assertEquals(3, arr.get(2));
    }

    @Test
    void invalidIndicesThrow() {
        DynamicArray arr = new DynamicArray();
        arr.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.remove(5));
    }

    @Test
    void largeInput() {
        DynamicArray arr = new DynamicArray();
        for (int i = 0; i < 50000; i++) arr.add(i);
        assertEquals(50000, arr.size());
        assertEquals(25000, arr.get(25000));
    }

    @Test
    void insertAndRemoveConsistency() {
        DynamicArray arr = new DynamicArray();
        arr.add(1); arr.add(2); arr.add(3);
        arr.add(1, 99);
        assertEquals(99, arr.get(1));
        int removed = arr.remove(1);
        assertEquals(99, removed);
        assertEquals(2, arr.get(1));
    }
}