package com.severyn.zabara.spring.ownuserrestservicewithui.entity;

import com.severyn.zabara.spring.ownuserrestservicewithui.model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(unique=true)
    private String email;

    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bucket_entity_id")
    private BucketEntity bucket;

    public UserEntity() {
        this.bucket = new BucketEntity(new Date());
    }

    public UserEntity(String name, String surname, Role role, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.email = email;
        this.password = password;
        this.bucket = new BucketEntity(new Date());
    }

    public BucketEntity getBucket() {
        return bucket;
    }

    public void setBucket(BucketEntity bucket) {
        this.bucket = bucket;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
