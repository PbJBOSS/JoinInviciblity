package com.pbjboss.joininvincibility;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

import java.io.File;

/**
 * Created by Nico on 2/8/2015.
 */
public
class ConfigurationHandler
{
    public static int joinInvicibility;
    public static Configuration config;

    public static void load(File file)
    {
        config = new Configuration(file);

        try
        {
            config.load();

            joinInvicibility = config.getInt("invicibilityTime",Configuration.CATEGORY_GENERAL, 30, 0,300,"Time of player invincibility on joining in seconds");
        }
        catch (Exception e)
        {
            FMLLog.log(Level.ERROR, "Error Loading Configuration!");
        }
        finally
        {
            if (config.hasChanged())
            {
                config.save();
            }
        }
    }
}
