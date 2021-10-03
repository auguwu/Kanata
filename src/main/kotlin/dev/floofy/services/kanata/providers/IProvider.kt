/**
 * Microservice to handle Kubernetes pod state changes and reports them in Instatus or Statuspages.
 * Copyright (c) 2021 Noel <cutie@floofy.dev>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package dev.floofy.services.kanata.providers

import dev.floofy.services.kanata.Kanata
import dev.floofy.services.kanata.types.StatusPacket

/**
 * Represents a provider class to post to any status page
 * services available.
 *
 * @param kanata The current server instance to send http requests as an example!
 */
abstract class IProvider(val kanata: Kanata) {
    /**
     * Dispatch method to post to the statuspage based off the [StatusPacket.phase] change.
     * @param packet The status packet to use.
     */
    abstract suspend fun dispatch(packet: StatusPacket)
}
