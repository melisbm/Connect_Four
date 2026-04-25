package Player;

public class Player {
    private String playerName = "Player";
    private int coinsPlaced = 0;

    private boolean isWinner = false;
    private boolean firstTurn = false;

    public static int totalPlayers = 0;

    public Player(String playerName){
        this.playerName = playerName;
    }

    public void setFirstTurn() {
        this.firstTurn = true;
    }

    public void setWinner() {
        this.isWinner = true;
    }

    public String getPlayerName(){
        return playerName;
    }

}