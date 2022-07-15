package com.asklat.gw2_bot;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

/**
 *
 * @author algam
 */
public class Gw2_bot {

    public static void main(String[] args) throws LoginException {
        final String BOT_TOKEN = "OTkxNjQ4ODcyNTY2ODk0NjQ0.GidKt5.pDl4N57vEPpf1ISii2qM7KTSXkJKwE4X1_EeJ8";
        JDA api = JDABuilder.createDefault(BOT_TOKEN).setActivity(Activity.playing("Guild Wars 2")).build();
        api.addEventListener(new MyListener());
    }
}
