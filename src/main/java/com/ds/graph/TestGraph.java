package com.ds.graph;

import java.io.InputStream;
import java.util.Scanner;

public class TestGraph {
    public static void main(String[] args) {
        String friendshipFilePath = "/friendship.txt";
        String intercitynetwork = "/intracitynetwork.txt";
        String webpages = "/webpages.txt";
        InputStream fileInputStream = TestGraph.class.getResourceAsStream(webpages);
        Scanner sc = new Scanner(fileInputStream);

        Graph g = new Graph(sc);

        System.out.println("Print graph based on its relations");
        g.print();

        System.out.println("Traverse the graph in depth first manner!");
        g.dfs();


    }
}
