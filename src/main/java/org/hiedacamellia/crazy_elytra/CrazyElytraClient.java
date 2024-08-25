package org.hiedacamellia.crazy_elytra;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.hiedacamellia.crazy_elytra.core.config.ScreenProvider;

import java.util.function.Supplier;

@Mod(value=CrazyElytra.MOD_ID,dist = Dist.CLIENT)
public class CrazyElytraClient {

    public CrazyElytraClient(ModContainer modContainer) {
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, (Supplier<IConfigScreenFactory>) ScreenProvider::new);
    }

}