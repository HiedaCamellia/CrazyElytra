package org.hiedacamellia.unlimitedelytra;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.hiedacamellia.unlimitedelytra.core.config.*;
import org.hiedacamellia.unlimitedelytra.core.data.Data;

import java.util.function.Supplier;

@Mod(UnlimitedElytra.MODID)
public class UnlimitedElytra {

    public static final String MODID = "unlimitedelytra";

    public UnlimitedElytra(IEventBus modEventBus, ModContainer modContainer){
        modEventBus.addListener(Data::onGatherData);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, (Supplier<IConfigScreenFactory>) ScreenProvider::new);
    }
}
