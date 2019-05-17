package com.tensquare.recruit.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_recruit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recruit {

    @Id
    private String id;
    @Column(name = "jobname")
    private String jobName; //职位名称
    private String salary; //薪资范围
    private String condition; //经验要求
    private String education; //学历要求
    private String type; //任职方式
    private String address; //办公地址
    private String eid; //企业id
    @Column(name = "createtime")
    private Timestamp createTime; //创建日期
    private String state; //状态
    private String url; //网址
    private String label; //标签
    private String content1; //职位描述
    private String content2; //职位要求

}
