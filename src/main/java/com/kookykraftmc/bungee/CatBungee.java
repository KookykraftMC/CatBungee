package com.kookykraftmc.bungee;

import com.kookykraftmc.bungee.config.BungeeConfigManager;
import net.md_5.bungee.api.plugin.Plugin;

public class CatBungee extends Plugin {

    private static CatBungee p;

    @Override
    public void onEnable() {
        p = this;

        //load our config files
        BungeeConfigManager.getInstance().setup();

    }

    public static CatBungee getPlugin() {
        return p;
    }

}
