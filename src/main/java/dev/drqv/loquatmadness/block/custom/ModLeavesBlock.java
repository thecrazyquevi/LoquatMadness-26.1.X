package dev.drqv.loquatmadness.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TintedParticleLeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModLeavesBlock extends TintedParticleLeavesBlock {

    public static final MapCodec<ModLeavesBlock> CODEC = simpleCodec(ModLeavesBlock::new);

    public ModLeavesBlock(BlockBehaviour.Properties properties) {
        super(0.005f, properties);
    }

    @Override
    protected void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random) {

        int r = 101;
        int g = 130;
        int b = 67;

        int colorHex = (r << 16) | (g << 8) | b;

        ColorParticleOption particle = ColorParticleOption.create(net.minecraft.core.particles.ParticleTypes.TINTED_LEAVES, colorHex);

        ParticleUtils.spawnParticleBelow(level, pos, random, particle);
    }

    @Override
    public MapCodec<? extends TintedParticleLeavesBlock> codec() {
        return CODEC;
    }

}