package Game;

import Board.*;
import Console.Console;
import Player.Player;
import jdk.jshell.JShellConsole;

public class Game {

    private Console console;

    private Player player1;
    private Player player2;

    private int turnCount = 0;

    private Board board;

    public Game(){
        console = new Console();
    }

    private void askForPlayersName(Player player1, Player player2){

        char chooseNamesInput = console.inputChar("Do you want to set custom player names? (y/n): ");
        String formatedInput = (chooseNamesInput + "").toLowerCase();

        while (!formatedInput.equals("y") && !formatedInput.equals("n")){

            chooseNamesInput = console.inputChar("Invalid input, type Y or N: ");
            formatedInput = (chooseNamesInput + "").toLowerCase();
        }

        if (formatedInput.equals("y")){

            String playersName1 = console.input("Who is Player 1: ");
            player1.setPlayerName(playersName1.trim());

            String playersName2 = console.input("Who is Player 2: ");
            player2.setPlayerName(playersName2.trim());
        }
    }

    public void startGame(){
        gameSetUp();
        gameLoop();
        console.close();
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

            console.println(board.boardInfo());
            console.println(board.boardToString());

            String askColumnMessage = String.format("\n(%s) Select a column (1 - 7): ", currentPlayerName);
            int indexOfColumnPick = console.inputInt(askColumnMessage);

            while(!board.updateBoardOnColumn(indexOfColumnPick, new Coin(playerTurn))){
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
