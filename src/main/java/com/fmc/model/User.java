package com.fmc.model;

/**
 * Created by ycw on 2017/9/14 0014.
 */
public class User {
    private  Long id;
    private  String username;
    private  String userpwd;

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

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
}
