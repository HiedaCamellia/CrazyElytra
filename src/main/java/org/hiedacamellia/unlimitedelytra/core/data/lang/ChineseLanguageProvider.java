package org.hiedacamellia.unlimitedelytra.core.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.unlimitedelytra.UnlimitedElytra;

public class ChineseLanguageProvider extends LanguageProvider {

    public ChineseLanguageProvider(PackOutput output) {
        super(output, UnlimitedElytra.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add("mod.unlimitedelytra", "无限鞘翅");
        add("config.unlimitedelytra.title", "无限鞘翅 配置");
        add("config.unlimitedelytra.enableelytra", "启用无限鞘翅");
        add("config.unlimitedelytra.enableelytra.desc", "如果为true，则无限鞘翅将启用");
        add("config.unlimitedelytra.airresistance", "空气阻力");
        add("config.unlimitedelytra.infinitefireworkacceleration", "启用烟花的无限加速");
        add("config.unlimitedelytra.infinitefireworkacceleration.desc", "如果为true，则玩家可以被烟花无限加速");
        add("config.unlimitedelytra.fireworkacceleration", "烟花的加速度");
        add("config.unlimitedelytra.comfirm", "确认");
    }
}