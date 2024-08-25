package org.hiedacamellia.crazy_elytra.core.event;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.event.level.ExplosionKnockbackEvent;
import org.hiedacamellia.crazy_elytra.CrazyElytra;
import org.hiedacamellia.crazy_elytra.core.registry.CEAttachmentTypes;

@EventBusSubscriber(modid = CrazyElytra.MOD_ID)
public class LevelEventSubscriber {

    @SubscribeEvent
    public static void onExplosionKnockback(ExplosionKnockbackEvent event) {
        AttachmentType<Boolean> type = CEAttachmentTypes.IS_EXPLODER.get();
        Entity entity = event.getAffectedEntity();
        if (entity.getData(type)) {
            entity.setData(type, false);
            event.setKnockbackVelocity(Vec3.ZERO);
        }
    }

}