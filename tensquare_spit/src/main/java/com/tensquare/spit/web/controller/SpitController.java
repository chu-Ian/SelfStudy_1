package com.tensquare.spit.web.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import constants.StatusCode;
import dto.PageResultDTO;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @PostMapping("/save")
    public ResultDTO saveSpit(@RequestBody Spit spit) {

        try {
            spitService.saveSpit(spit);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO(false, StatusCode.ERROR, "保存失败");
        }

        return new ResultDTO(true, StatusCode.OK, "保存成功");
    }

    @PutMapping("/update")
    public ResultDTO updateSpit(@RequestBody Spit spit) {

        try {
            spitService.updateSpit(spit);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO(false, StatusCode.ERROR, "修改失败");
        }

        return new ResultDTO(true, StatusCode.OK, "修改成功");
    }

    @DeleteMapping("/delete")
    public ResultDTO deleteById(@RequestParam String id) {

        spitService.deleteSpitById(id);

        return new ResultDTO(true, StatusCode.OK, "删除成功");

    }

    @GetMapping("/findAll")
    public ResultDTO findAll() {
        List<Spit> allSpit = spitService.findAllSpit();

        return new ResultDTO(true, StatusCode.OK, "查询成功", allSpit);
    }

    @GetMapping("/find/{id}")
    public ResultDTO findSpit(@PathVariable String id) {
        Spit spitById = spitService.findSpitById(id);

        if (null == spitById) {
            return new ResultDTO(true, StatusCode.OK, "用户不存在");
        }

        return new ResultDTO(true, StatusCode.OK, "查询成功", spitById);
    }

    @GetMapping("/findPage/{page}/{size}")
    public ResultDTO findSpitByPage(@RequestParam String parentId,
                                    @PathVariable("page") int currentPage,
                                    @PathVariable("size") int size) {

        Page<Spit> spitsByPage = spitService.findSpitByPage(parentId, currentPage, size);

        return new ResultDTO(true, StatusCode.OK, "查询成功",
                new PageResultDTO<Spit>(spitsByPage.getTotalElements(), spitsByPage.getContent()));
    }

    @PutMapping("increThumbup")
    public ResultDTO updateSpitIncrThumbup(@RequestParam String id) {
        spitService.updateSpitIncrThumbup(id);

        return new ResultDTO(true, StatusCode.OK, "点赞成功");
    }

    @PutMapping("/increThumbup/{id}")
    public ResultDTO distinctThumbup(@PathVariable String id) {

        //获取当前登录用户
        String userId = "1024";

        //定义已点赞用户存入redis中的key
        String redisKey = "thumbup" + userId + "_" + id;

        //判断是否已经点赞
        if (null != redisTemplate.opsForValue().get("redisKey")) {
            return new ResultDTO(false, StatusCode.ERROR, "不能重复点赞");
        }

        //点赞
        spitService.updateSpitIncrThumbup(id);
        //redis中记录缓存，以便下次去重
        redisTemplate.opsForValue().set("redisKey", redisKey);

        return new ResultDTO(true, StatusCode.OK, "点赞成功");
    }

    @PostMapping("/publish")
    public ResultDTO publishVersion(Spit spit) {

        spitService.publishVersion(spit);

        return new ResultDTO(true, StatusCode.OK, "发布成功");
    }
}
