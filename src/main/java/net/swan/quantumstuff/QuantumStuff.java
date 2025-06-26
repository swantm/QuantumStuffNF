package net.swan.quantumstuff;

import net.minecraft.world.item.CreativeModeTabs;
import net.swan.quantumstuff.block.ModBlocks;
import net.swan.quantumstuff.effect.ModEffects;
import net.swan.quantumstuff.event.ModClientEvents;
import net.swan.quantumstuff.event.ModEvents;
import net.swan.quantumstuff.item.ModCreativeModeTabs;
import net.swan.quantumstuff.item.ModItems;
import net.swan.quantumstuff.potion.ModPotions;
import net.swan.quantumstuff.sound.ModSounds;
import net.swan.quantumstuff.util.ModItemProperties;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(QuantumStuff.MOD_ID)
public class QuantumStuff {
    public static final String MOD_ID = "quantumstuff";
    private static final Logger LOGGER = LogUtils.getLogger();

    public QuantumStuff(IEventBus modEventBus, ModContainer modContainer) {
        // Common setup
        modEventBus.addListener(this::commonSetup);

        // Creative tab contents
        modEventBus.addListener(this::addCreative);

        // Register config
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        // Register this instance to NeoForge's main event bus
        NeoForge.EVENT_BUS.register(this);
        NeoForge.EVENT_BUS.register(ModEvents.class);




        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);


        // Register client-only events
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(ClientModEvents::onClientSetup);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Common setup initialized");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.QUANTUMINGOT);
            event.accept(ModItems.QUANTUMROD);
            event.accept(ModItems.THOUSANDDOLLARWALLET);
            event.accept(ModItems.NOISECOIN);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.QUANTUM_BLOCK);
            event.accept(ModBlocks.NETHER_STAR_BLOCK);
            event.accept(ModBlocks.COMPRESSED_DIAMOND_BLOCK);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.QUANTUM_PICKAXE);
            event.accept(ModItems.QUANTUM_AXE);
            event.accept(ModItems.QUANTUM_SHOVEL);
            event.accept(ModItems.QUANTUM_HOE);
        }

        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.QUANTUM_SWORD);
            event.accept(ModItems.QUANTUM_HELMET);
            event.accept(ModItems.QUANTUM_CHESTPLATE);
            event.accept(ModItems.QUANTUM_LEGGINGS);
            event.accept(ModItems.QUANTUM_BOOTS);
            event.accept(ModItems.QUANTUM_BOW);
        }
    }

    // Server event handler
    @net.neoforged.bus.api.SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Server is starting!");
    }

    // Client-only event handlers
    public static class ClientModEvents {
        public static void onClientSetup(FMLClientSetupEvent event) {
            // ✅ Register client-side event handlers
            NeoForge.EVENT_BUS.register(ModClientEvents.class);

            // ✅ Register item model predicates like the bow pulling
            event.enqueueWork(ModItemProperties::addCustomItemProperties);
        }
    }
}
