package org.axonframework.samples.trader.api.kds.servery

import org.axonframework.commandhandling.TargetAggregateIdentifier
import org.axonframework.samples.trader.api.kds.stall.StallId

abstract class ServeryCommand(@TargetAggregateIdentifier open val serveryId: ServeryId)

data class CreateServeryCommand(
    override val serveryId: ServeryId,
    val poiId: Long,
    val name: String,
    val remark: String,
    val stallId: StallId,
    val online: Boolean,
    val offline: Boolean
) : ServeryCommand(serveryId)

data class UpdateServeryCommand(
    val name: String,
    val remark: String,
    val online: Boolean,
    val offline: Boolean
)

data class AddStallToServeryCommand(
    override val serveryId: ServeryId,
    val stallId: StallId
) : ServeryCommand(serveryId)

data class RemoveStallFromServeryCommand(
    override val serveryId: ServeryId,
    val stallId: StallId
) : ServeryCommand(serveryId)

data class DeleteServeryCommand(
    override val serveryId: ServeryId
) : ServeryCommand(serveryId)