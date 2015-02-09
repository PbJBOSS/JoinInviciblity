package com.pbjboss.joininvincibility;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import java.util.List;

/**
 * Created by Nico on 2/8/2015.
 */
public
class EventHandler
{

    @SubscribeEvent
    public void serverTick(TickEvent.ServerTickEvent event)
    {
        List players = MinecraftServer.getServer().getEntityWorld().playerEntities;
        for (int i = 0; i < players.size(); i++)
        {
            EntityPlayer player = (EntityPlayer) players.get(i);
            System.out.println(player.getAge() / 20);
            int invincibilityTimeTicks = ConfigurationHandler.joinInvicibility * 20;
            if (player.getAge() > invincibilityTimeTicks + 2)
                return;

            if (player.getAge() < invincibilityTimeTicks)
            {
                player.capabilities.disableDamage = true;
            }
            else
            {
                player.capabilities.disableDamage = false;
            }
        }
    }
}
