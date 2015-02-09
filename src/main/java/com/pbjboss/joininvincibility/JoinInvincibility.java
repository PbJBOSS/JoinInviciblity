package com.pbjboss.joininvincibility;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Level;

/**
 * Created by Nico on 2/8/2015.
 */
@Mod(modid=JoinInvincibility.modid, name = JoinInvincibility.name, version = JoinInvincibility.version)
public
class JoinInvincibility
{
    public static final String modid = "joininvincibility";
    public static final String name = "JoinInvincibility";
    public static final String version = "1.7.10-1.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.load(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new EventHandler());
        FMLLog.log(Level.INFO,"JoinInviciblity pre-init complete!");
        FMLLog.log(Level.INFO, String.format("Join Invincibility time set to %s seconds",ConfigurationHandler.joinInvicibility));
    }
}
