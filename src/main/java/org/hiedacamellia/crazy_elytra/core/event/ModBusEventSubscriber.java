package org.hiedacamellia.crazy_elytra.core.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.hiedacamellia.crazy_elytra.CrazyElytra;
import org.hiedacamellia.crazy_elytra.core.network.CompletelyInvisibleS2CPacket;

@EventBusSubscriber(modid = CrazyElytra.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModBusEventSubscriber {

    @SubscribeEvent
    public static void registerNetworks(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1");
        registrar.playToClient(CompletelyInvisibleS2CPacket.TYPE,
                CompletelyInvisibleS2CPacket.STREAM_CODEC,
                CompletelyInvisibleS2CPacket::handle);
    }

}