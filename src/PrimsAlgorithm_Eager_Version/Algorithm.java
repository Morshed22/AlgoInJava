package PrimsAlgorithm_Eager_Version;

import java.util.List;
import java.util.PriorityQueue;

public class Algorithm {
    private List<Vertex> vertexList;
    private PriorityQueue<Vertex> heap;

    public Algorithm(Graph graph) {
        this.vertexList = graph.getVertexList();
        this.heap = new PriorityQueue<>();
    }
    public void spanningTree(){
        for(Vertex vertex : vertexList){
            if(!vertex.isVisited()){
               greedyPrimsAlgo(vertex);
            }
        }
    }
    private void greedyPrimsAlgo(Vertex vertex){
        vertex.setMinDistance(0);
        heap.add(vertex);
        while (!heap.isEmpty()){
            Vertex v = heap.remove();
           scanVertex(v);
        }
    }
    private void scanVertex(Vertex vertex){
        for(Edge edge : vertex.getAdjacencies()){
            Vertex v = edge.getTargetVertex();

            if(v.isVisited()) continue;

            if(edge.getWeight() < v.getMinDistance()){
                v.setMinDistance(edge.getWeight());
                v.setMinEdge(edge);

                if(heap.contains(v)){
                    heap.remove(v);
                }
                heap.add(v);
            }

        }
    }
    public void show(){
        for (Vertex vertex:vertexList){
            if(vertex.getMinEdge() != null){
                Edge e = vertex.getMinEdge();
                System.out.println("Edge: "+ e.getStartVertex() + "-" + e.getTargetVertex());
            }
        }
    }
}
