package com.ds.graph;

/**
 * Used as node to maintain adjacency list
 */
class Neighbor {
    private int vertexNo;
    private Neighbor next;
    private int weight;

    public Neighbor(int vertexNo, int weight, Neighbor next) {
        this.vertexNo = vertexNo;
        this.weight = weight;
        this.next = next;
    }

    public int getVertexNo() {
        return vertexNo;
    }

    public void setVertexNo(int vertexNo) {
        this.vertexNo = vertexNo;
    }

    public Neighbor getNext() {
        return next;
    }

    public void setNext(Neighbor next) {
        this.next = next;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}