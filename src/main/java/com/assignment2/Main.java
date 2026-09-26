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
    }

}