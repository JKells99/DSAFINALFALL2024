package com.keyin;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(11 );
        bst.insert(22);
        bst.insert(36);
        bst.insert(49);
        bst.insert(51);
        bst.insert(65);

        bst.inorder();
    }
}
