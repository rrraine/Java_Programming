public class InvalidPositionException extends RuntimeException{

    public <T> InvalidPositionException(T upper){
        super("Position must be between 1 and " + upper);
    }
}
