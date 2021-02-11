package com.zf.mo;

import java.util.Arrays;

public class Inserted {


    public static void sort(int[] arr){

        for (int i = 1; i <arr.length ; i++) {
            int j = i;
            while(j > 0){
                int temp;
                if(arr[j] < arr[j-1]){
                    temp =arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
                j--;
            }

        }
        System.out.println(Arrays.toString(arr));

    }

}

class Test3{
    public static void main(String[] args) {
        int arr[] = {3,4,7,2,1,8,6,9};
        Inserted.sort(arr);
    }
}
