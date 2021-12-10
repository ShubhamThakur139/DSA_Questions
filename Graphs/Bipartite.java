package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Prob Stat: Check whether graph is Bipartite or Not 
// Graph is known as bipartite when there is no adjacent vertices have same color.
class Bipartite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            // number of vertices in a graph
            int n = sc.nextInt();
            // number of edges in a graph
            int m = sc.nextInt();
            // Storing a graph in Adjacency List
            ArrayList<Integer> graph[] = new ArrayList[n + 1];
            // at every index we are giving an array list
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            // taking values of vertices
            for (int i = 0; i < m; i++) {
                int src = sc.nextInt();
                int dest = sc.nextInt();
                graph[src].add(dest);
                graph[dest].add(src);
            }

            if (isBipartite(graph, n)) {
                System.out.println("Bipartite graph");
            } else {
                System.out.println("Non-Bipartite graph");
            }

        }
        sc.close();
    }

    private static boolean isBipartite(ArrayList<Integer>[] graph, int n) {

        int color[] = new int[n + 1];
        Arrays.fill(color, -1);

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!dfs(graph, i, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean dfs(ArrayList<Integer>[] graph, int src, int[] color) {
        if (color[src] == -1) {
            color[src] = 1;
        }

        for (Integer adj : graph[src]) {
            if (color[adj] == -1) {
                color[adj] = 1 - color[src];
                if (!dfs(graph, adj, color)) {
                    return false;
                }
            } else if (color[adj] == color[src]) {
                return false;
            }
        }

        return true;
    }
}

// Sample Input Output
// 2
// 4 3
// 1 2
// 2 3
// 3 4
// 3 3
// 1 2
// 2 3
// 3 1