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

        for(int j = 0; j < rows; j++){
            char[] emptyRow = new char[columns];

            for(int i = 0; i < columns; i++){
                emptyRow[i] = ' ';
            }

            boardCells[j] = emptyRow;
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

    public boolean updateBoardOnColumn(int indexOfColumn, Coin coin){
        int coinsInColumn = columnCoins[indexOfColumn];

        if(coinsInColumn + 1 > rows){
            return false;
        }

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

        columnCoins[indexOfColumn]++;

        width = right - left + 1;

        return true;
    }

    public String boardInfo(){
        return String.format("\nPlayed area:\nLeft: %d\nRight: %d\nHeight: %d\nWidth: %d\n", left, right, height, width);
    }

//    private boolean isWinRound(){
//        boolean enoughCoinsOnBoard = coinsOnBoard >= 7;
//
//        if(enoughCoinsOnBoard) {
//            if(){
//
//            }
//
//            return true;
//        }
//
//        return false;
//    }
//
//    private boolean checkRows(){
//        if(){
//            return true;
//        }
//        return false;
//    }
//
//    private boolean checkColumns(){
//        return false;
//    }
}