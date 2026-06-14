package dev.drqv.loquatmadness.registry;

import dev.drqv.loquatmadness.LoquatMadness; // ajusta si tu clase principal tiene otro nombre
import dev.drqv.loquatmadness.entity.LoquatniteArrowEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntityTypes {

    public static final DeferredRegister.Entities ENTITY_TYPES =
            DeferredRegister.createEntities(LoquatMadness.MOD_ID);

    public static final Supplier<EntityType<LoquatniteArrowEntity>> LOQUATNITE_ARROW =
            ENTITY_TYPES.registerEntityType(
                    "loquatnite_arrow",
                    LoquatniteArrowEntity::new,
                    MobCategory.MISC,
                    builder -> builder
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
            );


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}