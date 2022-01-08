package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Prob Stat: n a computer network, we have N computers numbered from 1 to N connected by M wires. You are using computer number 1 and wants to send the message to the computer N. The message will electronically transfer from one computer to other using the connecting wires but there can be many possible paths from computer 1 to computer N. No one wants delay in communication so you need to find the shortest possible path length between computer 1 and computer N.
public class TextMessage {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> graph[] = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            graph[src].add(dest);
            graph[dest].add(src);
        }

        int ans = bfs(graph, n);
        System.out.println(ans);
    }

    static int bfs(ArrayList<Integer> graph[], int n) {
        boolean visited[] = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- != 0) {
                int src = q.poll();
                if (src == n) {
                    return level;
                }

                for (Integer adj : graph[src]) {
                    if (!visited[adj]) {
                        q.add(adj);
                        visited[adj] = true;
                    }
                }

            }
            level = level + 1;
        }

        return -1;
    }

}

// I/O: 5 5
// 1 2
// 1 3
// 1 4
// 2 3
// 5 4
// o/p = 2

// 5 2
// 1 2
// 3 4
// op = -1