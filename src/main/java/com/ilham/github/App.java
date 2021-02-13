package com.ilham.github;

import com.ilham.github.datastructures.hashmap.HashMap;

public class App {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(4, 40);
        map.put(5, 50);
        map.put(6, 60);
        map.put(7, 70);
        map.put(8, 80);
        map.put(12, 120);
        map.put(30, 300);
        map.put(47, 470);
        map.put(65, 650);

        System.out.println(map.get(65));
    }
}
