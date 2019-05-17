package com.tensquare.recruit.service;

import com.tensquare.recruit.po.Enterprise;

import java.util.List;

public interface EnterpriseService {

    /**
     * 热门企业列表
     * @return
     */
    List<Enterprise> findEnterIsHot();
}
