package com.mi.user.domain;

import lombok.Data;


import javax.persistence.*;

/**
 * @author : Rong
 * @date : 2020/2/14
 * @Desc:
 */
@Data
@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String username;

    private String password;

    private String openid;

    private Integer role;
}