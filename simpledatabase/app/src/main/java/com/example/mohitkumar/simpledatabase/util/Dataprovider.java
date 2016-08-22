package com.example.mohitkumar.simpledatabase.util;

/**
 * Created by mohitkumar on 15/08/16.
 */
public class Dataprovider {

    private String name;
    private String mobile;
    private String email;

    public Dataprovider(String name,String mobile,String email)
    {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
