package dev.drqv.loquatmadness.datagen;

import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

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


    }
}
