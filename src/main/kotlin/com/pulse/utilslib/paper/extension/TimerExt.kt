package com.pulse.utilslib.paper.extension

import com.pulse.utilslib.paper.plugin.PluginContext
import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask

fun runLater(delay: Long, task: () -> Unit): BukkitTask =
    Bukkit.getScheduler().runTaskLater(PluginContext.plugin, task, delay)

fun runLaterAsync(delay: Long, task: () -> Unit): BukkitTask =
    Bukkit.getScheduler().runTaskLaterAsynchronously(PluginContext.plugin, task, delay)

fun runTimer(delay: Long, period: Long, task: BukkitRunnable.() -> Unit): BukkitRunnable {
    val timer = object : BukkitRunnable() {
        override fun run() {
            task()
        }
    }

    timer.runTaskTimer(
        PluginContext.plugin,
        delay,
        period
    )

    return timer
}

fun runTimerAsync(delay: Long, period: Long, task: BukkitRunnable.() -> Unit): BukkitRunnable {
    val timer = object : BukkitRunnable() {
        override fun run() {
            task()
        }
    }

    timer.runTaskTimerAsynchronously(
        PluginContext.plugin,
        delay,
        period
    )

    return timer
}