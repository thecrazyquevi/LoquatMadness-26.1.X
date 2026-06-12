package dev.drqv.loquatmadness.tags;

import dev.drqv.loquatmadness.LoquatMadness;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> LOQUATNITE_MATERIAL = createTag("loquatnite_material");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, name));

        }
    }

    public static class Items {

        public static final TagKey<Item> LOQUATNITE_BARS = createTag("loquatnite_bars");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, name));



        }
    }

}
