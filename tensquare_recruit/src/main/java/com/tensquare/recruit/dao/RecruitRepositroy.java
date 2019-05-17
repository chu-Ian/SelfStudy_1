package com.tensquare.recruit.dao;

import com.tensquare.recruit.po.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecruitRepositroy extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {
//    @Query(value = "select * from tb_recruit where state :state order by createtime DESC Limit 4",nativeQuery = true)
    List<Recruit> findTop4ByStateOrderByCreateTimeDesc(String state);
}
