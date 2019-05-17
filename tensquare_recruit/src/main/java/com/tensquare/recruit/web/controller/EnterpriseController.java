package com.tensquare.recruit.web.controller;

import com.tensquare.recruit.po.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/EnterPrise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * 查询热门企业
     * @return
     */
    @GetMapping("/search/hotList")
    public ResultDTO findEnterIsHot() {
        List<Enterprise> enterprise = enterpriseService.findEnterIsHot();
        return new ResultDTO(true, StatusCode.OK, "查询成功", enterprise);
    }

}
