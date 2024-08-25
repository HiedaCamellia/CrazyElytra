package org.hiedacamellia.unlimitedelytra.core.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.hiedacamellia.unlimitedelytra.core.config.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LivingEntity.class)
public class AirResistanceMixin {

    @ModifyArg(method = "travel",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V", ordinal = 6)
    )
    private Vec3 setDeltaMovement(Vec3 vec3) {
        vec3 = vec3.multiply(1 / 0.99F, 1 / 0.98F, 1 / 0.99F);
        double r = Config.AirResistance.get();
        vec3 = vec3.multiply((1 - 0.01 * r)>0?(1 - 0.01 * r):0, (1 - 0.02 * r)>0?(1 - 0.02 * r):0, (1 - 0.01 * r)>0?(1 - 0.01 * r):0);

        return vec3;
    }

}
