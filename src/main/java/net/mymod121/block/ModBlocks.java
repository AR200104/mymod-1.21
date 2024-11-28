package net.mymod121.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.mymod121.MyMod;

public class ModBlocks {
    public static void initialize() {};
    public static final Block SUS_BLOCK = registerBlock(new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).strength(6, 7)),
            "sus_block", true);
    public static final Block SUS_ORE = registerBlock(new SusOre(AbstractBlock.Settings.create().strength(6, 7)),
            "sus_ore", true);

    public static Block registerBlock(Block block, String name, boolean shouldRegisterItem) {
        // Register the block and its item.
        Identifier id = Identifier.of(MyMod.MOD_ID, name);

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }
    public static void registerModBlocks() {
        MyMod.LOGGER.info("Registering Mod Blocks for " + MyMod.MOD_ID);
        /*
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(itemGroup -> {
            itemGroup.add(ModBlocks.SUS_BLOCK);
        });

         */
    }

}
