package org.axonframework.samples.trader.query.kds.repositories;

import org.axonframework.samples.trader.query.kds.ServeryView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServeryViewRepository extends JpaRepository<ServeryView, String> {
}
