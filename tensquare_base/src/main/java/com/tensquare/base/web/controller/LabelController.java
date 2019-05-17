package com.tensquare.base.web.controller;

import com.tensquare.base.po.Label;
import com.tensquare.base.service.LabelService;
import constants.StatusCode;
import dto.PageResultDTO;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 标签控制层
 */
@CrossOrigin //支持跨域请求
@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 保存一个标签
     * @param label
     * @return
     */
    @PostMapping
    public ResultDTO add(@RequestBody Label label) {
        labelService.saveLabel(label);
        return new ResultDTO(true, StatusCode.OK,"添加成功");
    }

    /**
     * 修改一个标签
     * @param id
     * @return
     */
    @PutMapping
    public ResultDTO update(@RequestParam("id") String id) {
        Label label = labelService.findLabelById(id);
        label.setLabelName("myBatis");

        labelService.updateLabel(label);
        return new ResultDTO(true, StatusCode.OK, "更新成功");
    }

    /**
     * 删除一个标签
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResultDTO deleteById(@PathVariable String id) {
        labelService.deleteLabelById(id);
        return new ResultDTO(true,StatusCode.OK,"删除成功");
    }

    /**
     * 查询全部标签
     * @return
     */
    @GetMapping
    public ResultDTO findAllLabel() {
        List<Label> labelList = labelService.findLabelList();
        return new ResultDTO(true, StatusCode.OK, "查询成功", labelList);
    }

    /**
     * 通过id查询标签
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResultDTO findLabelById(@PathVariable String id) {

        Label labelById = labelService.findLabelById(id);
        return new ResultDTO(true, StatusCode.OK, "查询成功", labelById);
    }

    /**
     * 有条件查询标签
     * @param params
     * @return
     */
    @PostMapping("/search")
    public ResultDTO findLabelByParams(@RequestBody Map<String, Object> params) {
        List<Label> labelList = labelService.findLabelByParams(params);
        return new ResultDTO(true,StatusCode.OK,"查询成功",labelList);
    }

    /**
     * 分页查询条件
     * @param params
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/search/{page}/{size}")
    public ResultDTO findLabelByPage(@RequestBody Map<String, Object> params,
                                     @PathVariable int page,
                                     @PathVariable int size) {
        Page<Label> pageResp = labelService.findLabelByPage(params, page, size);
//        System.out.println(pageResp.getContent());
        PageResultDTO<Label> pageResultDTO = new PageResultDTO<>(pageResp.getTotalElements(),pageResp.getContent());
        return new ResultDTO(true, StatusCode.OK, "查询成功", pageResultDTO);

    }
}
