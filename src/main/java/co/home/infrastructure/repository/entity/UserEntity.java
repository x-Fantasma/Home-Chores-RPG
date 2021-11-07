package co.home.infrastructure.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
@Builder
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String username;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private LocalDate birthDay;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "user_rol",
            joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<RolEntity> roles;

    public UserEntity() { }

    public UserEntity(String username, String name, String password, LocalDate birthDay, Set<RolEntity> roles) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.birthDay = birthDay;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Set<RolEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolEntity> roles) {
        this.roles = roles;
    }

    public void addRol(RolEntity rol) {
        this.roles.add(rol);
    }
}
