package com.freepath.user.component;

import org.springframework.stereotype.Service;

import com.freepath.user.domain.NewUser;
import com.freepath.user.domain.User;

@Service
public class UserService {

    private final UserAppender userAppender;

    private final UserValidator userValidator;

    public UserService(UserAppender userAppender, UserValidator userValidator) {
        this.userAppender = userAppender;
        this.userValidator = userValidator;
    }

    public User create(NewUser newUser) {
        userValidator.verify(newUser);
        return userAppender.append(newUser);
    }

}
