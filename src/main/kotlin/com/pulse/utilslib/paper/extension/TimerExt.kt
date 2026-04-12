package com.pulse.utilslib.paper.extension

import com.pulse.utilslib.paper.plugin.PluginContext
import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask


fun runTask(
    plugin: Plugin = PluginContext.plugin,
    task: () -> Unit
): BukkitTask =
    Bukkit.getScheduler().runTask(plugin, task)

fun runTaskAsync(
    plugin: Plugin = PluginContext.plugin,
    task: () -> Unit
): BukkitTask =
    Bukkit.getScheduler().runTaskAsynchronously(plugin, task)


fun runLater(
    delay: Long,
    plugin: Plugin = PluginContext.plugin,
    task: () -> Unit
): BukkitTask =
    Bukkit.getScheduler().runTaskLater(plugin, task, delay)

fun runLaterAsync(
    delay: Long,
    plugin: Plugin = PluginContext.plugin,
    task: () -> Unit
): BukkitTask =
    Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, task, delay)

fun runTimer(delay: Long, period: Long, plugin: Plugin = PluginContext.plugin, task: BukkitRunnable.() -> Unit): BukkitRunnable {
    val timer = object : BukkitRunnable() {
        override fun run() {
            task()
        }
    }

    timer.runTaskTimer(
        plugin,
        delay,
        period
    )

    return timer
}

fun runTimerAsync(delay: Long, period: Long, plugin: Plugin = PluginContext.plugin, task: BukkitRunnable.() -> Unit): BukkitRunnable {
    val timer = object : BukkitRunnable() {
        override fun run() {
            task()
        }
    }

    timer.runTaskTimerAsynchronously(
        plugin,
        delay,
        period
    )

    return timer
}