package com.tensquare.recruit.dao;

import com.tensquare.recruit.po.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 企业数据访问接口
 */
public interface EnterpriseRepository extends JpaRepository<Enterprise, String>, JpaSpecificationExecutor<Enterprise> {
    List<Enterprise> findEnterByIsHot(String s);
}
