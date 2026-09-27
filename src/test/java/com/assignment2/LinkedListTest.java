package com.assignment2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    void emptyStructure() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.size());
        assertFalse(list.contains(1));
    }

    @Test
    void oneElement() {
        LinkedList list = new LinkedList();
        list.add(5);
        assertEquals(1, list.size());
        assertEquals(5, list.get(0));
    }

    @Test
    void multipleElements() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 20; i++) list.add(i);
        assertEquals(20, list.size());
        assertEquals(10, list.get(10));
    }

    @Test
    void duplicateValues() {
        LinkedList list = new LinkedList();
        list.add(7); list.add(7); list.add(7);
        assertTrue(list.contains(7));
        assertEquals(3, list.size());
    }

    @Test
    void boundaryIndices() {
        LinkedList list = new LinkedList();
        list.add(1); list.add(2); list.add(3);
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(2));
    }

    @Test
    void invalidIndicesThrow() {
        LinkedList list = new LinkedList();
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
    }

    @Test
    void largeInput() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 50000; i++) list.add(i);
        assertEquals(50000, list.size());
        assertEquals(25000, list.get(25000));
    }

    @Test
    void insertAndRemoveConsistency() {
        LinkedList list = new LinkedList();
        list.add(1); list.add(2); list.add(3);
        list.add(1, 99);
        assertEquals(99, list.get(1));
        int removed = list.remove(1);
        assertEquals(99, removed);
        assertEquals(2, list.get(1));
    }
}