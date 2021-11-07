package co.home.application.dto.jwt;

import java.io.Serializable;

public class JwtDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;

    public JwtDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
