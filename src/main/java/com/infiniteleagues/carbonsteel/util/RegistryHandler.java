package com.infiniteleagues.carbonsteel.util;


import com.infiniteleagues.carbonsteel.blocks.*;
import com.infiniteleagues.carbonsteel.carbonsteel;
import com.infiniteleagues.carbonsteel.items.Coffee;
import com.infiniteleagues.carbonsteel.items.ItemBase;
import com.infiniteleagues.carbonsteel.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, carbonsteel.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, carbonsteel.MOD_ID);

    public static void Init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //THIS IS FOR ITEMS ONLY
    public static final RegistryObject<Item> CARBON_STEEL_INGOT = ITEMS.register("carbon_steel_ingot", ItemBase::new);
    public static final RegistryObject<Item> RANDALIUM_INGOT = ITEMS.register("randalium_ingot", ItemBase::new);
    public static final RegistryObject<Item> ARKALLIUM = ITEMS.register("arkallium", ItemBase::new);
    public static final RegistryObject<Coffee> COFFEE = ITEMS.register("coffee", Coffee::new);

    //THIS IS FOR BLOCKS ONLY
    public static final RegistryObject<Block> CARBON_STEEL_BLOCK = BLOCKS.register("carbon_steel_block", CarbonSteelBlock::new);
    public static final RegistryObject<Block> CARBON_STEEL_ORE = BLOCKS.register("carbon_steel_ore", CarbonSteelOre::new);
    public static final RegistryObject<Block> ARKALLIUM_ORE = BLOCKS.register("arkallium_ore", ArkalliumOre::new);
    public static final RegistryObject<Block> RANDALIUM_ORE = BLOCKS.register("randalium_ore", RandaliumOre::new);
    public static final RegistryObject<Block> MICROWAVE = BLOCKS.register("microwave", Microwave::new);


    //THIS IS FOR BLOCK ITEM BASE's ONLY
    public static final RegistryObject<Item> CARBON_STEEL_ITEM = ITEMS.register("carbon_steel_block", () -> new BlockItemBase(CARBON_STEEL_BLOCK.get()));
    public static final RegistryObject<Item> CARBON_STEEL_ORE_ITEM = ITEMS.register("carbon_steel_ore", () -> new BlockItemBase(CARBON_STEEL_ORE.get()));
    public static final RegistryObject<Item> ARKALLIUM_ORE_ITEM = ITEMS.register("arkallium_ore", () -> new BlockItemBase(ARKALLIUM_ORE.get()));
    public static final RegistryObject<Item> RANDALIUM_ORE_ITEM = ITEMS.register("randalium_ore", () -> new BlockItemBase(RANDALIUM_ORE.get()));
    public static final RegistryObject<Item> MICROWAVE_ITEM = ITEMS.register("microwave", () -> new BlockItemBase(MICROWAVE.get()));

    // CARBON STEEL TOOLS ONLY
    public static final RegistryObject<SwordItem> CARBON_STEEL_SWORD = ITEMS.register("carbon_steel_sword", () ->
            new SwordItem(ModItemTier.CARBON_STEEL_INGOT, 2, -2.4F,new Item.Properties().group(carbonsteel.TAB)));
    public static final RegistryObject<PickaxeItem> CARBON_STEEL_PICKAXE = ITEMS.register("carbon_steel_pickaxe", () ->
            new PickaxeItem(ModItemTier.CARBON_STEEL_INGOT, 2, -2.4F,new Item.Properties().group(carbonsteel.TAB)));
    public static final RegistryObject<ShovelItem> CARBON_STEEL_SHOVEL = ITEMS.register("carbon_steel_shovel", () ->
            new ShovelItem(ModItemTier.CARBON_STEEL_INGOT, 2, -2.4F,new Item.Properties().group(carbonsteel.TAB)));
    public static final RegistryObject<AxeItem> CARBON_STEEL_AXE = ITEMS.register("carbon_steel_axe", () ->
            new AxeItem(ModItemTier.CARBON_STEEL_INGOT, 2, -2.4F,new Item.Properties().group(carbonsteel.TAB)));



}
