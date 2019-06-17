package com.tensquare.gathering.controller;

import com.alibaba.fastjson.JSON;
import com.tensquare.gathering.po.Gathering;
import com.tensquare.gathering.service.GatheringService;
import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gathering")
public class GatheringController {

    @Autowired
    private GatheringService gatheringService;

    /**
     * 根据id 查询
     *
     * @param articleId
     * @return
     */
    @PostMapping("/search")
    public ResultDTO findGatheringById(@RequestParam String articleId) {
        Gathering gathering = gatheringService.findGatheringById(articleId);

        return new ResultDTO(true, StatusCode.OK, "查询成功", JSON.toJSONString(gathering));
    }

    @PostMapping("/update")
    public ResultDTO updateGathering(@RequestBody Gathering gathering) {
        gatheringService.updateGathering(gathering);
        return new ResultDTO(true, StatusCode.OK, "修改成功");
    }

    @PostMapping("/delete")
    public ResultDTO deleteGatheringById(@RequestParam String articleId) {
        gatheringService.deleteGatheringById(articleId);

        return new ResultDTO(true, StatusCode.OK, "删除成功");
    }

}
