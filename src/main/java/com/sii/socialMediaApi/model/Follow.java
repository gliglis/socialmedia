package com.sii.socialMediaApi.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Follow {

    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long followedUserId;
    @CreatedDate
    private Date createDate;
    @ManyToOne
    @JoinColumn(name="userId", insertable=false, updatable=false)
    private User user;
}
