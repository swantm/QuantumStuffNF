package net.swan.quantumstuff.item;

import net.swan.quantumstuff.QuantumStuff;
import net.swan.quantumstuff.block.ModBlocks;
import net.swan.quantumstuff.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, QuantumStuff.MOD_ID);

    public static final Supplier<CreativeModeTab> QUANTUMSTUFF_ITEMS_TAB = CREATIVE_MODE_TAB.register("quantumstuff_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.QUANTUMINGOT.get()))
                    .title(Component.translatable("creativetab.quantumstuff.quantumstuff_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.QUANTUMINGOT.get());
                        output.accept(ModItems.QUANTUMROD.get());
                        output.accept(ModItems.THOUSANDDOLLARWALLET.get());
                        output.accept(ModItems.NOISECOIN.get());

                        output.accept(ModBlocks.QUANTUM_BLOCK.get());
                        output.accept(ModBlocks.NETHER_STAR_BLOCK.get());
                        output.accept(ModBlocks.COMPRESSED_DIAMOND_BLOCK.get());

                        output.accept(ModItems.QUANTUM_SWORD.get());
                        output.accept(ModItems.QUANTUM_PICKAXE.get());
                        output.accept(ModItems.QUANTUM_AXE.get());
                        output.accept(ModItems.QUANTUM_SHOVEL.get());
                        output.accept(ModItems.QUANTUM_HOE.get());

                        output.accept(ModItems.QUANTUM_HELMET.get());
                        output.accept(ModItems.QUANTUM_CHESTPLATE.get());
                        output.accept(ModItems.QUANTUM_LEGGINGS.get());
                        output.accept(ModItems.QUANTUM_BOOTS.get());

                        output.accept(ModItems.EMERALD_CARROT.get());
                        output.accept(ModItems.QUANTUM_APPLE.get());

                        output.accept(ModItems.QUANTUM_BOW.get());

                        output.accept(ModItems.SILENT_MUSIC_DISC.get());





                    }).build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}