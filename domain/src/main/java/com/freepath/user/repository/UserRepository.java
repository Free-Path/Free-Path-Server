package com.freepath.user.repository;

import com.freepath.user.domain.NewUser;
import com.freepath.user.domain.User;

public interface UserRepository {

    User create(NewUser newUser);

}
