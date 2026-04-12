package com.pulse.utilslib.paper.command

import com.pulse.utilslib.paper.PaperClassScanner
import com.pulse.utilslib.paper.command.auto.AutoCommand
import com.pulse.utilslib.paper.plugin.PaperPlugin

class CommandScanner(
    plugin: PaperPlugin,
    verbose: Boolean = false
) : PaperClassScanner<AutoCommand>(plugin, AutoCommand::class, verbose) {

    override val name = "commands"

    override fun handle(instance: AutoCommand): Boolean {
        instance.register()
        return true
    }
}
