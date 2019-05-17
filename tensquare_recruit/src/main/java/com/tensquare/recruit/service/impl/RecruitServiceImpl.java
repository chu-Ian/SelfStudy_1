package com.tensquare.recruit.service.impl;

import com.tensquare.recruit.dao.RecruitRepositroy;
import com.tensquare.recruit.po.Recruit;
import com.tensquare.recruit.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    private RecruitRepositroy recruitRepositroy;

    /**
     * 查询推荐的、最新职位列表的前4条记录
     * @param state
     * @return
     */
    @Override
    public List<Recruit> findRecruitBystaAndDate(String state) {
        return recruitRepositroy.findTop4ByStateOrderByCreateTimeDesc(state);
    }
}
