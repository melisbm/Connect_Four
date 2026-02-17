import java.util.*;

public class Main {
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

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Player player1 = new Player(null);
        Player player2 = new Player(null);

        askForPlayersName(player1, player2, sc);

        Board board = new Board();
        int turnCount = 0;

        while(true){
            int playerTurn = (turnCount++ % 2) + 1;
            String playerName;

            if (playerTurn == 1){
                playerName = player1.getPlayerName();
            }
            else{
                playerName = player2.getPlayerName();
            }

            System.out.println(board.boardToString());


            System.out.printf("\n(%s) Select a column (1 - 7): ", playerName);

            int indexOfColumnPick = sc.nextInt() - 1;

            board.updateBoardOnColumn(indexOfColumnPick, new Coin(playerTurn));
        }

        //sc.close();
    }
}