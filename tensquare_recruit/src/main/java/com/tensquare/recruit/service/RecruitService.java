package com.tensquare.recruit.service;

import com.tensquare.recruit.po.Recruit;

import java.util.List;

public interface RecruitService {
    /**
     * 查询推荐的、最新职位列表的前4条记录
     * @param state
     * @return
     */
    List<Recruit> findRecruitBystaAndDate(String state);
}
