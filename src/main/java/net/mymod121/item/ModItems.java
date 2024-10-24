package net.mymod121.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mymod121.MyMod;

public class ModItems {
    public static final Item SUS_ITEM = registerItem("sus_item", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MyMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MyMod.LOGGER.info("Registering Mod Items for " + MyMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SUS_ITEM);
        });
    }

}
