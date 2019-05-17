package com.tensquare.qa.controller;

import com.tensquare.qa.po.Problem;
import com.tensquare.qa.service.ProblemService;
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
}
