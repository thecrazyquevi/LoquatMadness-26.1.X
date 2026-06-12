package dev.drqv.loquatmadness.block.entity;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, LoquatMadness.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModSignBlockEntity>> LOQUAT_SIGN =
            BLOCK_ENTITIES.register("loquat_sign", () ->
                    new BlockEntityType<>(
                            ModSignBlockEntity::new,
                            false,
                            LoquatMadness_Blocks.LOQUAT_SIGN.get(),
                            LoquatMadness_Blocks.LOQUAT_WALL_SIGN.get()
                    )
            );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModHangingSignBlockEntity>> LOQUAT_HANGING_SIGN =
            BLOCK_ENTITIES.register("loquat_hanging_sign", () ->
                    new BlockEntityType<>(
                            ModHangingSignBlockEntity::new,
                            false,
                            LoquatMadness_Blocks.LOQUAT_HANGING_SIGN.get(),
                            LoquatMadness_Blocks.LOQUAT_WALL_HANGING_SIGN.get()
                    )
            );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModShelfBlockEntity>> LOQUAT_SHELF =
            BLOCK_ENTITIES.register("loquat_shelf", () ->
                    new BlockEntityType<>(
                            ModShelfBlockEntity::new,
                            false,
                            LoquatMadness_Blocks.LOQUAT_SHELF.get()
                    )
            );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}