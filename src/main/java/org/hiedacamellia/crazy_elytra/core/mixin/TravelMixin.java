package org.hiedacamellia.crazy_elytra.core.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.hiedacamellia.crazy_elytra.core.config.Config;
import org.hiedacamellia.crazy_elytra.core.debug.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.hiedacamellia.crazy_elytra.core.aerodynamics.Aerodynamics;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(LivingEntity.class)
public class TravelMixin {


    @ModifyArg(method = "travel",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V", ordinal = 6)
    )
    private Vec3 setDeltaMovement(Vec3 vec3) {

        Vec3 mov = ((LivingEntity)(Object)this).getDeltaMovement();
        Vec3 lok = ((LivingEntity)(Object)this).getLookAngle();

        if(!Config.EnableElytra.get())
            return vec3;

        double r = Config.AirResistance.get();
        //取得空气阻力

        if(!Config.EnableRealPhysic.get()) {
            //如果没有启用真实物理
            //使用原版的空气阻力计算
            vec3 = vec3.multiply(1 / 0.99F, 1 / 0.98F, 1 / 0.99F);
            //取得原速度
            double factorX = (1 - 0.01 * r) > 0 ? (1 - 0.01 * r) : 0;
            double factorY = (1 - 0.02 * r) > 0 ? (1 - 0.02 * r) : 0;
            return vec3.multiply(factorX, factorY, factorX);
        }else {
            Level level = ((LivingEntity)(Object)this).level();
            Vec3 postion = ((LivingEntity)(Object)this).position();
            //取得实体的位置和世界
            double vol = mov.length();
            //取得速度

            double baseT = 1.0;
            double t = baseT / (vol + 0.1);
            t = Math.max(0.001, Math.min(t, 0.1));
            //计算插值的t

            Vec3 movl = mov.lerp(lok,t);
            double v = movl.length();
            Debug.debug("vol",vol);
            Debug.debug("v",v);
            //插值

            double lasty = postion.y;
            double vols = Aerodynamics.getRealV(vol);
            double Ek = Aerodynamics.getEk(vols);
            double Ep = Aerodynamics.getEp(lasty,level);
            //计算动能和势能

            double airresistance = Aerodynamics.getAirResistanceWithHeight(vols,lasty);
            //计算空气阻力
            double airfactorwork = airresistance * vols * 0.05 * r;
            //计算空气阻力做的功

            Vec3 nowpos = postion.add(movl);
            //计算现在的位置

            double nowy = nowpos.y;
            double Eps = Aerodynamics.getEp(nowy,level);
            double Eks = Ek + Ep - Eps - airfactorwork;
            //计算现在的动能

            double nowvols = Aerodynamics.getV(Eks);
            double scale = nowvols/vols;
            Debug.debug("lv",movl.scale(scale));
            return movl.scale(scale);
            //计算现在的速度
        }
    }

}
