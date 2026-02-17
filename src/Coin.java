public class Coin {
    private char color = 'R';
    private int[] boardPosition = new int[2];

    public Coin(int playerTurn){
        this.color = (playerTurn == 1) ? 'R' : 'Y';
    }

    public char getColor(){
        return this.color;
    }

    public void setRowPos(int rowIndex){
        this.boardPosition[0] = rowIndex;
    }

    public void setColumnPos(int columnIndex){
        this.boardPosition[1] = columnIndex;
    }
}