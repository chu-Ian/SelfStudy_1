package com.tensquare.aritcle.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.tensquare.aritcle.dao.ArticleRespository;
import com.tensquare.aritcle.po.Article;
import com.tensquare.aritcle.service.ArticleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRespository articleRespository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 根据文章id修改文章状态
     *
     * @param articleId
     * @return
     */
    @Transactional
    @Override
    public boolean updateArticleState(String articleId) {

        return articleRespository.updateArticleState(articleId, "1") != 0;
    }

    @Transactional
    @Override
    public boolean updateThumbup(String articleId, int thumbup, int isAdd) {

        boolean flag = false;
        if (isAdd == 0) {
            //点赞
            flag = articleRespository.updateAddThumbup(articleId, thumbup) != 0;
        }
        if (isAdd == 1) {
            Article article = articleRespository.findById(articleId).orElse(null);
            if (article.getThumbup() != 0) {
                //取消点赞
                flag = articleRespository.updateSubThumbup(articleId, thumbup) != 0;
            } else {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public Article findArticleById(String articleId) {

        String articleStr = redisTemplate.opsForValue().get("ARTICLE" + articleId);
        log.info("redis缓冲文章：" + articleStr);

        Article article = JSON.parseObject(articleStr, new TypeReference<Article>() {
        });
        log.info("对象转换后：" + article);

        if (article == null) {

            article = articleRespository.findById(articleId).orElse(null);
            log.info("存redis文章" + article);

            redisTemplate.opsForValue().set("ARTICLE" + articleId, JSON.toJSONString(article));
        }

        return article;

    }
}
