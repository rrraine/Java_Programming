
public class ArrayFullException extends Exception{

    public <T> ArrayFullException(T num){
        super("The array is full and " + num + " cannot be inserted.");
    }
}
