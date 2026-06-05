package dev.drqv.loquatmadness.datagen;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, LoquatMadness.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(ItemTags.PLANKS)
                .add(LoquatMadness_Blocks.LOQUAT_PLANKS.get().asItem());

        tag(ItemTags.LOGS)
                .add(LoquatMadness_Blocks.LOQUAT_LOG.get().asItem())
                .add(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get().asItem())
                .add(LoquatMadness_Blocks.STRIPPED_LOQUAT_WOOD.get().asItem())
                .add(LoquatMadness_Blocks.LOQUAT_WOOD.get().asItem());

        tag(ItemTags.WOODEN_SLABS)
                .add(LoquatMadness_Blocks.LOQUAT_SLAB.get().asItem());

        tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(LoquatMadness_Blocks.LOQUAT_PRESSURE_PLATE.get().asItem());

        tag(ItemTags.WOODEN_STAIRS)
                .add(LoquatMadness_Blocks.LOQUAT_STAIRS.get().asItem());

        tag(ItemTags.WOODEN_BUTTONS)
                .add(LoquatMadness_Blocks.LOQUAT_BUTTON.get().asItem());

        tag(ItemTags.WOODEN_FENCES)
                .add(LoquatMadness_Blocks.LOQUAT_FENCE.get().asItem());

        tag(ItemTags.FENCE_GATES)
                .add(LoquatMadness_Blocks.LOQUAT_FENCE_GATE.get().asItem());

    }
}
