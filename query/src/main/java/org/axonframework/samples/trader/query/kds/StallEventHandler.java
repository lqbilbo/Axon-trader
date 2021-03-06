package org.axonframework.samples.trader.query.kds;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.samples.trader.api.kds.stall.StallCreatedEvent;
import org.axonframework.samples.trader.query.kds.repositories.StallViewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("queryModel")
public class StallEventHandler {

    private static Logger logger = LoggerFactory.getLogger(StallEventHandler.class);

    private final StallViewRepository stallViewRepository;

    @Autowired
    public StallEventHandler(StallViewRepository stallViewRepository) {
        this.stallViewRepository = stallViewRepository;
    }

    @EventHandler
    public void on(StallCreatedEvent event) {
        StallView stallView = new StallView();

        stallView.setIdentifier(event.getStallId().toString());
        stallView.setPoiId(event.getPoiId());
        stallView.setStallName(event.getStallName());
        stallView.setRemark(event.getRemark());
        stallView.setRequirements(event.getRequirements());
        stallView.setAbility(event.getAbility());

        stallViewRepository.save(stallView);

        logger.info("saved success!!!");
    }
}