package com.tensquare.aritcle.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    private String id;
    @Field(value = "articleid")
    private String articleId;
    private String content;
    @Field(value = "userid")
    private String userId;
    @Field(value = "parentid")
    private String parentId;
    @Field(value = "publishdate")
    private Date publishDate;
}
