package customExceptions;

/**
 * Exception class, signals that the given substring is not a substring of the given string
 */
public class NoSuchSubstringException extends IllegalArgumentException{

    public NoSuchSubstringException(){}

    public NoSuchSubstringException(String message){
        super(message);
    }

    public NoSuchSubstringException(Throwable cause){
        super(cause);
    }

    public NoSuchSubstringException(String message, Throwable cause){
        super(message, cause);
    }

}
