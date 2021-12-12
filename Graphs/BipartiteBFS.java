package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BipartiteBFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            // number of vertices in a graph
            int n = sc.nextInt();
            // number of edges in a graph
            int m = sc.nextInt();
            // Storing a graph in Adjacency List
            ArrayList<Integer> graph[] = new ArrayList[n];
            // at every index we are giving an array list
            for (int i = 0; i < n; i++) {
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
        int color[] = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (bfs(graph, i, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean bfs(ArrayList<Integer>[] graph, int i, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        color[i] = 1;

        while (!queue.isEmpty()) {
            int currVal = queue.poll();
            for (Integer adj : graph[currVal]) {
                if (color[adj] == -1) {
                    queue.add(adj);
                    color[adj] = 1 - color[currVal];
                } else if (color[adj] == color[currVal]) {
                    return true;
                }
            }

        }
        return false;
    }
}

// Sample Input Output:
// graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
// graph = [[1,3],[0,2],[1,3],[0,2]]