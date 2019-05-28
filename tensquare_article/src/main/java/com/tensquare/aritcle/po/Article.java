package com.tensquare.aritcle.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_article")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private String id;
    @Column(name = "columnid")
    private String columnId; //专栏id
    @Column(name = "userid")
    private String usetId; //用户id
    private String title; //文章标题
    private String content; //文章内容
    private String image; //文章封面
    @Column(name = "createtime")
    private Timestamp createTime; //发表日期
    @Column(name = "updatetime")
    private Timestamp updateTime; //修改日期
    @Column(name = "ispublic")
    private Boolean isPublic; //是否公开
    @Column(name = "istop")
    private Boolean isTop; //是否置顶
    private Integer visits; //浏览量
    private Integer thumbup; //点赞数
    private Integer comment; //评论数
    private String state; //审核状态
    @Column(name = "channelid")
    private Integer channelId; //所属频道
    private String url; //URL地址
    private String type; //文章类型

}
