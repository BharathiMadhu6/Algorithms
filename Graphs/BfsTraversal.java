package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BfsTraversal {

    private int n;
    private LinkedList<Integer> adj[];

    public BfsTraversal(int v){
        this.n = v;
        adj= new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int u){
        adj[v].add(u);
    }

    public void bfs(int v){
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);

        while(!queue.isEmpty()){

            v = queue.poll();
            System.out.print(v+" ");

            Iterator<Integer> i = adj[v].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args){
        BfsTraversal b = new BfsTraversal(4);
        b.addEdge(0,1);
        b.addEdge(0,2);
        b.addEdge(1,2);
        b.addEdge(2,0);
        b.addEdge(2,3);
        b.addEdge(3,3);
        b.bfs(2);
    }
}
