package dev.drqv.loquatmadness.item.consumable;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomEffectsConsumeEffect implements ConsumeEffect {

    public static final MapCodec<RandomEffectsConsumeEffect> CODEC = MapCodec.unit(RandomEffectsConsumeEffect::new);

    public static final StreamCodec<RegistryFriendlyByteBuf, RandomEffectsConsumeEffect> STREAM_CODEC =
            StreamCodec.unit(new RandomEffectsConsumeEffect());

    @Override
    public ConsumeEffect.Type<? extends ConsumeEffect> getType() {
        return new ConsumeEffect.Type<>(CODEC, STREAM_CODEC);
    }
    @Override
    public boolean apply(net.minecraft.world.level.Level level, ItemStack stack, LivingEntity entity) {
        if (!level.isClientSide() && entity instanceof net.minecraft.server.level.ServerPlayer player) {

            List<Holder<net.minecraft.world.effect.MobEffect>> todosLosEfectos = new java.util.ArrayList<>(List.of(
                    MobEffects.HASTE,
                    MobEffects.SPEED,
                    MobEffects.FIRE_RESISTANCE,
                    MobEffects.SLOWNESS,
                    MobEffects.JUMP_BOOST,
                    MobEffects.INVISIBILITY,
                    MobEffects.RESISTANCE,
                    MobEffects.WATER_BREATHING,
                    MobEffects.GLOWING,
                    MobEffects.SATURATION,
                    MobEffects.BAD_OMEN,
                    MobEffects.ABSORPTION,
                    MobEffects.MINING_FATIGUE,
                    MobEffects.WITHER,
                    MobEffects.WIND_CHARGED,
                    MobEffects.WEAVING,
                    MobEffects.UNLUCK,
                    MobEffects.STRENGTH,
                    MobEffects.BREATH_OF_THE_NAUTILUS,
                    MobEffects.DOLPHINS_GRACE,
                    MobEffects.HEALTH_BOOST,
                    MobEffects.CONDUIT_POWER,
                    MobEffects.HUNGER,
                    MobEffects.INFESTED,
                    MobEffects.DARKNESS,
                    MobEffects.BLINDNESS,
                    MobEffects.INSTANT_DAMAGE,
                    MobEffects.WEAKNESS,
                    MobEffects.NAUSEA,
                    MobEffects.OOZING,
                    MobEffects.HERO_OF_THE_VILLAGE,
                    MobEffects.INSTANT_HEALTH,
                    MobEffects.LEVITATION
            ));

            java.util.Random javaRandom = new java.util.Random(player.getRandom().nextLong());
            java.util.Collections.shuffle(todosLosEfectos, javaRandom);

            int efectosAAplicar = Math.min(5, todosLosEfectos.size());
            for (int i = 0; i < efectosAAplicar; i++) {
                Holder<net.minecraft.world.effect.MobEffect> efectoElegido = todosLosEfectos.get(i);

                player.addEffect(new net.minecraft.world.effect.MobEffectInstance(efectoElegido, 300, 0));
            }
            player.addEffect(new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1, 2));
            return true;
        }
        return false;
    }
}