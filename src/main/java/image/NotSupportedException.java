package image;

public class NotSupportedException extends RuntimeException{

    /**
     * Write a message on the terminal that communicated the exception
     * @param message
     */
    public NotSupportedException(String message) {

        super(message);
    }

}
