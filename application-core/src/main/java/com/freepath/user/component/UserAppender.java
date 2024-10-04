package com.freepath.user.component;

import org.springframework.stereotype.Component;

import com.freepath.user.domain.NewUser;
import com.freepath.user.domain.User;
import com.freepath.user.repository.UserRepository;

@Component
public class UserAppender {

    private final UserRepository userRepository;

    public UserAppender(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User append(NewUser newUser) {
        return userRepository.create(newUser);
    }
}
