package net.mymod121.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mymod121.MyMod;

import java.util.List;

public class ModItems {


    //public static final SusMaterial SUS_MATERIAL = new SusMaterial();

    public static final Item SUS_ITEM = registerItem("sus_item", new Item(new Item.Settings()));
    public static final Item SUS_STICK = registerItem("sus_stick", new SusStick(new Item.Settings()));
    public static final Item SUS_INGOT = registerItem("sus_ingot", new SusIngot(new Item.Settings()));
    public static final Item SUS_SWORD = registerItem("sus_sword", new SwordItem(ToolMaterials.DIAMOND, new Item.Settings()));
    //public static final Item WOODEN_SWORD = Items.register("wooden_sword", (Item)new SwordItem(ToolMaterials.WOOD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 3, -2.4f))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MyMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MyMod.LOGGER.info("Registering Mod Items for " + MyMod.MOD_ID);
/*
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SUS_ITEM);
        });

 */
        FuelRegistry.INSTANCE.add(ModItems.SUS_ITEM, 30*20);
        new Item.Settings().food(new FoodComponent.Builder()
                .nutrition(6)
                .saturationModifier(7)
                .build());

    }



}
