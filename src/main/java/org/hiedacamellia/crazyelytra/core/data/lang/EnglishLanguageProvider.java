package org.hiedacamellia.crazyelytra.core.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.crazyelytra.CrazyElytra;

public class EnglishLanguageProvider extends LanguageProvider {

    public EnglishLanguageProvider(PackOutput output) {
        super(output, CrazyElytra.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("mod.crazyelytra", "Crazy Elytra");
        add("config.crazyelytra.title", "Crazy Elytra Config");
        add("config.crazyelytra.enableelytra", "Enable Crazy Elytra");
        add("config.crazyelytra.enableelytra.desc", "If true, the Crazy Elytra will be enabled");
        add("config.crazyelytra.airresistance", "Air Resistance");
        add("config.crazyelytra.enableairresistancewithspeed", "Enable Air Resistance With Speed");
        add("config.crazyelytra.enableairresistancewithspeed.desc", "If true, the air resistance will be related to the speed");
        add("config.crazyelytra.enableairresistancewithheight", "Enable Air Resistance With Height");
        add("config.crazyelytra.enableairresistancewithheight.desc", "If true, the air resistance will be related to the height");
        add("config.crazyelytra.infinitefireworkacceleration", "Infinite FireWork Acceleration");
        add("config.crazyelytra.infinitefireworkacceleration.desc", "If true, the player can be infinitely accelerated by fireworks");
        add("config.crazyelytra.fireworkacceleration", "The acceleration of the firework");
        add("config.crazyelytra.comfirm", "Comfirm");
    }
}