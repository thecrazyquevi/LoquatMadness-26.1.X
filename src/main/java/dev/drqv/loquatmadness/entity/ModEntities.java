package dev.drqv.loquatmadness.entity;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, LoquatMadness.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<Boat>> LOQUAT_BOAT =
            ENTITY_TYPES.register("loquat_boat", () ->
                    EntityType.Builder.<Boat>of(
                                    (entityType, level) -> new Boat(entityType, level, () -> LoquatMadness_Items.LOQUAT_BOAT.get()),
                                    MobCategory.MISC)
                            .noLootTable()
                            .sized(1.375f, 0.5625f)
                            .eyeHeight(0.5625f)
                            .clientTrackingRange(10)
                            .build(ResourceKey.create(Registries.ENTITY_TYPE,
                                    Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "loquat_boat")))
            );

    public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> LOQUAT_CHEST_BOAT =
            ENTITY_TYPES.register("loquat_chest_boat", () ->
                    EntityType.Builder.<ChestBoat>of(
                                    (entityType, level) -> new ChestBoat(entityType, level, () -> LoquatMadness_Items.LOQUAT_CHEST_BOAT.get()),
                                    MobCategory.MISC)
                            .noLootTable()
                            .sized(1.375f, 0.5625f)
                            .eyeHeight(0.5625f)
                            .clientTrackingRange(10)
                            .build(ResourceKey.create(Registries.ENTITY_TYPE,
                                    Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "loquat_chest_boat")))
            );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}