package com.ds.graph;

/**
 * Represents sourceVertex in graph
 */
class Vertex implements Cloneable {
    private String name;
    private Neighbor adjList;
    private int index;

    public Vertex(String name, Neighbor adjList) {
        this.name = name;
        this.adjList = adjList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Neighbor getAdjList() {
        return adjList;
    }

    public void setAdjList(Neighbor adjList) {
        this.adjList = adjList;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Vertex v = (Vertex) super.clone();
        v.adjList = (Neighbor) this.adjList.clone();
        Neighbor t = this.adjList.getNext();
        Neighbor tv = v.adjList;
        while (t != null) {
            tv.setNext((Neighbor) t.clone());
            t = t.getNext();
            tv = tv.getNext();
        }
        return v;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", adjList=" + adjList.toString() +
                ", index=" + index +
                '}';
    }
}
