package com.assignment2;

public class Main {
    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray();
        for (int i = 0; i < 15; i++) {
            arr.add(i);
        }
        System.out.println("Size: " + arr.size());
        System.out.println("Element at index 3: " + arr.get(3));
        System.out.println("Element at index 14: " + arr.get(14));
        arr.add(0, 999);
        System.out.println("After inserting 999 at index 0: " + arr.get(0));
        System.out.println("Old index 0 now at index 1: " + arr.get(1));
        System.out.println("Size after insert: " + arr.size());
        int removedValue = arr.remove(0);
        System.out.println("Removed value: " + removedValue);
        System.out.println("New index 0: " + arr.get(0));
        System.out.println("Size after remove: " + arr.size());
        System.out.println("Contains 7? " + arr.contains(7));
        System.out.println("Contains 999? " + arr.contains(999));
        LinkedList list = new LinkedList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        MinHeap heap = new MinHeap();
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        System.out.println("Heap size: " + heap.size());
        System.out.println("Min element: " + heap.peekMin());
        System.out.println("Extracted: " + heap.extractMin());
        System.out.println("New min: " + heap.peekMin());
        System.out.println("Heap size after extract: " + heap.size());
        System.out.println("LinkedList size: " + list.size());
        System.out.println("LinkedList element at index 2: " + list.get(2));
        System.out.println("LinkedList element at index 4: " + list.get(4));
        list.add(0, 999);
        System.out.println("LinkedList after inserting 999 at index 0: " + list.get(0));
        System.out.println("Old index 0 now at index 1: " + list.get(1));
        System.out.println("LinkedList size after insert: " + list.size());
        int removedFromList = list.remove(0);
        System.out.println("Removed from LinkedList: " + removedFromList);
        System.out.println("New index 0: " + list.get(0));
        System.out.println("LinkedList size after remove: " + list.size());
        System.out.println("LinkedList contains 3? " + list.contains(3));
        System.out.println("LinkedList contains 999? " + list.contains(999));
        }



    }

