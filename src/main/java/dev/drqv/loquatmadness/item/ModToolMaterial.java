package dev.drqv.loquatmadness.item;

import dev.drqv.loquatmadness.tags.ModTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterial {
    public static final ToolMaterial LOQUATNITE_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            867,
            6f,
            0f,
            18,
            ModTags.Items.LOQUATNITE_BARS
    );

    public static final ToolMaterial LOQUATNITE_CORE_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            82,
            4f,
            1f,
            18,
            ModTags.Items.LOQUATNITE_CORES
    );
}

