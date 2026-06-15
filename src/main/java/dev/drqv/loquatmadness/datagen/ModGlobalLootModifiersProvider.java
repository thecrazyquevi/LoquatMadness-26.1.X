package dev.drqv.loquatmadness.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String modid) {
        super(output, registries, modid);
    }

    @Override
    protected void start() {
        // Almacenamos la ruta hacia la tabla de botín personalizada que creamos en el Paso 1
        ResourceKey<LootTable> loquatItems = ResourceKey.create(
                Registries.LOOT_TABLE,
                Identifier.fromNamespaceAndPath("loquatmadness", "chests/loquat_items_loot"));

        ResourceKey<LootTable> netherItems = ResourceKey.create(
                Registries.LOOT_TABLE,
                Identifier.fromNamespaceAndPath("loquatmadness", "chests/loquat_nether_loot"));

        ResourceKey<LootTable> otherItems = ResourceKey.create(
                Registries.LOOT_TABLE,
                Identifier.fromNamespaceAndPath("loquatmadness", "chests/loquat_other_loot"));


        String[] loquatItemsChest = {
                "chests/village/village_desert_house",
                "chests/village/village_plains_house",
                "chests/village/village_savanna_house",
                "chests/village/village_snowy_house",
                "chests/village/village_taiga_house",
                "chests/village/village_armorer",
                "chests/village/village_fisher",
                "chests/village/village_fletcher",
                "chests/village/village_mason",
                "chests/village/village_toolsmith",
                "chests/village/village_weaponsmith",
                "chests/trial_chambers/supply",
                "chests/spawn_bonus_chest",
                "chests/woodland_mansion",
        };

        for (String rutaCofre : loquatItemsChest) {
            String nombreModificador = rutaCofre.replace("/", "_") + "_injector";

            LootItemCondition[] condicionesDeInyeccion = new LootItemCondition[]{
                    LootTableIdCondition.builder(Identifier.fromNamespaceAndPath("minecraft", rutaCofre)).build()
            };
            this.add(nombreModificador, new AddTableLootModifier(
                    condicionesDeInyeccion,
                    0,
                    loquatItems
            ));
        }

        String[] netherItemsChest = {
                "chests/nether_bridge",        // Nether Fortress
                "chests/ruined_portal",        // Ruined Portal
                "chests/bastion_treasure",     // Bastions
        };

        for (String rutaCofre : netherItemsChest) {
            String nombreModificador = rutaCofre.replace("/", "_") + "_injector";

            LootItemCondition[] condicionesDeInyeccion = new LootItemCondition[]{
                    LootTableIdCondition.builder(Identifier.fromNamespaceAndPath("minecraft", rutaCofre)).build()
            };
            this.add(nombreModificador, new AddTableLootModifier(
                    condicionesDeInyeccion,
                    0,
                    netherItems
            ));
        }

        String[] otherItemsChest = {
                "chests/shipwreck_supply",      // Shipwrecks
                "chests/underwater_ruin_big",   // Ruin 1
                "chests/underwater_ruin_small", // Ruin 2
                "chests/simple_dungeon",        // Spawners
                "chests/desert_pyramid",        // Desert Pyramids
                "chests/jungle_temple",         // Jungle Temple
                "chests/jungle_temple_dispenser",
                "chests/ancient_city",
                "chests/abandoned_mineshaft",   // Mineshaft
                "chests/end_city_treasure",     // End Cities
                "chests/stronghold_corridor",   // Stronghold
                "chests/stronghold_crossing",   // Stronghold
                "chests/buried_treasure",       // Chest
        };

        for (String rutaCofre : otherItemsChest) {
            String nombreModificador = rutaCofre.replace("/", "_") + "_injector";

            LootItemCondition[] condicionesDeInyeccion = new LootItemCondition[]{
                    LootTableIdCondition.builder(Identifier.fromNamespaceAndPath("minecraft", rutaCofre)).build()
            };
            this.add(nombreModificador, new AddTableLootModifier(
                    condicionesDeInyeccion,
                    0,
                    otherItems
            ));
        }
    }
}