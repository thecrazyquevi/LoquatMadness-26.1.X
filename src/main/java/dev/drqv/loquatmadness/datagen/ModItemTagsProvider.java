package dev.drqv.loquatmadness.datagen;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import dev.drqv.loquatmadness.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, LoquatMadness.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(ItemTags.PLANKS)
                .add(LoquatMadness_Blocks.LOQUAT_PLANKS.get().asItem());

        tag(ItemTags.LOGS)
                .add(LoquatMadness_Blocks.LOQUAT_LOG.get().asItem())
                .add(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get().asItem())
                .add(LoquatMadness_Blocks.STRIPPED_LOQUAT_WOOD.get().asItem())
                .add(LoquatMadness_Blocks.LOQUAT_WOOD.get().asItem());

        tag(ItemTags.ARROWS)
                .add(LoquatMadness_Items.LOQUATNITE_ARROW.get().asItem());

        tag(ItemTags.WOODEN_SLABS)
                .add(LoquatMadness_Blocks.LOQUAT_SLAB.get().asItem());

        tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(LoquatMadness_Blocks.LOQUAT_PRESSURE_PLATE.get().asItem());

        tag(ItemTags.WOODEN_STAIRS)
                .add(LoquatMadness_Blocks.LOQUAT_STAIRS.get().asItem());

        tag(ItemTags.WOODEN_BUTTONS)
                .add(LoquatMadness_Blocks.LOQUAT_BUTTON.get().asItem());

        tag(ItemTags.WOODEN_FENCES)
                .add(LoquatMadness_Blocks.LOQUAT_FENCE.get().asItem());

        tag(ItemTags.FENCE_GATES)
                .add(LoquatMadness_Blocks.LOQUAT_FENCE_GATE.get().asItem());

        tag(ItemTags.WOODEN_DOORS)
                .add(LoquatMadness_Blocks.LOQUAT_DOOR.get().asItem());

        tag(ItemTags.WOODEN_TRAPDOORS)
                .add(LoquatMadness_Blocks.LOQUAT_TRAPDOOR.get().asItem());

        tag(ItemTags.HOES)
                .add(LoquatMadness_Items.LOQUATNITE_HOE.get().asItem());

        tag(ItemTags.SIGNS)
                .add(LoquatMadness_Items.LOQUAT_SIGN.get().asItem());

        tag(ItemTags.WOODEN_SHELVES)
                .add(LoquatMadness_Blocks.LOQUAT_SHELF.get().asItem());

        tag(ItemTags.HANGING_SIGNS)
                .add(LoquatMadness_Items.LOQUAT_HANGING_SIGN.get().asItem());

        tag(Tags.Items.FOODS_FRUIT)
                .add(LoquatMadness_Items.LOQUAT.get().asItem());

        tag(Tags.Items.FOODS)
                .add(LoquatMadness_Items.LOQUAT.get().asItem())
                .add(LoquatMadness_Items.CANDY_LOQUAT.get().asItem())
                .add(LoquatMadness_Items.BURNING_LOQUAT.get().asItem())
                .add(LoquatMadness_Items.CONCENTRATED_LOQUATNITE.get().asItem())
                .add(LoquatMadness_Items.GLAZED_CONCENTRATED_LOQUATNITE_SANDWICH.get().asItem())
                .add(LoquatMadness_Items.CONCENTRATED_LOQUATNITE_CHOCOLATE_MIX.get().asItem())
                .add(LoquatMadness_Items.LOQUATNITIAN_AMALGAMATION.get().asItem());

        tag(ItemTags.SWORDS)
                .add(LoquatMadness_Items.LOQUATNITE_SICKLE.get().asItem());

        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(LoquatMadness_Items.LOQUATNITE_SICKLE.get().asItem());

        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(LoquatMadness_Items.LOQUATNITE_SICKLE.get().asItem());

        tag(ItemTags.SWEEPING_ENCHANTABLE)
                .add(LoquatMadness_Items.LOQUATNITE_SICKLE.get().asItem());

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .remove(LoquatMadness_Items.LOQUATNITE_SICKLE.get().asItem());


        tag(Tags.Items.INGOTS)
                .add(LoquatMadness_Items.LOQUATNITE.get().asItem());

        tag(ItemTags.LEAVES)
                .add(LoquatMadness_Blocks.LOQUAT_LEAVES.get().asItem())
                .add(LoquatMadness_Blocks.LOQUAT_FRUIT_LEAVES.get().asItem());

        tag(ItemTags.SAPLINGS)
                .add(LoquatMadness_Blocks.LOQUAT_PROPAGULE.get().asItem());

        tag(ItemTags.BOATS)
                .add(LoquatMadness_Items.LOQUAT_BOAT.get().asItem());

        tag(ItemTags.CHEST_BOATS)
                .add(LoquatMadness_Items.LOQUAT_CHEST_BOAT.get().asItem());

        /* TAGS CUSTOM */
        tag(ModTags.Items.LOQUATNITE_BARS)
                .add(LoquatMadness_Items.LOQUATNITE.get());

        tag(ModTags.Items.LOQUATNITE_CORES)
                .add(LoquatMadness_Items.LOQUATNITE_CORE.get());

    }
}
