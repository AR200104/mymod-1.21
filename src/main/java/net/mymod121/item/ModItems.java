package net.mymod121.item;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mymod121.MyMod;

import java.util.List;

public class ModItems {

    public static final Item SUS_ITEM = registerItem("sus_item", new Item(new Item.Settings()));
    public static final Item SUS_STICK = registerItem("sus_stick", new SusStick(new Item.Settings()));
    public static final Item SUS_INGOT = registerItem("sus_ingot", new SusIngot(new Item.Settings()));
    public static final Item SUS_SWORD = registerItem("sus_sword", new SwordItem(SusMaterial.INSTANCE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(SusMaterial.INSTANCE, 3, -2.4f))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MyMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MyMod.LOGGER.info("Registering Mod Items for " + MyMod.MOD_ID);

        FuelRegistry.INSTANCE.add(ModItems.SUS_ITEM, 30*20);
        new Item.Settings().food(new FoodComponent.Builder()
                .nutrition(6)
                .saturationModifier(7)
                .build());

    }
}
