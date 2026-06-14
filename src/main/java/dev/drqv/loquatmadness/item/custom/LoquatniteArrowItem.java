package dev.drqv.loquatmadness.item.custom;

import dev.drqv.loquatmadness.entity.LoquatniteArrowEntity;
import dev.drqv.loquatmadness.registry.ModEntityTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class LoquatniteArrowItem extends ArrowItem {

    public LoquatniteArrowItem(Properties properties) {
        super(properties);
    }

    @Override
    public AbstractArrow createArrow(Level level, ItemStack firedFromStack, LivingEntity shooter, @Nullable ItemStack weaponStack) {
        return new LoquatniteArrowEntity(level, shooter, firedFromStack.copyWithCount(1), weaponStack);
    }
}