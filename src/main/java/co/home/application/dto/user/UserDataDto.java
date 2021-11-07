package co.home.application.dto.user;


public abstract class UserDataDto extends UserCredentialsDto {

    private static final long serialVersionUID = 1L;

    private String name;
    private String birthDay;

    public UserDataDto() { }

    public UserDataDto(String username, String password, String name, String birthDay) {
        super(username, password);
        this.name = name;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public String getBirthDay() {
        return birthDay;
    }
}
