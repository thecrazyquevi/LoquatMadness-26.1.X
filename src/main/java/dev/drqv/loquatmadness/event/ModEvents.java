package dev.drqv.loquatmadness.event;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import dev.drqv.loquatmadness.creativemodetab.ModCreativeModeTabs;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundPlayerCombatKillPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.CombatEntry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.wanderingtrader.WanderingTrader;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.VillagerTrades;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.brewing.BrewingRecipe;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import java.util.List;

@EventBusSubscriber(modid = LoquatMadness.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addRecipe(new BrewingRecipe(
                Ingredient.of(LoquatMadness_Items.LOQUAT.get()),
                Ingredient.of(Items.AMETHYST_SHARD),
                new ItemStack(LoquatMadness_Items.LOQUATNITE_FRAGMENT.get())
        ));
    }

    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        if (!event.getEntity().level().isClientSide() && event.getEntity() instanceof ServerPlayer player) {

            if (player.getPersistentData().contains("LoquatMadness_DeathTimer")) {
                int ticksDeExpiracion = player.getPersistentData().getInt("LoquatMadness_DeathTimer").orElse(0);

                if (player.tickCount <= ticksDeExpiracion && ticksDeExpiracion != 0) {


                    Component mensajeSobredosis = Component.translatable(
                            "death.attack.loquatmadness.overdose",
                            player.getDisplayName()
                    );

                    player.connection.send(new ClientboundPlayerCombatKillPacket(
                            player.getId(),
                            mensajeSobredosis
                    ));

                    if (player.level().getServer() != null) {
                        player.level().getServer().getPlayerList().broadcastSystemMessage(mensajeSobredosis, false);
                    }
                    player.getCombatTracker().recheckStatus();

                    player.getPersistentData().remove("LoquatMadness_DeathTimer");
                }
            }
        }
    }

    @SubscribeEvent
    public static void buildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == ModCreativeModeTabs.LOQUAT_MADNESS_TAB.get()) {

            HolderLookup.RegistryLookup<Enchantment> enchantments =
                    event.getParameters().holders().lookupOrThrow(Registries.ENCHANTMENT);

            ItemStack hoe = new ItemStack(LoquatMadness_Items.LOQUATNITE_HOE.get());
            hoe.enchant(enchantments.getOrThrow(Enchantments.FORTUNE), 3);

            event.accept(hoe);
        }
    }
}