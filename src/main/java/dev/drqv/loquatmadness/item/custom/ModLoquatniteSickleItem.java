package dev.drqv.loquatmadness.item.custom;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.neoforged.neoforge.common.extensions.IItemExtension;

import java.util.List;

public class ModLoquatniteSickleItem extends Item {

    public ModLoquatniteSickleItem(ToolMaterial material, float baseDamage, float attackSpeed, double bonusRange, double bonusRangeAlt, Item.Properties properties) {
        super(properties
                .durability(material.durability())
                .enchantable(material.enchantmentValue())
                .component(DataComponents.ATTRIBUTE_MODIFIERS, createSickleAttributes(baseDamage, attackSpeed, bonusRange, bonusRangeAlt))
                .component(DataComponents.TOOL, new Tool(List.of(), 1.0F, 1, false))
        );
    }

    @Override
    public void hurtEnemy(ItemStack itemStack, net.minecraft.world.entity.LivingEntity mob, net.minecraft.world.entity.LivingEntity attacker) {
        super.hurtEnemy(itemStack, mob, attacker);

        if (attacker.level() instanceof ServerLevel serverLevel) {

            if (!(attacker instanceof ServerPlayer serverPlayer && serverPlayer.isCreative())) {
                itemStack.hurtAndBreak(1, serverLevel, attacker, (brokenItem) -> {
                attacker.onEquippedItemBroken(brokenItem, net.minecraft.world.entity.EquipmentSlot.MAINHAND);
                });
            }

            if (attacker instanceof Player player) {

                float cooldown = player.getAttackAnim(0.5F);
                if (cooldown > 0.9F && !player.isSprinting()) {
                    ejecutarBarridoManual(serverLevel, player, mob, itemStack);
                }
            }
        }
    }

    private void ejecutarBarridoManual(ServerLevel level, Player player, LivingEntity targetMob, ItemStack stack) {
        float damageBase = (float) player.getAttributeValue(Attributes.ATTACK_DAMAGE);
        float ratioBarrido = (float) player.getAttributeValue(Attributes.SWEEPING_DAMAGE_RATIO);
        float dañoFinalBarrido = 1.0F + (ratioBarrido * damageBase);

        double alcanceHorizontal = 1.0D + player.getAttributeValue(Attributes.ENTITY_INTERACTION_RANGE);

        List<LivingEntity> victimas = level.getEntitiesOfClass(LivingEntity.class, targetMob.getBoundingBox().inflate(alcanceHorizontal, 0.25D, alcanceHorizontal));

        for (LivingEntity victima : victimas) {
            if (victima != player && victima != targetMob && !player.isAlliedTo(victima)) {
                if (!(victima instanceof ArmorStand && ((ArmorStand) victima).isMarker())) {
                    victima.knockback(0.4F, Mth.sin(player.getYRot() * ((float) Math.PI / 180F)), -Mth.cos(player.getYRot() * ((float) Math.PI / 180F)));
                    victima.hurt(level.damageSources().playerAttack(player), dañoFinalBarrido);
                }
            }
        }

        double d0 = -Mth.sin(player.getYRot() * ((float)Math.PI / 180F));
        double d1 = Mth.cos(player.getYRot() * ((float)Math.PI / 180F));
        level.sendParticles(ParticleTypes.SWEEP_ATTACK, player.getX() + d0, player.getY(0.5D), player.getZ() + d1, 1, 0.0D, 0.0D, 0.0D, 0.0D);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP, player.getSoundSource(), 1.0F, 1.0F);
    }


    private static ItemAttributeModifiers createSickleAttributes(float baseDamage, float attackSpeed, double bonusRange, double bonusRangeAlt) {
        ItemAttributeModifiers.Builder modifiers = ItemAttributeModifiers.builder();

        modifiers.add(Attributes.ATTACK_DAMAGE, new AttributeModifier(
                Identifier.fromNamespaceAndPath("loquatmadness", "sickle_attack_damage"),
                baseDamage,
                AttributeModifier.Operation.ADD_VALUE
        ), EquipmentSlotGroup.MAINHAND);

        modifiers.add(Attributes.ATTACK_SPEED, new AttributeModifier(
                Identifier.fromNamespaceAndPath("loquatmadness", "sickle_attack_speed"),
                attackSpeed,
                AttributeModifier.Operation.ADD_VALUE
        ), EquipmentSlotGroup.MAINHAND);

        modifiers.add(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(
                Identifier.fromNamespaceAndPath("loquatmadness", "sickle_attack_range_bonus"),
                bonusRange,
                AttributeModifier.Operation.ADD_VALUE
        ), EquipmentSlotGroup.MAINHAND);

        modifiers.add(Attributes.SWEEPING_DAMAGE_RATIO, new AttributeModifier(
                Identifier.fromNamespaceAndPath("loquatmadness", "sickle_attack_ratio"),
                bonusRangeAlt,
                AttributeModifier.Operation.ADD_VALUE
        ), EquipmentSlotGroup.MAINHAND);

        return modifiers.build();
    }
}