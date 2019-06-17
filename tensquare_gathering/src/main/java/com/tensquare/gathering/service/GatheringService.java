package com.tensquare.gathering.service;

import com.tensquare.gathering.po.Gathering;

public interface GatheringService {
    Gathering findGatheringById(String articleId);

    void updateGathering(Gathering gathering);

    void deleteGatheringById(String articleId);
}
