package com.kookykraftmc.bungee.utils;


import com.kookykraftmc.bungee.CatBungee;

import java.util.logging.Level;


public class LogUtil {

    public static void LogToConsole(String msg, Level level) {
        CatBungee.getPlugin().getLogger().log(level, msg);
    }

}
