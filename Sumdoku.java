import java.util.Scanner;


public class Sumdoku {

    /**
     * Lê um inteiro do usuário que deve estar dentro de um intervalo específico.
     *
     * @param min     O valor mínimo permitido.
     * @param max     O valor máximo permitido.
     * @param reader  O objeto Scanner para leitura de entradas.
     * @return        Um inteiro válido entre min e max.
     */
    public static int readIntInInterval (int min, int max, Scanner reader) { 
        int input = reader.nextInt(); 
        while (input > max || input < min) {
            System.out.println("Valor inválido. Tem que estar entre " + min + " e " + max + ".");
            input = reader.nextInt();
        }
        return input;
    }


    /**
     * Calcula a linha correspondente a uma célula específica em uma grelha.
     *
     * @param square   O número da célula (1 a n^2).
     * @param gridSize O tamanho da grelha (n).
     * @return         A linha correspondente (1 a n).
     */
    public static int rowOfSquare(int square, int gridSize) {
        
        int row = (square - 1) / gridSize + 1;
        return row;
    }

    /**
     * Calcula a coluna correspondente a uma célula específica em uma grelha.
     *
     * @param square   O número da célula (1 a n^2).
     * @param gridSize O tamanho da grelha (n).
     * @return         A coluna correspondente (1 a n).
     */
    public static int columnOfSquare(int square, int gridSize) {
        int column= (square - 1) % gridSize+1;
        return column;
    }

    /**
     * Verifica se uma grelha Sumdoku é válida.
     *
     * @param grid A grelha a ser verificada.
     * @return     true se a grelha for válida, false caso contrário.
     */
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
    
    /**
     * Verifica se os grupos de uma grelha são válidos.
     *
     * @param groups Os grupos a serem verificados.
     * @return       true se os grupos forem válidos, false caso contrário.
     */
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
    /**
     * Verifica se uma grelha e seus grupos definem um puzzle resolvível.
     *
     * @param grid   A grelha de jogo.
     * @param groups Os grupos de células.
     * @return       true se o puzzle for válido e resolvível, false caso contrário.
     */
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

    /**
     * Converte as pistas do puzzle em uma string formatada.
     *
     * @param grid   A grelha de jogo.
     * @param groups Os grupos de células.
     * @return       Uma string representando as pistas.
     */
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

    /**
     * Lê uma grelha de entrada do usuário e garante que ela seja válida.
     *
     * @param size    O tamanho da grelha.
     * @param scanner O objeto Scanner para leitura de entradas.
     * @return        Uma grelha preenchida pelo usuário.
     */
    public static SumdokuGrid readGrid(int size, java.util.Scanner scanner) {
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
            
        return userGrid;
    }

    /**
     * Lê grupos de entrada do usuário e os organiza em uma estrutura de grupos.
     *
     * @param grid    A grelha associada.
     * @param scanner O objeto Scanner para leitura de entradas.
     * @return        Uma estrutura de grupos preenchida pelo usuário.
     */
    public static GridGroups readGroups(SumdokuGrid grid, java.util.Scanner scanner) {
        
        int tamanho = grid.size();
        int totalCasas = grid.size()*grid.size();
        int casasDisponiveis = totalCasas;
        boolean valid;
        boolean allValid=false;
        int tamGrupos = 0;

        
        //Pergunta ao utilizador o numero de grupos que deseja fazer
        System.out.println("Quantos Grupos Quer Fazer?");
        int nGrupos = readIntInInterval(1, totalCasas, scanner);

        GridGroups grupoUser = new GridGroups(grid.size(), nGrupos);
        
       
        while (!allValid) {
            
        // -Itera o numero de grupos que o utilizador escolhe fazer
        for (int i=1;i <=nGrupos;i++){
            
            // -Pergunta o tamanho do grupo
            System.out.println("Tamanho do grupo "+i+"? :");
            tamGrupos = readIntInInterval(1, casasDisponiveis, scanner);
            
            for(int j=1;j <= tamGrupos;j++){
                valid = false;
                while(!valid){
                
                System.out.println("Casa ?:");
                int casa = readIntInInterval(1, totalCasas, scanner);

                int linha = rowOfSquare(casa, tamanho);
                int coluna = columnOfSquare(casa, tamanho);
                
                if(grupoUser.groupOfSquare(linha,coluna)==0){
                    grupoUser.addSquareToGroup(linha, coluna, i);
                    valid = true;
                }else{
                    System.out.println("Casa ja preenchida (Escolha outra)");
                }

                }

                
            }

            casasDisponiveis -= tamGrupos;

        }

        if(!isValidForPuzzle(grupoUser)) {
            System.out.println("Grupos Invalidos Faz de novo");
        } else{
            allValid=true;
        }

        }
        return grupoUser;

    }


