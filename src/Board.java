public class Board {
    private int rows = 6;
    private int columns = 7;

    private char[][] boardCells = new char[rows][columns];

    private int[] columnCoins = new int[columns];

    //played area
    private int left = Integer.MAX_VALUE;
    private int right = Integer.MIN_VALUE;

    private int height = 0;
    private int width = 0;

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
        int coinsInColumn = columnCoins[indexOfColumn]++;
        int indexOfRow = rows - coinsInColumn - 1;

        boardCells[indexOfRow][indexOfColumn] = coin.getColor();
        coinsOnBoard++;

        if(indexOfColumn < left){
            left = indexOfColumn;
        }

        if(indexOfColumn > right){
            right = indexOfColumn;
        }

        if(columnCoins[indexOfColumn] > height){
            height = columnCoins[indexOfColumn];
        }

        width = right - left + 1;

        System.out.printf("\nLeft: %d\nRight: %d\nHeight: %d\nWidth: %d\n\n", left, right, height, width);
    }

    private boolean isWinRound(){
        if(coinsOnBoard < 7) {
            return false;
        }
        return false;
    }

    private boolean checkRows(){
        return false;
    }

    private boolean checkColumns(){
        return false;
    }
}