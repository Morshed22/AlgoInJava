package com.morshed.MazeSolver;

public class MazeSolving {

   private int [][] matrix ;
   private boolean[][] visited;

    public void doMazeOperation(int[][] matrix, int startRow, int startCol){
        this.matrix = matrix;
        this.visited = new boolean[matrix.length][matrix.length];
        try {
            dfs(startRow,startCol, this.matrix.length-1);
            System.out.println("No solution found!!!");
        }catch (RuntimeException e){
            System.out.println("Route found exit");
        }
    }
    private void dfs(int rowIndex, int colIndex, int end){

        System.out.println("Visiting i = "+rowIndex+", j = "+colIndex+" ");

        if(this.matrix[rowIndex][colIndex] == 3){
            throw new RuntimeException();
        }

        if(visited[rowIndex][colIndex]) {
            return;
        }else if(rowIndex < 0 || rowIndex > end){
            return;
        }else if(colIndex < 0 || colIndex > end){
            return;
        }else if(matrix[rowIndex][colIndex] == 1){
            return;
        }else {
            this.visited[rowIndex][colIndex] = true;
            dfs(rowIndex+1, colIndex, end); //going down
            dfs(rowIndex, colIndex+1, end); //going right
            dfs(rowIndex-1, colIndex, end); //going up
            dfs(rowIndex, colIndex-1, end); //going left
        }

    }
}
