package com.tensquare.aritcle.service;

import com.tensquare.aritcle.po.Comment;

public interface CommentService {
    void save(Comment comment);

    Comment findcommentById(String id);
}
