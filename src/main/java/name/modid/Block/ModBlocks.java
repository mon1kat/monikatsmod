package name.modid.Block;

import name.modid.Monikatsmod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block PET_CUSHION = registerBlock("pet_cushion",
            new PetCushionBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Monikatsmod.MOD_ID, "pet_cushion")))
                    .sounds(BlockSoundGroup.WOOL)
                    .dynamicBounds()
                    .nonOpaque()
                    .breakInstantly()));

    // Enables the registration of block items
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Monikatsmod.MOD_ID, "pet_cushion"),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Monikatsmod.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }
    // Enables the registration of blocks
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Monikatsmod.MOD_ID, name), block);
    }

    //spits out a message to the log
    public static void registerModBlocks(){
        Monikatsmod.LOGGER.info(Monikatsmod.MOD_ID + "registering new blocks");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> fabricItemGroupEntries.add(ModBlocks.PET_CUSHION));
    }
}
