import java.util.Scanner;


public class Sumdoku {

    public static int rowOfSquare(int square, int gridSize) {
        
        int row = (square - 1) / gridSize + 1;
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
                
                if(grid.value(linha, coluna)<1||grid.value(linha, coluna)>grid.size()||!grid.isFilled(linha, coluna)){
                    return false;
                }
                
                for(int j = linha; j <= grid.size(); j++){
                     if (linha!=j){
                        if (grid.value(linha, coluna) == grid.value(j, coluna)){
                            return false;
                        }
                    }     
                }

                for(int j = coluna; j <= grid.size(); j++){
                    if (coluna!=j){
                        if (grid.value(linha, coluna) == grid.value(linha, j)){
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
        int tamanho = groups.gridSize();
        int nGrupos = groups.numberOfGroups();
        
        if(tamanho < 3 || tamanho > 9 || groups == null){
            return false;
            
        }else{
            int coluna;
            int linha;
            
            int grupoDoQuadrado;
            
            
            
            if (nGrupos < 1 || nGrupos > totalCasas){
                return false;
            }
            
            for(int j = 1; j <= nGrupos; j++){
                valido = false;
                
                for (int i = 1; i <= totalCasas; i++) {

                    linha = rowOfSquare(i,tamanho);
                    coluna = columnOfSquare(i, tamanho);
                    grupoDoQuadrado = groups.groupOfSquare(linha,coluna);
                    
                    if (grupoDoQuadrado < 1 || grupoDoQuadrado > nGrupos){
                        return false;
                    }
                     
                    if (grupoDoQuadrado == j){
                           valido = true;
                    }
 
                }

                if(!valido){return false;}
            
                
            }

            
        }
         

        return true;
    }

    public static boolean definesPuzzle(SumdokuGrid grid, GridGroups groups) {
      

        if (grid.size() != groups.gridSize()){
            return false;
        }
        
        SumdokuSolver solved = new SumdokuSolver(grid, groups);

        if(solved.howManySolutions(2) > 1){
                 return false;
        }

        return true;
    }

    public static String cluesToString(SumdokuGrid grid, GridGroups groups) {
        StringBuilder clue = new StringBuilder("Soma das casas:");
        
        int totalCasas= groups.gridSize()*groups.gridSize();
        int counter=0;

        int tamanho = groups.gridSize();
        int nGrupos = groups.numberOfGroups();
        int coluna;
        int linha;
        int quadrado;
        int grupoQuadrado;

        

        for(int j = 1; j <= nGrupos; j++){
            
            
            for (int i = 1; i <= totalCasas; i++) {
                linha = rowOfSquare(i,tamanho);
                coluna = columnOfSquare(i, tamanho);
                grupoQuadrado = groups.groupOfSquare(linha,coluna);
                quadrado = grid.value(linha, coluna);

                 
                if (grupoQuadrado == j){
                       counter += quadrado ;
                }
                
            }

            clue.append(" G" + j + " = "+counter);
            counter = 0;
        
            
        }
        clue.append(" \n");
        
        return clue.toString();
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
