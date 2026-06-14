package dev.drqv.loquatmadness.datagen;

import dev.drqv.loquatmadness.block.LoquatMadness_Blocks;
import dev.drqv.loquatmadness.item.LoquatMadness_Items;
import net.minecraft.advancements.*;
import net.minecraft.advancements.criterion.ConsumeItemTrigger;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier; // ¡EL NUEVO IMPORT QUE REEMPLAZA A RESOURCELOCATION!
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.data.advancements.AdvancementProvider;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider {

    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, List.of(new ModAdvancements()));
    }

    private static class ModAdvancements implements net.minecraft.data.advancements.AdvancementSubProvider {

        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver) {

            AdvancementHolder root = Advancement.Builder.advancement()
                    .display(new DisplayInfo(

                            new ItemStackTemplate(LoquatMadness_Items.LOQUAT.get()),
                            Component.translatable("advancements.loquatmadness.root.title"),
                            Component.translatable("advancements.loquatmadness.root.description"),
                            java.util.Optional.of(new net.minecraft.core.ClientAsset.ResourceTexture(
                                    Identifier.fromNamespaceAndPath("loquatmadness", "block/loquat_planks")
                            )),

                            AdvancementType.TASK,
                            true, true, false // showToast, announceToChat, hidden
                    ))
                            .addCriterion("has_loquat", InventoryChangeTrigger.TriggerInstance.hasItems(LoquatMadness_Items.LOQUAT.get()))
                    .save(saver, "loquatmadness:main/root");

            net.minecraft.core.HolderGetter<net.minecraft.world.item.Item> itemGetter =
                    registries.lookupOrThrow(net.minecraft.core.registries.Registries.ITEM);

            AdvancementHolder eatLoquat = Advancement.Builder.advancement()
                    .parent(root)
                    .display(new DisplayInfo(
                            new ItemStackTemplate(LoquatMadness_Items.LOQUAT.get()),
                            Component.translatable("advancements.loquatmadness.eat_loquat.title"),
                            Component.translatable("advancements.loquatmadness.eat_loquat.description"),
                            Optional.empty(), AdvancementType.TASK, true, true, false
                    ))
                    .addCriterion("eat_loquat", ConsumeItemTrigger.TriggerInstance.usedItem(ItemPredicate.Builder.item().of(itemGetter, LoquatMadness_Items.LOQUAT.get())))
                    .save(saver, "loquatmadness:main/eat_loquat");

            AdvancementHolder eatTwentyLoquats = Advancement.Builder.advancement()
                    .parent(eatLoquat)
                    .display(new DisplayInfo(

                            new ItemStackTemplate(LoquatMadness_Items.LOQUAT_GROUP.get()),
                            Component.translatable("advancements.loquatmadness.eat_twenty_loquats.title"),
                            Component.translatable("advancements.loquatmadness.eat_twenty_loquats.description"),

                            java.util.Optional.empty(),
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    ))

                    .addCriterion("consume_twenty_times", new net.minecraft.advancements.Criterion<>(
                            net.minecraft.advancements.CriteriaTriggers.IMPOSSIBLE,
                            new net.minecraft.advancements.criterion.ImpossibleTrigger.TriggerInstance()
                    ))
                    .save(saver, "loquatmadness:main/eat_twenty_loquats");

            AdvancementHolder eatCandyLoquat = Advancement.Builder.advancement()
                    .parent(eatLoquat)
                    .display(new DisplayInfo(
                            new ItemStackTemplate(LoquatMadness_Items.CANDY_LOQUAT.get()),
                            Component.translatable("advancements.loquatmadness.eat_candy_loquat.title"),
                            Component.translatable("advancements.loquatmadness.eat_candy_loquat.description"),
                            Optional.empty(), AdvancementType.TASK, true, true, false
                    ))
                    .addCriterion("eat_candy_loquat", ConsumeItemTrigger.TriggerInstance.usedItem(ItemPredicate.Builder.item().of(itemGetter, LoquatMadness_Items.CANDY_LOQUAT.get())))
                    .save(saver, "loquatmadness:main/eat_candy_loquat");

            AdvancementHolder loquatniteFragment = Advancement.Builder.advancement()
                    .parent(eatLoquat)
                    .display(new DisplayInfo(

                            new ItemStackTemplate(LoquatMadness_Items.LOQUATNITE_FRAGMENT.get()),
                            Component.translatable("advancements.loquatmadness.loquatnite_fragment.title"),
                            Component.translatable("advancements.loquatmadness.loquatnite_fragment.description"),
                            Optional.empty(), AdvancementType.TASK, true, true, false
                    ))
                    .addCriterion("has_loquatnite_fragment", InventoryChangeTrigger.TriggerInstance.hasItems(LoquatMadness_Items.LOQUATNITE_FRAGMENT.get()))
                    .save(saver, "loquatmadness:main/has_loquatnite_fragment");

            AdvancementHolder eatBurningLoquat = Advancement.Builder.advancement()
                    .parent(eatCandyLoquat)
                    .display(new DisplayInfo(
                            new ItemStackTemplate(LoquatMadness_Items.BURNING_LOQUAT.get()),
                            Component.translatable("advancements.loquatmadness.eat_burning_loquat.title"),
                            Component.translatable("advancements.loquatmadness.eat_burning_loquat.description"),
                            Optional.empty(), AdvancementType.TASK, true, true, false
                    ))
                    .addCriterion("eat_burning_loquat", ConsumeItemTrigger.TriggerInstance.usedItem(ItemPredicate.Builder.item().of(itemGetter, LoquatMadness_Items.BURNING_LOQUAT.get())))
                    .save(saver, "loquatmadness:main/eat_burning_loquat");

            AdvancementHolder loquatniteIngot = Advancement.Builder.advancement()
                    .parent(loquatniteFragment)
                    .display(new DisplayInfo(

                            new ItemStackTemplate(LoquatMadness_Items.CONCENTRATED_LOQUATNITE.get()),
                            Component.translatable("advancements.loquatmadness.loquatnite_ingot.title"),
                            Component.translatable("advancements.loquatmadness.loquatnite_ingot.description"),
                            Optional.empty(), AdvancementType.TASK, true, true, false
                    ))
                    .addCriterion("has_loquatnite_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(LoquatMadness_Items.CONCENTRATED_LOQUATNITE.get()))
                    .save(saver, "loquatmadness:main/has_loquatnite_ingot");

            AdvancementHolder loquatniteHoe = Advancement.Builder.advancement()
                    .parent(loquatniteFragment)
                    .display(new DisplayInfo(

                            new ItemStackTemplate(LoquatMadness_Items.LOQUATNITE_HOE.get()),
                            Component.translatable("advancements.loquatmadness.loquatnite_hoe.title"),
                            Component.translatable("advancements.loquatmadness.loquatnite_hoe.description"),
                            Optional.empty(), AdvancementType.TASK, true, true, false
                    ))
                    .addCriterion("has_loquatnite_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(LoquatMadness_Items.LOQUATNITE_HOE.get()))
                    .save(saver, "loquatmadness:main/has_loquatnite_hoe");

            AdvancementHolder loquatniteSickle = Advancement.Builder.advancement()
                    .parent(loquatniteHoe)
                    .display(new DisplayInfo(

                            new ItemStackTemplate(LoquatMadness_Items.LOQUATNITE_SICKLE.get()),
                            Component.translatable("advancements.loquatmadness.loquatnite_sickle.title"),
                            Component.translatable("advancements.loquatmadness.loquatnite_sickle.description"),
                            Optional.empty(), AdvancementType.CHALLENGE, true, true, false
                    ))
                    .addCriterion("has_loquatnite_sickle", InventoryChangeTrigger.TriggerInstance.hasItems(LoquatMadness_Items.LOQUATNITE_SICKLE.get()))
                    .save(saver, "loquatmadness:main/has_loquatnite_sickle");

            AdvancementHolder eatLoquatniteSandwich = Advancement.Builder.advancement()
                    .parent(eatBurningLoquat)
                    .display(new DisplayInfo(
                            new ItemStackTemplate(LoquatMadness_Items.GLAZED_CONCENTRATED_LOQUATNITE_SANDWICH.get()),
                            Component.translatable("advancements.loquatmadness.eat_loquatnite_sandwich.title"),
                            Component.translatable("advancements.loquatmadness.eat_loquatnite_sandwich.description"),
                            Optional.empty(), AdvancementType.TASK, true, true, false
                    ))
                    .addCriterion("eat_loquatnite_sandwich", ConsumeItemTrigger.TriggerInstance.usedItem(ItemPredicate.Builder.item().of(itemGetter, LoquatMadness_Items.GLAZED_CONCENTRATED_LOQUATNITE_SANDWICH.get())))
                    .save(saver, "loquatmadness:main/eat_loquatnite_sandwich");

            AdvancementHolder eatAmalgamation = Advancement.Builder.advancement()
                    .parent(eatLoquatniteSandwich)
                    .display(new DisplayInfo(
                            new ItemStackTemplate(LoquatMadness_Items.LOQUATNITIAN_AMALGAMATION.get()),
                            Component.translatable("advancements.loquatmadness.eat_loquatnitian_amalgamation.title"),
                            Component.translatable("advancements.loquatmadness.eat_loquatnitian_amalgamation.description"),
                            Optional.empty(), AdvancementType.TASK, true, true, false
                    ))
                    .addCriterion("eat_loquatnitian_amalgamation", ConsumeItemTrigger.TriggerInstance.usedItem(ItemPredicate.Builder.item().of(itemGetter, LoquatMadness_Items.LOQUATNITIAN_AMALGAMATION.get())))
                    .save(saver, "loquatmadness:main/eat_loquatnitian_amalgamation");

            AdvancementHolder surviveAmalgamation = Advancement.Builder.advancement()
                    .parent(eatAmalgamation)
                    .display(new DisplayInfo(
                            new ItemStackTemplate(LoquatMadness_Items.LOQUATNITIAN_AMALGAMATION.get()),
                            Component.translatable("advancements.loquatmadness.survive_amalgamation.title"),
                            Component.translatable("advancements.loquatmadness.survive_amalgamation.description"),
                            Optional.empty(), AdvancementType.CHALLENGE, true, true, false
                    ))
                    .addCriterion("survived_ten_seconds", new net.minecraft.advancements.Criterion<>(
                            net.minecraft.advancements.CriteriaTriggers.IMPOSSIBLE,
                            new net.minecraft.advancements.criterion.ImpossibleTrigger.TriggerInstance()
                    ))
                    .save(saver, "loquatmadness:main/survive_amalgamation");
        }
    }
}