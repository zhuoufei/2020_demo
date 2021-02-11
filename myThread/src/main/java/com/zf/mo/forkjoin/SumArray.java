package com.zf.mo.forkjoin;

import com.zf.mo.utils.MakeArray;
import com.zf.mo.utils.SleepTool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumArray{


    private static class SumTask extends RecursiveTask<Integer> {

        private static int THRESHOLD = MakeArray.ARRAY_LENGTH /10;
        private int fromIndex;
        private int toIndex;
        private int[] src;
        public SumTask(int[] src,int fromIndex,int toIndex){
            this.src = src;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @Override
        protected Integer compute() {
            System.out.println("-----------1-----------");
            if(toIndex - fromIndex < THRESHOLD){
                SleepTool.sleepSeconds(1);
                int count = 0;
                for (int i = fromIndex; i <=toIndex ; i++) {
                    count += src[i];
                }
                System.out.println("----------2------------fromIndex:"+fromIndex+" ,toIndex:"+toIndex);
                return count;
            }else{
                System.out.println("--------3--------------");
                int mid = (toIndex + fromIndex)/2;
                SumTask left = new SumTask(src,fromIndex,mid);
                SumTask right = new SumTask(src,mid+1,toIndex);
                invokeAll(left,right);
                System.out.println("----------4-----------fromIndex:"+fromIndex+" ,toIndex:"+toIndex);

                return left.join()+right.join();
            }
        }
    }

    public static void main(String[] args) {
        int[] array = MakeArray.makeArray();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SumTask sumTask = new SumTask(array, 0, array.length - 1);
        forkJoinPool.invoke(sumTask);
        System.out.println("----------------------");
    }

}
