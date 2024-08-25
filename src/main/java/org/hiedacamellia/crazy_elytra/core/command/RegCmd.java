package org.hiedacamellia.crazy_elytra.core.command;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@EventBusSubscriber
public class RegCmd {
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        CrazyEdelytraCommand.register(event.getDispatcher());
    }
}
