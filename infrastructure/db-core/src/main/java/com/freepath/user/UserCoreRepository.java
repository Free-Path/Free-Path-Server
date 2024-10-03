package com.freepath.user;

import org.springframework.stereotype.Repository;

@Repository
public class UserCoreRepository {

    private final UserJpaRepository userJpaRepository;

    public UserCoreRepository(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public User create(NewUser newUser) {
        UserEntity userEntity = new UserEntity(newUser);
        return userJpaRepository.save(userEntity).toUser();
    }
}
