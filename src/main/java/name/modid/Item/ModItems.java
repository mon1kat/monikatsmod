package name.modid.Item;

import name.modid.Monikatsmod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item STUPID_WAND = regiterItem("stupid_wand", new Item(new Item.Settings().maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Monikatsmod.MOD_ID,"stupid_wand")))));

    private static Item regiterItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Monikatsmod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Monikatsmod.LOGGER.info("Items from " + Monikatsmod.MOD_ID + " are loading");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(STUPID_WAND);
        });
    }

}
