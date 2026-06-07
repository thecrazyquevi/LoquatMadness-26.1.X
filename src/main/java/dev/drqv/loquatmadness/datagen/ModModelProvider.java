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
        itemModels.generateFlatItem(LoquatMadness_Items.LOQUATNITE_FRAGMENT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.RODQUAT.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        /* bloques */
        // blockModels.createTrivialCube(LoquatMadness_Blocks.LOQUAT_PLANKS.get()); está oculto porque ya está en las familias
        blockModels.woodProvider(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get()).log(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get()).wood(LoquatMadness_Blocks.STRIPPED_LOQUAT_WOOD.get());;
        blockModels.woodProvider(LoquatMadness_Blocks.LOQUAT_LOG.get()).log(LoquatMadness_Blocks.LOQUAT_LOG.get()).wood(LoquatMadness_Blocks.LOQUAT_WOOD.get());;


        /* familias */
        blockModels.family(LoquatMadness_Blocks.LOQUAT_PLANKS.get())
                .stairs(LoquatMadness_Blocks.LOQUAT_STAIRS.get())
                .slab(LoquatMadness_Blocks.LOQUAT_SLAB.get())
                .pressurePlate(LoquatMadness_Blocks.LOQUAT_PRESSURE_PLATE.get())
                .button(LoquatMadness_Blocks.LOQUAT_BUTTON.get())
                .fence(LoquatMadness_Blocks.LOQUAT_FENCE.get())
                .fenceGate(LoquatMadness_Blocks.LOQUAT_FENCE_GATE.get())
                .door(LoquatMadness_Blocks.LOQUAT_DOOR.get())
                .trapdoor(LoquatMadness_Blocks.LOQUAT_TRAPDOOR.get());

    }
}
