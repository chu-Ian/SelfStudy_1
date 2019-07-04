package com.tensquare.spit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * 吐槽实体类
 * 把一个实体类声明成mongodb的文档类型，可以通过collection参数指定集合
 * @Document ： mongodb对应数据库的集合注解
 * 若未加该注解，则保存到mongodb的默认数据库中
 * 若加上，则保存到mongodb的指定数据库中
 */
@Document(collection = "spitTest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spit {

    //主键标识。该属性的值会自动对应monggodb的主键字段"_id"
    //如果该属性就叫"id",则该注解可以省略
    @Id
    private String id; //主键
    private String content; //吐槽内容
    //该注解对应monggodb的字段的名字，如果一致，则无需该注解
    @Field("userid")
    private String userId; //发布人ID
    private Date publishtime; //发布日期
    @Field("nickname")
    private String nickName; //昵称
    private Integer visits; //浏览量
    private Integer thumbup; //点赞数
    private Integer share; //分享数
    private Integer comment; //回复数
    private String state; //状态
    @Field("parentid")
    private String parentId; //上级ID
}
