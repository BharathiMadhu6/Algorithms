package Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

class GraphT
{
    private int n;

    private ArrayList<ArrayList<Integer>> adj;

    GraphT(int v)
    {
        n = v;
        adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<Integer>());
    }

    void addEdge(int v,int w) {
        adj.get(v).add(w);
    }

    void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent
        // to thisvertex
        Iterator<Integer> it = adj.get(v).iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
        stack.push((v));
    }

    void topologicalSort()
    {
        Stack<Integer> stack = new Stack<Integer>();

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            visited[i] = false;

        // Call the recursive helper
// function to store
        // Topological Sort starting
        // from all vertices one by one
        for (int i = 0; i < n; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    public static void main(String args[])
    {
        GraphT g = new GraphT(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println(
                "Following is a Topological " +
                        "sort of the given graph");
        g.topologicalSort();
    }
}