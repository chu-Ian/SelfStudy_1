package com.tensquare.recruit.service.impl;

import com.tensquare.recruit.dao.EnterpriseRepository;
import com.tensquare.recruit.po.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Override
    public List<Enterprise> findEnterIsHot() {
        List<Enterprise> enterpriseList = enterpriseRepository.findEnterByIsHot("1");
        return enterpriseList;
    }
}
