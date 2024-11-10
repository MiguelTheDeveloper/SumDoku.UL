import java.util.Scanner;


public class Sumdoku {

    public static int rowOfSquare(int square, int gridSize) {
        
        int row= (square - 1) / gridSize+1;
        return row;
    }

    public static int columnOfSquare(int square, int gridSize) {
        int column= (square - 1) % gridSize+1;
        return column;
    }

    public static boolean isValidForPuzzle(SumdokuGrid grid) {
        
        boolean valid = true;

        if(grid != null){
            valid = false;
        }
        
        for (int i = 1; i < (grid.size()*grid.size()); i++) {
            if(grid.value(rowOfSquare(i, grid.size()),columnOfSquare(i, grid.size())) > grid.size()){
                valid = false;
            }
        }
        
         

        return valid;
    }

    public static boolean isValidForPuzzle(GridGroups groups) {
        return false;
    }

    public static boolean definesPuzzle(SumdokuGrid grid, GridGroups groups) {
        return false;
    }

    public static String cluesToString(SumdokuGrid grid, GridGroups groups) {
        return "";
    }

    public static void readGrid(int size, java.util.Scanner scanner) {
        // void method, no return
    }

    public static void readGroups(SumdokuGrid grid, java.util.Scanner scanner) {
        // void method, no return
    }

    public static SumdokuGrid getBuiltInGrid(int size) {
        return null;
    }

    public static GridGroups getBuiltInGroups(int size) {
        return null;
    }

    public static boolean puzzleSolved(SumdokuGrid playedGrid, SumdokuGrid grid) {
        return false;
    }

    public static void play(SumdokuGrid grid, GridGroups groups, int maxAttempts, java.util.Scanner scanner) {
        // void method, no return
    }

    public static void main(String[] args) {
        
        
    }
}
