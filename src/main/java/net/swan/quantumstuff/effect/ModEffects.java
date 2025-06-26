package net.swan.quantumstuff.effect;

import net.swan.quantumstuff.QuantumStuff;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, QuantumStuff.MOD_ID);

    public static final Holder<MobEffect> INVINCIBILITY_EFFECT = MOB_EFFECTS.register("invincibility",
            () -> new InvincibilityEffect(MobEffectCategory.NEUTRAL, 0xEBF0C4)
                    .addAttributeModifier(Attributes.MAX_HEALTH,
                            ResourceLocation.fromNamespaceAndPath(QuantumStuff.MOD_ID, "invincibility"), 1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}