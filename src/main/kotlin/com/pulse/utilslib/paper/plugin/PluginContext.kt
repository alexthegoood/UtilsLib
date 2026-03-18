package com.pulse.utilslib.paper.plugin

import com.pulse.nexoforge.NexoForge
import com.tcoded.folialib.FoliaLib
import net.coreprotect.CoreProtect
import net.megavex.scoreboardlibrary.api.ScoreboardLibrary

object PluginContext {
    lateinit var foliaLib: FoliaLib
    lateinit var scoreboardLib: ScoreboardLibrary
    lateinit var nexoForge: NexoForge
    lateinit var coreProtect: CoreProtect
    lateinit var plugin: PaperPlugin
}