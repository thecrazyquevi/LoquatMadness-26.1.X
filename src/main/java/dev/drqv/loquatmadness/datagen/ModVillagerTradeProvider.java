package dev.drqv.loquatmadness.datagen;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;
import net.neoforged.neoforge.common.data.JsonCodecProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.core.registries.Registries.VILLAGER_TRADE;

public class ModVillagerTradeProvider extends JsonCodecProvider<VillagerTrade> {

    public static final ResourceKey<VillagerTrade> LOQUAT_PROPAGULE_TRADE = ResourceKey.create(
            VILLAGER_TRADE, Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "wandering_trader_loquat_propagule")
    );

    public static final ResourceKey<VillagerTrade> LOQUAT_LOG_TRADE = ResourceKey.create(
            VILLAGER_TRADE, Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "wandering_trader_loquat_log")
    );

    public static final ResourceKey<VillagerTrade> LOQUAT_GROUP_TRADE = ResourceKey.create(
            VILLAGER_TRADE, Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "wandering_trader_loquat_group")
    );

    public ModVillagerTradeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, PackOutput.Target.DATA_PACK, "villager_trade", VillagerTrade.CODEC, lookupProvider, LoquatMadness.MOD_ID);
    }

    @Override
    protected void gather() {
        unconditional(
                Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "wandering_trader_loquat_propagule"),
                new VillagerTrade(
                        new TradeCost(Items.EMERALD, 5),
                        new ItemStackTemplate(LoquatMadness_Items.LOQUAT_PROPAGULE.get()),
                        8, 1, 0.05F, Optional.empty(), List.of()
                )
        );

        unconditional(
                Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "wandering_trader_loquat_log"),
                new VillagerTrade(
                        new TradeCost(Items.EMERALD, 1),
                        new ItemStackTemplate(LoquatMadness_Blocks.LOQUAT_LOG.get().asItem(), 8),
                        5, 1, 0.05F, Optional.empty(), List.of()
                )
        );

        unconditional(
                Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "wandering_trader_loquat_group"),
                new VillagerTrade(
                        new TradeCost(Items.EMERALD, 3),
                        new ItemStackTemplate(LoquatMadness_Items.LOQUAT_GROUP.get().asItem(), 1),
                        5, 1, 0.05F, Optional.empty(), List.of()
                )
        );
    }
}