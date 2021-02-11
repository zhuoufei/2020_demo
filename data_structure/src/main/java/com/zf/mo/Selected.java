package com.zf.mo;

import java.util.Arrays;

public class Selected {

    public static void sort(int[] arr){

        for (int i = 0; i < arr.length-2; i++) {
            int midIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[midIndex] > arr[j]){
                    midIndex = j;
                }
            }
            int temp ;
            temp = arr[midIndex];
            arr[midIndex] = arr[i];
            arr[i] = temp;
        }

        System.out.println("选择排序:"+Arrays.toString(arr));

    }

}

class SelectedTest{

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        Selected.sort(arr);
    }
}
