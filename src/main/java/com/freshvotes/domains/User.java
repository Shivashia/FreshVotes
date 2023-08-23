package com.freshvotes.domains;


import jakarta.persistence.*;
//import javax.persistence.Entity;

@Entity
@Table(name="users_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long u_id;
    @Column(name = "username")
    private String username;
    @Column(name = "pwd")
    private String password;

    @Column(name = "u_name")
    private String u_name;

    public User() {
    }

    public User(Long u_id, String username, String password, String u_name) {
        this.u_id = u_id;
        this.username = username;
        this.password = password;
        this.u_name = u_name;
    }

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getU_id() {
        return u_id;
    }

    public void setU_id(Long u_id) {
        this.u_id = u_id;
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

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", u_name='" + u_name + '\'' +
                '}';
    }
}
