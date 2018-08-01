package org.axonframework.samples.trader.api.kds.servery

import org.axonframework.common.IdentifierFactory
import java.io.Serializable

data class ServeryId(val identifier: String = IdentifierFactory.getInstance().generateIdentifier()) : Serializable {

    companion object {
        private const val serialVersionUID = -2521069615900157078L
    }
}