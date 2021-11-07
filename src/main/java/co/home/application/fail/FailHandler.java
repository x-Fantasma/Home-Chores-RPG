package co.home.application.fail;

import co.home.transversal.exception.ExceptionAuth;
import co.home.transversal.exception.ExceptionJwt;
import co.home.transversal.exception.ExceptionUser;
import co.home.transversal.exception.ExceptionArgument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class FailHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(FailHandler.class);

    private static final String AN_ERROR_OCCURRED_PLEASE_CONTACT_THE_ADMINISTRATOR = "Ocurrió un error favor contactar al administrador.";

    private static final ConcurrentHashMap<String, Integer> STATUS_CODES = new ConcurrentHashMap<>();

    public FailHandler() {
        STATUS_CODES.put(ExceptionUser.class.getSimpleName(), HttpStatus.CONFLICT.value());
        STATUS_CODES.put(ExceptionArgument.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        STATUS_CODES.put(ExceptionAuth.class.getSimpleName(), HttpStatus.UNAUTHORIZED.value());
        STATUS_CODES.put(ExceptionJwt.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<Fail> handleAllExceptions(Exception exception) {
        ResponseEntity<Fail> result;

        var exceptionName = exception.getClass().getSimpleName();
        var message = exception.getMessage();
        var code = STATUS_CODES.get(exceptionName);

        if (code != null) {
            var fail = new Fail(exceptionName, message);
            result = new ResponseEntity<>(fail, HttpStatus.valueOf(code));
        } else {
            var fail = new Fail(exceptionName, AN_ERROR_OCCURRED_PLEASE_CONTACT_THE_ADMINISTRATOR);

            result = new ResponseEntity<>(fail, HttpStatus.INTERNAL_SERVER_ERROR);

            LOGGER_ERROR.error(exceptionName, exception);
        }

        return result;
    }
}
