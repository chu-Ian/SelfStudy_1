package com.tensquare.qa.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_reply")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class reply {

    @Id
    private String id;
    @Column(name = "problem_id")
    private String problemId; //问题ID
    private String text; //回答内容
    @Column(name = "createtime")
    private Timestamp createTime; //创建日期
    @Column(name = "updatetime")
    private Timestamp updateTime; //更新日期
    @Column(name = "userid")
    private String userId; //回答人id
    @Column(name = "nickname")
    private String nickName; //回答人昵称

}
