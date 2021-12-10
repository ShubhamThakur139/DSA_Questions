package Graphs;

// Implementing Breadth First Search : In BFS we are traversing level by level. or first we traverse of 
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // number of vertices
        int n = sc.nextInt();
        // number of edges
        int m = sc.nextInt();

        // Adjacency List
        ArrayList<Integer> graph[] = new ArrayList[n];
        // at every index we are giving an array list
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        // taking relationship between vertices
        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            graph[src].add(dest);
            graph[dest].add(src);
        }
        boolean isVisited[] = new boolean[n];

        ArrayList<Integer> bfsarr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                BreadthFirstSearch(graph, 0, isVisited, bfsarr);
            }
        }
        System.out.println(bfsarr);

        sc.close();
    }

    private static void BreadthFirstSearch(ArrayList<Integer>[] graph, int src, boolean[] isVisited,
            ArrayList<Integer> bfsarr) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        isVisited[src] = true;
        while (!queue.isEmpty()) {
            int currItem = queue.poll();
            bfsarr.add(currItem);
            for (Integer adj : graph[src]) {
                if (!isVisited[adj]) {
                    queue.add(adj);
                    isVisited[adj] = true;
                }
            }
        }
    }
}

// 4 vertices with 6 edges
// 0, 1
// 0, 2
// 1, 2
// 2, 0
// 2, 3
// 3, 3