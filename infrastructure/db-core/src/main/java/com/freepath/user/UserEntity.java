package com.freepath.user;

import com.freepath.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer age;

    private String imageUrl;

    protected UserEntity() {
    }

    public UserEntity(NewUser newUser) {
        this.name = newUser.name();
        this.gender = newUser.gender();
        this.age = newUser.age();
        this.imageUrl = newUser.imageUrl();
    }

    public User toUser() {
        return new User(
            this.getId(),
            this.name,
            this.gender,
            this.age,
            this.imageUrl
        );
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
