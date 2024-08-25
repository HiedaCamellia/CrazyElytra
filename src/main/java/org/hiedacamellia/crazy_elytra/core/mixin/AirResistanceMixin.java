package org.hiedacamellia.crazy_elytra.core.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.hiedacamellia.crazy_elytra.core.config.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LivingEntity.class)
public class AirResistanceMixin {

    @Shadow
    private BlockPos lastPos;

    @ModifyArg(method = "travel",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V", ordinal = 6)
    )
    private Vec3 setDeltaMovement(Vec3 vec3) {

        if(!Config.EnableElytra.get())
            return vec3;

        vec3 = vec3.multiply(1 / 0.99F, 1 / 0.98F, 1 / 0.99F);
        //现在取得的原速度

        double r = Config.AirResistance.get();
        //取得空气阻力

        if(!Config.EnableAirResistanceWithSpeed.get()&&!Config.EnableAirResistanceWithHeight.get()) {
            //如果没有启用速度相关空气阻力和高度相关空气阻力
            //使用原版的空气阻力计算
            double factorX = (1 - 0.01 * r) > 0 ? (1 - 0.01 * r) : 0;
            double factorY = (1 - 0.02 * r) > 0 ? (1 - 0.02 * r) : 0;
            vec3 = vec3.multiply(factorX, factorY, factorX);
        }else if(Config.EnableAirResistanceWithSpeed.get()&&!Config.EnableAirResistanceWithHeight.get()) {
            //如果启用速度相关空气阻力
            //速度越快，空气阻力越大
        }else if(!Config.EnableAirResistanceWithSpeed.get()&&Config.EnableAirResistanceWithHeight.get()) {
            //如果启用高度相关空气阻力
            //高度越高，空气阻力越小
        }else {
            //如果同时启用速度相关空气阻力和高度相关空气阻力
            //速度越快，空气阻力越大
            //高度越高，空气阻力越小
        }
        return vec3;
    }

}
