package Board;

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

    public void updateBoardOnColumn(int indexOfColumn, Coin coin){

        int coinsInColumn = columnCoins[indexOfColumn];

        int indexOfRow = rows - coinsInColumn - 1;

        boardCells[indexOfRow][indexOfColumn] = coin.getCharacter();
        coinsOnBoard++;
        columnCoins[indexOfColumn]++;

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
    }

    public boolean isColumnOverflow(int indexOfColumn){

        int coinsInColumn = columnCoins[indexOfColumn];
        return coinsInColumn >= rows;
    }

    public String boardInfo(){
        return String.format("\nPlayed area:\nLeft: %d\nRight: %d\nHeight: %d\nWidth: %d\n", left, right, height, width);
    }

    public boolean isWinRound(){

        boolean enoughCoinsOnBoard = coinsOnBoard >= 7;

        if(enoughCoinsOnBoard) {

            if(width >= 4 || height >= 4){
                return isAnyRowWin() || isAnyColumnWin() || isAnyDiagonalWin();
            }
        }

        return false;
    }

    public boolean isAnyRowWin(){

        int endColumn = columns - 4;

        for(int row = 0; row < rows; row++){

            for(int col = 0; col <= endColumn; col++){

                if(boardCells[row][col] != ' ' &&
                        boardCells[row][col] == boardCells[row][col + 1] &&
                        boardCells[row][col] == boardCells[row][col + 2] &&
                        boardCells[row][col] == boardCells[row][col + 3]){

                    return true;
                }
            }
        }

        return false;
    }

    private boolean isAnyColumnWin(){

        int endRow = rows - 4;

        for(int col = 0; col < columns; col++){

            for(int row = 0; row <= endRow; row++){

                if(boardCells[row][col] != ' ' &&
                        boardCells[row][col] == boardCells[row + 1][col] &&
                        boardCells[row][col] == boardCells[row + 2][col] &&
                        boardCells[row][col] == boardCells[row + 3][col]){

                    return true;
                }
            }
        }

        return false;
    }

    private boolean isAnyDiagonalWin(){

        int endRow = rows - 4;
        int endColumn = columns - 4;

        for(int row = 0; row <= endRow; row++){

            for(int col = 0; col <= endColumn; col++){

                if(boardCells[row][col] != ' ' &&
                        boardCells[row][col] == boardCells[row + 1][col + 1] &&
                        boardCells[row][col] == boardCells[row + 2][col + 2] &&
                        boardCells[row][col] == boardCells[row + 3][col + 3]){

                    return true;
                }
            }
        }

        for(int row = 0; row <= endRow; row++){

            for(int col = 3; col < columns; col++){

                if(boardCells[row][col] != ' ' &&
                        boardCells[row][col] == boardCells[row + 1][col - 1] &&
                        boardCells[row][col] == boardCells[row + 2][col - 2] &&
                        boardCells[row][col] == boardCells[row + 3][col - 3]){

                    return true;
                }
            }
        }

        return false;
    }

    public int getColumns() {
        return columns;
    }
}