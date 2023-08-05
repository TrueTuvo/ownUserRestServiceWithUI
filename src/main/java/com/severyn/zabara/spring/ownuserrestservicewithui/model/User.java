package com.severyn.zabara.spring.ownuserrestservicewithui.model;

import com.severyn.zabara.spring.ownuserrestservicewithui.entity.UserEntity;

public class User {
    private Long id;
    private String name;
    private String surname;
    private Role role;
    private String email;
    private Bucket bucket;

    public User() {
    }

    public User(Long id, String name, String surname, Role role, String email, Bucket bucket) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.email = email;
        this.bucket = bucket;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public static User toModel(UserEntity userEntity) {
        User model = new User();
        model.setId(userEntity.getId());
        model.setName(userEntity.getName());
        model.setSurname(userEntity.getSurname());
        model.setEmail(userEntity.getEmail());
        model.setRole(userEntity.getRole());
        model.setBucket(Bucket.toModel(userEntity.getBucket()));
        return model;
    }
}
