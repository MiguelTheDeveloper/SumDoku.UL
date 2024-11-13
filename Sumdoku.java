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
        int tamanho = grid.size();
        int coluna;
        int linha;

        
        if(tamanho < 3 || tamanho > 9 || grid == null){
            return false;

            
        }else{
            for (int i = 1; i <= totalCasas; i++) {
                linha = rowOfSquare(i,tamanho);
                coluna = columnOfSquare(i, tamanho);
                
                for(int j = 1; j <= grid.size(); j++){
                    
              

                    if(grid.value(linha, coluna)<1||grid.value(linha, coluna)>grid.size()||!grid.isFilled(linha, coluna)){
                        return false;
                    }
                    
                    
                    if (coluna!=j){
                        if (grid.value(linha, coluna) == grid.value(linha, j)){
                            return false;
                        }

                    } else if (linha!=j){
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

        int totalCasas= groups.gridSize()*groups.gridSize();
        boolean valido;
        final int tamanho = groups.gridSize();
        final int nGrupos = groups.numberOfGroups();
        
        if(tamanho < 3 || tamanho > 9 || groups == null){
            return false;
            
        }else{
            int coluna;
            int linha;
            
            int quadrado;
            
            
            
            if (nGrupos < 1 || nGrupos >= totalCasas){
                return false;
            }
            
            for(int j = 1; j <= nGrupos; j++){
                valido = false;
                
                for (int i = 1; i <= totalCasas; i++) {

                    linha = rowOfSquare(i,tamanho);
                    coluna = columnOfSquare(i, tamanho);
                    quadrado = groups.groupOfSquare(linha,coluna);
                    
                    if (quadrado < 1 || quadrado > nGrupos){
                        return false;
                    }
                     
                    if (quadrado == j){
                           valido = true;
                    }
 
                }

                if(!valido){return false;}
            
                
            }

            
        }
         

        return true;
    }

    public static boolean definesPuzzle(SumdokuGrid grid, GridGroups groups) {
        
        if (grid.size() == groups.gridSize()){
            return true;
        }
        
        
        
        return false;
    }

    public static String cluesToString(SumdokuGrid grid, GridGroups groups) {
        StringBuilder clue = new StringBuilder("Soma das casas: ");
        int totalCasas= groups.gridSize()*groups.gridSize();
        int counter=0;

        final int tamanho = groups.gridSize();
        final int nGrupos = groups.numberOfGroups();
        int coluna;
        int linha;
        int quadrado;
        

        for(int j = 1; j <= nGrupos; j++){
            counter = 0;
            
            for (int i = 1; i <= totalCasas; i++) {

                 
                if (quadrado == j){
                       counter++;
                }

            }

           
        
            
        }
        
        
        return "Soma das casas: G1 = 5 G2 = 2 G3 = 5 G4 = 5 G5 = 1";
    }

    public static void readGrid(int size, java.util.Scanner scanner) {
        SumdokuGrid userGrid = new SumdokuGrid(size);
        boolean valid = true;
        boolean allValid = true;
        int totalSize = size*size;
        int linha;
        int coluna;
        int value;

        do{
            for (int i = 1; i <= totalSize;i++){
            
                do{
                linha = rowOfSquare(i,size);
                coluna = columnOfSquare(i, size);
                System.out.println("Casa "+i+" :");
                value = scanner.nextInt();
                
                if(value < 1 || value > size){
                   System.out.println("Numero de Casa Invalido tem que ser entre 1 e "+size);
                   valid = false;
                }else{
                    valid = true;
                }
                
            
                }while(!valid);

            userGrid.fill(linha, coluna, value);
        }
            allValid = isValidForPuzzle(userGrid);
            
            if(!allValid){
                System.out.println("A grelha de Jogo é invalida (Reinsere a grid)");
            }

        }while (!allValid);
            
        
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
        int totalCasas = playedGrid.size()*playedGrid.size();
        int tamanho = playedGrid.size();
        int linha;
        int coluna;

        

        for (int i = 1; i <= totalCasas; i++) {
            linha = rowOfSquare(i,tamanho);
            coluna = columnOfSquare(i, tamanho);
            
            if (!playedGrid.isFilled(linha, coluna)){
                
                return false;
                
            }
            
            if (grid.value(linha, coluna) != playedGrid.value(linha, coluna)){
                return false;
            }
        
        }

        

        return true;
    }

    public static void play(SumdokuGrid grid, GridGroups groups, int maxAttempts, java.util.Scanner scanner) {
        
    }

    public static void main(String[] args) {
        Scanner inpScanner = new Scanner(System.in);
        readGrid(3, inpScanner);
        System.out.println("Olá ");
        
    }
}
