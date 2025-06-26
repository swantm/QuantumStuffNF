package net.swan.quantumstuff.item;

import net.swan.quantumstuff.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier QUANTUM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_QUANTUM_TOOL,
            9999, 100, 10f, 15, () -> Ingredient.of(ModItems.QUANTUMINGOT));

}
