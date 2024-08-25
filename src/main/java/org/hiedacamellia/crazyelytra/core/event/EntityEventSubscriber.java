package org.hiedacamellia.crazyelytra.core.event;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.crazyelytra.CrazyElytra;
import org.hiedacamellia.crazyelytra.core.network.CompletelyInvisibleS2CPacket;
import org.hiedacamellia.crazyelytra.core.registry.CEAttachmentTypes;
import org.hiedacamellia.crazyelytra.core.registry.CEDamageTypes;
import org.hiedacamellia.crazyelytra.core.registry.CEEnchantments;

@EventBusSubscriber(modid = CrazyElytra.MOD_ID)
public class EntityEventSubscriber {

    @SubscribeEvent
    public static void onLivingAttack(LivingIncomingDamageEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            float amount = event.getAmount();
            Level level = player.level();
            DamageSource source = event.getSource();
            ItemStack itemInChest = player.getItemBySlot(EquipmentSlot.CHEST);
            AttachmentType<Integer> type = CEAttachmentTypes.FALL_FLYING_TICKS.get();
            int i = itemInChest.getEnchantmentLevel(CEEnchantments.get(level, CEEnchantments.KAMIKAZE_ELYTRA));
            if (itemInChest.canElytraFly(player) && i > 0 && !level.isClientSide) {
                if (source.is(DamageTypeTags.IS_FALL) && player.getData(type) > 0 && amount > 3.0F || source.is(DamageTypes.FLY_INTO_WALL)) {
                    player.stopFallFlying();
                    player.setData(CEAttachmentTypes.IS_EXPLODER, true);
                    itemInChest.hurtAndBreak(Mth.floor(amount), player, EquipmentSlot.CHEST);
                    DamageSource explosion = player.damageSources().source(CEDamageTypes.SUICIDE_EXPLOSION);
                    level.explode((null), explosion, (null), player.position(), amount, Boolean.FALSE, Level.ExplosionInteraction.MOB);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        LivingEntity entity = event.getEntity();
        if (event.getSource().is(CEDamageTypes.SUICIDE_EXPLOSION)) {
            entity.setNoGravity(true);
            entity.setDeltaMovement(Vec3.ZERO);
            if (entity instanceof ServerPlayer serverPlayer) {
                CompletelyInvisibleS2CPacket packet = new CompletelyInvisibleS2CPacket(Boolean.TRUE);
                PacketDistributor.sendToPlayer(serverPlayer, packet);
            }
        }
    }

}