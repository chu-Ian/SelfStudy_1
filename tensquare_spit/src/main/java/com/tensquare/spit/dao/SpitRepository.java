package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * 数据访问层
 */
@Repository
public interface SpitRepository extends MongoRepository<Spit, String> {

    Page<Spit> findByParentId(String id, Pageable pageable);
}
