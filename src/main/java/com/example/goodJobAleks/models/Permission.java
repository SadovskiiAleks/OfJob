package com.example.goodJobAleks.models;

public enum Permission {
    //уточнить что тут есть
    USER_PERMISSION("user:user"),
    OPERATOR_PERMISSION("operator:operator"),
    ADMIN_PERMISSION("admin:admin");
    private final String permission;


    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
