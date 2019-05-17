package com.tensquare.qa.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_problem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem {

    @Id
    private String id;
    private String title; //标题
    private String content; //内容
    @Column(name = "createtime")
    private Timestamp createTime; //创建日期
    @Column(name = "updatetime")
    private Timestamp updateTime; //修改日期
    @Column(name = "userid")
    private String userId; //用户id
    @Column(name = "nickname")
    private String nickName; //昵称
    private BigInteger visits; //浏览量
    private BigInteger thumbup; //点赞数
    private BigInteger reply; //回复数
    private String solve; //是否解决
    @Column(name = "replyName")
    private String replyName; //回复人昵称
    @Column(name = "replytime")
    private Timestamp replyTime; //回复时间
}
