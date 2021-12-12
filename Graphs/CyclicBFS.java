package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int first;
    int second;

    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class CyclicBFS {
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

            if (isCycleFormed(graph, n)) {
                System.out.println("Cyclic graph");
            } else {
                System.out.println("Non-Cyclic graph");
            }

        }
        sc.close();
    }

    private static boolean isCycleFormed(ArrayList<Integer>[] graph, int n) {

        boolean isVisited[] = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                if (bfs(graph, i, isVisited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean bfs(ArrayList<Integer>[] graph, int i, boolean[] isVisited) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, -1));
        isVisited[i] = true;
        while (!queue.isEmpty()) {

            int curValue = queue.peek().first;
            int parent = queue.peek().second;
            queue.remove();

            for (Integer adj : graph[curValue]) {
                if (!isVisited[adj]) {
                    queue.add(new Node(adj, curValue));
                    isVisited[adj] = true;
                } else if (adj != parent) {
                    return true;
                }
            }

        }

        return false;
    }
}
