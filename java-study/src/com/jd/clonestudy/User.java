package com.jd.clonestudy;

import java.io.Serializable;

public class User implements Cloneable, Serializable {
    private String username;

    private String password;

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        if (username.equals(user.username) && password.equals(user.password)) {
            return true;
        }
        return false;
    }

}
