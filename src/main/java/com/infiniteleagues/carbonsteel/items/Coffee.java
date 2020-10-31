package com.infiniteleagues.carbonsteel.items;

import com.infiniteleagues.carbonsteel.carbonsteel;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Coffee extends Item {
    public Coffee() {
        super(new Properties()
                .group(carbonsteel.TAB)
                .food(new Food.Builder()
                .hunger(4)
                .saturation(1F)
                .effect(new EffectInstance(Effects.LUCK, 400, 5),.5F)
                .effect(new EffectInstance(Effects.SPEED, 400, 5),.5F)
                .effect(new EffectInstance(Effects.STRENGTH, 400, 5),.5F)
                .setAlwaysEdible()
                .build()
                )

        );
    }
}
