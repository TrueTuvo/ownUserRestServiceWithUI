package com.severyn.zabara.spring.ownuserrestservicewithui.model;

import com.severyn.zabara.spring.ownuserrestservicewithui.entity.BucketEntity;

import java.util.Date;

public class Bucket {
    private Date creationDate;

    public Bucket() {
    }

    public Bucket(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public static Bucket toModel(BucketEntity bucketEntity){
        Bucket  model = new Bucket();
        model.setCreationDate(bucketEntity.getCreationDate());
        return model;
    }
}
