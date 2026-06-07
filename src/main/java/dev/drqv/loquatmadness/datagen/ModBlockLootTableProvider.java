package dev.drqv.loquatmadness.datagen;

import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

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

        add(LoquatMadness_Blocks.LOQUAT_SLAB.get(), this::createSlabItemTable);
        add(LoquatMadness_Blocks.LOQUAT_DOOR.get(), this::createDoorTable);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return LoquatMadness_Blocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
