package net.archman609.culturesmod;

import net.archman609.culturesmod.entity.ModEntities;
import net.archman609.culturesmod.entity.client.StoneGuyModel;
import net.archman609.culturesmod.entity.client.StoneGuyRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class CulturesModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(StoneGuyModel.STONEGUY, StoneGuyModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.STONEGUY, StoneGuyRenderer::new);
    }
}
