package com.mi.appoint.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : Rong
 * @date : 2019/12/9
 * @Desc: 预约实体类
 */
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "appoint_ment")
public class Appointment implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String appointId;

    /**名字*/

    private String appointName;

    /**日期*/
    private Date appointWeek;

    /**时间 08:00*/
    private String appointTime;

    /**单价*/
    private BigDecimal appointPrice;

    /** 状态，0正常 1下架*/
    private Integer appointStatus;

    /**类目编号*/
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;


}