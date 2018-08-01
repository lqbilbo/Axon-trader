package org.axonframework.samples.trader.api.kds.servery

import org.axonframework.samples.trader.api.kds.stall.StallId

abstract class ServeryEvent(open val serveryId: ServeryId)

data class ServeryCreatedEvent(
    override val serveryId: ServeryId,
    val poiId: Long,
    val name: String,
    val remark: String,
    val stallIdentifiers: List<String>,
    val online: Boolean,
    val offline: Boolean
) : ServeryEvent(serveryId)

data class ServeryUpdatedEvent(
    val name: String,
    val remark: String,
    val online: Boolean,
    val offline: Boolean
)

data class StallAddedToServeryEvent(
    override val serveryId: ServeryId,
    val stallId: StallId
) : ServeryEvent(serveryId)

data class StallRemovedFromServeryEvent(
    override val serveryId: ServeryId,
    val stallId: StallId
) : ServeryEvent(serveryId)

data class ServeryDeletedEvent(
    override val serveryId: ServeryId
) : ServeryEvent(serveryId)

