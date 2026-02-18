import java.util.*;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static Player player1;
    public static Player player2;

    public static int turnCount = 0;

    public static Board board;

    public static void askForPlayersName(Player player1, Player player2, Scanner sc){
        System.out.print("Do you want to set custom player names? (y/N): ");
        String chooseNamesInput = sc.nextLine().trim().toLowerCase();

        if (chooseNamesInput.equals("y") || chooseNamesInput.equals("yes")){
            System.out.print("Who is Player 1: ");
            player1.setPlayerName(sc.nextLine().trim());

            System.out.print("Who is Player 2: ");
            player2.setPlayerName(sc.nextLine().trim());
        }
    }

    public static void gameSetUp(){
        player1 = new Player(null);
        player2 = new Player(null);

        askForPlayersName(player1, player2, sc);

        board = new Board();

        turnCount = 0;
    }

    public static void gameLoop(){
        while(true){
            int playerTurn = (turnCount % 2) + 1;
            String currentPlayer;

            if (playerTurn == 1){
                currentPlayer = player1.getPlayerName();
            }
            else{
                currentPlayer = player2.getPlayerName();
            }

            System.out.println(board.boardInfo());
            System.out.println(board.boardToString());

            System.out.printf("\n(%s) Select a column (1 - 7): ", currentPlayer);

            int indexOfColumnPick = sc.nextInt();

            while(board.updateBoardOnColumn(indexOfColumnPick, new Coin(playerTurn))){
                indexOfColumnPick = sc.nextInt();
                sc.nextLine();
            }
            turnCount++;

        }
    }

    public static void main(String[] args){
        gameSetUp();
        gameLoop();

        //sc.close();
    }
}