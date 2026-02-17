import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Board board = new Board();

        System.out.print("Who is Player 1: ");
        String playerNamePick = sc.next();

        Player player1 = new Player(playerNamePick);

        System.out.print("\nWho is Player 2: ");
        playerNamePick = sc.next();

        Player player2 = new Player(playerNamePick);

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