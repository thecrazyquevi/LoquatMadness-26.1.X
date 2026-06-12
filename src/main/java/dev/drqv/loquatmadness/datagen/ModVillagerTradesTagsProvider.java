package dev.drqv.loquatmadness.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.VillagerTradeTags;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.data.tags.KeyTagProvider;

import java.util.concurrent.CompletableFuture;

public class ModVillagerTradesTagsProvider extends KeyTagProvider<VillagerTrade> {

    public ModVillagerTradesTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.VILLAGER_TRADE, lookupProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(VillagerTradeTags.WANDERING_TRADER_COMMON)
                .add(ModVillagerTradeProvider.LOQUAT_PROPAGULE_TRADE)
                .add(ModVillagerTradeProvider.LOQUAT_LOG_TRADE);
    }
}