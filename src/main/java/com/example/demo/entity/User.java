package com.example.demo.entity;

public class User {
    private Integer id;
    private Integer tenant_id;
    private String username;
    private String phone;
    private String password;
    private Integer state;
    private Integer is_examine;
    private Integer is_assess;
    private String email;
    private String avatar;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(Integer tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIs_examine() {
        return is_examine;
    }

    public void setIs_examine(Integer is_examine) {
        this.is_examine = is_examine;
    }

    public Integer getIs_assess() {
        return is_assess;
    }

    public void setIs_assess(Integer is_assess) {
        this.is_assess = is_assess;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
