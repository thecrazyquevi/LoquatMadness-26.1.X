package dev.drqv.loquatmadness.datagen;

import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.crafting.SmokingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.brewing.BrewingRecipe;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {


        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "Loquat Madness Recipes";
        }
    }

    @Override
    protected void buildRecipes() {

        shaped(RecipeCategory.MISC, LoquatMadness_Items.RODQUAT.get(), 1)
                .pattern("AB")
                .pattern("BA")
                .define('A', LoquatMadness_Items.LOQUAT_SKIN.get())
                .define('B', Items.STICK)
                .group("loquat")
                .unlockedBy("has_loquat_skin", has(LoquatMadness_Items.LOQUAT_SKIN.get()))
                .save(output);

        shapeless(RecipeCategory.BUILDING_BLOCKS, LoquatMadness_Blocks.LOQUAT_PLANKS.get(), 4)
                .requires(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get(), 1)
                .unlockedBy(getHasName(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get()), has(LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get()))
                .group("loquat")
                .save(output, "loquatmadness:loquat_planks_from_stripped_loquat_log");

        shapeless(RecipeCategory.BUILDING_BLOCKS, LoquatMadness_Blocks.LOQUAT_PLANKS.get(), 4)
                .requires(LoquatMadness_Blocks.LOQUAT_LOG.get(), 1)
                .unlockedBy(getHasName(LoquatMadness_Blocks.LOQUAT_LOG.get()), has(LoquatMadness_Blocks.LOQUAT_LOG.get()))
                .group("loquat")
                .save(output);

        stairBuilder(LoquatMadness_Blocks.LOQUAT_STAIRS.get(), Ingredient.of(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .unlockedBy("has_loquat_planks", has(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .group("loquat")
                .save(output);

        slab(RecipeCategory.BUILDING_BLOCKS, LoquatMadness_Blocks.LOQUAT_SLAB.get(), LoquatMadness_Blocks.LOQUAT_PLANKS.get());

        buttonBuilder(LoquatMadness_Blocks.LOQUAT_BUTTON.get(), Ingredient.of(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .unlockedBy("has_loquat_planks", has(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .group("loquat")
                .save(output);

        pressurePlate(LoquatMadness_Blocks.LOQUAT_PRESSURE_PLATE.get(), LoquatMadness_Blocks.LOQUAT_PLANKS.get());

        fenceBuilder(LoquatMadness_Blocks.LOQUAT_FENCE.get(), Ingredient.of(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .unlockedBy("has_loquat_planks", has(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .group("loquat")
                .save(output);

        fenceGateBuilder(LoquatMadness_Blocks.LOQUAT_FENCE_GATE.get(), Ingredient.of(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .unlockedBy("has_loquat_planks", has(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .group("loquat")
                .save(output);

        woodFromLogs(LoquatMadness_Blocks.LOQUAT_WOOD.get(), LoquatMadness_Blocks.LOQUAT_LOG.get());
        woodFromLogs(LoquatMadness_Blocks.STRIPPED_LOQUAT_WOOD.get(), LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get());

        shapeless(RecipeCategory.BUILDING_BLOCKS, LoquatMadness_Blocks.LOQUAT_PLANKS.get(), 4)
                .requires(LoquatMadness_Blocks.STRIPPED_LOQUAT_WOOD.get(), 1)
                .unlockedBy("has_loquat_wood", has(LoquatMadness_Blocks.STRIPPED_LOQUAT_WOOD.get()))
                .group("loquat")
                .save(output, "loquatmadness:loquat_planks_from_stripped_loquat_wood");

        shapeless(RecipeCategory.BUILDING_BLOCKS, LoquatMadness_Blocks.LOQUAT_PLANKS.get(), 4)
                .requires(LoquatMadness_Blocks.LOQUAT_WOOD.get(), 1)
                .unlockedBy("has_loquat_wood", has(LoquatMadness_Blocks.LOQUAT_WOOD.get()))
                .group("loquat")
                .save(output, "loquatmadness:loquat_planks_from_loquat_wood");

        doorBuilder(LoquatMadness_Blocks.LOQUAT_DOOR.get(), Ingredient.of(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .unlockedBy("has_loquat_planks", has(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .group("loquat")
                .save(output);

        trapdoorBuilder(LoquatMadness_Blocks.LOQUAT_TRAPDOOR.get(), Ingredient.of(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .unlockedBy("has_loquat_planks", has(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .group("loquat")
                .save(output);

        simpleCookingRecipe("loquat_skin", SmeltingRecipe::new, 200, LoquatMadness_Items.LOQUAT.get(), LoquatMadness_Items.LOQUAT_SKIN.get(), 0.2f);


    }
}
