/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asklat.gw2_bot;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 *
 * @author algam
 */
public class MyListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        Comandos cmd = new Comandos(event.getChannel());
        Message message = event.getMessage();
        String content = message.getContentRaw();
        if (content.startsWith("!")) {
            content = content.replace("!","").trim();
            String[] params = content.split(" ");
            switch (params[0]) {
                case "ping":
                    cmd.ping();
                    break;
                case "mejoras":
                    cmd.queryGuildUpdates();
                    break;
                case "apikey":
                    cmd.saveGuild(params[1]);
                    break;
                default:
                    
            }
        }
    }
}
