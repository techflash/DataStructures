package com.ds.graph;

import java.util.Scanner;

/**
 * An undirected graph G consists of a set of vertices V and a set of edges E.
 * Where an edge is an unordered pair of vertices. 3. V = {v1,v2,v3,v4,v5} and E = {e1,e2,e3,e4,e5,e6}.
 * A directed graph or digraph G consists of a set of vertices V and a set of directed edges E.
 * Where an edge is an ordered pair of vertices.
 * <p>
 * Vertices: Node in the graph
 * Edge: Line connecting the two nodes in the graph
 * Weighted Graph: A graph in which each line has been assigned a weight (or cost)
 * <p>
 * Representation Strategies:
 * 1. Edge List: Graph is represented with two lists. I. holds the vertices and II. holds the connection information
 * 2. Adjacency Matrix: A list is used to hold the vertices (v) and a matrix of v*v is used to represent connection
 * 3. Adjacency List: Most efficient way to represent a graph. An array is used to hold the vertices. and each vertices maintains
 * the adjacency list(linked list).
 * <p>
 * Following graph implementation is based on adjacency list.
 */
class Graph {
    private static boolean undirected = true;
    private static boolean weighted = true;

    /**
     * This maintains the vertex array
     */
    private Vertex vertexes[];

    /**
     * This constructor does heavy lifting. It has to read graph entries and construct the graph.
     * However input file need to follow following format:
     * 1. first line needs to indicate whether is ti directed or undirected graph
     * 2. second line specifies the number of vertices
     * 3. following lines should have names added on each line
     * 4. once all vertices are defined in file it following lines should contains the relation ship
     *
     * @param scanner
     */
    public Graph(Scanner scanner) {

        // Check if graph is directed or undirected
        String graphType = scanner.next();
        if (graphType != null && graphType.equals("directed")) {
            undirected = false;
        }
        String weightedGraph = scanner.next();
        if (weightedGraph != null && weightedGraph.equals("nonweighted")) {
            weighted = false;
        }

        // Get the number of vertices
        int numOfV = scanner.nextInt();

        // Create array of vertices
        vertexes = new Vertex[numOfV];
        for (int i = 0; i < numOfV; i++) {
            vertexes[i] = new Vertex(scanner.next(), null);
            vertexes[i].setIndex(i);
        }

        // Now read the connections
        while (scanner.hasNext()) {
            // Read two first connection information between two vertex
            String firstV = scanner.next();
            String secondV = scanner.next();
            int weight = 0;
            if (weighted) {
                weight = scanner.nextInt();
            }

            // Find their actual index in the vertex array
            int v1 = findIndexOfVertice(firstV);
            int v2 = findIndexOfVertice(secondV);

            // Set the adjList of each other with apposite of index to
            // provide information about the adjacency. each new node is added to head
            // as it does not matter in what sequence the adjacecny list is created.
            vertexes[v1].setAdjList(new Neighbor(v2, weight, vertexes[v1].getAdjList()));
            if (undirected) {
                vertexes[v2].setAdjList(new Neighbor(v1, weight, vertexes[v2].getAdjList()));
            }
        }
    }

    // Find index of vertex in vertex array
    public int findIndexOfVertice(String vertex) {

        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i].getName().equals(vertex)) return i;
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < vertexes.length; i++) {
            Neighbor temp = vertexes[i].getAdjList();
            System.out.println(vertexes[i].getName());

            while (temp != null) {
                System.out.println("\t--" + (weighted ? temp.getWeight() : "") + "-->"
                        + vertexes[temp.getVertexNo()].getName());
                temp = temp.getNext();
            }

        }
    }


}
