package com.morshed.MazeSolver;

public class App {
    public static void main(String[] args) {

        int [][] mazeMatrix = {
                {1,1,1,1,1},
                {1,2,0,1,1},
                {1,1,0,1,1},
                {1,1,0,3,1},
                {1,1,1,1,1}
        };

       MazeSolving mazeSolving = new MazeSolving();
       mazeSolving.doMazeOperation(mazeMatrix, 1, 1);
    }
}
