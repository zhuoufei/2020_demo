package com.zf.mo;

public class SequenceList<T> {

    public SequenceList(int capacity){
        this.capacity = capacity;
        eles = new Object[capacity];

    }

    private int capacity;
    /**
     * 存储元素数组
     */
    private Object[] eles;
    /**
     * 当前线性表的长度
     */
    private int N;

    /**
     * 空置线性表
     */
    public void clear(){
        eles = new Object[capacity];
        N = 0;
    };

    /**
     * 判断线性是否为空
     * @return
     */
    public boolean isEmpty(){
        return N == 0 ? true : false;
    }

    /**
     * 获取线性表中元素的个数
     * @return
     */
    public int legth(){
        return N;
    }

    /**
     * 返回index元素
     * @param index
     * @return
     */
    public  T get(int index){
        if(index < 0 || index >= N){
            throw new IndexOutOfBoundsException("角标越键");
        }
        return (T)eles[index];
    }

    /**
     * 在index 插入元素
     * @param index
     * @param t
     */
    public void insert(int index, T t){
        if(index < 0 || index >= N - 1){
            throw new IndexOutOfBoundsException("角标越键");
        }
        for (int i = N; i <index ; --i) {
               eles[i] = eles[i-1];
        }
        eles[index] = t;
        N++;
    }

    /**
     * 移除index元素并返回
     * @param index
     * @return
     */
    public T remove(int index){
        if(index < 0 || index >= N - 1){
            throw new IndexOutOfBoundsException("角标越键");
        }
        T result = (T)eles[index];
        for (int i = index; i < N-1; i++) {
            eles[i] = eles[i+1];
        }
        N--;
        return result;
    }

    /**
     * 返回线性中首次出现的指定的数据元素
     * @param t
     * @return
     */
    public int indexOf(T t){
        for (int i = 0; i < capacity; i++) {
            if(((T)eles[i]).equals(t)){
                return i;
            };
        }
        return -1;
    }


    public static void main(String[] args) {

        String[] str = new String[10];
        System.out.println(str[5]);
    }

}















