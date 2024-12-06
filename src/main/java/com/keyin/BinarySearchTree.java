package com.keyin;

public class BinarySearchTree {

    BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    void insert(int value) {
        root = insertRec(root,value);

    }

    private BinaryNode insertRec(BinaryNode root, int value) {

        if(root == null) {
            root = new BinaryNode(value);
            return root;
        }

        if(value<root.getValue()){
            root.setLeft( insertRec(root.getLeft(),value));
        } else if (value > root.getValue()) {
            root.setRight(insertRec(root.getRight(),value));

        }
        return root;
    }

    void inorder() {
        inorderRec(root);
        System.out.println("\n");
    }

    void inorderRec(BinaryNode root) {
        if (root != null) {
            inorderRec(root.getLeft());
            System.out.print(root.getValue() + " ");
            inorderRec(root.getRight());
        }
    }

}
