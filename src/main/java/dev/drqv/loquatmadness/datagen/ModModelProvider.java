package dev.drqv.loquatmadness.datagen;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, LoquatMadness.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        /* items */
        itemModels.generateFlatItem(LoquatMadness_Items.LOQUAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.LOQUAT_SKIN.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.CANDY_LOQUAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.BURNING_LOQUAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.RODQUAT.get(), ModelTemplates.FLAT_ITEM);

        /* bloques */
        blockModels.createTrivialCube(LoquatMadness_Blocks.LOQUAT_PLANKS.get());
        blockModels.woodProvider(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get()).log(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get());
        blockModels.woodProvider(LoquatMadness_Blocks.LOQUAT_LOG.get()).log(LoquatMadness_Blocks.LOQUAT_LOG.get());

    }
}
