package dev.drqv.loquatmadness.item;

import dev.drqv.loquatmadness.LoquatMadness;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class LoquatMadness_Items {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LoquatMadness.MOD_ID);

    public static final DeferredItem<Item> LOQUAT = ITEMS.registerSimpleItem("loquat");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
