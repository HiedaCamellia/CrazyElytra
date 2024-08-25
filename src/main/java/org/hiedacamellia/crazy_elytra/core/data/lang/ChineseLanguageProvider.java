package org.hiedacamellia.crazy_elytra.core.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.crazy_elytra.CrazyElytra;

public class ChineseLanguageProvider extends LanguageProvider {

    public ChineseLanguageProvider(PackOutput output) {
        super(output, CrazyElytra.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add("mod.crazy_elytra", "疯狂鞘翅");
        add("config.crazy_elytra.title", "疯狂鞘翅 配置");
        add("config.crazy_elytra.enableelytra", "启用疯狂鞘翅");
        add("config.crazy_elytra.enableelytra.desc", "如果为true，则疯狂鞘翅将启用");
        add("config.crazy_elytra.airresistance", "空气阻力");
        add("config.crazy_elytra.enableairresistancewithspeed", "启用速度相关的空气阻力");
        add("config.crazy_elytra.enableairresistancewithspeed.desc", "如果为true，则空气阻力将与速度有关");
        add("config.crazy_elytra.enableairresistancewithheight", "启用高度相关的空气阻力");
        add("config.crazy_elytra.enableairresistancewithheight.desc", "如果为true，则空气阻力将与高度有关");
        add("config.crazy_elytra.infinitefireworkacceleration", "启用烟花的无限加速");
        add("config.crazy_elytra.infinitefireworkacceleration.desc", "如果为true，则玩家可以被烟花无限加速");
        add("config.crazy_elytra.fireworkacceleration", "烟花的加速度");
        add("config.crazy_elytra.comfirm", "确认");
        add("mod.crazy_elytra", "疯狂鞘翅");
        add("enchantment.crazy_elytra.kamikaze_elytra", "神风鞘翅");
        add("deathScreen.title.kamikaze", "目标已摧毁！");
        add("death.attack.explosion.suicide", "");
    }
}