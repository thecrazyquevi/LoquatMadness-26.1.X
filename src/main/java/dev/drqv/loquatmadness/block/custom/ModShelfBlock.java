package dev.drqv.loquatmadness.block.custom;

import dev.drqv.loquatmadness.block.entity.ModShelfBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.ShelfBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class ModShelfBlock extends ShelfBlock {

    public ModShelfBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ModShelfBlockEntity(pos, state);
    }
}