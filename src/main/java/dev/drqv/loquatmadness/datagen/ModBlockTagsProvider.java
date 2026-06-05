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
                .add(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get());

        tag(BlockTags.PLANKS)
                .add(LoquatMadness_Blocks.LOQUAT_PLANKS.get());

        tag(BlockTags.LOGS)
                .add(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get())
                .add(LoquatMadness_Blocks.LOQUAT_LOG.get());
    }
}
