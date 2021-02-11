package com.zf.mo.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class FindDiskFile extends RecursiveAction {

    private File path;
   public FindDiskFile(File path){
       this.path = path;
   }
    @Override
    protected void compute() {
        File[] files = path.listFiles();
        if(files != null){
            List<FindDiskFile> findDiskFiles = new ArrayList<>();
            for (File file:files){
                if(file.isDirectory()){
                    findDiskFiles.add(new FindDiskFile(file));
                }else{
                    if(file.getAbsolutePath().endsWith(".txt")){
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
            for (FindDiskFile fileTask:invokeAll(findDiskFiles)){
                fileTask.join();
            }
       }
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FindDiskFile task = new FindDiskFile(new File("E:\\"));
        forkJoinPool.execute(task);
        int count=0;
        for (int i = 0; i <100 ; i++) {
            count += i;
        }
        System.out.println("count:"+count);
        System.out.println("main thread is end");
        task.join();
        System.out.println("task is end");
    }
}
