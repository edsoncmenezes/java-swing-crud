/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hunter.models.user;

import java.util.Date;

/**
 *
 * @author edson
 */
public class User {

    String username;
    String name;
    String birth;
    String password;

    public User(String username, String name, String birth, String password) {
        this.username = username;
        this.name = name;
        this.birth = birth;
        this.password = password;
    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
