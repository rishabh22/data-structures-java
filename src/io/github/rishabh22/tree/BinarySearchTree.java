package io.github.rishabh22.tree;

public class BinarySearchTree {
    private Node root;

    public void add(int data) {
        if(root==null)
        {
            root = new Node(data);
            return;
        }

        Node currentNode = root;
        while(currentNode!=null){
            if(data > currentNode.getData()){

            }
        }
    }
}
