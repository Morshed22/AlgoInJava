package BellmanfordAlgo;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Vertex> vertexList = new ArrayList<>();

        vertexList.add(new Vertex("A"));
        vertexList.add(new Vertex("B"));
        vertexList.add(new Vertex("C"));

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge( vertexList.get(0), vertexList.get(1),1));
        edgeList.add(new Edge( vertexList.get(1), vertexList.get(2),-1));
        edgeList.add(new Edge( vertexList.get(2), vertexList.get(0),-11));

        BellmanFordAlgorithm bellmanFordAlgorithm = new BellmanFordAlgorithm(edgeList,vertexList);
        bellmanFordAlgorithm.computeBellmanFord(vertexList.get(0));
        //bellmanFordAlgorithm.getShortestPathTo(vertexList.get(2));

    }


}
