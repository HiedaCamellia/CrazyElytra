package org.hiedacamellia.unlimitedelytra.core.command;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@EventBusSubscriber
public class RegCmd {
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        UnlimitEdelytraCommand.register(event.getDispatcher());
    }
}
