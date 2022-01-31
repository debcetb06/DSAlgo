package com.deb.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Graph {
    static class Edge {
        int src;
        int nbr;
        int weight;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.weight = wt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int vrtcs = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vrtcs];
        for (int i = 0; i < vrtcs; i++) {
            graph[i] = new ArrayList<>();
        }
        int edge = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < edge; i++) {
            String edges = bufferedReader.readLine();
            int v1 = Integer.parseInt(edges.split(" ")[0]);
            int v2 = Integer.parseInt(edges.split(" ")[1]);
            int wt = Integer.parseInt(edges.split(" ")[2]);
            graph[v1].add(new Edge(v1, v2,wt));
            graph[v2].add(new Edge(v2, v1,wt));
        }
        int source = Integer.parseInt(bufferedReader.readLine());
        int destination = Integer.parseInt(bufferedReader.readLine());
        boolean[] visited = new boolean[vrtcs];
        System.out.println(hasPath(graph, source, destination,visited));
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        if(src == dest){
            return true;
        }
        visited[src] = true;
        for (Edge edge: graph[src]){
            if(visited[edge.nbr] == false){
                boolean hasPath = hasPath(graph, edge.nbr, dest, visited);
                if(hasPath){
                    return true;
                }
            }
        }
        return false;
    }

}
