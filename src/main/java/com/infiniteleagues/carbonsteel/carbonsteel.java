
package com.infiniteleagues.carbonsteel;

import com.infiniteleagues.carbonsteel.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("carbonsteel")
public class carbonsteel {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "carbonsteel";

    public carbonsteel() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        RegistryHandler.Init();
        MinecraftForge.EVENT_BUS.register(this);
    }




    private void setup(final FMLCommonSetupEvent event){

    }
    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    public static final ItemGroup TAB = new ItemGroup("CarbonSteelTab"){
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.CARBON_STEEL_INGOT.get());
        }
    };



}
