package com.freepath.user;

import org.springframework.stereotype.Repository;

import com.freepath.user.domain.NewUser;
import com.freepath.user.domain.User;
import com.freepath.user.repository.UserRepository;

@Repository
public class UserCoreRepository implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public UserCoreRepository(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public User create(NewUser newUser) {
        UserEntity userEntity = new UserEntity(newUser);
        return userJpaRepository.save(userEntity).toUser();
    }

}
