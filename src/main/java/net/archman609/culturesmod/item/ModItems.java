package net.archman609.culturesmod.item;

import net.archman609.culturesmod.CulturesMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item COINIUM = registerItem("coinium", new Item(new Item.Settings()));
    public static final Item COINIUM_ORE = registerItem("coinium_ore", new Item(new Item.Settings()));



    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(CulturesMod.MOD_ID, name), item);
    }



    public static void registerModItems() {

        CulturesMod.LOGGER.info("Registering Mod items for "+ CulturesMod.MOD_ID);


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(COINIUM);
            fabricItemGroupEntries.add(COINIUM_ORE);
        });


    }
}