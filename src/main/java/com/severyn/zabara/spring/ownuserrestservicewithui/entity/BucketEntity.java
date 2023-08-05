package com.severyn.zabara.spring.ownuserrestservicewithui.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class BucketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Date creationDate;

    public BucketEntity(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BucketEntity() {
    }
}
