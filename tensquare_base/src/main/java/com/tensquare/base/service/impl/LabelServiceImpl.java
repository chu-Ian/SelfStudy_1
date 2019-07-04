package com.tensquare.base.service.impl;

import com.tensquare.base.config.MyConfig;
import com.tensquare.base.dao.LabelRepository;
import com.tensquare.base.po.Label;
import com.tensquare.base.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 标签业务处理类
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private MyConfig myConfig;

    @Autowired
    private LabelRepository labelRepository;

    /**
     * 保存一个标签
     *
     * @param label
     */
    public void saveLabel(Label label) {
        label.setId(myConfig.getIdWorker().nextId() + "");
        labelRepository.save(label);
    }

    /**
     * 更新一个标签
     *
     * @param label
     */
    public void updateLabel(Label label) {
        labelRepository.save(label);
    }

    /**
     * 删除一个标签
     *
     * @param id
     */
    public void deleteLabelById(String id) {
        labelRepository.deleteById(id);
    }

    /**
     * 查询全部的标签
     *
     * @return
     */
    public List<Label> findLabelList() {
        return labelRepository.findAll();
    }

    /**
     * 根据ID查询标签
     *
     * @param id
     * @return
     */
    public Label findLabelById(String id) {
        return labelRepository.findById(id).get();
    }

    /**
     * 有条件查询标签
     *
     * @param params
     * @return
     */
    @Override
    public List<Label> findLabelByParams(Map<String, Object> params) {

        Specification<Label> specification = this.getSpecification(params);
        return labelRepository.findAll(specification);
    }

    /**
     * 分页查询条件
     *
     * @param params
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Label> findLabelByPage(Map<String, Object> params, int page, int size) {

        Specification<Label> specification = getSpecification(params);

        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return labelRepository.findAll(specification, pageRequest);
    }

    private Specification<Label> getSpecification(Map<String, Object> params) {

        Specification<Label> specification = ((root, query, cb) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if (!StringUtils.isEmpty(params.get("labelName"))) {
                predicateList.add(cb.like(root.get("labelName").as(String.class), "%" + (String) params.get("labelName") + "%"));
            }
            if (!StringUtils.isEmpty(params.get("state"))) {
                predicateList.add(cb.equal(root.get("state").as(String.class), (String) params.get("state")));
            }
            if (!StringUtils.isEmpty(params.get("recommend"))) {
                predicateList.add(cb.equal(root.get("recommend").as(String.class), (String) params.get("recommend")));
            }

            return query.where(predicateList.toArray(new Predicate[predicateList.size()])).getRestriction();
//          return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
        });

        return specification;
    }

}
