package com.pbjboss.joininvincibility;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

/**
 * Created by Nico on 2/8/2015.
 */
public
class EventHandler
{
    @SubscribeEvent
    public void damageEvent(LivingHurtEvent event)
    {
        if (event.entity instanceof EntityPlayer && event.entity.ticksExisted <= ConfigurationHandler.joinInvicibility * 20)
        {
            event.setCanceled(true);
        }
    }
}
