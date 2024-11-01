package net.mymod121.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.mymod121.MyMod;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterial {
    public static final int SUS_ARMOR_MULTIPLIER = 15;
    public static final RegistryEntry<ArmorMaterial> SUS = registerMaterial("sus",
            Map.of(
                    ArmorItem.Type.HELMET, 3,
                    ArmorItem.Type.CHESTPLATE, 7,
                    ArmorItem.Type.LEGGINGS, 5,
                    ArmorItem.Type.BOOTS, 2
            ),
            12,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            () -> Ingredient.ofItems(ModItems.SUS_INGOT),
            1.5f,
            0.2f,
            false);

    public static void init(){}

    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints,
                                                                int enchantability, RegistryEntry<SoundEvent> equipSound,
                                                                Supplier<Ingredient> repairIngredientSupplier, float toughness,
                                                                float knockbackResistance, boolean dyeable) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(Identifier.of(MyMod.MOD_ID, id), "", dyeable)
        );
        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier,
                layers, toughness, knockbackResistance);
        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(MyMod.MOD_ID, id), material);

        return RegistryEntry.of(material);

    }
}
