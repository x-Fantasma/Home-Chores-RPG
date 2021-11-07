package co.home.bussines.model.user;

import co.home.transversal.exception.messages.ExceptionMessages;
import co.home.bussines.model.validator.ArgumentValidator;

public class UserCredentials {

    private String username;
    private String password;

    public UserCredentials() { }

    protected UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static UserCredentials build(String username, String password) {
        ArgumentValidator.validateRequired(username, ExceptionMessages.MESSAGE_USERNAME_REQUIRED);
        ArgumentValidator.validateRequired(password, ExceptionMessages.MESSAGE_PASSWORD_REQUIRED);

        return new UserCredentials(username, password);
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
