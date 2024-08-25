package org.hiedacamellia.crazyelytra;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.hiedacamellia.crazyelytra.core.config.*;
import org.hiedacamellia.crazyelytra.core.data.Data;

import java.util.function.Supplier;

@Mod(CrazyElytra.MODID)
public class CrazyElytra {

    public static final String MODID = "crazyelytra";

    public CrazyElytra(IEventBus modEventBus, ModContainer modContainer){
        modEventBus.addListener(Data::onGatherData);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, (Supplier<IConfigScreenFactory>) ScreenProvider::new);
    }
}
