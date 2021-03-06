package com.infiniteleagues.carbonsteel.events;

import com.infiniteleagues.carbonsteel.carbonsteel;
import com.infiniteleagues.carbonsteel.util.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = carbonsteel.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onJumpWithStick(LivingEvent.LivingJumpEvent event) {
        LivingEntity player = event.getEntityLiving();
        if (player.getHeldItemMainhand().getItem() == Items.SUSPICIOUS_STEW) {
            carbonsteel.LOGGER.info("FOODY!");
            World world = player.getEntityWorld();
            world.setBlockState(player.func_233580_cy_().add(0, -1, 0), RegistryHandler.MICROWAVE.get().getDefaultState());
        }
    }

}
