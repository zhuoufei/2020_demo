package com.zf.mo;

import java.util.Arrays;

public class Bubble {

    public static void sort(int[] arr){

        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j < arr.length-1 - i; j++) {
                int temp = 0;
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("冒泡排序:"+ Arrays.toString(arr));
    }

}

class Test{
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        Bubble.sort(arr);
    }
}


