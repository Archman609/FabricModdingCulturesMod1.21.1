package net.archman609.culturesmod;

import net.archman609.culturesmod.entity.ModEntities;
import net.archman609.culturesmod.entity.custom.StoneGuyEntity;
import net.archman609.culturesmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CulturesMod implements ModInitializer {
	public static final String MOD_ID = "culturesmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();

		FabricDefaultAttributeRegistry.register(ModEntities.STONEGUY, StoneGuyEntity.createAttributes());
	}
}