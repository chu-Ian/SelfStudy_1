package com.tensquare.spit.service;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SpitService {

    public abstract void saveSpit(Spit spit);

    void updateSpit(Spit spit);

    void deleteSpitById(String id);

    List<Spit> findAllSpit();

    Spit findSpitById(String id);

    Page<Spit> findSpitByPage(String parentId, int currentPage, int size);

    void updateSpitIncrThumbup(String id);

    void publishVersion(Spit spit);
}
