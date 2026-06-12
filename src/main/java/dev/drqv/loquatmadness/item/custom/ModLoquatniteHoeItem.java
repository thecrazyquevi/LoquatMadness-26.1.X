package dev.drqv.loquatmadness.item.custom;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;

public class ModLoquatniteHoeItem extends HoeItem {

    public ModLoquatniteHoeItem(ToolMaterial material, Item.Properties properties) {
        super(material, -3f, 0f, properties.delayedComponent(
                DataComponents.ENCHANTMENTS,
                registries -> {
                    ItemEnchantments.Mutable enchantments = new ItemEnchantments.Mutable(ItemEnchantments.EMPTY);
                    enchantments.set(
                            registries.lookupOrThrow(Registries.ENCHANTMENT)
                                    .getOrThrow(Enchantments.FORTUNE),
                            3
                    );
                    return enchantments.toImmutable();
                }
        ));
    }
}
