package com.tensquare.aritcle.service;

import com.tensquare.aritcle.po.Article;

public interface ArticleService {

    boolean updateArticleState(String articleId);

    boolean updateThumbup(String articleId, int thumbup, int isAdd);

    Article findArticleById(String articleId);
}
