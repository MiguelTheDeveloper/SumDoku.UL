import java.util.Scanner;

/**
 * Classe que implementa a lógica do jogo Sumdoku.
 * Esta classe contém métodos para gerar grelhas e grupos predefinidos, ler entradas do utilizador e verificar se o puzzle está resolvido.
 * 
 * @author Miguel Cabeça, Duarte Rodrigues
 */
public class Sumdoku {
    
    /**
     * Gera uma grelha Sumdoku predefinida com base no tamanho fornecido.
     *
     * @param size o tamanho da grelha (por exemplo, 3 ou 5)
     * @return um objeto SumdokuGrid preenchido se o tamanho for válido; caso contrário, retorna null
     * @requires size deve ser 3 ou 5 para grelhas predefinidas válidas.
     */
    public static SumdokuGrid getBuiltInGrid(int size) {
           
            SumdokuGrid grid;
     
            if(size == 3){
                 grid = new SumdokuGrid(3);
                 grid.fill(1, 1, 1);
                 grid.fill(1, 2, 2);
                 grid.fill(1, 3, 3);
                 grid.fill(2, 1, 2);
                 grid.fill(2, 2, 3);
                 grid.fill(2, 3, 1);
                 grid.fill(3, 1, 3);
                 grid.fill(3, 2, 1);
                 grid.fill(3, 3, 2);
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
            }else{
                
                 grid=null;
            }
            
            
            
            return grid;
     
         }
     
    /**
     * Gera grupos predefinidos para uma grelha Sumdoku com base no tamanho fornecido.
     *
     * @param size o tamanho da grelha (por exemplo, 3 ou 5)
     * @return um objeto GridGroups contendo grupos predefinidos para a grelha
     * @requires size deve ser 3 ou 5 para grelhas predefinidas válidas.
     */
    public static GridGroups getBuiltInGroups(int size) {
            int numberOfGroups;
            GridGroups predefGroups;
    
    
            if (size == 3) {
                numberOfGroups = 3;
                predefGroups = new GridGroups(size, numberOfGroups);
                predefGroups.addSquareToGroup(1, 1, 1);
                predefGroups.addSquareToGroup(1, 2, 2);
                predefGroups.addSquareToGroup(1, 3, 3);
                predefGroups.addSquareToGroup(2, 1, 3);
                predefGroups.addSquareToGroup(2, 2, 1);
                predefGroups.addSquareToGroup(2, 3, 2);
                predefGroups.addSquareToGroup(3, 1, 2);
                predefGroups.addSquareToGroup(3, 2, 3);
                predefGroups.addSquareToGroup(3, 3, 1);
                
            }else if (size == 5) {
                numberOfGroups = 3;
                predefGroups = new GridGroups(size, numberOfGroups);
                predefGroups.addSquareToGroup(1, 1, 1);
                predefGroups.addSquareToGroup(1, 2, 2);
                predefGroups.addSquareToGroup(1, 3, 3);
                predefGroups.addSquareToGroup(1, 4, 3);
                predefGroups.addSquareToGroup(1, 5, 1);
                predefGroups.addSquareToGroup(2, 1, 2);
                predefGroups.addSquareToGroup(2, 2, 2);
                predefGroups.addSquareToGroup(2, 3, 3);
                predefGroups.addSquareToGroup(2, 4, 1);
                predefGroups.addSquareToGroup(2, 5, 1);
                predefGroups.addSquareToGroup(3, 1, 2);
                predefGroups.addSquareToGroup(3, 2, 3);
                predefGroups.addSquareToGroup(3, 3, 3);
                predefGroups.addSquareToGroup(3, 4, 1);
                predefGroups.addSquareToGroup(3, 5, 2);
                predefGroups.addSquareToGroup(4, 1, 2);
                predefGroups.addSquareToGroup(4, 2, 3);
                predefGroups.addSquareToGroup(4, 3, 1);
                predefGroups.addSquareToGroup(4, 4, 1);
                predefGroups.addSquareToGroup(4, 5, 2);
                predefGroups.addSquareToGroup(5, 1, 3);
                predefGroups.addSquareToGroup(5, 2, 3);
                predefGroups.addSquareToGroup(5, 3, 1);
                predefGroups.addSquareToGroup(5, 4, 2);
                predefGroups.addSquareToGroup(5, 5, 2);
            }else{
               
                predefGroups=null;
               }
            
            return predefGroups;
    
        }
    

