package com.mycompany.quatro.login;

public class User {
    private Integer id;
    private String name;

    private String email;
    private String password;

    private Integer fkClient;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getFkClient() {
        return fkClient;
    }

    public void setFkClient(Integer fkClient) {
        this.fkClient = fkClient;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", fkClient=").append(fkClient);
        sb.append('}');
        return sb.toString();
    }
}
