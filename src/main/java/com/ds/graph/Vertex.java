package com.ds.graph;

/**
 * Represents vertex in graph
 */
class Vertex {
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

}
