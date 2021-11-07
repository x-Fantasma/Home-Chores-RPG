package co.home.application.fail;

import java.io.Serializable;

public class Fail implements Serializable {

    private static final long serialVersionUID = 1L;

    private String exceptionName;
    private String message;

    public Fail(String exceptionName, String message) {
        this.exceptionName = exceptionName;
        this.message = message;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public String getMessage() {
        return message;
    }
}
