package com.example.goodJobAleks.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserOfDB {
    private Long id;
    private String firstName;
    private String lastName;
    private boolean userAccess;
    private boolean operatorAccess;
    private boolean adminAccess;

}
