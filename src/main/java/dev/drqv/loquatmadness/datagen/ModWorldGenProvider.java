package dev.drqv.loquatmadness.datagen;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import dev.drqv.loquatmadness.worldgen.feature.ModConfiguredFeatures;
import dev.drqv.loquatmadness.worldgen.feature.ModPlacedFeatures;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModWorldGenProvider::bootstrapConfiguredFeatures)
            .add(Registries.PLACED_FEATURE, ModWorldGenProvider::bootstrapPlacedFeatures)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModWorldGenProvider::bootstrapBiomeModifiers);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, BUILDER, Set.of(LoquatMadness.MOD_ID));
    }

    private static void bootstrapConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        BlockStateProvider leavesProvider = new WeightedStateProvider(
                new WeightedList.Builder<BlockState>()
                        .add(LoquatMadness_Blocks.LOQUAT_LEAVES.get().defaultBlockState(), 7)
                        .add(LoquatMadness_Blocks.LOQUAT_FRUIT_LEAVES.get().defaultBlockState(), 1)
        );

        context.register(ModConfiguredFeatures.LOQUAT_TREE_1,
                new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(LoquatMadness_Blocks.LOQUAT_LOG.get()),
                        new ForkingTrunkPlacer(2, 1, 0),
                        leavesProvider,
                        new AcaciaFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0)),
                        new TwoLayersFeatureSize(0, 1, 1)
                ).ignoreVines().build()
                )
        );

        context.register(ModConfiguredFeatures.LOQUAT_TREE_2,
                new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(LoquatMadness_Blocks.LOQUAT_LOG.get()),
                        new ForkingTrunkPlacer(3, 1, 0),
                        leavesProvider,
                        new AcaciaFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0)),
                        new TwoLayersFeatureSize(1, 1, 1)
                ).ignoreVines().build()
                )
        );
    }

    private static void bootstrapPlacedFeatures(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        PlacementModifier strictHeightmap = HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG);

        PlacementModifier survivalFilter = BlockPredicateFilter.forPredicate(
                BlockPredicate.matchesTag(BlockTags.DIRT)
        );

        PlacementModifier realAntiCrowdingFilter = BlockPredicateFilter.forPredicate(
                BlockPredicate.allOf(
                        // Detectar si hay hojas de cualquier árbol a 3 bloques de distancia en cruz
                        BlockPredicate.not(BlockPredicate.matchesTag(new Vec3i(3, 3, 0), BlockTags.LEAVES)),
                        BlockPredicate.not(BlockPredicate.matchesTag(new Vec3i(-3, 3, 0), BlockTags.LEAVES)),
                        BlockPredicate.not(BlockPredicate.matchesTag(new Vec3i(0, 3, 3), BlockTags.LEAVES)),
                        BlockPredicate.not(BlockPredicate.matchesTag(new Vec3i(0, 3, -3), BlockTags.LEAVES)),

                        // Diagonales (Evita que las esquinas de las copas se entrelacen)
                        BlockPredicate.not(BlockPredicate.matchesTag(new Vec3i(2, 3, 2), BlockTags.LEAVES)),
                        BlockPredicate.not(BlockPredicate.matchesTag(new Vec3i(-2, 3, 2), BlockTags.LEAVES)),
                        BlockPredicate.not(BlockPredicate.matchesTag(new Vec3i(2, 3, -2), BlockTags.LEAVES)),
                        BlockPredicate.not(BlockPredicate.matchesTag(new Vec3i(-2, 3, -2), BlockTags.LEAVES))
                )
        );

        PlacementModifier grassOnlyFilter = BlockPredicateFilter.forPredicate(
                BlockPredicate.matchesBlocks(new Vec3i(0, -1, 0), Blocks.GRASS_BLOCK)
        );

        context.register(ModPlacedFeatures.LOQUAT_TREE_1_PLACED,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModConfiguredFeatures.LOQUAT_TREE_1),
                        List.of(
                                RarityFilter.onAverageOnceEvery(14),     // Subimos un poco la rareza para compensar
                                InSquarePlacement.spread(),
                                strictHeightmap,                        // 1º Ir a la superficie
                                grassOnlyFilter,                        // 2º Comprobar que el suelo esté intacto
                                realAntiCrowdingFilter,                 // 3º Comprobar espacio aéreo libre de hojas
                                SurfaceWaterDepthFilter.forMaxDepth(0),
                                BiomeFilter.biome()
                        )
                )
        );

        context.register(ModPlacedFeatures.LOQUAT_TREE_2_PLACED,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModConfiguredFeatures.LOQUAT_TREE_2),
                        List.of(
                                RarityFilter.onAverageOnceEvery(14),     // Subimos un poco la rareza para compensar
                                InSquarePlacement.spread(),
                                strictHeightmap,                        // 1º Ir a la superficie
                                grassOnlyFilter,                        // 2º Comprobar que el suelo esté intacto
                                realAntiCrowdingFilter,                 // 3º Comprobar espacio aéreo libre de hojas
                                SurfaceWaterDepthFilter.forMaxDepth(0),
                                BiomeFilter.biome()
                        )
                )
        );
    }

    private static void bootstrapBiomeModifiers(BootstrapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(
                ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS,
                        Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "loquat_trees")),
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(ModBiomeTagsProvider.HAS_LOQUAT_TREE),
                        HolderSet.direct(
                                placedFeatures.getOrThrow(ModPlacedFeatures.LOQUAT_TREE_1_PLACED),
                                placedFeatures.getOrThrow(ModPlacedFeatures.LOQUAT_TREE_2_PLACED)
                        ),
                        GenerationStep.Decoration.VEGETAL_DECORATION
                )
        );
    }
}