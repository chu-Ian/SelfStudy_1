package com.tensquare.aritcle.service;

public interface ArticleService {

    boolean updateArticleState(String articleId);

    boolean updateThumbup(String articleId, int thumbup, boolean isAdd);
}
