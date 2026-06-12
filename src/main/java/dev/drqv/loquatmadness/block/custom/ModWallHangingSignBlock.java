package dev.drqv.loquatmadness.block.custom;

import dev.drqv.loquatmadness.block.entity.ModBlockEntities;
import dev.drqv.loquatmadness.block.entity.ModHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWallHangingSignBlock extends WallHangingSignBlock {

    public ModWallHangingSignBlock(WoodType woodType, Properties properties) {
        super(woodType, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ModHangingSignBlockEntity(pos, state);
    }

    @Override
    public boolean canPlace(BlockState state, LevelReader level, BlockPos pos) {
        Direction clockwise = state.getValue(FACING).getClockWise();
        Direction counterClockwise = state.getValue(FACING).getCounterClockWise();
        return this.canAttachTo(level, state, pos.relative(clockwise), counterClockwise)
                || this.canAttachTo(level, state, pos.relative(counterClockwise), clockwise)
                || super.canPlace(state, level, pos);
    }
}