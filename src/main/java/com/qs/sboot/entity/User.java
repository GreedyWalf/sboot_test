package com.qs.sboot.entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "t_sb_user")
public class User {
    @Id
    @Column(name = "user_id", nullable = false, length = 32)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String mobile;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
