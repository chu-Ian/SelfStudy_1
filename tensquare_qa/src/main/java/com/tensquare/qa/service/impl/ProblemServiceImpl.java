package com.tensquare.qa.service.impl;

import com.tensquare.qa.dao.ProblemRepository;
import com.tensquare.qa.po.Problem;
import com.tensquare.qa.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    /**
     * 根据标签id查询问题，并案恢复时间排序
     * @param labelId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<Problem> findLastestNewsByPage(String labelId, Integer currentPage, Integer pageSize) {

        Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        return problemRepository.findByLabelIdOrderByReplyTimeDesc(labelId, pageable);
    }

    /**
     * 根据标签id查询热门回复
     * @param labelId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<Problem> findHotReplay(String labelId, int currentPage, int pageSize) {

        Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        return problemRepository.findByLabelIdOrderByReplyDesc(labelId, pageable);
    }

    /**
     * 根据标签id查询待回复
     * @param labelId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<Problem> findWaitReply(String labelId, int currentPage, int pageSize) {

        Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        return problemRepository.findByLabelIdAndReplyISNullOrderByCreateTimeDesc(labelId, pageable);
    }
}
