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

        shelf(LoquatMadness_Blocks.LOQUAT_SHELF.get(), LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG.get());

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

        shapeless(RecipeCategory.FOOD, LoquatMadness_Items.CANDY_LOQUAT.get(), 3)
                .requires(LoquatMadness_Items.LOQUAT.get(), 3)
                .requires(Items.SUGAR, 1)
                .unlockedBy("has_loquat", has(LoquatMadness_Items.LOQUAT.get()))
                .group("loquat")
                .save(output);

        shapeless(RecipeCategory.FOOD, LoquatMadness_Items.BURNING_LOQUAT.get(), 3)
                .requires(LoquatMadness_Items.LOQUAT.get(), 3)
                .requires(Items.MAGMA_CREAM, 1)
                .unlockedBy("has_loquat", has(LoquatMadness_Items.LOQUAT.get()))
                .group("loquat")
                .save(output);

        doorBuilder(LoquatMadness_Blocks.LOQUAT_DOOR.get(), Ingredient.of(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .unlockedBy("has_loquat_planks", has(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .group("loquat")
                .save(output);

        trapdoorBuilder(LoquatMadness_Blocks.LOQUAT_TRAPDOOR.get(), Ingredient.of(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .unlockedBy("has_loquat_planks", has(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .group("loquat")
                .save(output);

        simpleCookingRecipe("loquat_skin", SmeltingRecipe::new, 200, LoquatMadness_Items.LOQUAT.get(), LoquatMadness_Items.LOQUAT_SKIN.get(), 0.2f);
        simpleCookingRecipe("concentrated_loquatnite", SmeltingRecipe::new, 200, LoquatMadness_Items.LOQUATNITE.get(), LoquatMadness_Items.CONCENTRATED_LOQUATNITE.get(), 0.2f);

        shaped(RecipeCategory.MISC, LoquatMadness_Items.LOQUATNITE.get(), 1)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', LoquatMadness_Items.LOQUATNITE_FRAGMENT.get())
                .group("loquat")
                .unlockedBy("has_loquatnite_fragment", has(LoquatMadness_Items.LOQUATNITE_FRAGMENT.get()))
                .save(output);

        shaped(RecipeCategory.TOOLS, LoquatMadness_Items.LOQUATNITE_HOE.get(), 1)
                .pattern("LL ")
                .pattern(" R ")
                .pattern(" R ")
                .define('L', LoquatMadness_Items.LOQUATNITE.get())
                .define('R', LoquatMadness_Items.RODQUAT.get())
                .group("loquat")
                .unlockedBy("has_loquatnite", has(LoquatMadness_Items.LOQUATNITE.get()))
                .save(output);

        shaped(RecipeCategory.TRANSPORTATION, LoquatMadness_Items.LOQUAT_BOAT.get(), 1)
                .pattern("P P")
                .pattern("PPP")
                .define('P', LoquatMadness_Blocks.LOQUAT_PLANKS.get())
                .unlockedBy("has_loquat_planks", has(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .save(output);

        shaped(RecipeCategory.TRANSPORTATION, LoquatMadness_Items.LOQUAT_CHEST_BOAT.get(), 1)
                .pattern("C")
                .pattern("B")
                .define('C', Items.CHEST)
                .define('B', LoquatMadness_Items.LOQUAT_BOAT.get())
                .unlockedBy("has_loquat_boat", has(LoquatMadness_Items.LOQUAT_BOAT.get()))
                .save(output);

        signBuilder(LoquatMadness_Items.LOQUAT_SIGN.get(), Ingredient.of(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .unlockedBy("has_loquat_planks", has(LoquatMadness_Blocks.LOQUAT_PLANKS.get()))
                .group("loquat")
                .save(output);

        shaped(RecipeCategory.MISC, LoquatMadness_Items.LOQUAT_GROUP.get(), 1)
                .pattern("LL")
                .pattern("LL")
                .define('L', LoquatMadness_Items.LOQUAT.get())
                .unlockedBy("has_loquat", has(LoquatMadness_Items.LOQUAT.get()))
                .save(output);

        shaped(RecipeCategory.COMBAT, LoquatMadness_Items.LOQUATNITE_ARROW.get(), 1)
                .pattern("L")
                .pattern("R")
                .pattern("F")
                .define('L', LoquatMadness_Items.LOQUATNITE_FRAGMENT.get())
                .define('R', LoquatMadness_Items.RODQUAT.get())
                .define('F', Items.FEATHER)
                .unlockedBy("has_loquatnite_fragment", has(LoquatMadness_Items.LOQUATNITE_FRAGMENT.get()))
                .save(output);

        shaped(RecipeCategory.COMBAT, LoquatMadness_Items.LOQUATNITE_SICKLE.get(), 1)
                .pattern("CCL")
                .pattern("CR ")
                .pattern("R  ")
                .define('L', LoquatMadness_Items.LOQUATNITE_CORE.get())
                .define('C', LoquatMadness_Items.CONCENTRATED_LOQUATNITE.get())
                .define('R', LoquatMadness_Items.RODQUAT.get())
                .unlockedBy("has_loquatnite_core", has(LoquatMadness_Items.LOQUATNITE_CORE.get()))
                .save(output);

        shaped(RecipeCategory.MISC, LoquatMadness_Items.LOQUATNITE_CORE.get(), 1)
                .pattern("LLL")
                .pattern("LRL")
                .pattern("LLL")
                .define('L', LoquatMadness_Items.LOQUAT_SKIN.get())
                .define('R', LoquatMadness_Items.LOQUATNITE.get())
                .unlockedBy("has_loquatnite", has(LoquatMadness_Items.LOQUATNITE.get()))
                .save(output);

        shaped(RecipeCategory.MISC, LoquatMadness_Items.LOQUATNITIAN_AMALGAMATION.get(), 1)
                .pattern("PES")
                .pattern("CCC")
                .pattern("FKM")
                .define('C', LoquatMadness_Items.CONCENTRATED_LOQUATNITE.get())
                .define('P', Items.PUFFERFISH)
                .define('E', Items.ENDER_EYE)
                .define('S', Items.GLISTERING_MELON_SLICE)
                .define('F', Items.FERMENTED_SPIDER_EYE)
                .define('K', Items.PUMPKIN_PIE)
                .define('M', Items.MAGMA_CREAM)
                .unlockedBy("has_concentrated_loquatnite", has(LoquatMadness_Items.CONCENTRATED_LOQUATNITE.get()))
                .save(output);

        shapeless(RecipeCategory.MISC, LoquatMadness_Items.LOQUAT.get(), 4)
                .requires(LoquatMadness_Items.LOQUAT_GROUP.get(), 1)
                .unlockedBy("has_loquat_group", has(LoquatMadness_Items.LOQUAT_GROUP.get()))
                .save(output);

        shaped(RecipeCategory.FOOD, LoquatMadness_Items.GLAZED_CONCENTRATED_LOQUATNITE_SANDWICH.get(), 1)
                .pattern(" B ")
                .pattern("ELH")
                .pattern(" B ")
                .define('L', LoquatMadness_Items.CONCENTRATED_LOQUATNITE.get())
                .define('B', Items.BREAD)
                .define('E', Items.EGG)
                .define('H', Items.HONEY_BOTTLE)
                .unlockedBy("has_concentrated_loquatnite", has(LoquatMadness_Items.CONCENTRATED_LOQUATNITE.get()))
                .save(output);

        shaped(RecipeCategory.FOOD, LoquatMadness_Items.CONCENTRATED_LOQUATNITE_CHOCOLATE_MIX.get(), 1)
                .pattern("CLC")
                .define('L', LoquatMadness_Items.CONCENTRATED_LOQUATNITE.get())
                .define('C', Items.COCOA_BEANS)
                .unlockedBy("has_concentrated_loquatnite", has(LoquatMadness_Items.CONCENTRATED_LOQUATNITE.get()))
                .save(output);

        hangingSign(LoquatMadness_Items.LOQUAT_HANGING_SIGN.get(), LoquatMadness_Blocks.STRIPPED_LOQUAT_LOG);



    }
}
