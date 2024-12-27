package net.archman609.culturesmod.entity;

import net.archman609.culturesmod.CulturesMod;
import net.archman609.culturesmod.entity.custom.StoneGuyEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<StoneGuyEntity> STONEGUY= Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(CulturesMod.MOD_ID, "stoneguy"),
            EntityType.Builder.create(StoneGuyEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 1f).build());



    public static void registerModEntities () {
        CulturesMod.LOGGER.info("Registering Mod Entities for " + CulturesMod.MOD_ID);
    }

}
