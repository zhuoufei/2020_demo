package com.zf.mo.table;

import jdk.nashorn.internal.ir.Symbol;

import java.util.HashMap;

public class SymbolTble <K,V>{

    public SymbolTble(){
        head = new Node(null,null,null);
    }

    private Node head;

    private int n;

    public void put(K key,V value){
        Node node = head;
        while (node.next != null){
            if(key.equals(node.next.key)){
                node.next.value = value;
                return;
            }
            node = node.next;
        }
        Node oldFirst = head.next;
        Node newFirst =  new Node<K,V>(key,value,oldFirst);
        head.next = newFirst;
    }

    public V delete(K key){
        Node node = head;
        while(node.next != null){
            if(key.equals(node.next.key)){
                V v = (V)node.next.value;
                head.next = node.next.next;
                node.next = null;
                return v;
            }
            node = node.next;
        }
        return null;
    }

    public V get(K key){
        Node node = head;
        while(node.next != null){
            if(node.next.key.equals(key)){
                return (V)node.next.value;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        SymbolTble symbolTble = new SymbolTble();
        symbolTble.put("1","张三");
        symbolTble.put("2",2);
        symbolTble.put("3","赵六");
        symbolTble.put("4","hello");
        int o = (Integer) symbolTble.get("2");
        symbolTble.delete("2");
        System.out.println(o);
    }



    private class Node <K,V>{
        private K key;
        private V value;
        private Node next;
        public Node(K key,V value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
