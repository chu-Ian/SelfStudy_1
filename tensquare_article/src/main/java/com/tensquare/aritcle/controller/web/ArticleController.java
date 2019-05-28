package com.tensquare.aritcle.controller.web;

import com.tensquare.aritcle.service.ArticleService;
import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 根据文章id修改文章状态
     *
     * @param articleId
     * @return
     */
    @PutMapping("/status")
    public ResultDTO updateArticleState(@RequestParam String articleId) {

        boolean flag = articleService.updateArticleState(articleId);
        if (flag) {
            return new ResultDTO(true, StatusCode.OK, "修改成功", flag);
        } else {
            return new ResultDTO(false, StatusCode.ERROR, "修改失败", flag);
        }
    }

    /**
     * 根据文章id增加减少点赞数
     *
     * @param thumbup
     * @param isAdd
     * @return
     */
    @PutMapping("/thumbup/{isAdd}")
    public ResultDTO updateThumbup(@RequestParam("id") String articleId,
                                   @RequestParam("thumbup") int thumbup,
                                   @PathVariable boolean isAdd) {

        boolean flag = articleService.updateThumbup(articleId, thumbup, isAdd);
        if (flag) {
            return new ResultDTO(true, StatusCode.OK, "点赞成功", flag);
        } else {
            return new ResultDTO(false, StatusCode.ERROR, "点赞失败", flag);
        }

    }

}
