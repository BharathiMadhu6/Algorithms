package Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {

    private int n;
    private ArrayList<ArrayList<Integer>> adj;

    TopologicalSort(int size){
        n = size;
        adj = new ArrayList<ArrayList<Integer>>(size);
        for(int i = 0; i < size; i++){
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        adj.get(u).add(v);
    }

    public void topSortUtil(int v, boolean[] visited, Stack<Integer> stack){
        visited[v] = true;
        Integer i;

        Iterator<Integer> itr = adj.get(v).iterator();
        while(itr.hasNext()){
            i = itr.next();
            if(!visited[i]){
                topSortUtil(i, visited, stack);
            }
        }
        stack.push(v);
    }

    public void topSort(){
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            visited[i] = false;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            if(! visited[i]){
                topSortUtil(i, visited, stack);
            }
        }
        int[] res = new int[n];
        int k = 0;
        while(!stack.isEmpty()){
//            System.out.print(stack.pop()+" ");
            res[k++] = stack.pop();
        }
        for(int i = res.length-1; i >= 0; i--){
            System.out.print(res[i]+" ");
        }
    }

    public int[] s(int v){
        int[] arr = new int[1];
        boolean f = true;
        if(f){
            return new int[0];
        }
        arr[0] = 1;
        return arr;
    }

    public static void main(String args[])
    {
        TopologicalSort g = new TopologicalSort(4);
//        g.addEdge(5, 2);
//        g.addEdge(5, 0);
//        g.addEdge(4, 0);
//        g.addEdge(4, 1);
//        g.addEdge(2, 3);
//        g.addEdge(3, 1);
        g.addEdge(0,1);
        g.addEdge(2,0);
        g.addEdge(3,2);
        g.addEdge(1,0);
        g.topSort();
    }
}
