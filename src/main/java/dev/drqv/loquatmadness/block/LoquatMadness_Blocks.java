package dev.drqv.loquatmadness.block;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class LoquatMadness_Blocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(LoquatMadness.MOD_ID);


    public static final DeferredBlock<Block> LOQUAT_PLANKS = registerBlock("loquat_planks",
            properties -> new Block(properties.strength(2f)
                    .sound(SoundType.CHERRY_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_LOQUAT_LOG = registerBlock("stripped_loquat_log",
            properties -> new RotatedPillarBlock(properties.strength(2f)
                    .sound(SoundType.CHERRY_WOOD)));

    public static final DeferredBlock<Block> LOQUAT_LOG = registerBlock("loquat_log",
            properties -> new RotatedPillarBlock(properties.strength(2f)
                    .sound(SoundType.CHERRY_WOOD)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        LoquatMadness_Items.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
