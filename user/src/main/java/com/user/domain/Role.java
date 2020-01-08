package com.user.domain;

/**
 * Author Kamil Seweryn
 */

public enum Role {
    ADMIN("Admin"),
    USER("User");

    String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}