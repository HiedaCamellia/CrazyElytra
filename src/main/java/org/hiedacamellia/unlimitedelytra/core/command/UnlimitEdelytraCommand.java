package org.hiedacamellia.unlimitedelytra.core.command;


import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import org.hiedacamellia.unlimitedelytra.core.config.Config;

public class UnlimitEdelytraCommand {
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
                .then(Commands.literal("unlimitedelytra").then(Commands.argument("value", BoolArgumentType.bool())).executes(ctx -> {
                    Config.EnableElytra.set(BoolArgumentType.getBool(ctx, "value"));
                    return 0;
                }))
        );
    }
}
