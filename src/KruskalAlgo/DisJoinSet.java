package KruskalAlgo;

import java.util.ArrayList;
import java.util.List;

public class DisJoinSet {
    private int nodeCount = 0;
    private int setCount =0;
    private List<Node> rootNodes;

    public    DisJoinSet(List<Vertex> vertexList){
        this.rootNodes = new ArrayList<>(vertexList.size());
        makeSets(vertexList);
    }
    private void makeSets(List<Vertex> vertexList){
        for (Vertex vertex : vertexList){
            makeSet(vertex);
        }
    }
    public int find(Node node){
        Node currentNode = node;
        while (currentNode.getParent() != null){
            currentNode = currentNode.getParent();
        }

        Node rootNode = currentNode;
        currentNode = node;

        // this code is path compression it will take O(1) time
        while (currentNode != rootNode){
            Node tempNode = currentNode.getParent();
            currentNode.setParent(rootNode);
            currentNode = tempNode;
        }
        return rootNode.getId();
    }
    public void union(Node n1, Node n2){
        int index1 = find(n1);
        int index2 = find(n2);
        if(index1 == index2){
            return;
        }
    Node root1 = this.rootNodes.get(index1);
    Node root2 = this.rootNodes.get(index2);
    if(root1.getRank() < root2.getRank()){
        root1.setParent(root2);
    }else if(root1.getRank() > root2.getRank()){
        root2.setParent(root1);
    }else {
        root2.setParent(root1);
        root1.setRank(root1.getRank()+1);
    }
    this.setCount--;
    }

    private void makeSet(Vertex vertex){
        Node node = new Node(this.rootNodes.size(), 0, null);
        vertex.setNode(node);
        this.rootNodes.add(node);
        this.setCount++;
        this.nodeCount++;
    }
}
