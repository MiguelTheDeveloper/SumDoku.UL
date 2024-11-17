import java.util.Scanner;

/**
 * Classe que implementa a lógica do jogo Sumdoku.
 * Esta classe contém métodos para gerar grelhas e grupos predefinidos, ler entradas do utilizador e verificar se o puzzle está resolvido.
 * 
 * @author Miguel Cabeça Nº63762, Duarte Rodrigues Nº63746
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
           //Declara uma grid
            SumdokuGrid grid;

            //verifica o tamanho e depois da fill a grid se for invalido grid retorna null
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
            
            
            //da return a grid ou a null se não estiver disponivel
            return grid;
     
         }
     
    /**
     * Gera grupos predefinidos para uma grelha Sumdoku com base no tamanho fornecido.
     *
     * @param size o tamanho da grelha (por exemplo, 3 ou 5)
     * @return um objeto GridGroups preenchido se o tamanho for válido; caso contrário, retorna null
     * @requires size deve ser 3 ou 5 para grelhas predefinidas válidas.
     */
    public static GridGroups getBuiltInGroups(int size) {
            //Declara e Inicializa as Variaveis necessarias    
            int numberOfGroups;
            GridGroups predefGroups;
    
            //verifica o tamanho e depois da fill ao predefGroups se for invalido predefGroups retorna null
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
            //da return a predefGroups ou a null se não estiver disponivel
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
        int tamanho = grid.size();
        int totalCasas= tamanho*tamanho;
        
        int coluna;
        int linha;

        //verifica o tamanho da grid e se não é null
        if(tamanho < 3 || tamanho > 9 || grid == null){
            return false;

            
        }else{
            // itera por todas as casas
            for (int i = 1; i <= totalCasas; i++) {
                linha = rowOfSquare(i,tamanho);
                coluna = columnOfSquare(i, tamanho);
                
                //verifica se todas as casas estao preenchidas e se estao nos valores corretos
                if(grid.value(linha, coluna)<1||grid.value(linha, coluna)>grid.size()||!grid.isFilled(linha, coluna)){
                    return false;
                }

                //itera pelo tamanho do lado da grid para verificar a linha e a coluna
                for(int j = 1; j <= tamanho; j++){
                     if (linha!=j){
                        if (grid.value(linha, coluna) == grid.value(j, coluna)){
                            return false;
                        }
                    }
                    if (coluna!=j){
                        if (grid.value(linha, coluna) == grid.value(linha, j)){
                            return false;
                        }

                    }      
                }
            }

            
        }
         
        //se passar as verificações todas retorna true
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

        //Declara as Variaveis e inicializa o necessario
        boolean valido;
        int tamanho = groups.gridSize();
        int totalCasas= tamanho*tamanho;
        int nGrupos = groups.numberOfGroups();
        
        //Verifica se o tamanho do grupo é invalido
        if(tamanho < 3 || tamanho > 9 || groups == null){
            return false;
            
        }else{
            //declara algumas variaves so utilizadas dentro do if
            int coluna;
            int linha;
            
            int grupoDoQuadrado;
            
            
            
            if (nGrupos < 1 || nGrupos > totalCasas){
                return false;
            }
            
            for(int j = 1; j <= nGrupos; j++){
                valido = false;
                
                for (int i = 1; i <= totalCasas; i++) {
                    //define a linha e a coluna baseado na iteraçao do for
                    linha = rowOfSquare(i,tamanho);
                    coluna = columnOfSquare(i, tamanho);

                    grupoDoQuadrado = groups.groupOfSquare(linha,coluna);
                    
                    //verifica se o grupoDoQuadrado esta entre dois valores
                    if (grupoDoQuadrado < 1 || grupoDoQuadrado > nGrupos){
                        return false;
                    }
                    
                    //verifica se o grupo do quadrado é igual ao grupo a ser testado
                    if (grupoDoQuadrado == j){
                           valido = true;
                    }
 
                }
                
                if(!valido){return false;}
            
                
            }

            
        }
         
        //se todas as verificações passarem sem returnar false retorna true
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
      
        //verifica se os grupos têm o mesmo tamanho
        if (grid.size() != groups.gridSize()){
            return false;
        }else{
            //Cria um objeto SumdokuSolver
            SumdokuSolver solved = new SumdokuSolver(grid, groups);

            //verifica se existe mais de uma solução
            if(solved.howManySolutions(2) > 1){
                     return false;
            }
            return true;
        }

        
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
        
        //Declara e Inicializa as Variaveis necessarias
        StringBuilder clue = new StringBuilder("Soma das casas:");
        int tamanho = groups.gridSize();
        int totalCasas= tamanho*tamanho;
        int nGrupos = groups.numberOfGroups();
        int valorQuadrado;
        int grupoQuadrado;
        int counter=0;

        
        //itera pelos numeros dos grupos
        for(int j = 1; j <= nGrupos; j++){
            
            //itera pelo total das casas
            for (int i = 1; i <= totalCasas; i++) {
                
                int linha = rowOfSquare(i,tamanho);
                int coluna = columnOfSquare(i, tamanho);
                grupoQuadrado = groups.groupOfSquare(linha,coluna);
                valorQuadrado = grid.value(linha, coluna);

                //verifica se o grupo do quadrado a ser verificado é o mesmo do grupo a ser iterado
                if (grupoQuadrado == j){
                    //Adiciona o valor do quadrado a variavel counter
                    counter += valorQuadrado ;
                }
                
            }
            //Da Append a Soma e ao numero do grupo
            clue.append(" G" + j + " = "+counter);
            counter = 0;
        
            
        }
        //Da append a uma quebra de linha
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
        //Declara e Inicializa as Variaveis necessarias
        SumdokuGrid userGrid = new SumdokuGrid(size);
        boolean allValid = true;
        int totalSize = size*size;
        int linha;
        int coluna;
        int value;

        //faz um do while enquanto não tiver uma Grid valida
        do{
            //itera pelo tamanho total da Grid
            for (int i = 1; i <= totalSize;i++){
                //define a linha e a coluna da casa a ser iterada
                linha = rowOfSquare(i,size);
                coluna = columnOfSquare(i, size);
                
                System.out.println("Casa "+i+" :");

                // pede o valor da casa ao utilizador
                value = readIntInInterval(1, size, scanner);

                //preenche a grid do user na linha e na coluna
                userGrid.fill(linha, coluna, value);

            }
            // verifica se a grelha é valida para o puzzle
            allValid = isValidForPuzzle(userGrid);
            
            // verifica se é valido e da uma mensagem
            if(!allValid){
                System.out.println("A grelha de Jogo é invalida (Reinsere a grid)");
            }
           
        }while (!allValid);
        
        //retorna a userGrid;
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
        //Declara e Inicializa as Variaveis necessarias
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
                
                //verifica se ainda a casas disponiveis a preencher se não tiver estamos perante um grupo totalmente invalido
                if(casasDisponiveis != 0){
                    
                    // Pergunta o tamanho do grupo
                    System.out.println("Tamanho do grupo "+i+"? :");
                    tamGrupos = readIntInInterval(1, casasDisponiveis, scanner);
                    
                    // Itera pelo tamanho do grupo Escolhido
                    for(int j=1;j <= tamGrupos;j++){
                        valid = false;
                        
                        //faz um loop enquanto estiver invalido
                        while(!valid){
                
                        System.out.println("Casa ?:");

                        //Pede a casa ao utilizador
                        int casa = readIntInInterval(1, totalCasas, scanner);
                        
                        //define a linha e a coluna da casa escolhida
                        int linha = rowOfSquare(casa, tamanho);
                        int coluna = columnOfSquare(casa, tamanho);
                        
                        //verifica se a casa a preencher não esta em nenhum grupo
                        if(grupoUser.groupOfSquare(linha,coluna)==0){
                            //e se nao estiver adiciona ao Grupo
                            grupoUser.addSquareToGroup(linha, coluna, i);
                            valid = true;

                        }else{
                            System.out.println("Casa ja preenchida (Escolha outra)");
                        }

                        }

                
                    }
                    //Remove o numero de casas disponiveis
                    casasDisponiveis -= tamGrupos;
                }
          
            }
            //Verifica se é um puzzle valido
            if(!isValidForPuzzle(grupoUser)) {

                System.out.println("Grupo Criado é invalido");

            }else{
                
                allValid=true;

            }

        }
        //retorna o grupoUser
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
        
        //Inicia as variaveis necessarias
        int tamanho = playedGrid.size();
        int totalCasas = tamanho*tamanho;
        int linha;
        int coluna;

        
        //itera pelo numero total de casas
        for (int i = 1; i <= totalCasas; i++) {
            //define a linha e a coluna da casa escolhida
            linha = rowOfSquare(i,tamanho);
            coluna = columnOfSquare(i, tamanho);
            
            //verifica se a casa não esta preenchida;
            if (!playedGrid.isFilled(linha, coluna)){
                return false;   
            }

            //verifica se o valor da casa é diferente 
            if (grid.value(linha, coluna) != playedGrid.value(linha, coluna)){
                return false;
            }
        
        }

        
        //caso tenha passado todas as verificações retorna true;
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
        //Inicia as variaveis necessarias
       
        int tamanho = grid.size();
        int tamanhoTotal=tamanho*tamanho;
        int casa;
        int valor;
        SumdokuGrid playedGrid = new SumdokuGrid(tamanho);

        //Da print as informações das pistas
        System.out.println("Neste jogo a grelha tem tamanho "+tamanho+" e tens estas pistas:");
        System.out.println(groups.toString());
        System.out.println(cluesToString(grid, groups));
        
        //Itera pelo numero de tentativas que o utilizador tem
        for (int i = maxAttempts; i >= 1; i--) {

                
                // Pede o numero da casa a preencher
                System.out.println("Casa a preencher?:");
                casa=readIntInInterval(1, tamanhoTotal, scanner);
                
                //pede o valor que se quer preencher na casa escolhida
                System.out.println("Valor da casa a preencher?:");
                valor=readIntInInterval(1,tamanho, scanner);

                //define a linha e a coluna da casa escolhida
                int linha = rowOfSquare(casa, grid.size());
                int coluna = columnOfSquare(casa, grid.size());
                
                //preenche a casa pedida;
                playedGrid.fill(linha, coluna, valor);
                
                //Escreve como esta a grelha do jogador
                System.out.println(playedGrid.toString());
        }
            //verifica se após o puzzle ter sido completado se esta igual ao original
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
        // declara as variaveis necessarias
        int tamGrid,tamTotalGrid;
        GridGroups inGroups;
        SumdokuGrid inGrid;
        boolean valid;
        
        // inicia um while enquanto o grid e o group
        do{
            
            System.out.println("Tamanho da Grid: ");

            //pede o tamanho da Grid
            tamGrid=readIntInInterval(3, 9, inpScanner);
            
            //pede ao utilizador a grid atravez da função read grid
            inGrid = readGrid(tamGrid, inpScanner);
            
            //calcula o tamTotalGrid
            tamTotalGrid=inGrid.size()*inGrid.size();

            //Pede os grupos ao utilizador
            inGroups= readGroups(inGrid, inpScanner);

            //Verifica se os dois juntos são validos
            valid = definesPuzzle(inGrid, inGroups);

            if (!valid){
                System.out.println("O jogo com esta grelha e estes grupos é invalido");
            }

        }while (!valid);

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
        
        //verifica se tem argumentos
        if (args.length == 0){
            usrInputGame(inpScanner);
        }else{
            //tira o valor dos argumentos
            int argSizeGrid = Integer.parseInt(args[0]);
            
            //vai buscar o a grid e o grupo as funções
            SumdokuGrid builtInGrid = getBuiltInGrid(argSizeGrid);
            GridGroups builtInGroup = getBuiltInGroups(argSizeGrid);
            
            //verifica se retornam null
            if (builtInGrid != null || builtInGrid != null){
                tamanhoTotal = argSizeGrid*argSizeGrid;
                play(builtInGrid,builtInGroup,tamanhoTotal,inpScanner);
            }else{ //se for null pede tudo ao utilizador
                
                System.out.println("Tamanho Indisponivel crie um jogo valido.");
                usrInputGame(inpScanner);
            }
        }
        

        
        //fecha o scanner
        inpScanner.close();
    }
}
