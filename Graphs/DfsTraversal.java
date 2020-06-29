package Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DfsTraversal {

    private int n;
    private LinkedList<Integer> adj[];

    DfsTraversal(int v){
        this.n = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public void dfsUtil(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v+" ");
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                dfsUtil(n, visited);
            }
        }
    }

    public void dfs(int v){
        boolean[] visited = new boolean[n];
        dfsUtil(v, visited);
    }

    public static void main(String[] args){
        DfsTraversal d = new DfsTraversal(4);
        d.addEdge(0,1);
        d.addEdge(0,2);
        d.addEdge(1,2);
        d.addEdge(2,0);
        d.addEdge(2,3);
        d.addEdge(3,3);
        d.dfs(0);
    }
}
