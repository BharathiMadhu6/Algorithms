package Graphs;

import java.util.ArrayList;

public class AdjacencyListRep {

    public void addEdge(ArrayList<ArrayList<Integer>> adj, int v, int u){
        adj.get(v).add(u);
        adj.get(u).add(v);
    }

    public void print(ArrayList<ArrayList<Integer>> adj){
        for(int i = 0; i < adj.size(); i++){
            System.out.println(+i+" : adj nodes : ");
            for(int j = 0; j < adj.get(i).size(); j++){
                System.out.print(" -> "+adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        AdjacencyListRep ad = new AdjacencyListRep();
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
        ad.addEdge(adj,0,1);
        ad.addEdge(adj,0,4);
        ad.addEdge(adj,1,4);
        ad.addEdge(adj,1,3);
        ad.addEdge(adj,1,2);
        ad.addEdge(adj,2,3);
        ad.addEdge(adj,3,4);
        ad.print(adj);
    }
}
