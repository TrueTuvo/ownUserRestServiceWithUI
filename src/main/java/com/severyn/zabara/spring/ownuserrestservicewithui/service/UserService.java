package com.severyn.zabara.spring.ownuserrestservicewithui.service;

import com.severyn.zabara.spring.ownuserrestservicewithui.entity.BucketEntity;
import com.severyn.zabara.spring.ownuserrestservicewithui.entity.UserEntity;
import com.severyn.zabara.spring.ownuserrestservicewithui.exceptions.UserNotFoundException;
import com.severyn.zabara.spring.ownuserrestservicewithui.exceptions.UserAlreadyExistException;
import com.severyn.zabara.spring.ownuserrestservicewithui.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BucketService bucketService;

    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }

    public UserEntity getUser(Long id) throws UserNotFoundException {

        Optional<UserEntity> entity = userRepository.findById(id);

        return entity.orElseThrow(() -> new UserNotFoundException("Can't find user in Database with ID = " + id));

    }

    public UserEntity createUser(UserEntity user) throws UserAlreadyExistException {
        if (userRepository.existsUserEntityByEmail(user.getEmail())){
            throw new UserAlreadyExistException("Can't add user with email: " + user.getEmail() + " . Email already used");
        }
        BucketEntity bucketEntity = new BucketEntity(new Date());
        user.setBucket(bucketEntity);
        return userRepository.save(user);
    }

    public UserEntity updateUser(Long id, UserEntity user) throws UserNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isEmpty()) {
            throw new UserNotFoundException("Cant find user with id = " + id + " in database");
        }
        UserEntity entity = userEntity.get();
        entity.setRole(user.getRole());
        entity.setSurname(user.getSurname());
        entity.setName(user.getName());
        entity.setPassword(user.getPassword());

        return userRepository.save(entity);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
