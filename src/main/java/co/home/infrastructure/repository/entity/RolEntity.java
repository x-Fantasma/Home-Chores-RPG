package co.home.infrastructure.repository.entity;

import co.home.transversal.model.Role;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "rol")
@Builder
public class RolEntity {

    @Id
    @Column
    @Enumerated(EnumType.STRING)
    private Role rol;

    public RolEntity() {
        super();
    }

    public RolEntity(Role role) {
        super();
        this.rol = role;
    }

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }
}
