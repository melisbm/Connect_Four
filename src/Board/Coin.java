package Board;

public class Coin {

    public static final char RED_COIN_CHARACTER = 'R';
    public static final char YELLOW_COIN_CHARACTER = 'Y';
    public char character;

    public Coin(char character){
        this.character = character;
    }

    public char getCharacter(){
        return character;
    }
}