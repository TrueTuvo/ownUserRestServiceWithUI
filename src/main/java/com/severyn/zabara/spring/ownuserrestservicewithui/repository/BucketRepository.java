package com.severyn.zabara.spring.ownuserrestservicewithui.repository;

import com.severyn.zabara.spring.ownuserrestservicewithui.entity.BucketEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BucketRepository extends CrudRepository<BucketEntity,Long> {
}
