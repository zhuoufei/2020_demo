package com.zf.mo.tree;

public class BinaryTree <V>{

    private int n;

    private Node root;

    /**
     * 添加数据
     * @param key
     * @param value
     */
    public void put(int key,V value){
        root  = put(root,key,value);
    }

    /**
     * 指定的节点插入数据
     * @return
     */
    public Node put(Node tree,Integer key,V value){
        //没有节点
        if(tree == null){
            n++;
            return new Node(null,null,key,value);
        }
        if(key > tree.key){
            tree.right = put(tree.right,key,value);
        }else if(key < tree.key){
            tree.left = put(tree.left,key,value);
        }else{
            tree.value = value;
        }
        return tree;
    }

    public V get(Integer key){
        if(key == null){
            return null;
        }
        return get(root,key) == null ? null : (V)get(root,key).value;
    }

     public Node get(Node tree,Integer key){
        if(key > tree.key){
            return get(tree.right,key);
        }else if(key < tree.key){
            return get(tree.left,key);
        }else if(key.equals(tree.key)){
            return tree;
        }else{
            return null;
        }
    }

    public void delete(Integer key){
        if(key == null){
            return;
        }
        delete(root,key);
    }

    public Node delete(Node tree,Integer key){
        if(tree == null){
            return null;
        }
        if(key > tree.key){
            tree.right = delete(tree.right,key);
        }else if(key < tree.key){
            tree.left = delete(tree.left,key);
        }else{
            if(tree.left == null && tree.right == null){
                tree = null;
                n--;
                return null;
            }
            if(tree.left == null){
                Node node = tree.right;
                tree = null;
                n--;
                return node;
            }
            if(tree.right == null){
                Node node = tree.left;
                tree = null;
                return node;
            }
            Node minNode = tree.right;
             while(minNode.left != null){
                 Node temp = minNode.left;
                 if(minNode.left.left == null){
                     break;
                 }
                 minNode = minNode.left;
                 temp.left = null;
             }
            minNode.left = tree.left;
            minNode.right = tree.right;
            n--;
            return minNode;
        }
        return tree;
    }




    public static void main(String[] args) {
        BinaryTree<String> binaryTree = new BinaryTree<String>();
        binaryTree.put(8,"张三");
        binaryTree.put(2,"李四");
        binaryTree.put(9,"王五");
        binaryTree.put(10,"王五");
        binaryTree.put(11,"王五");
        binaryTree.put(12,"王五");
        binaryTree.put(13,"王五");
        binaryTree.delete(10);
//        System.out.println(binaryTree.get(9));
//        System.out.println(binaryTree.get(2));

    }

    private class Node <K,V>{
        private Node left;
        private Node right;
        private Integer key;
        private V value;

        public Node(Node left, Node right, int key, V value) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
        }
    }
}
