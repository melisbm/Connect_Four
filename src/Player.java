public class Player {
    private String playerName = "Player";
    private int coinsPlaced = 0;

    private boolean isWinner = false;
    private boolean firstTurn = false;

    public static int totalPlayers = 0;

    public Player(String playerName){
        if(totalPlayers++ == 0){
            setFirstTurn();
        }

        if(playerName != null){
            this.playerName = playerName;
        }
        else{
            setPlayerName(this.playerName + ((firstTurn) ? " 1" : " 2"));
        }
    }

    public void setFirstTurn() {
        this.firstTurn = true;
    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public void setWinner() {
        this.isWinner = true;
    }

    public String getPlayerName(){
        return playerName;
    }

}