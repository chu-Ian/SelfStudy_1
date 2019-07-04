package com.tensquare.aritcle.service.impl;

import com.tensquare.aritcle.config.IdConfig;
import com.tensquare.aritcle.dao.CommentRespository;
import com.tensquare.aritcle.po.Comment;
import com.tensquare.aritcle.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private IdConfig idConfig;

    @Autowired
    private CommentRespository commentRespository;

    @Override
    public void save(Comment comment) {
        comment.setId(idConfig.getIdWork().nextId() + "");
        commentRespository.save(comment);
    }

    @Override
    public Comment findcommentById(String id) {

        return commentRespository.findCommentsByArticleId(id);
    }
}
