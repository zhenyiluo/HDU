package baiduStar2015.Cities;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-18.
 */
public class Main {
    public static class Pair{
        int id;
        int cost;
        public Pair(int id, int cost){
            this.id = id;
            this.cost = cost;
        }
    }
    private static void solve(Scanner sc, PrintWriter pw) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Pair>[] g = new ArrayList[n];
        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i++){
            g[i] = new ArrayList<Pair>();
        }
        for(int i = 0; i < n-1; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            int c = sc.nextInt();
            g[a].add(new Pair(b, c));
            g[b].add(new Pair(a, c));
        }

        for(int i = 0; i < n; i++){
            boolean[] visited = new boolean[n];
            visited[i] = true;
            dfs(i, i, graph, g, 0, visited);
        }

        long ans = Long.MAX_VALUE;

        for(int i = 0; i < n; i++){
            HashSet<Integer> visited = new HashSet<Integer>();
            visited.add(i);
            ans = Math.min(ans, dfs(k-1, g, 0, graph, visited));
        }
        pw.println(ans*2);
    }

    private static void dfs(int start, int cur, int[][] graph, ArrayList<Pair>[] g, int cost, boolean[] visited) {
        for(Pair pair : g[cur]){
            if(!visited[pair.id]){
                int newCost = cost + pair.cost;
                graph[start][pair.id] = newCost;
                visited[pair.id] = true;
                dfs(start, pair.id, graph, g, newCost, visited);
            }
        }
    }

    public static long dfs(int k, ArrayList<Pair>[] g, long cost, int[][] graph, HashSet<Integer> visited){
        if(k == 0){
            return cost;
        }
        long tmpCost = Long.MAX_VALUE;
        int selected = -1;

        for(int cur : visited){
            for(Pair pair : g[cur]){
                if(!visited.contains(pair.id)){
                    long sum = 0;
                    Iterator<Integer> it = visited.iterator();
                    while(it.hasNext()){
                        sum += graph[it.next()][pair.id];
                    }
                    if(sum < tmpCost){
                        selected = pair.id;
                        tmpCost = sum;
                    }
                }

            }
        }
        visited.add(selected);
        return dfs(k-1, g, cost+ tmpCost, graph, visited);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            solve(sc, pw);
        }
        pw.close();
        pw.flush();
        sc.close();
    }
}
