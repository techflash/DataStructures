package com.ds.graph;

/**
 * Used as node to maintain adjacency list
 */
class Neighbor implements Cloneable {
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return toString(this).toString();
    }

    public StringBuilder toString(Neighbor neighbor) {
        StringBuilder sb = new StringBuilder();
        while (neighbor != null) {
            sb.append("{" +
                    "vertexNo=" + neighbor.getVertexNo() +
                    ", weight=" + neighbor.getWeight() +
                    "}");
            neighbor = neighbor.next;
        }
        return sb;
    }
}