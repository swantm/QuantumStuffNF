package net.swan.quantumstuff.potion;


import net.swan.quantumstuff.QuantumStuff;
import net.swan.quantumstuff.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, QuantumStuff.MOD_ID);

    public static final Holder<Potion> INVINCIBILITY_POTION = POTIONS.register("invincibility_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.INVINCIBILITY_EFFECT, 600, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}