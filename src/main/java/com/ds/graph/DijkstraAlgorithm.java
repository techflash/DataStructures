package com.ds.graph;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Dijkstra algorithm is to find the the shortest path in a directed graph from a given source.
 */
public class DijkstraAlgorithm {
    private VertexNode[] vertexNodes;
    private Queue<VertexNode> vertexNodeQueue;

    public void findShortestPath(Graph graph, Vertex source) {
        vertexNodeQueue = new PriorityQueue<>();
        vertexNodes = new VertexNode[graph.getVertexList().length];

        for (Vertex v : graph.getVertexList()) {
            VertexNode vn = new VertexNode();
            vn.setIndex(v.getIndex());
            vertexNodes[v.getIndex()] = vn;
            vertexNodeQueue.offer(vn);
        }

        initialiseDistances(vertexNodes, source);

        // Find shorted path
        while (!vertexNodeQueue.isEmpty()) {
            VertexNode vertexNode = vertexNodeQueue.remove();
            Neighbor adjList = graph.getVertexList()[vertexNode.getIndex()].getAdjList();
            Vertex sourceVertex = graph.getVertexList()[vertexNode.getIndex()];
            for (; adjList != null; adjList = adjList.getNext()) {
                // If adjacent vertex has already been removed from queue then do not recalculate distance for it.
                // Because shortest path to reach to the vertex from source must has been found.
                if (vertexNodes[adjList.getVertexNo()].isRemovedFromQueue()) continue;

                calculateAndSetDistance(sourceVertex, adjList);

            }
            vertexNode.setRemovedFromQueue(true);

            // Re-heapify
            if (!vertexNodeQueue.isEmpty()) {
                vertexNodeQueue.add(vertexNodeQueue.remove());
            }
        }

        // Display final vertextNodes after calculation
        for (VertexNode vn : vertexNodes
                ) {
            System.out.println(vn.toString());
        }
    }

    private void initialiseDistances(VertexNode[] vertexNodes, Vertex source) {
        for (VertexNode vn : vertexNodes
                ) {
            vn.setDistance(1000000);
            vn.setSourceVertex(null);
        }
        // set the first source to have distance zero
        vertexNodes[source.getIndex()].setDistance(0);
    }

    private void calculateAndSetDistance(Vertex source, Neighbor neighbor) {

        int currentNeighborDistance = vertexNodes[neighbor.getVertexNo()].getDistance();
        int neighborDistanceFromSource = vertexNodes[source.getIndex()].getDistance() + neighbor.getWeight();

        // Check if current distance of neighbor is greater than the distance from source.
        if (currentNeighborDistance > neighborDistanceFromSource) {
            vertexNodes[neighbor.getVertexNo()].setDistance(neighborDistanceFromSource);
            vertexNodes[neighbor.getVertexNo()].setSourceVertex(source);
        }
    }

    private class VertexNode implements Comparable {
        int index;
        int distance;
        Vertex sourceVertex;
        boolean isRemovedFromQueue;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public Vertex getSourceVertex() {
            return sourceVertex;
        }

        public void setSourceVertex(Vertex sourceVertex) {
            this.sourceVertex = sourceVertex;
        }

        public boolean isRemovedFromQueue() {
            return isRemovedFromQueue;
        }

        public void setRemovedFromQueue(boolean removedFromQueue) {
            isRemovedFromQueue = removedFromQueue;
        }

        @Override
        public int compareTo(Object o) {
            VertexNode other = ((VertexNode) o);
            if (this.getDistance() == other.getDistance()) {
                return 0;
            }
            if (this.getDistance() > other.getDistance()) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public boolean equals(Object obj) {
            return this.getDistance() == ((VertexNode) obj).getDistance();
        }

        @Override
        public String toString() {
            return "VertexNode{" +
                    "index=" + index +
                    ", distance=" + distance +
                    ", sourceVertex=" + (sourceVertex != null ? sourceVertex.getName() : "-") +
                    ", isRemovedFromQueue=" + isRemovedFromQueue +
                    '}';
        }
    }

}
