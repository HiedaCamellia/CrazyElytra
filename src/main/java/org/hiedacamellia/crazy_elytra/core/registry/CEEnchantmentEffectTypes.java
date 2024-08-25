package org.hiedacamellia.crazy_elytra.core.registry;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.crazy_elytra.CrazyElytra;
import org.hiedacamellia.crazy_elytra.core.enchantments.KamikazeElytraEffect;

public class CEEnchantmentEffectTypes {

    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENCHANTMENT_ENTITY_EFFECT_TYPES =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, CrazyElytra.MOD_ID);

    static {
        ENCHANTMENT_ENTITY_EFFECT_TYPES.register("kamikaze_elytra", () -> KamikazeElytraEffect.CODEC);
    }

}