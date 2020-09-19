package TarjanAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Algorithm {
    private Stack<Vertex> stack;
    private List<Vertex> vertexList;
    private List<List<Vertex>> connectedComponents;
    private int id = 0;
    private int count = 0;

    public Algorithm(List<Vertex> vertexList) {
        this.stack = new Stack<>();
        this.vertexList = vertexList;
        this.connectedComponents = new ArrayList<>();
    }
    public void runAlgorithm(){
        for(Vertex vertex : vertexList){
            if(!vertex.isVisited()){
                DFS(vertex);
            }
        }
    }
    private void DFS(Vertex vertex){
        vertex.setLowLink(id++);
        System.out.println("Visiting vertex " +vertex+ " with lowlink " + vertex.getLowLink());
        vertex.setVisited(true);
        this.stack.add(vertex);
        boolean isRootNode = true;
        for(Vertex v : vertex.getNeighbourList()){
            if(!v.isVisited()){
                DFS(v);
            }

            if(vertex.getLowLink() > v.getLowLink()){
               // System.out.println();
               vertex.setLowLink(v.getLowLink());
               isRootNode = false;
            }
        }
        if(isRootNode){
            count++;
            List<Vertex> component = new ArrayList<>();
            while (true){
                Vertex actualVertex = stack.pop();
                component.add(actualVertex);
                actualVertex.setLowLink(Integer.MAX_VALUE);
                if(actualVertex.getName().equals(vertex.getName())) break;
            }
            connectedComponents.add(component);
        }
    }

    public void printComponents(){
        System.out.println(this.connectedComponents);
    }
}
