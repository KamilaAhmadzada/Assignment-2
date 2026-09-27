package com.assignment2;

import java.util.Random;

public class Benchmark {
    public static int[] generateRandomArray(int n, long seed) {
        Random random = new Random(seed);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(1_000_000);
        }
        return arr;
    }

    public static int[] generateRandomIndices(int count, int bound, long seed) {
        Random random = new Random(seed);
        int[] indices = new int[count];
        for (int i = 0; i < count; i++) {
            indices[i] = random.nextInt(bound);
        }
        return indices;
    }

    public static void runWorkload1() throws java.io.IOException {
        int[] sizes = {100, 1000, 10000, 100000};

        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter("results/tables/workload1.csv"))) {
            writer.println("structure,n,timeMs,accesses");

            for (int n : sizes) {
                int[] values = generateRandomArray(n, 42);
                int[] indices = generateRandomIndices(10000, n, 42);

                DynamicArray dArr = new DynamicArray();
                for (int v : values) dArr.add(v);

                LinkedList lList = new LinkedList();
                for (int v : values) lList.add(v);

                long dArrTime = timeDynamicArrayAccess(dArr, indices);
                writer.println("DynamicArray," + n + "," + dArrTime + "," + indices.length);

                LinkedList.nodeAccesses = 0;
                long lListTime = timeLinkedListAccess(lList, indices);
                writer.println("LinkedList," + n + "," + lListTime + "," + LinkedList.nodeAccesses);

                System.out.println("n=" + n + " | DynamicArray: " + dArrTime + "ms | LinkedList: " + lListTime + "ms, accesses=" + LinkedList.nodeAccesses);
            }
        }
    }

    private static long timeDynamicArrayAccess(DynamicArray arr, int[] indices) {
        long start = System.nanoTime();
        for (int idx : indices) {
            arr.get(idx);
        }
        long end = System.nanoTime();
        return (end - start) / 1_000_000;
    }

    private static long timeLinkedListAccess(LinkedList list, int[] indices) {
        long start = System.nanoTime();
        for (int idx : indices) {
            list.get(idx);
        }
        long end = System.nanoTime();
        return (end - start) / 1_000_000;
    }

    public static void runWorkload2() throws java.io.IOException {
        int[] sizes = {100, 1000, 10000, 100000};

        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter("results/tables/workload2.csv"))) {
            writer.println("structure,n,timeMs,comparisons");

            for (int n : sizes) {
                int[] values = generateRandomArray(n, 42);
                int[] searchValues = generateRandomArray(1000, 99);

                DynamicArray dArr = new DynamicArray();
                for (int v : values) dArr.add(v);

                LinkedList lList = new LinkedList();
                for (int v : values) lList.add(v);

                DynamicArray.comparisons = 0;
                long start1 = System.nanoTime();
                for (int v : searchValues) dArr.contains(v);
                long dArrTime = (System.nanoTime() - start1) / 1_000_000;
                writer.println("DynamicArray," + n + "," + dArrTime + "," + DynamicArray.comparisons);

                LinkedList.comparisons = 0;
                long start2 = System.nanoTime();
                for (int v : searchValues) lList.contains(v);
                long lListTime = (System.nanoTime() - start2) / 1_000_000;
                writer.println("LinkedList," + n + "," + lListTime + "," + LinkedList.comparisons);

                System.out.println("n=" + n + " | DynamicArray: " + dArrTime + "ms, comparisons=" + DynamicArray.comparisons +
                        " | LinkedList: " + lListTime + "ms, comparisons=" + LinkedList.comparisons);
            }
        }
    }
    public static void runWorkload3() throws java.io.IOException {
        int[] sizes = {100, 1000, 10000, 100000};

        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter("results/tables/workload3.csv"))) {
            writer.println("structure,operation,position,n,timeMs");

            for (int n : sizes) {
                int[] values = generateRandomArray(n, 42);
                int[] insertValues = generateRandomArray(1000, 77);
                int removeCount = Math.min(1000, n);

                DynamicArray dArr = new DynamicArray();
                for (int v : values) dArr.add(v);
                long start = System.nanoTime();
                for (int v : insertValues) dArr.add(0, v);
                long time = (System.nanoTime() - start) / 1_000_000;
                writer.println("DynamicArray,insert,0," + n + "," + time);

                LinkedList lList = new LinkedList();
                for (int v : values) lList.add(v);
                start = System.nanoTime();
                for (int v : insertValues) lList.add(0, v);
                time = (System.nanoTime() - start) / 1_000_000;
                writer.println("LinkedList,insert,0," + n + "," + time);

                dArr = new DynamicArray();
                for (int v : values) dArr.add(v);
                start = System.nanoTime();
                for (int i = 0; i < removeCount; i++) dArr.remove(0);
                time = (System.nanoTime() - start) / 1_000_000;
                writer.println("DynamicArray,remove,0," + n + "," + time);

                lList = new LinkedList();
                for (int v : values) lList.add(v);
                start = System.nanoTime();
                for (int i = 0; i < removeCount; i++) lList.remove(0);
                time = (System.nanoTime() - start) / 1_000_000;
                writer.println("LinkedList,remove,0," + n + "," + time);

                dArr = new DynamicArray();
                for (int v : values) dArr.add(v);
                start = System.nanoTime();
                for (int v : insertValues) dArr.add(dArr.size() / 2, v);
                time = (System.nanoTime() - start) / 1_000_000;
                writer.println("DynamicArray,insert,middle," + n + "," + time);

                lList = new LinkedList();
                for (int v : values) lList.add(v);
                start = System.nanoTime();
                for (int v : insertValues) lList.add(lList.size() / 2, v);
                time = (System.nanoTime() - start) / 1_000_000;
                writer.println("LinkedList,insert,middle," + n + "," + time);

                dArr = new DynamicArray();
                for (int v : values) dArr.add(v);
                start = System.nanoTime();
                for (int i = 0; i < removeCount; i++) dArr.remove(dArr.size() / 2);
                time = (System.nanoTime() - start) / 1_000_000;
                writer.println("DynamicArray,remove,middle," + n + "," + time);

                lList = new LinkedList();
                for (int v : values) lList.add(v);
                start = System.nanoTime();
                for (int i = 0; i < removeCount; i++) lList.remove(lList.size() / 2);
                time = (System.nanoTime() - start) / 1_000_000;
                writer.println("LinkedList,remove,middle," + n + "," + time);

                System.out.println("n=" + n + " done");
            }
        }
    }
    public static void runWorkload4() throws java.io.IOException {
        int[] sizes = {100, 1000, 10000, 100000};

        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter("results/tables/workload4.csv"))) {
            writer.println("n,insertTimeMs,extractTimeMs,comparisons,sortedCorrectly");

            for (int n : sizes) {
                int[] values = generateRandomArray(n, 42);

                MinHeap.comparisons = 0;
                MinHeap heap = new MinHeap();
                long start = System.nanoTime();
                for (int v : values) heap.insert(v);
                long insertTime = (System.nanoTime() - start) / 1_000_000;

                start = System.nanoTime();
                int previous = Integer.MIN_VALUE;
                boolean sortedCorrectly = true;
                for (int i = 0; i < n; i++) {
                    int extracted = heap.extractMin();
                    if (extracted < previous) {
                        sortedCorrectly = false;
                    }
                    previous = extracted;
                }
                long extractTime = (System.nanoTime() - start) / 1_000_000;

                writer.println(n + "," + insertTime + "," + extractTime + "," + MinHeap.comparisons + "," + sortedCorrectly);
                System.out.println("n=" + n + " | insert=" + insertTime + "ms | extract=" + extractTime + "ms | sortedCorrectly=" + sortedCorrectly);
            }
        }
    }
}