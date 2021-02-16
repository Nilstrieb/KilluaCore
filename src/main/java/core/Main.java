package core;

import cofig.Config;
import commands.info.HelpCommand;
import commands.info.InviteCommand;
import core.command.CommandListener;
import core.reactions.ReactionEventListener;
import core.sections.ChannelMessageListener;
import listener.StartUpListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.Compression;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault("THE TOKEN, get it from somewhere safe");
        builder.setCompression(Compression.ZLIB);
        builder.setActivity(Activity.watching("over Gon"));

        builder.addEventListeners(
                new StartUpListener(),
                new ChannelMessageListener(),
                new CommandListener(),
                new ReactionEventListener()
        );

        JDA jda = builder.build();
        setupCommands();
        Config.setJda(jda);
    }

    private static void setupCommands() {
        new HelpCommand();
        new InviteCommand();
    }
}
