package org.hiedacamellia.crazyelytra.core.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue DEBUG = BUILDER
            .comment("Set to true to enable debug info")
            .comment("设置为true以启用调试信息")
            .define("debug", false);


    public static final ModConfigSpec.BooleanValue EnableElytra = BUILDER
            .comment("Enable the CrazyElytra")
            .comment("启用疯狂鞘翅")
            .define("Enable CrazyElytra", true);

    public static final ModConfigSpec.BooleanValue EnableAirResistanceWithSpeed = BUILDER
            .comment("Enable the air resistance with speed")
            .comment("启用速度相关的空气阻力")
            .define("Enable Air Resistance With Speed", false);

    public static final ModConfigSpec.BooleanValue EnableAirResistanceWithHeight = BUILDER
            .comment("Enable the air resistance with height")
            .comment("启用高度相关的空气阻力")
            .define("Enable Air Resistance With Height", false);

    public static final ModConfigSpec.ConfigValue<Double> AirResistance = BUILDER
            .comment("The air resistance of the elytra")
            .comment("鞘翅的空气阻力")
            .define("Air Resistance", 1.0);

    public static final ModConfigSpec.BooleanValue InfiniteFireWorkAcceleration = BUILDER
            .comment("Enable the infinite acceleration of the firework")
            .comment("启用烟花的无限加速")
            .define("Infinite FireWork Acceleration", false);

    public static final ModConfigSpec.ConfigValue<Double> FireWorkAcceleration = BUILDER
            .comment("The acceleration of the firework")
            .comment("烟花的加速度")
            .define("FireWork Acceleration", 1.0);



    public static final ModConfigSpec SPEC = BUILDER.build();
}

