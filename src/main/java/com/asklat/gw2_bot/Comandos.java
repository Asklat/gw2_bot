package com.asklat.gw2_bot;

import com.asklat.gw2_bot.Objects.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.MessageChannel;

/**
 *
 * @author algam
 */
public class Comandos {
    private MessageChannel channel;
    public Comandos(MessageChannel channel){
        this.channel = channel;
    }
    
    public void ping(){
        channel.sendMessage("pong!").queue();
    }
    
    public void queryGuildUpdates(){
        String format;
        Item[] ls = null;
        try {
            ls = ConnectionClass.getMateriales(getIdGuild());
        } catch (Exception ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(ls == null){
            format = "Se produjo un error.";
        }else{
            format = "Materiales necesarios para las mejoras de clan: \n\n";
            for (Item l : ls) {
                format += "Nombre: " + l.getName() + "\n";
                format += "Cantidad actual: " + l.getCount()+ "\n";
                format += "Meta: " + l.getCountNeed()+ "\n";
                format += "Cantidad necesaria: " + l.getCountTotal()+ "\n";
                format += "\n";
            }
        }
        channel.sendMessage(format).queue();
    }
    
    public void saveGuild(String apikey){
        String a = "";
        try {
            a = ConnectionClass.saveGuild(getIdGuild(),apikey);
        } catch (Exception ex) {
            a = "Error inesperado";
        }
        channel.sendMessage(a).queue();
    }
    
    private String getIdGuild(){
        String idDc = "";
        List<Guild> lg = channel.getJDA().getGuilds();
        for (Guild g : lg) {
            List<GuildChannel> lc = g.getChannels();
            for (GuildChannel l: lc) {
                if(l.getId().equals(channel.getId())){
                    idDc = l.getGuild().getId();
                    break;
                }
            }
            if(!idDc.equals("")){
                break;
            }
        }
        return idDc;
    }
}
