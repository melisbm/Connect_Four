import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Board board = new Board();

        System.out.println(board.boardToString());

        int turn = 0;

        while(true){
            int playerTurn = (turn++ % 2) + 1;
            System.out.printf("\n(Player %d) Select a column (1 - 7): ", playerTurn);

            int indexOfColumnPick = sc.nextInt() - 1;

            board.updateBoardOnColumn(indexOfColumnPick, new Coin(playerTurn));
            System.out.println(board.boardToString());
        }

    }
}