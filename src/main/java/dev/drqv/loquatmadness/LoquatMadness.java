package dev.drqv.loquatmadness;

import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import dev.drqv.loquatmadness.block.entity.ModBlockEntities;
import dev.drqv.loquatmadness.client.LoquatniteArrowDispenseBehavior;
import dev.drqv.loquatmadness.creativemodetab.ModCreativeModeTabs;
import dev.drqv.loquatmadness.entity.ModEntities;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import dev.drqv.loquatmadness.registry.ModEntityTypes;
import dev.drqv.loquatmadness.worldgen.feature.ModConfiguredFeatures;
import dev.drqv.loquatmadness.worldgen.feature.ModPlacedFeatures;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;


@Mod(LoquatMadness.MOD_ID)
public class LoquatMadness {

    public static final String MOD_ID = "loquatmadness";

    public static final Logger LOGGER = LogUtils.getLogger();

    public LoquatMadness(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);

        ModCreativeModeTabs.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);
        ModEntities.register(modEventBus);
        ModEntityTypes.register(modEventBus);

        LoquatMadness_Items.register(modEventBus);
        LoquatMadness_Blocks.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(
                    LoquatMadness_Items.LOQUAT_PROPAGULE.getId(),
                    LoquatMadness_Blocks.POTTED_LOQUAT_PROPAGULE
            );
        });

        event.enqueueWork(() -> {
            DispenserBlock.registerBehavior(
                    LoquatMadness_Items.LOQUATNITE_ARROW.get(),
                    new LoquatniteArrowDispenseBehavior()
            );
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(LoquatMadness_Items.LOQUAT);
            event.accept(LoquatMadness_Items.CANDY_LOQUAT);
            event.accept(LoquatMadness_Items.BURNING_LOQUAT);
            event.accept(LoquatMadness_Items.CONCENTRATED_LOQUATNITE);
            event.accept(LoquatMadness_Items.GLAZED_CONCENTRATED_LOQUATNITE_SANDWICH);
            event.accept(LoquatMadness_Items.CONCENTRATED_LOQUATNITE_CHOCOLATE_MIX);
            event.accept(LoquatMadness_Items.LOQUATNITIAN_AMALGAMATION);
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(LoquatMadness_Items.LOQUAT_SKIN);
            event.accept(LoquatMadness_Items.LOQUAT_GROUP);
            event.accept(LoquatMadness_Items.RODQUAT);
            event.accept(LoquatMadness_Items.LOQUATNITE_FRAGMENT);
            event.accept(LoquatMadness_Items.LOQUATNITE);
            event.accept(LoquatMadness_Items.LOQUATNITE_CORE);
        }

        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(LoquatMadness_Items.LOQUAT_SIGN);
            event.accept(LoquatMadness_Items.LOQUAT_HANGING_SIGN);
            event.accept(LoquatMadness_Blocks.LOQUAT_SHELF);
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept((ItemLike) LoquatMadness_Items.LOQUATNITE_HOE);
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(LoquatMadness_Blocks.LOQUAT_LOG);
            event.accept(LoquatMadness_Blocks.LOQUAT_WOOD);
            event.accept(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG);
            event.accept(LoquatMadness_Blocks.STRIPPED_LOQUAT_WOOD);
            event.accept(LoquatMadness_Blocks.LOQUAT_PLANKS);
            event.accept(LoquatMadness_Blocks.LOQUAT_STAIRS);
            event.accept(LoquatMadness_Blocks.LOQUAT_SLAB);
            event.accept(LoquatMadness_Blocks.LOQUAT_FENCE);
            event.accept(LoquatMadness_Blocks.LOQUAT_FENCE_GATE);
            event.accept(LoquatMadness_Blocks.LOQUAT_DOOR);
            event.accept(LoquatMadness_Blocks.LOQUAT_TRAPDOOR);
            event.accept(LoquatMadness_Blocks.LOQUAT_PRESSURE_PLATE);
            event.accept(LoquatMadness_Blocks.LOQUAT_BUTTON);
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(LoquatMadness_Blocks.LOQUAT_LEAVES);
            event.accept(LoquatMadness_Blocks.LOQUAT_FRUIT_LEAVES);
            event.accept(LoquatMadness_Blocks.LOQUAT_PROPAGULE);
        }

        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(LoquatMadness_Items.LOQUAT_BOAT);
            event.accept(LoquatMadness_Items.LOQUAT_CHEST_BOAT);
            event.accept(LoquatMadness_Items.LOQUATNITE_ARROW);
            event.accept(LoquatMadness_Items.LOQUATNITE_SICKLE);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

}
