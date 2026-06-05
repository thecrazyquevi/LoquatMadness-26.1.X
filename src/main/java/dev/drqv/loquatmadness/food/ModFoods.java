package dev.drqv.loquatmadness.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {
    public static final FoodProperties LOQUAT = new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build();
    public static final FoodProperties PLUS_LOQUAT = new FoodProperties.Builder().nutrition(5).saturationModifier(0.3F).build();

    public static final Consumable LOQUAT_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.6F).build();
    public static final Consumable BURNING_LOQUAT_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.6F).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0)))
            .build();
    public static final Consumable CANDY_LOQUAT_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.6F).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 600, 0)))
            .build();
}
