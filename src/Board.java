public class Board {
    private int rows = 6;
    private int columns = 7;

    private char[][] boardCells = new char[rows][columns];

    private int[] columnCoins = new int[columns];

    //played area
    private int left;
    private int right;

    private int height;
    private int width;

    private int coinsOnBoard = 0;

    public Board(){
        resetBoard();
    }

    public void resetBoard(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                boardCells[i][j] = ' ';
            }
        }
    }

    public String boardToString(){
        StringBuilder sb = new StringBuilder();
        sb.append("+").append("-".repeat((columns * 2) - 1)).append("+\n");

        for(int i = 0; i < rows; i++){
            sb.append("|");
            for(int j = 0; j < columns; j++){
                sb.append(boardCells[i][j]).append("|");
            }
            sb.append("\n");
        }
        sb.append("+").append("-".repeat((columns * 2) - 1)).append("+");
        return sb.toString();
    }

    public void updateBoardOnColumn(int indexOfColumn, Coin coin){
        char coinColor = coin.getColor();

        int coinsInColumn = columnCoins[indexOfColumn]++;
        int indexOfRow = rows - coinsInColumn - 1;

        boardCells[indexOfRow][indexOfColumn] = coinColor;
        coinsOnBoard++;
    }

    private boolean isWinRound(){
        if(coinsOnBoard < 7) { return false; }
        return false;
    }

    private boolean checkRows(){

    }

    private boolean checkColumns(){

    }
}