package PrimsAlgorithm_Lazy_Version;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Algorithm {
    private List<Vertex> unvisitedVertex;
    private List<Edge> minimumSpanningTree;
    private PriorityQueue<Edge> edgeHeap;
    private double fullCost;

    public Algorithm(List<Vertex> unvisitedVertex) {
        this.unvisitedVertex = unvisitedVertex;
        this.edgeHeap = new PriorityQueue<>();
        this.minimumSpanningTree = new ArrayList<>();
    }
    public void doOperation(Vertex vertex){
        this.unvisitedVertex.remove(vertex);

        while (!unvisitedVertex.isEmpty()){
            for(Edge edge : vertex.getAdjacencies()){

                if(this.unvisitedVertex.contains(edge.getTargetVertex())){
                    edgeHeap.add(edge);
                }
               Edge minEdge = this.edgeHeap.remove();
                this.minimumSpanningTree.add(edge);
                this.fullCost+= minEdge.getWeight();
                vertex = minEdge.getTargetVertex();
                this.unvisitedVertex.remove(vertex);
            }

        }
    }

    public void showMST(){
        System.out.println("The minimum spanning tree cost : + this.fullCost");
        for (Edge edge :minimumSpanningTree){
            System.out.println(edge.getStartVertex() + " - " +edge.getTargetVertex());
        }
    }
}
