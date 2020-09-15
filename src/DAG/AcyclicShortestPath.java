package DAG;


import java.util.List;
import java.util.Stack;

public class AcyclicShortestPath {
    public void shortestPath(List<Vertex> vertexList, Vertex source, Vertex target){
        source.setMinDistance(0);
        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.makeTopologicalOrder(vertexList);
        //stack
        Stack<Vertex> stack = topologicalSort.getTopologicalOrder();

        for(Vertex vertex : stack){
            for(Edge edge : vertex.getAdjacenciesList()){
                Vertex u = edge.getStartVertex();
                Vertex v = edge.getTargetVertex();

                if(u.getMinDistance() == Double.MAX_VALUE ) {
                    continue;
                }
                double newDistance = u.getMinDistance() + edge.getWeight();

                if( newDistance < v.getMinDistance() ){
                    v.setMinDistance(newDistance);
                    v.setPredecessor(u);
                }

            }
        }

        if( target.getMinDistance() == Double.MAX_VALUE){
            System.out.println("No shortest path there...");
        }else{
            System.out.println("Target vertex shortest path: "+target.getMinDistance());
        }


    }
}
