package com.keyin;

import jakarta.persistence.*;

@Entity
public class BinaryNode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int value;

    @OneToOne(cascade=CascadeType.ALL)
    private BinaryNode left;

    @OneToOne(cascade=CascadeType.ALL)
    private BinaryNode right;




    public BinaryNode(int item) {
        value = item;
    }

    public BinaryNode() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
