package com.severyn.zabara.spring.ownuserrestservicewithui.service;

import com.severyn.zabara.spring.ownuserrestservicewithui.entity.BucketEntity;
import com.severyn.zabara.spring.ownuserrestservicewithui.entity.UserEntity;
import com.severyn.zabara.spring.ownuserrestservicewithui.exceptions.UserNotFoundException;
import com.severyn.zabara.spring.ownuserrestservicewithui.model.Bucket;
import com.severyn.zabara.spring.ownuserrestservicewithui.repository.BucketRepository;
import com.severyn.zabara.spring.ownuserrestservicewithui.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BucketService {

    @Autowired
    BucketRepository bucketRepository;

    @Autowired
    UserRepository userRepository;

    public List<BucketEntity> getAllBuckets() {
        return (List<BucketEntity>) bucketRepository.findAll();
    }

    public BucketEntity getBucketByUserId(Long id) throws UserNotFoundException {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.orElseThrow().getBucket();
    }

}
