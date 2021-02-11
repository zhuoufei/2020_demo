package com.zf.mo;

public class ReverseList<T> {

    int N ;
    NodeR<T> head;

    public ReverseList(){
        head = new NodeR<T>(null,null);
    }

    public void add(T item){
        NodeR<T> node = new NodeR<T>(null, item);
        head.next = node;
        N++;
    }

    public void resver(){
        if(N == 0){
            return ;
        }
        revers(head.next);
    }

    private NodeR revers(NodeR current){

        if(current.next == null){
            head.next = current;
            return current;
        }
        NodeR next = revers(current.next);
        next.next = current;
        current.next = null;
        return current;
    }

    private class NodeR <T>{

        private NodeR next;

        private T item;

        public NodeR(NodeR next,T item){
            this.next = next;
            this.item = item;
        }
    }

}
