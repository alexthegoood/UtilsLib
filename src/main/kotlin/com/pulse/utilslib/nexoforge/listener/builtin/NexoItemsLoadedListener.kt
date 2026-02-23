package com.pulse.utilslib.nexoforge.listener.builtin

import com.nexomc.nexo.api.events.NexoItemsLoadedEvent
import com.pulse.utilslib.nexoforge.NexoItemsScanner
import com.pulse.utilslib.paper.listener.auto.AutoListener
import com.pulse.utilslib.paper.plugin.PluginContext
import org.bukkit.event.EventHandler

class NexoItemsLoadedListener: AutoListener(false) {
    @EventHandler
    fun onNexoItemsLoaded(event: NexoItemsLoadedEvent) {
        NexoItemsScanner(PluginContext.plugin)
            .load()
    }
}