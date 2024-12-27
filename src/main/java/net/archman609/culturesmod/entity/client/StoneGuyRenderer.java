package net.archman609.culturesmod.entity.client;

import net.archman609.culturesmod.CulturesMod;
import net.archman609.culturesmod.entity.custom.StoneGuyEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class StoneGuyRenderer extends MobEntityRenderer<StoneGuyEntity, StoneGuyModel<StoneGuyEntity>> {
    public StoneGuyRenderer(EntityRendererFactory.Context context) {
        super(context, new StoneGuyModel<>(context.getPart(StoneGuyModel.STONEGUY)), 0.75f);
    }

    @Override
    public Identifier getTexture(StoneGuyEntity entity) {
        return Identifier.of(CulturesMod.MOD_ID, "textures/entity/stoneguy/stoneguy.png");
    }

    @Override
    public void render(StoneGuyEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}

