package dev.drqv.loquatmadness.creativemodetab;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LoquatMadness.MOD_ID);

    public static final Supplier<CreativeModeTab> LOQUAT_MADNESS_TAB = CREATIVE_MODE_TABS.register("loquat_madness_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(LoquatMadness_Items.LOQUAT.get()))
                    .title(Component.translatable("creativetab.loquatmadness.loquat_madness_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(LoquatMadness_Items.LOQUAT);
                        output.accept(LoquatMadness_Items.BURNING_LOQUAT);
                        output.accept(LoquatMadness_Items.LOQUAT_SKIN);
                        output.accept(LoquatMadness_Items.RODQUAT);

                        output.accept(LoquatMadness_Blocks.LOQUAT_LOG);
                        output.accept(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG);
                        output.accept(LoquatMadness_Blocks.LOQUAT_PLANKS);



                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
