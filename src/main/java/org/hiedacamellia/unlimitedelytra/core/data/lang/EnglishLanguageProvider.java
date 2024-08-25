package org.hiedacamellia.unlimitedelytra.core.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.unlimitedelytra.UnlimitedElytra;

public class EnglishLanguageProvider extends LanguageProvider {

    public EnglishLanguageProvider(PackOutput output) {
        super(output, UnlimitedElytra.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("mod.unlimitedelytra", "Unlimited Elytra");
        add("config.unlimitedelytra.title", "Unlimited Elytra Config");
        add("config.unlimitedelytra.enableelytra", "Enable Unlimited Elytra");
        add("config.unlimitedelytra.enableelytra.desc", "If true, the Unlimited Elytra will be enabled");
        add("config.unlimitedelytra.airresistance", "Air Resistance");
        add("config.unlimitedelytra.infinitefireworkacceleration", "Infinite FireWork Acceleration");
        add("config.unlimitedelytra.infinitefireworkacceleration.desc", "If true, the player can be infinitely accelerated by fireworks");
        add("config.unlimitedelytra.fireworkacceleration", "The acceleration of the firework");
        add("config.unlimitedelytra.comfirm", "Comfirm");
    }
}