package co.home.transversal.exception;

public class ExceptionUser extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExceptionUser(String message) {
        super(message);
    }
}
