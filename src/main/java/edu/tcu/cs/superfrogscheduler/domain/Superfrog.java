package edu.tcu.cs.superfrogscheduler.domain;

import java.io.Serializable;

public class Superfrog implements Serializable {
    private String name;
    private String email;
    private String username;
    private String actions;

    public Superfrog() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }
}
