package com.henry.test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        // 打乱索引 (1 - 15)
        int[] tmp = new int[15];
        for (int i = 0; i < 15; i++) {
            tmp[i] = i + 1;
        }
        Random r = new Random();
        for (int i = 0; i < 15; i++) {
            int idx = r.nextInt(tmp.length);
            int t = tmp[idx];
            tmp[idx] = tmp[i];
            tmp[i] = t;
        }
        for (int i = 0; i < 15; i++) {
            System.out.println(tmp[i]);
        }
    }
}
