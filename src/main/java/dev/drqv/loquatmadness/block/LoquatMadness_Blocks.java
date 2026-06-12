package dev.drqv.loquatmadness.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.block.custom.*;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

    public static final WoodType LOQUAT_WOOD_TYPE = WoodType.register(
            new WoodType("loquatmadness:loquat", BlockSetType.CHERRY)
    );

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

    public static final DeferredBlock<Block> LOQUAT_DOOR = registerBlock("loquat_door",
            properties -> new DoorBlock(BlockSetType.CHERRY, properties.strength(2f)
                    .ignitedByLava().sound(SoundType.CHERRY_WOOD).noOcclusion()));

    public static final DeferredBlock<Block> LOQUAT_TRAPDOOR = registerBlock("loquat_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.CHERRY, properties.strength(2f)
                    .ignitedByLava().sound(SoundType.CHERRY_WOOD).noOcclusion()));

    public static final DeferredBlock<Block> LOQUAT_SHELF = registerBlock("loquat_shelf",
            properties -> new ModShelfBlock(properties.strength(1.5f)
                    .ignitedByLava().sound(SoundType.SHELF).noOcclusion()));

    public static final DeferredBlock<StandingSignBlock> LOQUAT_SIGN = BLOCKS.registerBlock("loquat_sign",
            properties -> new ModStandingSignBlock(LOQUAT_WOOD_TYPE, properties
                    .noCollision().strength(1f).ignitedByLava().sound(SoundType.CHERRY_WOOD)));

    public static final DeferredBlock<WallSignBlock> LOQUAT_WALL_SIGN = BLOCKS.registerBlock("loquat_wall_sign",
            properties -> new ModWallSignBlock(LOQUAT_WOOD_TYPE, properties
                    .noCollision().strength(1f).ignitedByLava().sound(SoundType.CHERRY_WOOD)));

    public static final DeferredBlock<CeilingHangingSignBlock> LOQUAT_HANGING_SIGN = BLOCKS.registerBlock("loquat_hanging_sign",
            properties -> new ModCeilingHangingSignBlock(LOQUAT_WOOD_TYPE, properties
                    .noCollision().strength(1f).ignitedByLava().sound(SoundType.CHERRY_WOOD)));

    public static final DeferredBlock<WallHangingSignBlock> LOQUAT_WALL_HANGING_SIGN = BLOCKS.registerBlock("loquat_wall_hanging_sign",
            properties -> new ModWallHangingSignBlock(LOQUAT_WOOD_TYPE, properties
                    .noCollision().strength(1f).ignitedByLava().sound(SoundType.CHERRY_WOOD)));

    public static final DeferredBlock<Block> LOQUAT_LEAVES = registerBlock("loquat_leaves",
            properties -> new ModLeavesBlock(properties
                    .strength(0.2f)
                    .randomTicks()
                    .sound(SoundType.GRASS)
                    .noOcclusion()
                    .isValidSpawn(LoquatMadness_Blocks::ocelotOrParrot)
                    .isSuffocating((state, lavel, pos) -> false)
                    .isViewBlocking((state, lavel, pos) -> false)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
                    .isRedstoneConductor(((state, level, pos) -> false))
            ));

    public static final DeferredBlock<Block> LOQUAT_FRUIT_LEAVES = registerBlock("loquat_fruit_leaves",
            properties -> new ModFruitLeavesBlock(properties
                    .strength(0.2f)
                    .randomTicks()
                    .sound(SoundType.GRASS)
                    .noOcclusion()
                    .isValidSpawn(LoquatMadness_Blocks::ocelotOrParrot)
                    .isSuffocating((state, lavel, pos) -> false)
                    .isViewBlocking((state, lavel, pos) -> false)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
                    .isRedstoneConductor(((state, level, pos) -> false))
            ));

    public static final DeferredBlock<Block> LOQUAT_PROPAGULE = BLOCKS.registerBlock("loquat_propagule",
            properties -> new ModSaplingBlock(properties
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)
                    .ignitedByLava()));

    public static final DeferredBlock<Block> POTTED_LOQUAT_PROPAGULE = BLOCKS.registerBlock("potted_loquat_propagule",
            properties -> new FlowerPotBlock(
                    () -> (FlowerPotBlock) Blocks.FLOWER_POT,
                    LoquatMadness_Blocks.LOQUAT_PROPAGULE,
                    properties.instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)
            ));

    private static Boolean ocelotOrParrot(BlockState state, BlockGetter level, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }

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
