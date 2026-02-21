import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in);

    private Player player1;
    private Player player2;

    private int turnCount = 0;

    private Board board;

    private void askForPlayersName(Player player1, Player player2){
        System.out.print("Do you want to set custom player names? (y/N): ");
        String chooseNamesInput = sc.nextLine().trim().toLowerCase();

        if (chooseNamesInput.equals("y") || chooseNamesInput.equals("yes")){
            System.out.print("Who is Player 1: ");
            player1.setPlayerName(sc.nextLine().trim());

            System.out.print("Who is Player 2: ");
            player2.setPlayerName(sc.nextLine().trim());
        }
    }

    public void startGame(){
        gameSetUp();
        gameLoop();
    }

    private void gameSetUp(){
        player1 = new Player(null);
        player2 = new Player(null);

        askForPlayersName(player1, player2);

        board = new Board();

        turnCount = 0;
    }

    private String getCurrentPlayerName(int playerTurn){
        if (playerTurn == 1){
            return player1.getPlayerName();
        }
        else{
            return player2.getPlayerName();
        }
    }

    private void gameLoop(){

        while(!board.isWinRound()){

            int playerTurn = (turnCount % 2) + 1;

            String currentPlayerName = getCurrentPlayerName(playerTurn);

            System.out.println(board.boardInfo());
            System.out.println(board.boardToString());

            System.out.printf("\n(%s) Select a column (1 - 7): ", currentPlayerName);

            int indexOfColumnPick = sc.nextInt();

            while(!board.updateBoardOnColumn(indexOfColumnPick, new Coin(playerTurn))){
                indexOfColumnPick = sc.nextInt();
                sc.nextLine();
            }

            if(board.isWinRound()){
                System.out.println("\n==Game Over==");
                System.out.println(currentPlayerName + " WINS");
                System.out.println(board.boardToString());
            }

            turnCount++;
        }
    }
}
