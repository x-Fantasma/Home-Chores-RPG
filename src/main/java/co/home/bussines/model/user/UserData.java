package co.home.bussines.model.user;

import java.time.LocalDate;

public abstract class UserData extends UserCredentials {

    private String name;
    private LocalDate birthDay;

    public UserData() { }

    protected UserData(String name, String username, String password, LocalDate birthDay) {
        super(username, password);
        this.name = name;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }
}
