package Game;

import Board.*;
import Console.Console;
import Player.Player;

public class Game {

    private Console console;

    private Player player1;
    private Player player2;

    private int turnCount = 0;

    private Board board;

    public Game(){
        console = new Console();
    }

    private String[] askForPlayersName(){

        String[] playersName = new String[2];
        playersName[0] = "Player 1";
        playersName[1] = "Player 2";

        char chooseNamesInput = console.inputChar("Do you want to set custom player names? (y/n): ");
        String formatedInput = (chooseNamesInput + "").toLowerCase();

        while (!formatedInput.equals("y") && !formatedInput.equals("n")){

            chooseNamesInput = console.inputChar("Invalid input, type Y or N: ");
            formatedInput = (chooseNamesInput + "").toLowerCase();
        }

        if (formatedInput.equals("y")){

            String playersName1 = console.input("Who is Player 1: ");
            playersName[0] = playersName1.trim();

            String playersName2 = console.input("Who is Player 2: ");
            playersName[1] = playersName2.trim();
        }

        return playersName;
    }

    public void startGame(){
        gameSetUp();
        gameLoop();
        console.close();
    }

    private void gameSetUp(){

        String[] playersNames = askForPlayersName();

        player1 = new Player(playersNames[0]);
        player2 = new Player(playersNames[1]);

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

            console.println(board.boardInfo());
            console.println(board.boardToString());

            String askColumnMessage = String.format("\n(%s) Select a column (1 - 7): ", currentPlayerName);
            int indexOfColumnPick = console.inputInt(askColumnMessage);

            while(!board.updateBoardOnColumn(indexOfColumnPick, new Coin((playerTurn == 1) ? Coin.RED_COIN_CHARACTER : Coin.YELLOW_COIN_CHARACTER))){
                indexOfColumnPick = console.inputInt("");
            }

            if(board.isWinRound()){

                console.println("\n==Game Over==");
                console.println(currentPlayerName + " WINS");
                console.println(board.boardToString());
            }

            turnCount++;
        }
    }
}
