package dev.drqv.loquatmadness.datagen;

import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(LoquatMadness_Blocks.LOQUAT_PLANKS.get());
        dropSelf(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get());
        dropSelf(LoquatMadness_Blocks.STRIPPED_LOQUAT_WOOD.get());
        dropSelf(LoquatMadness_Blocks.LOQUAT_LOG.get());
        dropSelf(LoquatMadness_Blocks.LOQUAT_WOOD.get());
        dropSelf(LoquatMadness_Blocks.LOQUAT_STAIRS.get());
        dropSelf(LoquatMadness_Blocks.LOQUAT_PRESSURE_PLATE.get());
        dropSelf(LoquatMadness_Blocks.LOQUAT_BUTTON.get());
        dropSelf(LoquatMadness_Blocks.LOQUAT_FENCE.get());
        dropSelf(LoquatMadness_Blocks.LOQUAT_FENCE_GATE.get());
        dropSelf(LoquatMadness_Blocks.LOQUAT_TRAPDOOR.get());
        dropSelf(LoquatMadness_Blocks.LOQUAT_SIGN.get());
        dropSelf(LoquatMadness_Blocks.LOQUAT_HANGING_SIGN.get());
        dropSelf(LoquatMadness_Blocks.LOQUAT_LEAVES.get());
        dropSelf(LoquatMadness_Blocks.LOQUAT_PROPAGULE.get());
        dropSelf(LoquatMadness_Blocks.LOQUAT_SHELF.get());


        add(LoquatMadness_Blocks.LOQUAT_SHELF.get(), this::createNameableBlockEntityTable);

        add(LoquatMadness_Blocks.LOQUAT_WALL_HANGING_SIGN.get(),
                block -> createSingleItemTable(LoquatMadness_Items.LOQUAT_HANGING_SIGN.get()));
        add(LoquatMadness_Blocks.LOQUAT_WALL_SIGN.get(),
                block -> createSingleItemTable(LoquatMadness_Items.LOQUAT_SIGN.get()));
        add(LoquatMadness_Blocks.LOQUAT_FRUIT_LEAVES.get(),
                block -> createLoquatFruitLeavesDrops(block, LoquatMadness_Items.LOQUAT.get()));
        add(LoquatMadness_Blocks.LOQUAT_LEAVES.get(), block ->
                createLeavesDrops(block, LoquatMadness_Blocks.LOQUAT_PROPAGULE.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        add(LoquatMadness_Blocks.LOQUAT_SLAB.get(), this::createSlabItemTable);
        add(LoquatMadness_Blocks.LOQUAT_DOOR.get(), this::createDoorTable);
        add(LoquatMadness_Blocks.POTTED_LOQUAT_PROPAGULE.get(), block ->
                createPotFlowerItemTable(LoquatMadness_Items.LOQUAT_PROPAGULE.get()));


    }


    private LootTable.Builder createLoquatFruitLeavesDrops(Block original, Item fruit) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createFruitLeavesDrops(original, fruit)
                .withPool(
                        LootPool.lootPool()
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.6F)))
                                .when(doesNotHaveSilkTouch())
                                .add(
                                        ((LootPoolSingletonContainer.Builder)this.applyExplosionCondition(original, LootItem.lootTableItem(Items.STICK)))
                                                .when(
                                                        BonusLevelTableCondition.bonusLevelFlatChance(
                                                                enchantments.getOrThrow(Enchantments.FORTUNE), 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F
                                                        )
                                                )
                                )
                );
    }

    private LootTable.Builder createFruitLeavesDrops(Block original, Item fruit) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchOrShearsDispatchTable(
                        original,
                        ((LootPoolSingletonContainer.Builder)this.applyExplosionCondition(original,
                                LootItem.lootTableItem(fruit)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.6F)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(
                                                enchantments.getOrThrow(Enchantments.FORTUNE)
                                        ))
                        ))
                )
                .withPool(
                        LootPool.lootPool()
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .when(this.doesNotHaveSilkTouch())
                                .add(
                                        ((LootPoolSingletonContainer.Builder)this.applyExplosionDecay(
                                                original, LootItem.lootTableItem(Items.STICK)
                                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                        ))
                                                .when(BonusLevelTableCondition.bonusLevelFlatChance(
                                                        enchantments.getOrThrow(Enchantments.FORTUNE),
                                                        0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F
                                                ))
                                )
                );

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return LoquatMadness_Blocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
