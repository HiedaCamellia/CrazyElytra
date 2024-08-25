package org.hiedacamellia.crazy_elytra.core.data;

import net.minecraft.core.HolderLookup;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.hiedacamellia.crazy_elytra.CrazyElytra;
import org.hiedacamellia.crazy_elytra.core.data.lang.ChineseLanguageProvider;
import org.hiedacamellia.crazy_elytra.core.data.lang.EnglishLanguageProvider;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = CrazyElytra.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Data {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        var gen = event.getGenerator();
        var packOutput = gen.getPackOutput();
        var helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        gen.addProvider(event.includeClient(), new EnglishLanguageProvider(packOutput));
        gen.addProvider(event.includeClient(), new ChineseLanguageProvider(packOutput));
        gen.addProvider(event.includeServer(), new RegistryDataGenerator(packOutput, provider));
    }

}