package com.tensquare.aritcle.service.impl;

import com.tensquare.aritcle.dao.ArticleRespository;
import com.tensquare.aritcle.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRespository articleRespository;

    /**
     * 根据文章id修改文章状态
     *
     * @param articleId
     * @return
     */
    @Override
    public boolean updateArticleState(String articleId) {

        return articleRespository.updateArticleState(articleId, "1") != 1;
    }

    @Override
    public boolean updateThumbup(String articleId, int thumbup, boolean isAdd) {

        if (isAdd) {
            return articleRespository.updateAddThumbup(articleId, thumbup) != 0;
        } else {
            return articleRespository.updateSubThumbup(articleId, thumbup) != 0;
        }
    }
}
