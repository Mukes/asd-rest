package com.asd.framework.model;

import com.asd.framework.validation.constraints.*;
import com.asd.framework.validation.constraints.Number;

/**
 * Created by Crawlers on 6/12/2017.
 */
public class User {
    @Email
    @Length(min = 10, max = 20)
    @Mandatory
    @Number
    @Url
    @Password
    @DateTime
    private String email;



    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
