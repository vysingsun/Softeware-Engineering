package exceptions;

public class DBException extends RuntimeException {
    public DBException(Throwable e) {
        super(e);
    }
}
