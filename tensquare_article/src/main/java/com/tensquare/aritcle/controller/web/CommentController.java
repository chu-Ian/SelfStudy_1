package com.tensquare.aritcle.controller.web;

import com.tensquare.aritcle.po.Comment;
import com.tensquare.aritcle.service.CommentService;
import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/save")
    public ResultDTO saveComment(@RequestBody Comment comment) {
        commentService.save(comment);

        return new ResultDTO(true, StatusCode.OK, "保存成功");
    }

    @GetMapping("/find")
    public ResultDTO findCommentById(@RequestParam String id) {

        Comment comment = commentService.findcommentById(id);

        return new ResultDTO(true, StatusCode.OK, "查询成功", comment);
    }
}
