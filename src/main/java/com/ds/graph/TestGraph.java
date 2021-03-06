package com.ds.graph;

import java.io.InputStream;
import java.util.Scanner;

public class TestGraph {
    public static void main(String[] args) {
        String friendshipFilePath = "/friendship.txt";
        String intercitynetwork = "/intracitynetwork.txt";
        String webpages = "/webpages.txt";
        String dependencygraph = "/dependencygraph.txt";
        InputStream fileInputStream = TestGraph.class.getResourceAsStream(dependencygraph);
        Scanner sc = new Scanner(fileInputStream);

        Graph g = new Graph(sc);

/*
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        dijkstraAlgorithm.findShortestPath(g, g.getVertexList()[0]);

        System.out.println("Print graph based on its relations");
        g.print();

        System.out.println("Traverse the graph in depth first manner!");
        g.dfs();
*/

        System.out.println("Traverse the graph in breadth first manner!");
        g.bfs();

        // Topological sort
/*
        int topnum[] = g.topologicalSort();
        System.out.println("Topological sort: ");
        for (int i : topnum) {

            System.out.print("--" + g.getVertexList()[i].getName());
        }
*/


    }
}
