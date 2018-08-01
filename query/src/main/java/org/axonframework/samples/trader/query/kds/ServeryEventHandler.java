package org.axonframework.samples.trader.query.kds;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.samples.trader.api.kds.servery.ServeryCreatedEvent;
import org.axonframework.samples.trader.api.kds.servery.ServeryId;
import org.axonframework.samples.trader.query.kds.repositories.ServeryViewRepository;
import org.axonframework.samples.trader.query.kds.repositories.StallViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ProcessingGroup("queryModel")
public class ServeryEventHandler {

    private final ServeryViewRepository serveryViewRepository;
    private final StallViewRepository stallViewRepository;

    @Autowired
    public ServeryEventHandler(ServeryViewRepository serveryViewRepository,
                               StallViewRepository stallViewRepository) {
        this.serveryViewRepository = serveryViewRepository;
        this.stallViewRepository = stallViewRepository;
    }

    @EventHandler
    public void on(ServeryCreatedEvent event) {

        List<StallView> stallViews = stallViewRepository.findAll(event.getStallIdentifiers());

        ServeryView view = new ServeryView();

        view.setIdentifier(event.getServeryId().getIdentifier());
        for (int i = 0; i < stallViews.size(); i++) {
            view.setStallIdentifier(stallViews.get(i).getIdentifier());
            view.setRequirement(stallViews.get(i).getRequirements());
            view.setSeq(i);
        }

        view.setName(event.getName());
        view.setPoiId(event.getPoiId());
        view.setRemark(event.getRemark());
        view.setOnline(event.getOnline());
        view.setOffline(event.getOffline());

        serveryViewRepository.save(view);
    }



}
