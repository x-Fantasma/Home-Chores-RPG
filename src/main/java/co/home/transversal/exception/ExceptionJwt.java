package co.home.transversal.exception;

public class ExceptionJwt extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExceptionJwt(String message) {
        super(message);
    }
}
