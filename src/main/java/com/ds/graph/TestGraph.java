package com.ds.graph;

import java.io.InputStream;
import java.util.Scanner;

public class TestGraph {
    public static void main(String[] args) {
        InputStream fileInputStream = TestGraph.class.getResourceAsStream("/friendship.txt");
        Scanner sc = new Scanner(fileInputStream);

        Graph g = new Graph(sc);
        g.print();
    }
}
