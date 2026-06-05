package dev.drqv.loquatmadness.item;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.food.ModFoods;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;

public class LoquatMadness_Items {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LoquatMadness.MOD_ID);

    public static final DeferredItem<Item> LOQUAT_SKIN = ITEMS.registerItem("loquat_skin",
            Item::new);

    public static final DeferredItem<Item> LOQUAT = ITEMS.registerItem("loquat",
            properties -> new Item(properties.food(ModFoods.LOQUAT, ModFoods.LOQUAT_CONSUMABLE)
                    .usingConvertsTo(LOQUAT_SKIN.get())));

    public static final DeferredItem<Item> BURNING_LOQUAT = ITEMS.registerItem("burning_loquat",
            properties -> new Item(properties.food(ModFoods.PLUS_LOQUAT, ModFoods.BURNING_LOQUAT_CONSUMABLE)) {
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
