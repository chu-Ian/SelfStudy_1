package com.tensquare.gathering.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@Table(name = "tb_gathering")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gathering implements Serializable {

    @Id
    private String id; //编号
    private String name; //活动名称
    private String summary; //大会简介
    private String detail; //详细说明
    private String sponsor; //主办方
    private String image; //活动图片
    @Column(name = "starttime")
    private Timestamp startTime; //开始时间
    @Column(name = "endtime")
    private Timestamp endTime; //截止时间
    private String address; //举办地点
    @Column(name = "enrolltime")
    private Timestamp enrollTime; //报名截止
    private String state; //是否可见
    private String city; //城市
}
