package com.angela.trianglePuzzle;

/**
 * Created by Angela on 4/14/2017.
 */
public class Node {
    private int weight;
    Node left;
    Node Right;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return Right;
    }

    public void setRight(Node right) {
        Right = right;
    }



    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }



    public Node(int Triangle){
        this.weight = Triangle;

        this.left = null;
        this.Right = null;
    }

}
