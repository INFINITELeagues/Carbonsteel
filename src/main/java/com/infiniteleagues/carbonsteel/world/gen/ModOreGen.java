package com.infiniteleagues.carbonsteel.world.gen;

import com.infiniteleagues.carbonsteel.carbonsteel;
import com.infiniteleagues.carbonsteel.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = carbonsteel.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {

            //Nether Generation
            if (biome.getCategory() == Biome.Category.NETHER) {
                genOre(biome, 0, 0, 0, 0, OreFeatureConfig.FillerBlockType.NETHERRACK, RegistryHandler.CARBON_STEEL_ORE.get().getDefaultState(),0);
                //World Generation
            } else {
                genOre(biome, 5, 2, 5, 55, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.CARBON_STEEL_ORE.get().getDefaultState(),5);
                genOre(biome, 5, 2, 5, 55, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.RANDALIUM_ORE.get().getDefaultState(),5);
                genOre(biome, 1, 2, 5, 55, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.ARKALLIUM_ORE.get().getDefaultState(),3);
            }
        }
    }

    private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockstate, int size) {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockstate, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }
}
