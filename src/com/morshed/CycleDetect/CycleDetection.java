package com.morshed.CycleDetect;

import java.util.List;

public class CycleDetection {

    public void detectCycle(List<Vertex> vertexList){
        for(Vertex v : vertexList){
            if(!v.isVisited()){
                dfs(v);
            }
        }
    }

    private void dfs(Vertex v){
        System.out.println("DFS on vertex "+ v);
        v.setBeingVisited(true);
        for(Vertex vertex : v.getAdjacencyList()){
            System.out.println("Visiting the neighbours of vertex "+ v);
            if(vertex.isBeingVisited()){
                System.out.println("There is a backward edge : so there is a cycle");
                return;
            }
            if(!vertex.isVisited()){
                System.out.println("Visiting vertex "+vertex+" recursively");
                dfs(vertex);
            }
        }
        System.out.println("Set vertex "+v+" setBeingVisited(false) visited(true)");
        v.setBeingVisited(false);
        v.setVisited(true);

    }
}
