package dev.drqv.loquatmadness.item;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import dev.drqv.loquatmadness.entity.ModEntities;
import dev.drqv.loquatmadness.food.ModFoods;
import dev.drqv.loquatmadness.item.custom.ModLoquatniteHoeItem;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;

import static dev.drqv.loquatmadness.item.ModToolMaterial.LOQUATNITE_MATERIAL;

public class LoquatMadness_Items {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LoquatMadness.MOD_ID);

    public static final DeferredItem<Item> LOQUAT_SKIN = ITEMS.registerItem("loquat_skin",
            Item::new);

    public static final DeferredItem<Item> LOQUAT = ITEMS.registerItem("loquat",
            properties -> new Item(properties.food(ModFoods.LOQUAT, ModFoods.LOQUAT_CONSUMABLE)
                    .usingConvertsTo(LOQUAT_SKIN.get())));

    public static final DeferredItem<Item> BURNING_LOQUAT = ITEMS.registerItem("burning_loquat",
            properties -> new Item(properties.food(ModFoods.PLUS_LOQUAT, ModFoods.BURNING_LOQUAT_CONSUMABLE).fireResistant()) {
                @Override
                public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    if(Minecraft.getInstance().hasAltDown()) {
                        builder.accept(Component.translatable("tooltip.loquatmadness.burning_loquat.shift_down"));
                    } else {
                        builder.accept(Component.translatable("tooltip.loquatmadness.burning_loquat"));
                    }

                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> CANDY_LOQUAT = ITEMS.registerItem("candy_loquat",
            properties -> new Item(properties.food(ModFoods.PLUS_LOQUAT, ModFoods.CANDY_LOQUAT_CONSUMABLE)) {
                @Override
                public void appendHoverText(ItemStack itemStack, Item.TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    if(Minecraft.getInstance().hasAltDown()) {
                        builder.accept(Component.translatable("tooltip.loquatmadness.candy_loquat.shift_down"));
                    } else {
                        builder.accept(Component.translatable("tooltip.loquatmadness.candy_loquat"));
                    }

                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> RODQUAT = ITEMS.registerSimpleItem("rodquat");
    public static final DeferredItem<Item> LOQUATNITE_FRAGMENT = ITEMS.registerSimpleItem("loquatnite_fragment");
    public static final DeferredItem<Item> LOQUATNITE = ITEMS.registerSimpleItem("loquatnite");

    public static final DeferredItem<HoeItem> LOQUATNITE_HOE = ITEMS.registerItem("loquatnite_hoe",
            properties -> new ModLoquatniteHoeItem(ModToolMaterial.LOQUATNITE_MATERIAL, properties) {
                @Override
                public void appendHoverText(ItemStack itemStack, Item.TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    if(Minecraft.getInstance().hasAltDown()) {
                        builder.accept(Component.translatable("tooltip.loquatmadness.loquatnite_how.shift_down"));
                    } else {
                        builder.accept(Component.translatable("tooltip.loquatmadness.loquatnite_hoe"));
                    }

                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> LOQUAT_SIGN = ITEMS.registerItem("loquat_sign",
            properties -> new SignItem(
                    LoquatMadness_Blocks.LOQUAT_SIGN.get(),
                    LoquatMadness_Blocks.LOQUAT_WALL_SIGN.get(),
                    properties.stacksTo(16))
    );

    public static final DeferredItem<Item> LOQUAT_HANGING_SIGN = ITEMS.registerItem("loquat_hanging_sign",
            properties -> new HangingSignItem(
                    LoquatMadness_Blocks.LOQUAT_HANGING_SIGN.get(),
                    LoquatMadness_Blocks.LOQUAT_WALL_HANGING_SIGN.get(),
                    properties.stacksTo(16))
    );

    public static final DeferredItem<Item> LOQUAT_PROPAGULE = ITEMS.registerItem("loquat_propagule",
            properties -> new BlockItem(LoquatMadness_Blocks.LOQUAT_PROPAGULE.get(), properties)
    );

    public static final DeferredItem<Item> LOQUAT_BOAT = ITEMS.registerItem("loquat_boat",
            properties -> new BoatItem(
                    (EntityType<? extends AbstractBoat>) ModEntities.LOQUAT_BOAT.get(),
                    properties)
    );

    public static final DeferredItem<Item> LOQUAT_CHEST_BOAT = ITEMS.registerItem("loquat_chest_boat",
            properties -> new BoatItem(
                    (EntityType<? extends AbstractBoat>) ModEntities.LOQUAT_CHEST_BOAT.get(),
                    properties)
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
