package DijkstraAlgo;

import java.util.*;

public class DijkstraAlgorithm {

     public void computePaths(Vertex sourceVertex){
         sourceVertex.setDistance(0);
         PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
         priorityQueue.add(sourceVertex);
         while (!priorityQueue.isEmpty()){
             Vertex actualVertex = priorityQueue.poll();
            // actualVertex.setVisited(true);

             for(Edge edge : actualVertex.getAdjacencyList()){
                 Vertex targetVertex = edge.getTargetVertex();
                 double distance = actualVertex.getDistance() + edge.getWeight();
                 if (distance < targetVertex.getDistance()){
                     priorityQueue.remove(targetVertex);
                     targetVertex.setDistance(distance);
                     targetVertex.setPredecessor(actualVertex);
                     priorityQueue.add(targetVertex);
                 }
             }
         }
     }

     public List<Vertex> getShortestPathTo(Vertex targetVertex){
         List<Vertex> shortestPathToTarget = new ArrayList<>();
         while (targetVertex != null){
             shortestPathToTarget.add(targetVertex);
             targetVertex = targetVertex.getPredecessor();
         }
         Collections.reverse(shortestPathToTarget);
         return shortestPathToTarget;
     }
   
}
