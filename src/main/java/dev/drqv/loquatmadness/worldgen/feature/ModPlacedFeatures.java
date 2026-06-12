package dev.drqv.loquatmadness.worldgen.feature;

import dev.drqv.loquatmadness.LoquatMadness;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registries.PLACED_FEATURE, LoquatMadness.MOD_ID);

    public static final ResourceKey<PlacedFeature> LOQUAT_TREE_1_PLACED = ResourceKey.create(
            Registries.PLACED_FEATURE,
            Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "loquat_tree_1")
    );

    public static final ResourceKey<PlacedFeature> LOQUAT_TREE_2_PLACED = ResourceKey.create(
            Registries.PLACED_FEATURE,
            Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "loquat_tree_2")
    );

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}