package Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    public  int size;
    public static LinkedList<Integer> adj[];

//    public Graph(int v){
//        size = v;
//        adj = new LinkedList[v];
//        for(int i = 0; i < size; i++){
//            adj[i] = new LinkedList();
//        }
    public ArrayList<ArrayList<Integer>> list;

    public Graph(int v){
          size = v;
          list = new ArrayList<ArrayList<Integer>>(size);
          for(int i = 0; i < v; i++){
                list.add(new ArrayList<Integer>());
          }
    }

//    To add an edge into the graph
    public void addEdge(int v, int value){
        adj[v].add(value);
    }

    //DFS of a directed graph
    public  void DFS(int v){
        boolean[] visited = new boolean[size];
        DFSUtil(v,visited);
    }

    public  void DFSUtil(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v+" ");

        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFSUtil(n,visited);
            }
        }
    }

    public void addEdges(int v, int value){
          list.get(v).add(value);
    }

    public void topologicalSort(){
        Stack<Integer> stack = new Stack<Integer>();

        boolean visited[] = new boolean[size];
        for (int i = 0; i < size; i++)
            visited[i] = false;

        for (int i = 0; i < size; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }

    public void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack){
          visited[v] = true;
          Integer k;
          Iterator<Integer> it = list.get(v).iterator();
          while(it.hasNext()){
               k = it.next();
               if(!visited[k]){
                   topologicalSortUtil(k,visited,stack);
               }
          }
        stack.push(v);
    }

    public static void main(String[] args){
        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);

        graph.DFS(0);
        Graph graph2 = new Graph(6);
        graph2.addEdges(5,2);
        graph2.addEdges(5,0);
        graph2.addEdges(4,0);
        graph2.addEdges(4,1);
        graph2.addEdges(2,3);
        graph2.addEdges(3,1);
        graph2.topologicalSort();
    }
}
