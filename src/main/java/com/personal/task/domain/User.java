package com.personal.task.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Data
@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

//    @NotNull
    @Column
    String name;

    @Column
    String address;

    @Column
    String mobile;

    @Column
    String country;

    @Column(name = "joined_at")
    ZonedDateTime joinedAt;

    @Column(name = "user_type")
    UserType userType;
}
