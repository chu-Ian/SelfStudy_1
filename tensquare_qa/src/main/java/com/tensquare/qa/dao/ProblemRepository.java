package com.tensquare.qa.dao;

import com.tensquare.qa.po.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ProblemRepository extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {

    @Query(value = "select * from tb_problem where exists (select problemid from tb_pl where labelid = :labelId) order by replytime DESC ", nativeQuery = true)
    Page<Problem> findByLabelIdOrderByReplyTimeDesc(String labelId, Pageable pageable);

    @Query(value = "select * from tb_problem where exists (select problemid from tb_pl where labelid = :labelId) order by reply DESC ", nativeQuery = true)
    Page<Problem> findByLabelIdOrderByReplyDesc(String labelId, Pageable pageable);

    @Query(value = "select * from tb_problem where exists (select problemid from tb_pl where labelid = :labelId) and reply = 0 order by createtime DESC ", nativeQuery = true)
    Page<Problem> findByLabelIdAndReplyISNullOrderByCreateTimeDesc(String labelId, Pageable pageable);
}