    /**
     * Lê um número inteiro dentro de um intervalo dado.
     *
     * @param min o valor mínimo permitido
     * @param max o valor máximo permitido
     * @param reader o scanner para ler a entrada do utilizador
     * @return um número inteiro dentro do intervalo especificado
     * @requires min <= max e reader não pode ser null
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
    * Calcula o índice da linha para um dado número de quadrado na grelha.
    *
    * @param square   o número do quadrado (índice baseado em 1)
    * @param gridSize o tamanho da grelha
    * @return o número da linha do quadrado
    * @requires square deve estar entre 1 e gridSize^2; gridSize deve ser > 0.
    */
    public static int rowOfSquare(int square, int gridSize) {
        
        int row = (square - 1) / gridSize + 1;
        return row;
    }
    
    /**
    * Calcula o índice da coluna para um dado número de quadrado na grelha.
    *
    * @param square   o número do quadrado (índice baseado em 1)
    * @param gridSize o tamanho da grelha
    * @return o número da coluna do quadrado
    * @requires square deve estar entre 1 e gridSize^2; gridSize deve ser > 0.
    */
    public static int columnOfSquare(int square, int gridSize) {
        int column= (square - 1) % gridSize+1;
        return column;
    }


    /**
     * Verifica se a grelha fornecida é válida para o puzzle.
     *
     * @param grid a grelha Sumdoku a ser verificada
     * @return true se a grelha for válida, false caso contrário
     * @requires grid não pode ser null
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
                
                for(int j = 1; j <= grid.size(); j++){
                     if (linha!=j){
                        if (grid.value(linha, coluna) == grid.value(j, coluna)){
                            return false;
                        }
                    }     
                }

                for(int j = 1; j <= grid.size(); j++){
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
    * Valida se um dado objeto GridGroups satisfaz as regras do puzzle.
    *
    * @param groups o objeto GridGroups a validar
    * @return true se os grupos forem válidos; false caso contrário
    * @requires groups não deve ser nulo.
    */
    public static boolean isValidForPuzzle(GridGroups groups) {

       
        boolean valido;
        int tamanho = groups.gridSize();
        int totalCasas= tamanho*tamanho;
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
    * Determina se uma grelha Sumdoku e os grupos definem um puzzle resolúvel.
    *
    * @param grid   o objeto SumdokuGrid
    * @param groups o objeto GridGroups
    * @return true se a grelha e os grupos definirem um puzzle válido; false caso contrário
    * @requires grid e groups não devem ser nulos; grid.size() deve ser igual a groups.gridSize().
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
    * Constrói uma representação em string das pistas para o puzzle, mostrando a soma de cada grupo.
    *
    * @param grid   o objeto SumdokuGrid
    * @param groups o objeto GridGroups
    * @return uma string contendo as pistas do puzzle
    * @requires grid e groups não devem ser nulos; grid.size() deve ser igual a groups.gridSize().
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
    * Lê uma grelha Sumdoku a partir da entrada do utilizador, validando após cada entrada.
    *
    * @param size    o tamanho da grelha
    * @param scanner um objeto Scanner para ler a entrada do utilizador
    * @return um objeto SumdokuGrid válido inserido pelo utilizador
    * @requires size deve ser >= 3 e <= 9; scanner não deve ser nulo.
    */
    public static SumdokuGrid readGrid(int size, Scanner scanner) {
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
    * Lê os grupos para uma grelha Sumdoku a partir da entrada do utilizador, validando as atribuições dos grupos.
    *
    * @param grid    o objeto SumdokuGrid para o qual os grupos estão a ser definidos
    * @param scanner um objeto Scanner para ler a entrada do utilizador
    * @return um objeto GridGroups válido inserido pelo utilizador
    * @requires grid não deve ser nulo; scanner não deve ser nulo.
    */
    public static GridGroups readGroups(SumdokuGrid grid, Scanner scanner) {
        
        int tamanho = grid.size();
        int totalCasas = grid.size()*grid.size();
        int casasDisponiveis;
        boolean valid;
        boolean allValid=false;
        int tamGrupos = 0;
        GridGroups grupoUser = null;

        while (!allValid) {
            //Pergunta ao utilizador o numero de grupos que deseja fazer
            System.out.println("Quantos Grupos Quer Fazer?");
            int nGrupos = readIntInInterval(1, totalCasas, scanner);

            grupoUser = new GridGroups(grid.size(), nGrupos);
        
       
        
            casasDisponiveis= totalCasas;
            // -Itera o numero de grupos que o utilizador escolhe fazer
            for (int i=1;i <=nGrupos;i++){
                
                if(casasDisponiveis != 0){
                    
                    // Pergunta o tamanho do grupo
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
          
            }

            if(!isValidForPuzzle(grupoUser)) {

                System.out.println("Grupo Criado é invalido");

            }else{

                allValid=true;

            }

        }

        return grupoUser;

    }


    /**
     * Verifica se o puzzle foi resolvido ao comparar a grelha jogada com a grelha solução.
     *
     * @param playedGrid o objeto SumdokuGrid representando a grelha jogada pelo utilizador
     * @param grid       o objeto SumdokuGrid representando a solução do puzzle
     * @return true se o puzzle estiver resolvido; false caso contrário
     * @requires playedGrid e grid não devem ser nulos; playedGrid.size() deve ser igual a grid.size().
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


    /**
    * Executa o jogo Sumdoku, permitindo ao utilizador jogar e tentar resolver o puzzle.
    *
    * @param grid        o objeto SumdokuGrid solução
    * @param groups      o objeto GridGroups definindo os grupos
    * @param maxAttempts o número máximo de tentativas permitidas ao utilizador
    * @param scanner     um objeto Scanner para ler a entrada do utilizador
    * @requires grid e groups não devem ser nulos; scanner não deve ser nulo; maxAttempts >= 1.
    */
    public static void play(SumdokuGrid grid, GridGroups groups, int maxAttempts, Scanner scanner) {
        SumdokuGrid playedGrid = new SumdokuGrid(grid.size());
        int tamanho = grid.size();
        int tamanhoTotal=grid.size()*grid.size();
        int casa;
        int valor;
        boolean valid = false;
        
        System.out.println("Neste jogo a grelha tem tamanho "+grid.size()+" e tens estas pistas:");
        System.out.println(groups.toString());
        System.out.println(cluesToString(grid, groups));

        for (int i = maxAttempts; i >= 1; i--) {
            
                System.out.print("Casa a preencher?");
                
                System.out.println("Casa?:");
                casa=readIntInInterval(1, tamanhoTotal, scanner);
                
                System.out.println("Valor?:");
                valor=readIntInInterval(1,tamanho, scanner);

                int linha = rowOfSquare(casa, grid.size());
                int coluna = columnOfSquare(casa, grid.size());
                
                playedGrid.fill(linha, coluna, valor);

                System.out.println(playedGrid.toString());
        }
            if (puzzleSolved(playedGrid, grid)) {
                System.out.println("Ganhaste!!!!!");
            }else{
                System.out.println("Tentativas Esgotadas. Tenta outra vez!");
            }
        

    }

    /**
    * Permite ao utilizador inserir um jogo personalizado definindo a grelha e os grupos interativamente.
    *
    * @param inpScanner um objeto Scanner para ler a entrada do utilizador
    * @requires inpScanner não deve ser nulo.
    */
    public static void usrInputGame(Scanner inpScanner){
        
        int tamGrid,tamTotalGrid;
        GridGroups inGroups;
        SumdokuGrid inGrid;
        boolean valid;
        
        do{
            System.out.println("Tamanho da Grid: ");
            tamGrid=readIntInInterval(3, 9, inpScanner);
        
            inGrid = readGrid(tamGrid, inpScanner);
            tamTotalGrid=inGrid.size()*inGrid.size();

            inGroups= readGroups(inGrid, inpScanner);

            valid = definesPuzzle(inGrid, inGroups);

            if (!valid){
                System.out.println("O jogo com esta grelha e estes grupos é invalido");
            }

        }while (!definesPuzzle(inGrid, inGroups));

        play(inGrid, inGroups, tamTotalGrid, inpScanner);
    }

    /**
    * O ponto de entrada principal para o programa Sumdoku. Executa o jogo com base na entrada do utilizador ou argumentos predefinidos.
    *
    * @param args argumentos de linha de comando especificando o tamanho da grelha (opcional)
    */
    public static void main(String[] args) {
        int tamanhoTotal;
        System.out.println("Bem vindo ao Sumdoku");
        Scanner inpScanner = new Scanner(System.in);
        if (args.length == 0){
            usrInputGame(inpScanner);
        }else{
            
            int argSizeGrid = Integer.parseInt(args[0]);
            
            SumdokuGrid builtInGrid = getBuiltInGrid(argSizeGrid);
            GridGroups builtInGroup = getBuiltInGroups(argSizeGrid);
            
            if (builtInGrid != null || builtInGrid != null){
                tamanhoTotal = argSizeGrid*argSizeGrid;
                play(builtInGrid,builtInGroup,tamanhoTotal,inpScanner);
            }
            else{
                System.out.println("Tamanho Indisponivel crie um jogo valido.");
                usrInputGame(inpScanner);
            }
        }
        

        
        
        inpScanner.close();
    }
}
