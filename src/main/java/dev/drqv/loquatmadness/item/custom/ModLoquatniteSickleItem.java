package dev.drqv.loquatmadness.item.custom;

import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;

import java.util.List;

public class ModLoquatniteSickleItem extends Item {

    public ModLoquatniteSickleItem(ToolMaterial material, float baseDamage, float attackSpeed, double bonusRange, Item.Properties properties) {
        super(properties
                .durability(material.durability())
                .component(DataComponents.ATTRIBUTE_MODIFIERS, createSickleAttributes(baseDamage, attackSpeed, bonusRange))
                .component(DataComponents.TOOL, new Tool(List.of(), 1.0F, 1, false))
        );
    }

    @Override
    public void hurtEnemy(ItemStack itemStack, net.minecraft.world.entity.LivingEntity mob, net.minecraft.world.entity.LivingEntity attacker) {
        super.hurtEnemy(itemStack, mob, attacker);

        if (attacker.level() instanceof net.minecraft.server.level.ServerLevel serverLevel) {

            if (attacker instanceof net.minecraft.server.level.ServerPlayer serverPlayer) {
                if (serverPlayer.isCreative()) {
                    return;
                }
            }

            itemStack.hurtAndBreak(1, serverLevel, attacker, (brokenItem) -> {
                attacker.onEquippedItemBroken(brokenItem, net.minecraft.world.entity.EquipmentSlot.MAINHAND);
            });
        }
    }


    /**
     * Builder manual para inyectar Daño, Velocidad y el Rango extendido compatible con 26.1
     */
    private static ItemAttributeModifiers createSickleAttributes(float baseDamage, float attackSpeed, double bonusRange) {
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

        return modifiers.build();
    }
}