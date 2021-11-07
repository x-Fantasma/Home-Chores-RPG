package co.home.application.dto.user;

import java.io.Serializable;

public class UserCredentialsDto implements Serializable  {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    public UserCredentialsDto() { }

    public UserCredentialsDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
