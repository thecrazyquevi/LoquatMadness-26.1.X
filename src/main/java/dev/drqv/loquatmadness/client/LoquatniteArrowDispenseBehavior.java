package dev.drqv.loquatmadness.client;

import dev.drqv.loquatmadness.entity.LoquatniteArrowEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class LoquatniteArrowDispenseBehavior extends DefaultDispenseItemBehavior {

    @Override
    public ItemStack execute(BlockSource blockSource, ItemStack stack) {
        Level level = blockSource.level();


        if (!level.isClientSide()) {
            Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
            Position position = DispenserBlock.getDispensePosition(blockSource);


            LoquatniteArrowEntity arrow = new LoquatniteArrowEntity(
                    level,
                    position.x(),
                    position.y(),
                    position.z(),
                    stack.copyWithCount(1),
                    null
            );


            arrow.shoot(direction.getStepX(), direction.getStepY() + 0.1F, direction.getStepZ(), 1.1F, 6.0F);

            arrow.pickup = AbstractArrow.Pickup.ALLOWED;

            level.addFreshEntity(arrow);

            stack.shrink(1);
        }

        return stack;
    }
}