    //Creates a predefined grid for the sizes of 3 and 5.   
    public static SumdokuGrid getBuiltInGrid(int size) {
           
       SumdokuGrid grid = new SumdokuGrid(0);

       if(size == 3){
        grid = new SumdokuGrid(3);
           grid.fill(1, 1, 1);
           grid.fill(1, 2, 2);
           grid.fill(1, 3, 3);
           grid.fill(2, 1, 2);
           grid.fill(2, 2, 3);
           grid.fill(2, 3, 1);
           grid.fill(3, 1, 3);
           grid.fill(3, 2, 2);
           grid.fill(3, 3, 1);
       }else if(size == 5){
        grid = new SumdokuGrid(5);
           grid.fill(1, 1, 1);
           grid.fill(1, 2, 2);
           grid.fill(1, 3, 3);
           grid.fill(1, 4, 4);
           grid.fill(1, 5, 5);
           grid.fill(2, 1, 2);
           grid.fill(2, 2, 3);
           grid.fill(2, 3, 4);
           grid.fill(2, 4, 5);
           grid.fill(2, 5, 1);
           grid.fill(3, 1, 3);
           grid.fill(3, 2, 4);
           grid.fill(3, 3, 5);
           grid.fill(3, 4, 1);
           grid.fill(3, 5, 2);
           grid.fill(4, 1, 4);
           grid.fill(4, 2, 5);
           grid.fill(4, 3, 1);
           grid.fill(4, 4, 2);
           grid.fill(4, 5, 3);
           grid.fill(5, 1, 5);
           grid.fill(5, 2, 1);
           grid.fill(5, 3, 2);
           grid.fill(5, 4, 3);
           grid.fill(5, 5, 4);
       }else if(size == 6){
            grid = new SumdokuGrid(6);
            grid.fill(1, 1, 1);
            grid.fill(1, 2, 2);
            grid.fill(1, 3, 3);
            grid.fill(1, 5, 5);
            grid.fill(1, 4, 4);
            grid.fill(1, 6, 6);
            grid.fill(2, 1, 2);
            grid.fill(2, 2, 3);
            grid.fill(2, 3, 4);
            grid.fill(2, 4, 5);
            grid.fill(2, 5, 6);
            grid.fill(2, 6, 1);
            grid.fill(3, 1, 3);
            grid.fill(3, 2, 4);
            grid.fill(3, 3, 5);
            grid.fill(3, 4, 6);
            grid.fill(3, 5, 1);
            grid.fill(3, 6, 2);
            grid.fill(4, 1, 4);
            grid.fill(4, 2, 5);
            grid.fill(4, 3, 6);
            grid.fill(4, 4, 1);
            grid.fill(4, 5, 2);
            grid.fill(4, 6, 3);
            grid.fill(5, 1, 5);
            grid.fill(5, 2, 6);
            grid.fill(5, 3, 1);
            grid.fill(5, 4, 2);
            grid.fill(5, 5, 3);
            grid.fill(5, 6, 4);
            grid.fill(6, 1, 6);
            grid.fill(6, 2, 1);
            grid.fill(6, 3, 2);
            grid.fill(6, 4, 3);
            grid.fill(6, 5, 4);
            grid.fill(6, 6, 5);

       }
       
       
       
       return grid;
   
		
	
    }

    public static GridGroups getBuiltInGroups(int size) {
        return null;
    }

    /**
    * Verifica se a grelha jogada (playedGrid) é igual à grelha de solução (grid).
    * <p>
    * O método compara todos os valores de cada casa na grelha jogada com os valores correspondentes
    * na grelha de solução. Se todas as casas estiverem preenchidas corretamente e os valores
    * coincidirem, o método retorna true, indicando que o puzzle foi resolvido corretamente.
    * Caso contrário, retorna false.
    *
    * @param playedGrid A grelha jogada, que é a configuração atual do jogo.
    * @param grid A grelha de solução, que contém a configuração correta e resolvida do jogo.
    * @return true se a grelha jogada for igual à grelha de solução; false caso contrário.
    */
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
        
        System.out.println("Bem vindo ao Sumdoku \n");

        if (args.length == 0){
            Scanner inpScanner = new Scanner(System.in);

            System.out.println("tamanho da Grid: ");
            int tamGrid=readIntInInterval(3, 9, inpScanner);
    
            SumdokuGrid usrGrid = readGrid(tamGrid, inpScanner);
            readGroups(usrGrid, inpScanner);

        }else{
            int argSizeGrid = Integer.parseInt(args[0]);
            SumdokuGrid builtInGrid = getBuiltInGrid(argSizeGrid);
            System.out.println(builtInGrid.toString());
            System.out.println(isValidForPuzzle(builtInGrid));
        }
        

        
        
        
    }
}
