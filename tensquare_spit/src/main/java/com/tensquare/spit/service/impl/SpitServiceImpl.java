package com.tensquare.spit.service.impl;

import com.tensquare.spit.config.SpitConfig;
import com.tensquare.spit.dao.SpitRepository;
import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class SpitServiceImpl implements SpitService {

    @Autowired
    private SpitConfig spitConfig;

    @Autowired
    private SpitRepository spitRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 存数据
     *
     * @param spit
     */
    public void saveSpit(Spit spit) {
        spit.setId(spitConfig.getWorkId().nextId() + "");

        spitRepository.save(spit);
    }

    /**
     * 修改数据
     *
     * @param spit
     */
    public void updateSpit(Spit spit) {

        Spit spitById = spitRepository.findById(spit.getId()).get();

        if (null == spitById) {
            spitRepository.save(spit);
        } else {
            BeanUtils.copyProperties(spit, spitById);
            spitRepository.save(spitById);
        }

    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteSpitById(String id) {

        Spit spit = spitRepository.findById(id).get();

        if (spit == null) {
            return;
        } else {
            spitRepository.deleteById(id);
        }
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    public List<Spit> findAllSpit() {
        return spitRepository.findAll();
    }

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    public Spit findSpitById(String id) {
        return spitRepository.findById(id).orElse(null);
    }

    /**
     * 分页查询数据
     *
     * @param parentId
     * @param currentPage
     * @param size
     * @return
     */
    @Override
    public Page<Spit> findSpitByPage(String parentId, int currentPage, int size) {

        Page<Spit> spitPage = spitRepository.findByParentId(parentId, PageRequest.of(currentPage - 1, size));
//                .findAll(PageRequest.of(currentPage - 1, size));
        return spitPage;
    }

    /**
     * 使用MongoTemplate来增加点赞数
     *
     * @param id
     */
    @Override
    public void updateSpitIncrThumbup(String id) {
        log.info("参数值：" + id);
        //构建查询条件
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));

        //构建要修改的对象
        Update update = new Update();
        //参数一：递增的字段，参数二：递增的步进
        update.inc("thumbup", 1);
        //更新指定字段
        update.set("share", 1);

        //更新符合条件的第一条记录
        //参数一：查询条件对象，参数二：要修改的对象，参数三：映射的实体类和集合名字
//        mongoTemplate.updateFirst(query, update, Spit.class);
        mongoTemplate.updateMulti(Query.query(Criteria.where("_id").is("1144441597237268480")),
                Update.update("nickname", "周八"), Spit.class);
        mongoTemplate.updateMulti(Query.query(Criteria.where("_id").is("1144441602270433280")),
                Update.update("nickname", "凤九"), Spit.class);
    }

    /**
     * 添加评论/回复
     *
     * @param spit
     */
    @Override
    public void publishVersion(Spit spit) {
        spit.setId(spitConfig.getWorkId().nextId() + "");
        spit.setThumbup(0);
        spit.setShare(0);
        spit.setVisits(0);
        spit.setComment(0);
        spit.setState("1");

        spitRepository.save(spit);

        //查看是否存在父节点，存在则表明这是父节点的回复，则需要为父节点回复+1
        if (!StringUtils.isEmpty(spit.getParentId())) {
            mongoTemplate.updateFirst(Query.query(Criteria.where("parentid").is(spit.getParentId())),
                    new Update().inc("thumbup", 1),
                    Spit.class);
        }
    }
}
