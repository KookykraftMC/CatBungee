package com.kookykraftmc.bungee.config;

import com.kookykraftmc.bungee.CatBungee;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.*;
import java.nio.file.Files;

public class BungeeConfigManager {

    private static BungeeConfigManager instance = new BungeeConfigManager();
    private static Plugin p = CatBungee.getPlugin();

    //config files
    File conigFile;
    File messagesFile;
    File playersFile;
    File catbotFile;

    //configs
    private Configuration config;
    private Configuration messages;
    private Configuration players;
    private Configuration catbot;

    public BungeeConfigManager() {

    }

    public static BungeeConfigManager getInstance() {
        return instance;
    }

    public void setup() {

        if (!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }

        //load our config files
        conigFile = new File(p.getDataFolder(), "config.yml");
        messagesFile = new File(p.getDataFolder(), "messages.yml");
        playersFile = new File(p.getDataFolder(), "players.yml");
        catbotFile = new File(p.getDataFolder(), "catbot.yml");

        if (!conigFile.exists()) {
            loadFile("config.yml");
        }

        if (!messagesFile.exists()) {
            loadFile("messages.yml");
        }

        if(!playersFile.exists()) {
            //create an empty file that we can use later
            try {
                playersFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!catbotFile.exists()) {
            loadFile("catbot.yml");
        }

        //finally we load our config file
        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(conigFile);
            messages = ConfigurationProvider.getProvider(YamlConfiguration.class).load(messagesFile);
            players = ConfigurationProvider.getProvider(YamlConfiguration.class).load(playersFile);
            catbot = ConfigurationProvider.getProvider(YamlConfiguration.class).load(catbotFile);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void loadFile(String file) {

        File t = new File(p.getDataFolder(), file);

        try {
            InputStream in = p.getResourceAsStream(file);
            Files.copy(in, t.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
