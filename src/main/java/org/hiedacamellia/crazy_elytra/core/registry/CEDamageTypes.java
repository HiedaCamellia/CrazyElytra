package org.hiedacamellia.crazy_elytra.core.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import org.hiedacamellia.crazy_elytra.CrazyElytra;

public class CEDamageTypes {

    public static final ResourceKey<DamageType> SUICIDE_EXPLOSION = ResourceKey.create(Registries.DAMAGE_TYPE, CrazyElytra.prefix("suicide_explosion"));

    public static void bootstrap(BootstrapContext<DamageType> context) {
        context.register(SUICIDE_EXPLOSION, new DamageType("explosion.suicide", 0.1F));
    }

}