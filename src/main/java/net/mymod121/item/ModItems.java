package net.mymod121.item;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mymod121.MyMod;
import net.mymod121.item.ModArmorMaterial;

import java.util.List;

public class ModItems {
    public static final Item SUS_ITEM = registerItem("sus_item", new Item(new Item.Settings()));
    public static final Item SUS_STICK = registerItem("sus_stick", new SusStick(new Item.Settings()));
    public static final Item SUS_INGOT = registerItem("sus_ingot", new SusIngot(new Item.Settings()));

    public static final Item SUS_SWORD = registerItem("sus_sword", new SwordItem(SusMaterial.INSTANCE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(SusMaterial.INSTANCE, 3, -2.4f))));
    public static final Item SUS_HELMET = registerItem("sus_helmet", new ArmorItem(ModArmorMaterial.SUS, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(ModArmorMaterial.SUS_ARMOR_MULTIPLIER))));
    public static final Item SUS_CHESTPLATE = registerItem("sus_chestplate", new ArmorItem(ModArmorMaterial.SUS, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(ModArmorMaterial.SUS_ARMOR_MULTIPLIER))));
    public static final Item SUS_LEGGINGS = registerItem("sus_leggings", new ArmorItem(ModArmorMaterial.SUS, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(ModArmorMaterial.SUS_ARMOR_MULTIPLIER))));
    public static final Item SUS_BOOTS = registerItem("sus_boots", new ArmorItem(ModArmorMaterial.SUS, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(ModArmorMaterial.SUS_ARMOR_MULTIPLIER))));

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
