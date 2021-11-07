package co.home.bussines.model.jwt;

import co.home.transversal.exception.messages.ExceptionMessages;
import co.home.bussines.model.validator.ArgumentValidator;

public class JwToken {

    private String token;

    public JwToken() { }

    private JwToken(String token) {
        this.token = token;
    }

    public static JwToken build(String token) {
        ArgumentValidator.validateRequired(token, ExceptionMessages.MESSAGE_TOKEN_REQUIRED);
        return new JwToken(token);
    }

    public String getToken() {
        return token;
    }
}
