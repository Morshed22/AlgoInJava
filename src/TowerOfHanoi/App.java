package TowerOfHanoi;

public class App {
    public static void main(String[] args) {
        hanoiProblem(3, 'A', 'B', 'C');

    }
    private static void hanoiProblem(int n, char fromRoad, char middleRoad, char toRoad){
        if(n == 1){
            System.out.println("Plate 1 from "+ fromRoad +" to " + toRoad);
            return;
        }
        hanoiProblem(n-1, fromRoad, toRoad, middleRoad);
        System.out.println("Plate "+n+" from "+ fromRoad +" to " + toRoad);
        hanoiProblem(n-1, middleRoad, fromRoad, toRoad);
    }
}
