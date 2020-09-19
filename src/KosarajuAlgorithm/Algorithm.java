package KosarajuAlgorithm;

public class Algorithm {
 //private int [] ids;
 private int count;
 private boolean[] marked;

    public Algorithm(Graph graph) {
         DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph.getTransposedGraph());
        // ids = new int[graph.getVertexList().size()];
         marked = new boolean[graph.getVertexList().size()];

         for(Vertex vertex : depthFirstOrder.getReversePost() ){
             if(!marked[vertex.getId()]){
                 DFS(vertex);
                 count++;
             }
         }

    }

    private void DFS(Vertex vertex){
         marked[vertex.getId()] = true;
        // ids[vertex.getId()] = count;
         vertex.setComponentId(count);
         for (Vertex v : vertex.getAdjaenciesList()){
             if(!marked[v.getId()]){
                 DFS(v);
             }
         }
    }
    public int getCount(){
        return count;
    }
}
