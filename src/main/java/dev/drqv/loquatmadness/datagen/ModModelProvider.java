package dev.drqv.loquatmadness.datagen;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, LoquatMadness.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(LoquatMadness_Items.LOQUAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.LOQUAT_SKIN.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.BURNING_LOQUAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.RODQUAT.get(), ModelTemplates.FLAT_ITEM);


    }
}
