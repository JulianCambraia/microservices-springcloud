package com.br.juliancambraia.hroauth.entities;

import java.io.Serializable;
import java.util.Objects;

public class Role implements Serializable {

    private Long id;
    private String roleName;

    public Role() {
    }

    public Role(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role roles = (Role) o;

        return Objects.equals(roleName, roles.roleName);
    }

    @Override
    public int hashCode() {
        return roleName != null ? roleName.hashCode() : 0;
    }
}
