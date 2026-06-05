package dev.drqv.loquatmadness.datagen;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, LoquatMadness.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(LoquatMadness_Blocks.LOQUAT_PLANKS.get())
                .add(LoquatMadness_Blocks.LOQUAT_LOG.get())
                .add(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get())
                .add(LoquatMadness_Blocks.LOQUAT_STAIRS.get())
                .add(LoquatMadness_Blocks.LOQUAT_SLAB.get())
                .add(LoquatMadness_Blocks.LOQUAT_PRESSURE_PLATE.get())
                .add(LoquatMadness_Blocks.LOQUAT_BUTTON.get())
                .add(LoquatMadness_Blocks.LOQUAT_FENCE.get())
                .add(LoquatMadness_Blocks.LOQUAT_FENCE_GATE.get());

        tag(BlockTags.PLANKS)
                .add(LoquatMadness_Blocks.LOQUAT_PLANKS.get());

        tag(BlockTags.LOGS)
                .add(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get())
                .add(LoquatMadness_Blocks.LOQUAT_LOG.get())
                .add(LoquatMadness_Blocks.LOQUAT_WOOD.get())
                .add(LoquatMadness_Blocks.STRIPPED_LOQUAT_WOOD.get());

        tag(BlockTags.WOODEN_SLABS)
                .add(LoquatMadness_Blocks.LOQUAT_SLAB.get());

        tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(LoquatMadness_Blocks.LOQUAT_PRESSURE_PLATE.get());

        tag(BlockTags.WOODEN_STAIRS)
                .add(LoquatMadness_Blocks.LOQUAT_STAIRS.get());

        tag(BlockTags.WOODEN_BUTTONS)
                .add(LoquatMadness_Blocks.LOQUAT_BUTTON.get());

        tag(BlockTags.WOODEN_FENCES)
                .add(LoquatMadness_Blocks.LOQUAT_FENCE.get());

        tag(BlockTags.FENCE_GATES)
                .add(LoquatMadness_Blocks.LOQUAT_FENCE_GATE.get());
    }
}
