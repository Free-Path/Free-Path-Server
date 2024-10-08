package com.freepath.user;

import com.freepath.BaseEntity;
import com.freepath.user.domain.Gender;
import com.freepath.user.domain.NewUser;
import com.freepath.user.domain.User;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "f_user")
public class UserEntity extends BaseEntity {

    private String name;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String ageRange;

    private String imageUrl;

    protected UserEntity() {
    }

    public UserEntity(NewUser newUser) {
        this.name = newUser.name();
        this.nickname = newUser.nickname();
        this.gender = newUser.gender();
        this.ageRange = newUser.ageRange();
        this.imageUrl = newUser.imageUrl();
    }

    public User toUser() {
        return new User(
            this.getId(),
            this.name,
            this.nickname,
            this.gender,
            this.ageRange,
            this.imageUrl
        );
    }

    public String getName() {
        return name;
    }

    public String getNickname() {return nickname; }

    public Gender getGender() {
        return gender;
    }

    public String getAgeRange() { return ageRange; }

    public String getImageUrl() {
        return imageUrl;
    }
}
