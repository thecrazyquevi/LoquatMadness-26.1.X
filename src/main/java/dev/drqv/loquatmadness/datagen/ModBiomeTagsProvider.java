package dev.drqv.loquatmadness.datagen;

import dev.drqv.loquatmadness.LoquatMadness;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagsProvider extends BiomeTagsProvider {

    public static final TagKey<Biome> HAS_LOQUAT_TREE = TagKey.create(
            Registries.BIOME,
            Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "has_loquat_tree")
    );

    public static final TagKey<Biome> HAS_LOQUAT_TREE_ALT = TagKey.create(
            Registries.BIOME,
            Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "has_loquat_tree_alt")
    );

    public ModBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, LoquatMadness.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(HAS_LOQUAT_TREE)
                .addTag(BiomeTags.IS_SAVANNA)
                .addTag(BiomeTags.HAS_VILLAGE_PLAINS)
                .addTag(BiomeTags.HAS_SWAMP_HUT);

        tag(HAS_LOQUAT_TREE_ALT)
                .addTag(BiomeTags.IS_FOREST)
                .addTag(BiomeTags.IS_TAIGA)
                .addTag(BiomeTags.IS_JUNGLE);
    }
}