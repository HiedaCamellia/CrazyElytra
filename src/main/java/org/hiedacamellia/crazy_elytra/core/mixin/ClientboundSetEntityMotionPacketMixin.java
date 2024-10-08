package org.hiedacamellia.crazy_elytra.core.mixin;

import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.util.Mth;
import org.hiedacamellia.crazy_elytra.core.config.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientboundSetEntityMotionPacket.class)
public class ClientboundSetEntityMotionPacketMixin {
    @Redirect(method = "<init>(ILnet/minecraft/world/phys/Vec3;)V",at= @At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;clamp(DDD)D"))
    private double onClamp(double value, double min, double max) {
        if(!Config.EnableElytra.get())
            return Mth.clamp(value, min, max);
        return value;
    }
}
