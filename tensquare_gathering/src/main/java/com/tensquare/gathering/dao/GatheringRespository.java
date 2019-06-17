package com.tensquare.gathering.dao;

import com.tensquare.gathering.po.Gathering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GatheringRespository extends JpaRepository<Gathering, String> {

}
