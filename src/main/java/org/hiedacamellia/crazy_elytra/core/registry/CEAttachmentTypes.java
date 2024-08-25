package org.hiedacamellia.crazy_elytra.core.registry;

import com.mojang.serialization.Codec;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.hiedacamellia.crazy_elytra.CrazyElytra;

public class CEAttachmentTypes {

    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, CrazyElytra.MOD_ID);
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<Integer>> FALL_FLYING_TICKS = registerInteger("fall_flying_ticks");
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<Boolean>> IS_EXPLODER = registerBoolean("is_exploder");
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<Boolean>> COMPLETELY_INVISIBLE = registerBoolean("completely_invisible");

    private static DeferredHolder<AttachmentType<?>, AttachmentType<Integer>> registerInteger(String name) {
        return ATTACHMENT_TYPES.register(name, () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build());
    }

    private static DeferredHolder<AttachmentType<?>, AttachmentType<Float>> registerFloat(String name) {
        return ATTACHMENT_TYPES.register(name, () -> AttachmentType.builder(() -> 0.0F).serialize(Codec.FLOAT).build());
    }

    private static DeferredHolder<AttachmentType<?>, AttachmentType<Boolean>> registerBoolean(String name) {
        return ATTACHMENT_TYPES.register(name, () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL).build());
    }

}