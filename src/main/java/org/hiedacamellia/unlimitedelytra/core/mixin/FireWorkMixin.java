package org.hiedacamellia.unlimitedelytra.core.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.phys.Vec3;
import org.hiedacamellia.unlimitedelytra.core.config.Config;
import org.hiedacamellia.unlimitedelytra.core.debug.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FireworkRocketEntity.class)
public class FireWorkMixin {


    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V",ordinal = 0))
    public void onTick(LivingEntity attachedToEntity,Vec3 vec3) {

        Vec3 vec31 = attachedToEntity.getLookAngle();
        Vec3 vec32 = attachedToEntity.getDeltaMovement();
        Vec3 vec33;
        double a = Config.FireWorkAcceleration.get();

        if(Config.InfiniteFireWorkAcceleration.get())
            vec33=vec32.add(
                    vec31.x * 0.85 * a  ,
                    vec31.y * 0.85 * a  ,
                    vec31.z * 0.85 * a
            );
        else
            vec33=vec32.add(
                    vec31.x * 0.1 * a + (vec31.x * 1.5 * a - vec32.x) * 0.5,
                    vec31.y * 0.1 * a + (vec31.y * 1.5 * a - vec32.y) * 0.5,
                    vec31.z * 0.1 * a + (vec31.z * 1.5 * a - vec32.z) * 0.5
            );


        if(Config.EnableElytra.get())
            attachedToEntity.setDeltaMovement(vec33);
        else
            attachedToEntity.setDeltaMovement(vec3);

    }

}
