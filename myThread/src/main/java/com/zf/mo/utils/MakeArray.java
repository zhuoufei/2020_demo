package com.zf.mo.utils;

import java.util.Random;

public class MakeArray {

    public static int ARRAY_LENGTH = 4000;

    public static int[] makeArray(){
        Random random = new Random();

        int [] arr = new int[ARRAY_LENGTH];
        for (int j = 0; j < ARRAY_LENGTH; j++) {
            arr[j] = random.nextInt(ARRAY_LENGTH * 3);
        }
        return arr;
    }
}
