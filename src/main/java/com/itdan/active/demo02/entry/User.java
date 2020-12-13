package com.itdan.active.demo02.entry;

import java.io.Serializable;

public class User implements Serializable {

    private String username;

    private Integer userType;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
