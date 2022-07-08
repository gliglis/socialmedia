package com.sii.socialMediaApi.model;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty(message = "Please provide a userId")
    private long userId;
    @NotEmpty(message = "Please provide a title")
    private String title;
    @NotEmpty(message = "Please provide a text")
    @Length(min = 1, max = 140, message = "Please provide a text between 1 to 140 characters")
    private String text;
    @CreatedDate
    private Date createDate;
}
