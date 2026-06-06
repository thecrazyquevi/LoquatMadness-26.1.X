package dev.drqv.loquatmadness.block;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class LoquatMadness_Blocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(LoquatMadness.MOD_ID);

    public static final DeferredBlock<Block> LOQUAT_PLANKS = registerBlock("loquat_planks",
            properties -> new Block(properties.strength(2f, 3f)
                    .sound(SoundType.CHERRY_WOOD).ignitedByLava()));

    public static final DeferredBlock<Block> STRIPPED_LOQUAT_LOG = registerBlock("stripped_loquat_log",
            properties -> new RotatedPillarBlock(properties.strength(2f)
                    .sound(SoundType.CHERRY_WOOD).ignitedByLava()));

    public static final DeferredBlock<Block> LOQUAT_LOG = registerBlock("loquat_log",
            properties -> new RotatedPillarBlock(properties.strength(2f)
                    .sound(SoundType.CHERRY_WOOD).ignitedByLava()));

    public static final DeferredBlock<Block> STRIPPED_LOQUAT_WOOD = registerBlock("stripped_loquat_wood",
            properties -> new RotatedPillarBlock(properties.strength(2f)
                    .sound(SoundType.CHERRY_WOOD).ignitedByLava()));

    public static final DeferredBlock<Block> LOQUAT_WOOD = registerBlock("loquat_wood",
            properties -> new RotatedPillarBlock(properties.strength(2f)
                    .sound(SoundType.CHERRY_WOOD).ignitedByLava()));

    public static final DeferredBlock<Block> LOQUAT_STAIRS = registerBlock("loquat_stairs",
            properties -> new StairBlock(LoquatMadness_Blocks.LOQUAT_PLANKS.get().defaultBlockState(),
                    properties.strength(2f).sound(SoundType.CHERRY_WOOD).ignitedByLava()));

    public static final DeferredBlock<Block> LOQUAT_SLAB = registerBlock("loquat_slab",
            properties -> new SlabBlock(properties.strength(2f, 3f).sound(SoundType.CHERRY_WOOD).ignitedByLava()));

    public static final DeferredBlock<Block> LOQUAT_PRESSURE_PLATE = registerBlock("loquat_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.CHERRY, properties
                    .forceSolidOn().instrument(NoteBlockInstrument.BASS)
                    .noCollision().strength(0.5f)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> LOQUAT_BUTTON = registerBlock("loquat_button",
            properties -> new ButtonBlock(BlockSetType.CHERRY, 30, properties
                    .noCollision().strength(0.5f)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> LOQUAT_FENCE = registerBlock("loquat_fence",
            properties -> new FenceBlock(properties.strength(2f)
                    .ignitedByLava().sound(SoundType.CHERRY_WOOD)));

    public static final DeferredBlock<Block> LOQUAT_FENCE_GATE = registerBlock("loquat_fence_gate",
            properties -> new FenceGateBlock(WoodType.CHERRY, properties.strength(2f)
                    .ignitedByLava().sound(SoundType.CHERRY_WOOD)));


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
