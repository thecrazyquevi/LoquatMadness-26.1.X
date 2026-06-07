package dev.drqv.loquatmadness.event;

import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.brewing.BrewingRecipe;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

// 3. Make sure "your_mod_id" perfectly matches the ID in your neoforge.mods.toml
@EventBusSubscriber
public class ModEvents {

    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        // Usamos una receta personalizada limpia que maneja ítems puros sin buscar pociones
        builder.addRecipe(new BrewingRecipe(
                Ingredient.of(LoquatMadness_Items.LOQUAT.get()),
                Ingredient.of(Items.AMETHYST_SHARD),
                new ItemStack(LoquatMadness_Items.LOQUATNITE_FRAGMENT.get())
        ));
    }
}