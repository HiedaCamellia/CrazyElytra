package org.hiedacamellia.crazyelytra.core.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.crazyelytra.CrazyElytra;

public class ChineseLanguageProvider extends LanguageProvider {

    public ChineseLanguageProvider(PackOutput output) {
        super(output, CrazyElytra.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add("mod.crazyelytra", "疯狂鞘翅");
        add("config.crazyelytra.title", "疯狂鞘翅 配置");
        add("config.crazyelytra.enableelytra", "启用疯狂鞘翅");
        add("config.crazyelytra.enableelytra.desc", "如果为true，则疯狂鞘翅将启用");
        add("config.crazyelytra.airresistance", "空气阻力");
        add("config.crazyelytra.enableairresistancewithspeed", "启用速度相关的空气阻力");
        add("config.crazyelytra.enableairresistancewithspeed.desc", "如果为true，则空气阻力将与速度有关");
        add("config.crazyelytra.enableairresistancewithheight", "启用高度相关的空气阻力");
        add("config.crazyelytra.enableairresistancewithheight.desc", "如果为true，则空气阻力将与高度有关");
        add("config.crazyelytra.infinitefireworkacceleration", "启用烟花的无限加速");
        add("config.crazyelytra.infinitefireworkacceleration.desc", "如果为true，则玩家可以被烟花无限加速");
        add("config.crazyelytra.fireworkacceleration", "烟花的加速度");
        add("config.crazyelytra.comfirm", "确认");
    }
}