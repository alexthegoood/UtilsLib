package com.pulse.utilslib.nexoforge.extension

import com.nexomc.nexo.api.NexoItems
import com.pulse.nexoforge.api.NexoForgeItem
import com.pulse.utilslib.paper.extension.meta
import net.kyori.adventure.sound.Sound
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.persistence.PersistentDataType

fun NexoForgeItem.item() =
    NexoItems.itemFromId(id)!!.build()

fun ItemStack.nexoId(earlyExit: Boolean = true): String? {
    if (earlyExit) {
        if (type != Material.SHELTER_POTTERY_SHERD &&
            type != Material.PLAYER_HEAD &&
            type != Material.SUGAR &&
            type != Material.LEATHER_HORSE_ARMOR
        ) return null
    }

    return NexoItems.idFromItem(this)
}

fun ItemMeta.switchNexoId(string: String) {
    persistentDataContainer.set(
        NamespacedKey.fromString("nexo:id")!!,
        PersistentDataType.STRING, string
    )
}

fun toggleNexoItem(player: Player, newId: String, sound: Sound) {
    val newItem = NexoItems.itemFromId(newId) ?: return
    val item = player.inventory.itemInMainHand

    item.meta<ItemMeta> {
        itemModel = newItem.itemModel
        if (newItem.hasCustomModelDataComponent()) setCustomModelDataComponent(newItem.customModelDataComponent)
        lore(newItem.lore)
        switchNexoId(newId)
    }

    player.playSound(sound, player)
}