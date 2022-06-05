package com.mycompany.quatro.login;

import java.util.StringJoiner;

public class User {
    private Integer idUser;
    private String userName;

    private String email;
    private String userPassword;

    private Integer fkClient;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        userName = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getFkClient() {
        return fkClient;
    }

    public void setFkClient(Integer fkClient) {
        this.fkClient = fkClient;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("idUser=" + idUser)
                .add("userName='" + userName + "'")
                .add("email='" + email + "'")
                .add("userPassword='" + userPassword + "'")
                .add("fkClient=" + fkClient)
                .toString();
    }
}
