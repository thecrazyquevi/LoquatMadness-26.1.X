package dev.drqv.loquatmadness.block.custom;

import dev.drqv.loquatmadness.worldgen.feature.ModConfiguredFeatures;
import dev.drqv.loquatmadness.worldgen.feature.ModPlacedFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ModSaplingBlock extends BushBlock {

    public static final IntegerProperty STAGE = BlockStateProperties.STAGE;

    private static final List<ResourceKey<ConfiguredFeature<?, ?>>> TREES = List.of(
            ModConfiguredFeatures.LOQUAT_TREE_1,
            ModConfiguredFeatures.LOQUAT_TREE_2
    );

    public ModSaplingBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        builder.add(STAGE);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(BlockTags.SUBSTRATE_OVERWORLD)
                && !(state.getBlock() instanceof ModSaplingBlock);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (random.nextInt(7) == 0) {
            performBonemeal(level, random, pos, state);
        }
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if (state.getValue(STAGE) == 0) {
            level.setBlock(pos, state.cycle(STAGE), 4);
        } else {
            growTree(state, level, pos, random);
        }
    }

    private void growTree(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        ResourceKey<ConfiguredFeature<?, ?>> treeKey = TREES.get(random.nextInt(TREES.size()));

        level.registryAccess()
                .lookup(net.minecraft.core.registries.Registries.CONFIGURED_FEATURE)
                .flatMap(registry -> registry.get(treeKey))
                .ifPresent(feature -> {
                    level.removeBlock(pos, false);
                    if (!feature.value().place(level, level.getChunkSource().getGenerator(), random, pos)) {
                        level.setBlock(pos, state, 3);
                    }
                });
    }
}