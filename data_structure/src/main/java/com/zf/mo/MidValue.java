package com.zf.mo;

public class MidValue {

    private static int getMid(Node node){
        Node slow = node;
        Node fast = node;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return (Integer) slow.item;

    }

    public static void main(String[] args) {
        Node n9 = new Node<Integer>(9,null);
        Node n8 = new Node<Integer>(8,n9);
        Node n7 = new Node<Integer>(7,n8);
        Node n6 = new Node<Integer>(6,n7);
        Node n5 = new Node<Integer>(5,n6);
        Node n4 = new Node<Integer>(4,n5);
        Node n3 = new Node<Integer>(3,n4);
        Node n2 = new Node<Integer>(2,n3);
        Node n1 = new Node<Integer>(1,n2);
        int mid = getMid(n1);
        System.out.println(mid);
    }


    private static class Node <T>{

        private T item;

        private Node next;

        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }

    }


}
