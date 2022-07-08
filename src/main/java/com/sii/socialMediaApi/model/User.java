package com.sii.socialMediaApi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    @OneToMany(mappedBy = "user")
    private Collection<Follow> followed = new ArrayList<>();
    private Date createDate;
}
