package com.zf.mo;

public class LinkList<T> {

    //初始化
    public LinkList(){
        this.N = 0;
        this.head = new Node(null,null,null);
        this.tail = new Node(null,null,null);
    }
    private Node head;

    private Node tail;

    private int N;

    public void clear(){
        N = 0;
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return N == 0 ? true:false;
    }

    public int size(){
        return N;
    }

    public T get(int index){
        if(index <= 0 || index >= N ){
            System.out.println("输入index不合法");
            return null;
        }
        Node node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return (T)node.item;
    }



    public void add(T item){
        //LinkList为空
        if(head.next == null){
            Node<T> node = new Node<T>(head,tail,item);
            head.next = node;
            node.pre = head;
            node.next = tail;
            tail.pre = node;
        }
        //linklist有值
        Node<T> nodePre = tail.pre;
        Node<T> currNode = new Node<T>(nodePre,tail,item);
        nodePre.next = currNode;
        tail.pre = currNode;
        N++;
    }

    public T remove(int index){
        if(index < 0 || index > N){
            System.out.println("输入index有误");
            return null;
        }
        Node<T> node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        head.next = node;
        node.pre = head;
        N--;
        return node.item;
    }

    private class Node<T>{

        private Node next;

        private Node pre;

        private T item;

       public Node(Node pre,Node next,T item){
           this.pre = pre;
           this.next = next;
           this.item = item;
       }
    }

    public static void main(String[] args) {
        LinkList<String> linkList = new LinkList<String>();
        linkList.add("刘备");
        linkList.add("关羽");
        linkList.add("张飞");
        System.out.println(linkList.size());
        String remove = linkList.remove(1);
        System.out.println(remove);
        System.out.println(linkList.size());
        String s = linkList.get(1);
        System.out.println(s);
        System.out.println(linkList.size());
        linkList.add("赵云");
        System.out.println(linkList.size());
    }
}
