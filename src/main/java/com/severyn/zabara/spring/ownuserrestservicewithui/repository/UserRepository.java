package com.severyn.zabara.spring.ownuserrestservicewithui.repository;

import com.severyn.zabara.spring.ownuserrestservicewithui.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {

    boolean existsUserEntityByEmail(String email);

}

