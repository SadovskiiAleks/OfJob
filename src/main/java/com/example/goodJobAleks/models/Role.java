package com.example.goodJobAleks.models;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(Permission.USER_PERMISSION)),
    OPERATOR(Set.of(Permission.OPERATOR_PERMISSION)),
    ADMIN(Set.of(Permission.ADMIN_PERMISSION)),
    OPERATOR_USER(Set.of(Permission.OPERATOR_PERMISSION, Permission.USER_PERMISSION)),
    OPERATOR_ADMIN(Set.of(Permission.OPERATOR_PERMISSION, Permission.ADMIN_PERMISSION)),
    USER_ADMIN(Set.of(Permission.USER_PERMISSION, Permission.ADMIN_PERMISSION)),
    USER_OPERATOR_ADMIN(Set.of(Permission.USER_PERMISSION, Permission.ADMIN_PERMISSION));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermission() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> grantedAuthorities(){
        return getPermission().stream()
                .map(permissions -> new SimpleGrantedAuthority(permissions.getPermission()))
                .collect(Collectors.toSet());
    }
}
