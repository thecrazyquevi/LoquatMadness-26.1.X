package dev.drqv.loquatmadness.item;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.food.ModFoods;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class LoquatMadness_Items {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LoquatMadness.MOD_ID);

    public static final DeferredItem<Item> LOQUAT = ITEMS.registerItem("loquat",
            properties -> new Item(properties.food(ModFoods.LOQUAT, ModFoods.LOQUAT_CONSUMABLE)));

    public static final DeferredItem<Item> BURNING_LOQUAT = ITEMS.registerItem("burning_loquat",
            properties -> new Item(properties.food(ModFoods.PLUS_LOQUAT, ModFoods.BURNING_LOQUAT_CONSUMABLE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
