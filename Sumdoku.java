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

        int totalCasas= grid.size()*grid.size();

        
        if(grid == null){
            return false;

            
        }else{
            int coluna;
            int linha;
            int tamanho = grid.size();
            
            

            for (int i = 1; i <= totalCasas; i++) {
                linha = rowOfSquare(i,tamanho);
                coluna = columnOfSquare(i, tamanho);
                
                for(int j = 1; j <= grid.size(); j++){
                    
              

                    if(grid.value(linha, coluna)<1||grid.value(linha, coluna)>grid.size()){
                        return false;
                    }
                    
                    
                    if (coluna!=j){
                        if (grid.value(linha, coluna) == grid.value(linha, j)){
                            return false;
                        }

                    }

                    if (linha!=j){
                        if (grid.value(linha, coluna) == grid.value(j, coluna)){
                            return false;
                        }
                    }

                     
                    
                }

                
            
                
            }

            
        }
         

        return true;
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
        
    }

    public static void readGroups(SumdokuGrid grid, java.util.Scanner scanner) {
        
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
        
    }

    public static void main(String[] args) {
        System.out.println("Olá ");
        
    }
}
