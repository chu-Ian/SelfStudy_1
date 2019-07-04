package com.tensquare.aritcle.dao;

import com.tensquare.aritcle.po.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRespository extends MongoRepository<Comment, String> {

    Comment findCommentsByArticleId(String id);
}
