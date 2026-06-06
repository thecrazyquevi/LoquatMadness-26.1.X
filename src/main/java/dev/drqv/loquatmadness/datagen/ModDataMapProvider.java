package dev.drqv.loquatmadness.datagen;

import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FireBlock;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import net.neoforged.neoforge.registries.datamaps.DataMapsUpdatedEvent;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Strippable;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {

    public ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {

        builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(LoquatMadness_Items.LOQUAT_SKIN.getId(), new FurnaceFuel(100), false);

        builder(NeoForgeDataMaps.STRIPPABLES)
                .add(LoquatMadness_Blocks.LOQUAT_LOG.getId(), new Strippable(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get()), false)
                .add(LoquatMadness_Blocks.LOQUAT_WOOD.getId(), new Strippable(LoquatMadness_Blocks.STRIPPED_LOQUAT_WOOD.get()), false);

        builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(LoquatMadness_Items.LOQUAT.getId(), new Compostable(0.65f), true)
                .add(LoquatMadness_Items.LOQUAT_SKIN.getId(), new Compostable(0.3f), true);

    }
}
