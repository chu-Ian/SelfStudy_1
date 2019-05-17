package com.tensquare.recruit.web.controller;

import com.tensquare.recruit.po.Recruit;
import com.tensquare.recruit.service.RecruitService;
import constants.StatusCode;
import dto.ResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/recruit")
@Api(value="recruitController",tags={"招聘服务操作接口"})
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    /**
     * 查询推荐的、最新职位列表的前4条记录
     * @param state
     * @return
     */
    @ApiOperation(value ="查询推荐的、最新职位列表的前4条记录",httpMethod = "POST")
    @PostMapping("/search/recommend")
    public ResultDTO findRecruitBystaAndDate(@RequestParam String state) {

        List<Recruit> recruitList = recruitService.findRecruitBystaAndDate(state);
        return new ResultDTO(true, StatusCode.OK, "查询成功", recruitList);
    }

}
