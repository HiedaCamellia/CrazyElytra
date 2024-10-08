package org.hiedacamellia.crazy_elytra.core.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import org.hiedacamellia.crazy_elytra.CrazyElytra;
import org.hiedacamellia.crazy_elytra.core.registry.CEDamageTypes;
import org.hiedacamellia.crazy_elytra.core.registry.CEEnchantments;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RegistryDataGenerator extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.ENCHANTMENT, CEEnchantments::bootstrap)
            .add(Registries.DAMAGE_TYPE, CEDamageTypes::bootstrap);

    public RegistryDataGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(CrazyElytra.MOD_ID));
    }

}