package org.axonframework.samples.trader.api.kds.stall

import org.axonframework.commandhandling.TargetAggregateIdentifier

abstract class StallCommand(@TargetAggregateIdentifier open val stallId: StallId)

data class CreateStallCommand(
    override val stallId: StallId,
    val poiId: Long,
    val stallName: String,
    val remark: String,
    val requirements: String,
    val ability: Int
) : StallCommand(stallId)

data class UpdateStallCommand(
    val stallName: String,
    val remark: String,
    val requirements: String,
    val ability: Int
)

data class DeleteStallCommand(
    override val stallId: StallId
) : StallCommand(stallId)

