package com.czecht.java;

import java.io.IOException;
import java.util.*;

public class CollectionTest {

    public static void main(String[] args) throws IOException {
        List tmpList = Arrays.asList("A", "D", "G", "B", "D");

        //java.util.Collection
        List<String> arrayList = new ArrayList<>(tmpList);

        List<String> linkedList = new LinkedList<>(tmpList);

        Queue<String> linkedQueue = new LinkedList<>(tmpList);

        Set<String> treeSet = new TreeSet<>(tmpList);

        Set<String> hashSet = new HashSet<>(tmpList);

        System.out.println("tmpList:            " + tmpList);
        System.out.println("arrayList:          " + arrayList);
        System.out.println("linkedList:         " + linkedList);
        System.out.println("linkedList.get(2):  " + linkedList.get(2));
        System.out.println("linkedQueue:        " + linkedQueue);
        System.out.println("treeSet:            " + treeSet);
        System.out.println("hashSet:            " + hashSet);

        //java.util.Map
        Map<String, String> treeMap = new TreeMap<>();

        Map<String, String> hashMap = new HashMap<>();

        Map<String, String> weakHashMap = new WeakHashMap<>();
    }

}
