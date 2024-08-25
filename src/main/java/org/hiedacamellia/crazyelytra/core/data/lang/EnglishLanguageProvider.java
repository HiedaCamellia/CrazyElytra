package org.hiedacamellia.crazyelytra.core.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.crazyelytra.CrazyElytra;

public class EnglishLanguageProvider extends LanguageProvider {

    public EnglishLanguageProvider(PackOutput output) {
        super(output, CrazyElytra.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("mod.crazy_elytra", "Crazy Elytra");
        add("config.crazy_elytra.title", "Crazy Elytra Config");
        add("config.crazy_elytra.enableelytra", "Enable Crazy Elytra");
        add("config.crazy_elytra.enableelytra.desc", "If true, the Crazy Elytra will be enabled");
        add("config.crazy_elytra.airresistance", "Air Resistance");
        add("config.crazy_elytra.infinitefireworkacceleration", "Infinite FireWork Acceleration");
        add("config.crazy_elytra.infinitefireworkacceleration.desc", "If true, the player can be infinitely accelerated by fireworks");
        add("config.crazy_elytra.fireworkacceleration", "The acceleration of the firework");
        add("config.crazy_elytra.comfirm", "Comfirm");
        add("enchantment.crazy_elytra.kamikaze_elytra", "Kamikaze Elytra");
        add("deathScreen.title.kamikaze", "The target has been destroyed!");
        add("death.attack.explosion.suicide", "");
    }
}