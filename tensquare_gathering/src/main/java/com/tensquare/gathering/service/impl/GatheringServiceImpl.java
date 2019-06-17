package com.tensquare.gathering.service.impl;

import com.tensquare.gathering.dao.GatheringRespository;
import com.tensquare.gathering.po.Gathering;
import com.tensquare.gathering.service.GatheringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GatheringServiceImpl implements GatheringService {

    @Autowired
    private GatheringRespository gatheringRespository;

    /**
     * @param articleId
     * @return
     * @cacheable 该注解表示当方法第一次运行，
     * 在缓存中没有找到对应的key和value,就会将查询值放入缓存中
     */
    @Override
    @Cacheable(value = "GATHERING", key = "#articleId")
    public Gathering findGatheringById(String articleId) {

        return gatheringRespository.findById(articleId).orElse(null);
    }

    /**
     * @param gathering
     * @cacheable 该注解表示当数据进行修改（删除），需要去缓存中对该数据
     * 进行删除后再取数据库中查找修改后数据放入缓存中
     */
    @Override
    @CacheEvict(value = "GATHERING", key = "#gathering.id")
    public void updateGathering(Gathering gathering) {
        gatheringRespository.save(gathering);
    }

    @Override
    @CacheEvict(value = "delete", key = "#articleId")
    public void deleteGatheringById(String articleId) {
        gatheringRespository.deleteById(articleId);
    }


}
