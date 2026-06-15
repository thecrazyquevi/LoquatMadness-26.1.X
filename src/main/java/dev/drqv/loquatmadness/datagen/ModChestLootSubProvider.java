package dev.drqv.loquatmadness.datagen;

import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class ModChestLootSubProvider implements LootTableSubProvider {
    protected final HolderLookup.Provider registries;

    public ModChestLootSubProvider(HolderLookup.Provider registries) {
        this.registries = registries;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> writer) {

        // =========================================================================
        // 1: loquat_items_loot
        // =========================================================================
        ResourceKey<LootTable> loquatItems = ResourceKey.create(Registries.LOOT_TABLE,
                Identifier.fromNamespaceAndPath("loquatmadness", "chests/loquat_items_loot"));

        LootTable.Builder tablaItems = LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0F, 2.0F))

                        .add(LootItem.lootTableItem(LoquatMadness_Items.LOQUAT.get())
                                .setWeight(25)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))))
                        .add(LootItem.lootTableItem(LoquatMadness_Items.LOQUAT_SKIN.get())
                                .setWeight(17)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F))))
                        .add(LootItem.lootTableItem(LoquatMadness_Items.LOQUAT_GROUP.get())
                                .setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F))))
                        .add(LootItem.lootTableItem(LoquatMadness_Items.LOQUAT_PROPAGULE.get())
                                .setWeight(3)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F))))
                        .add(LootItem.lootTableItem(LoquatMadness_Blocks.LOQUAT_LOG.get().asItem())
                                .setWeight(10)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))

                        .add(EmptyLootItem.emptyItem()
                                .setWeight(40))
                );
        writer.accept(loquatItems, tablaItems);


        // =========================================================================
        // 2: loquat_nether_loot
        // =========================================================================
        ResourceKey<LootTable> netherItems = ResourceKey.create(Registries.LOOT_TABLE,
                Identifier.fromNamespaceAndPath("loquatmadness", "chests/loquat_nether_loot"));

        LootTable.Builder tablaNether = LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0F, 2.0F))

                        .add(LootItem.lootTableItem(LoquatMadness_Items.BURNING_LOQUAT.get())
                                .setWeight(15)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(LootItem.lootTableItem(LoquatMadness_Items.LOQUATNITE.get())
                                .setWeight(8)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F))))
                        .add(LootItem.lootTableItem(LoquatMadness_Items.LOQUATNITE_ARROW.get())
                                .setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F))))
                        .add(LootItem.lootTableItem(LoquatMadness_Items.LOQUAT_SKIN.get())
                                .setWeight(12)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))

                        .add(EmptyLootItem.emptyItem()
                                .setWeight(60))
                );
        writer.accept(netherItems, tablaNether);


        // =========================================================================
        // 3: loquat_other_loot
        // =========================================================================
        ResourceKey<LootTable> otherItems = ResourceKey.create(Registries.LOOT_TABLE,
                Identifier.fromNamespaceAndPath("loquatmadness", "chests/loquat_other_loot"));

        LootTable.Builder tablaOther = LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0F, 3.0F))

                        .add(LootItem.lootTableItem(LoquatMadness_Items.LOQUAT_SKIN.get())
                                .setWeight(15)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(LootItem.lootTableItem(LoquatMadness_Items.LOQUAT_GROUP.get())
                                .setWeight(10)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .add(LootItem.lootTableItem(LoquatMadness_Blocks.LOQUAT_PLANKS.get().asItem())
                                .setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(LoquatMadness_Items.LOQUATNITE_CORE.get())
                                .setWeight(3)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F))))
                        .add(LootItem.lootTableItem(LoquatMadness_Items.LOQUAT_PROPAGULE.get())
                                .setWeight(3)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F))))
                        .add(LootItem.lootTableItem(LoquatMadness_Items.CANDY_LOQUAT.get())
                                .setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(LoquatMadness_Items.BURNING_LOQUAT.get())
                                .setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))

                        .add(EmptyLootItem.emptyItem()
                                .setWeight(60))
                );
        writer.accept(otherItems, tablaOther);
    }
}