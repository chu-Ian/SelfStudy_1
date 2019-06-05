package com.tensquare.aritcle.dao;

import com.tensquare.aritcle.po.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRespository extends JpaRepository<Article, String> {

    @Query(value = "update tb_article set state = :state where id = :articleId", nativeQuery = true)
    @Modifying
    int updateArticleState(String articleId, String state);

    @Query(value = "update tb_article set thumbup = thumbup + :thumbup where id = :articleId", nativeQuery = true)
    @Modifying
    int updateAddThumbup(String articleId, int thumbup);

    @Query(value = "update tb_article set thumbup = thumbup - :thumbup where id = :articleId", nativeQuery = true)
    @Modifying
    int updateSubThumbup(String articleId, int thumbup);
}
