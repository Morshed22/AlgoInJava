package TSP;

public class TSPRun {
    public static void main(String[] args) {
        int n = 6;
        int[][] distanceMatrix = new int[n][n];
        for (int[] row : distanceMatrix) java.util.Arrays.fill(row, 10000);
        distanceMatrix[5][0] = 10;
        distanceMatrix[1][5] = 12;
        distanceMatrix[4][1] = 2;
        distanceMatrix[2][4] = 4;
        distanceMatrix[3][2] = 6;
        distanceMatrix[0][3] = 8;

        TravelingSalesmanHeldKarp t = new TravelingSalesmanHeldKarp();
        t.minCost(distanceMatrix);
    }
}
