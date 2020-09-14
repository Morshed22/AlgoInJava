package BellmanfordAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BellmanFordAlgorithm {
    private List<Edge> edgeList;
    private List<Vertex> vertexList;

    public BellmanFordAlgorithm(List<Edge> edgeList, List<Vertex> vertexList) {
        this.edgeList = edgeList;
        this.vertexList = vertexList;
    }
    public void computeBellmanFord(Vertex sourceVertex){
        sourceVertex.setMinDistance(0);
        for(int i = 0; i <vertexList.size()-1; i++){
            for(Edge edge : edgeList){

                Vertex u = edge.getStartVertex();
                Vertex v = edge.getTargetVertex();

                if(u.getMinDistance() == Double.MAX_VALUE ) {
                    continue;
                }
                double newDistance = u.getMinDistance() + edge.getWeight();

                if (newDistance <  v.getMinDistance()){
                    v.setMinDistance(newDistance);
                    v.setPreviousVertex(u);
                }
            }
        }

        for(Edge edge : edgeList){
            if(edge.getStartVertex().getMinDistance() != Double.MAX_VALUE){
                if(hasCycle(edge)){
                    System.out.println("There has been negative cycle detected ....");
                    return;
                }
            }
        }
    }
    private boolean hasCycle(Edge edge){
        return edge.getStartVertex().getMinDistance() + edge.getWeight() < edge.getTargetVertex().getMinDistance();
    }
    public void getShortestPathTo(Vertex targetVertex){
        if(targetVertex.getMinDistance() == Double.MAX_VALUE)
            System.out.println("There is no shortest path from source to target");
        System.out.println("There is a shortest path from sourco to target, with cost: " + targetVertex.getMinDistance());
        while (targetVertex != null){
            System.out.println(targetVertex + "-");
            targetVertex = targetVertex.getPreviousVertex();
        }
    }
}
