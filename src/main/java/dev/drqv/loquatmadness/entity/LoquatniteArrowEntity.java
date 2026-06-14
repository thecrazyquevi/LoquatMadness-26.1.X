package dev.drqv.loquatmadness.entity;

import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import dev.drqv.loquatmadness.registry.ModEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class LoquatniteArrowEntity extends AbstractArrow {

    public LoquatniteArrowEntity(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public LoquatniteArrowEntity(Level level, LivingEntity shooter, ItemStack pickupStack, @Nullable ItemStack weapon) {
        super(ModEntityTypes.LOQUATNITE_ARROW.get(), shooter, level, pickupStack, weapon);
    }

    public LoquatniteArrowEntity(Level level, double x, double y, double z, ItemStack pickupStack, @Nullable ItemStack weapon) {
        super(ModEntityTypes.LOQUATNITE_ARROW.get(), x, y, z, level, pickupStack, weapon);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(LoquatMadness_Items.LOQUATNITE_ARROW.get());
    }

    @Override
    protected void doPostHurtEffects(LivingEntity target) {
        super.doPostHurtEffects(target);

        if (!this.level().isClientSide()) {

            net.minecraft.world.effect.MobEffectInstance slownessEffect =
                    new net.minecraft.world.effect.MobEffectInstance(
                            net.minecraft.world.effect.MobEffects.SLOWNESS,
                            40,
                            9
                    );

            target.addEffect(slownessEffect);
        }
    }
}