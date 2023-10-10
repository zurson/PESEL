package Main.Exceptions;


/**
 * Exception which is thrown when given PESEL is invalid
 */
public class InvalidPeselException extends Exception{

    /**
     *
     * Invalid PESEL Expection constructor
     *
     * @param message exception details which can be shown in catch block
     */
    public InvalidPeselException(String message) {
        super(message);
    }

}
