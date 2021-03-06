package com.tensquare.qa.service;

import com.tensquare.qa.po.Problem;
import org.springframework.data.domain.Page;

public interface ProblemService {

    /**
     * 根据标签id查询问题，并案恢复时间排序
     * @param label
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<Problem> findLastestNewsByPage(String label, Integer currentPage, Integer pageSize);

    /**
     * 根据标签id查询热门回复
     * @param labelId
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<Problem> findHotReplay(String labelId, int currentPage, int pageSize);

    /**
     * 根据标签id查询待回复
     * @param labelId
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<Problem> findWaitReply(String labelId, int currentPage, int pageSize);
}
