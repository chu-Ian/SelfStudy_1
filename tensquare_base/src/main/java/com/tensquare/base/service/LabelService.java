package com.tensquare.base.service;

import com.tensquare.base.po.Label;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface LabelService {

    /**
     * 保存一个标签
     *
     * @param label
     */
    void saveLabel(Label label);

    /**
     * 更新一个标签
     *
     * @param label
     */
    void updateLabel(Label label);

    /**
     * 删除一个标签
     *
     * @param id
     */
    void deleteLabelById(String id);

    /**
     * 查询全部的标签
     *
     * @return
     */
    List<Label> findLabelList();

    /**
     * 根据ID查询标签
     *
     * @param id
     * @return
     */
    Label findLabelById(String id);

    List<Label> findLabelByParams(Map<String, Object> params);

    Page<Label> findLabelByPage(Map<String, Object> params, int page, int size);
}
