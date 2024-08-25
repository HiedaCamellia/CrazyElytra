package org.hiedacamellia.crazy_elytra;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.hiedacamellia.crazy_elytra.core.config.*;
import org.hiedacamellia.crazy_elytra.core.registry.CEAttachmentTypes;
import org.hiedacamellia.crazy_elytra.core.registry.CEEnchantmentEffectTypes;

import java.util.Locale;

@Mod(value=CrazyElytra.MOD_ID,dist = Dist.DEDICATED_SERVER)
public class CrazyElytra {

    public static final String MOD_ID = "crazy_elytra";

    public CrazyElytra(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        CEAttachmentTypes.ATTACHMENT_TYPES.register(modEventBus);
        CEEnchantmentEffectTypes.ENCHANTMENT_ENTITY_EFFECT_TYPES.register(modEventBus);
    }

    public static ResourceLocation prefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name.toLowerCase(Locale.ROOT));
    }

}