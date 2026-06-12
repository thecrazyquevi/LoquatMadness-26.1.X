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
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, LoquatMadness.MOD_ID);
    }

    public static final BlockFamily LOQUAT_FAMILY = new BlockFamily.Builder(LoquatMadness_Blocks.LOQUAT_PLANKS.get())
            .stairs(LoquatMadness_Blocks.LOQUAT_STAIRS.get())
            .slab(LoquatMadness_Blocks.LOQUAT_SLAB.get())
            .pressurePlate(LoquatMadness_Blocks.LOQUAT_PRESSURE_PLATE.get())
            .button(LoquatMadness_Blocks.LOQUAT_BUTTON.get())
            .fence(LoquatMadness_Blocks.LOQUAT_FENCE.get())
            .fenceGate(LoquatMadness_Blocks.LOQUAT_FENCE_GATE.get())
            .door(LoquatMadness_Blocks.LOQUAT_DOOR.get())
            .sign(LoquatMadness_Blocks.LOQUAT_SIGN.get(), LoquatMadness_Blocks.LOQUAT_WALL_SIGN.get())
            .trapdoor(LoquatMadness_Blocks.LOQUAT_TRAPDOOR.get())
            .getFamily();

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        /* items */
        itemModels.generateFlatItem(LoquatMadness_Items.LOQUAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.LOQUAT_SKIN.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.CANDY_LOQUAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.BURNING_LOQUAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.LOQUATNITE_FRAGMENT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.RODQUAT.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.LOQUATNITE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.LOQUAT_PROPAGULE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.LOQUATNITE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.LOQUAT_BOAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(LoquatMadness_Items.LOQUAT_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(LoquatMadness_Blocks.POTTED_LOQUAT_PROPAGULE.get().asItem(), ModelTemplates.FLAT_ITEM);


        /* bloques */
        // blockModels.createTrivialCube(LoquatMadness_Blocks.LOQUAT_PLANKS.get()); está oculto porque ya está en las familias
        blockModels.woodProvider(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get()).log(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get()).wood(LoquatMadness_Blocks.STRIPPED_LOQUAT_WOOD.get());
        blockModels.woodProvider(LoquatMadness_Blocks.LOQUAT_LOG.get()).log(LoquatMadness_Blocks.LOQUAT_LOG.get()).wood(LoquatMadness_Blocks.LOQUAT_WOOD.get());

        blockModels.family(LoquatMadness_Blocks.LOQUAT_PLANKS.get())
                .generateFor(LOQUAT_FAMILY);

        blockModels.createShelf(LoquatMadness_Blocks.LOQUAT_SHELF.get(), LoquatMadness_Blocks.LOQUAT_PLANKS.get());

        blockModels.createHangingSign(
                LoquatMadness_Blocks.LOQUAT_PLANKS.get(),
                LoquatMadness_Blocks.LOQUAT_HANGING_SIGN.get(),
                LoquatMadness_Blocks.LOQUAT_WALL_HANGING_SIGN.get()
        );

        blockModels.blockStateOutput.accept(
                BlockModelGenerators.createSimpleBlock(
                        LoquatMadness_Blocks.POTTED_LOQUAT_PROPAGULE.get(),
                        BlockModelGenerators.plainVariant(
                                ModelTemplates.FLOWER_POT_CROSS.create(
                                        LoquatMadness_Blocks.POTTED_LOQUAT_PROPAGULE.get(),
                                        TextureMapping.plant(LoquatMadness_Blocks.LOQUAT_PROPAGULE.get()),
                                        blockModels.modelOutput
                                )
                        )
                )
        );

        blockModels.createTrivialCube(LoquatMadness_Blocks.LOQUAT_LEAVES.get());
        blockModels.createTrivialCube(LoquatMadness_Blocks.LOQUAT_FRUIT_LEAVES.get());
        blockModels.createCrossBlock(LoquatMadness_Blocks.LOQUAT_PROPAGULE.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    }
}
