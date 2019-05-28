package com.tensquare.qa.controller;

import com.tensquare.qa.po.Problem;
import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/qa")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    /**
     * 根据标签id查询问题，并案恢复时间排序
     * @param label
     * @param currentPage
     * @param pageSize
     * @return
     */
    @PostMapping("/search/{label}")
    public ResultDTO findLastestNewsByPage(@PathVariable String label,
                                           @RequestParam("currentPage") int currentPage,
                                           @RequestParam("pageSize") int pageSize) {

        Page<Problem> problemsByPage = problemService.findLastestNewsByPage(label, currentPage, pageSize);
        return new ResultDTO(true, StatusCode.OK, "查询成功", problemsByPage.getContent());
    }

    /**
     * 根据标签id查询热门回复
     * @param label
     * @param currentPage
     * @param pageSize
     * @return
     */
    @PostMapping("/hostList/{label}")
    public ResultDTO hotReply(@PathVariable String label,
                              @RequestParam("currentPage") int currentPage,
                              @RequestParam("pageSize") int pageSize) {

        Page<Problem> page = problemService.findHotReplay(label, currentPage, pageSize);
        return new ResultDTO(true, StatusCode.OK, "查询成功", page.getContent());
    }

    /**
     * 根据标签id查询待回复
     * @return
     */
    @PostMapping("/waitReply/{label}")
    public ResultDTO waitReply(@PathVariable String label,
                               @RequestParam("currentPage") int currentPage,
                               @RequestParam("pageSize") int pageSize) {

        Page<Problem> page = problemService.findWaitReply(label, currentPage, pageSize);
        return new ResultDTO(true, StatusCode.OK, "查询成功", page.getContent());

    }
}
