package org.hiedacamellia.crazyelytra.core.command;


import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import org.hiedacamellia.crazyelytra.core.config.Config;

public class CrazyEdelytraCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("gamerule").requires((sourceStack) -> sourceStack.hasPermission(3))
                .then(Commands.literal("airresistance").then(Commands.argument("value", DoubleArgumentType.doubleArg()).executes(ctx -> {
                    Config.AirResistance.set(DoubleArgumentType.getDouble(ctx, "value"));
                    return 0;
                })))
                .then(Commands.literal("fireworkacceleration").then(Commands.argument("value", DoubleArgumentType.doubleArg()).executes(ctx -> {
                    Config.FireWorkAcceleration.set(DoubleArgumentType.getDouble(ctx, "value"));
                    return 0;
                })))
                .then(Commands.literal("crazyelytra").then(Commands.argument("value", BoolArgumentType.bool())).executes(ctx -> {
                    Config.EnableElytra.set(BoolArgumentType.getBool(ctx, "value"));
                    return 0;
                }))
        );
    }
}
