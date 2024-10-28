package net.mymod121.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mymod121.MyMod;
import net.mymod121.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup SUS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MyMod.MOD_ID, "sus_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SUS_ITEM))
                    .displayName(Text.translatable("itemgroup.mymod121.sus_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SUS_ITEM);
                        entries.add(ModItems.SUS_STICK);
                        //entries.add(Mod.SUS_ORE);
                    }).build());

    public static final ItemGroup SUS_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MyMod.MOD_ID, "sus_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.SUS_BLOCK))
                    .displayName(Text.translatable("itemgroup.mymod121.sus_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.SUS_BLOCK);
                    }).build());


    public static void registerItemGroups() {
        MyMod.LOGGER.info("Registering Item Groups for " + MyMod.MOD_ID);
    }
}
