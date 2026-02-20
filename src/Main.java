import java.util.*;

public class Main {

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

    public static void gameSetUp(Scanner sc){
        player1 = new Player(null);
        player2 = new Player(null);

        askForPlayersName(player1, player2, sc);

        board = new Board();

        turnCount = 0;
    }

    public static String getCurrentPlayerName(int playerTurn){
        if (playerTurn == 1){
            return player1.getPlayerName();
        }
        else{
            return player2.getPlayerName();
        }
    }

    public static void gameLoop(Scanner sc){

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

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        gameSetUp(sc);
        gameLoop(sc);

        sc.close();
    }
}