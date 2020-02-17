package com.mi.appoint.domain;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : Rong
 * @date : 2019/12/9
 * @Desc:  预约类别
 */
@Data
@Entity
@Table(name = "appoint_category")
public class AppointCategory implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}