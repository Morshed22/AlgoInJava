package KruskalAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {
    public void spanningTree(List<Vertex> vertexList, List<Edge> edgeList) {
        DisJoinSet disJoinSet = new DisJoinSet(vertexList);
        List<Edge> mst = new ArrayList<>();
        Collections.sort(edgeList);
        for(Edge edge : edgeList){
            Vertex u = edge.getStartVertex();
            Vertex v = edge.getTargetVertex();

            if(disJoinSet.find(u.getNode()) != disJoinSet.find(v.getNode())){
                mst.add(edge);
                disJoinSet.union(u.getNode(), v.getNode());
            }
        }
        for (Edge edge : mst){
            System.out.println(edge.getStartVertex() + " "+ edge.getTargetVertex()+" -- ");
        }

    }
}
