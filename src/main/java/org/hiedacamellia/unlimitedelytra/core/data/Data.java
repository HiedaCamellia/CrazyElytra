package org.hiedacamellia.unlimitedelytra.core.data;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.hiedacamellia.unlimitedelytra.core.data.lang.ChineseLanguageProvider;
import org.hiedacamellia.unlimitedelytra.core.data.lang.EnglishLanguageProvider;

public class Data {
    public static void onGatherData(GatherDataEvent event) {
        var gen = event.getGenerator();
        var packOutput = gen.getPackOutput();
        var helper = event.getExistingFileHelper();
        gen.addProvider(event.includeClient(), new EnglishLanguageProvider(packOutput));
        gen.addProvider(event.includeClient(), new ChineseLanguageProvider(packOutput));
    }
}