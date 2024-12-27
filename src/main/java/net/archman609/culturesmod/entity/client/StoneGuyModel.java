package net.archman609.culturesmod.entity.client;

import net.archman609.culturesmod.CulturesMod;
import net.archman609.culturesmod.entity.custom.StoneGuyEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class StoneGuyModel<T extends StoneGuyEntity> extends SinglePartEntityModel<T> {

	public static final EntityModelLayer STONEGUY = new EntityModelLayer(Identifier.of(CulturesMod.MOD_ID, "stoneguy"), "main");


	private final ModelPart wholestoneguy;
	private final ModelPart legs;
	private final ModelPart leftleg;
	private final ModelPart rightleg;
	private final ModelPart upperbody;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart arms;
	private final ModelPart leftarm;
	private final ModelPart rightarm;

	public StoneGuyModel(ModelPart root) {
		this.wholestoneguy = root.getChild("wholestoneguy");
		this.legs = this.wholestoneguy.getChild("legs");
		this.leftleg = this.legs.getChild("leftleg");
		this.rightleg = this.legs.getChild("rightleg");
		this.upperbody = this.wholestoneguy.getChild("upperbody");
		this.head = this.upperbody.getChild("head");
		this.body = this.upperbody.getChild("body");
		this.arms = this.upperbody.getChild("arms");
		this.leftarm = this.arms.getChild("leftarm");
		this.rightarm = this.arms.getChild("rightarm");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData wholestoneguy = modelPartData.addChild("wholestoneguy", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 13.0F, 0.0F));

		ModelPartData legs = wholestoneguy.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData leftleg = legs.addChild("leftleg", ModelPartBuilder.create().uv(0, 22).cuboid(-2.0F, -2.0F, -3.0F, 4.0F, 7.0F, 6.0F, new Dilation(-0.001F)), ModelTransform.pivot(4.0F, 0.0F, 0.0F));

		ModelPartData rightleg = legs.addChild("rightleg", ModelPartBuilder.create().uv(20, 22).cuboid(-2.0F, -2.0F, -3.0F, 4.0F, 7.0F, 6.0F, new Dilation(-0.001F)), ModelTransform.pivot(-4.0F, 0.0F, 0.0F));

		ModelPartData upperbody = wholestoneguy.addChild("upperbody", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

		ModelPartData head = upperbody.addChild("head", ModelPartBuilder.create().uv(0, 34).cuboid(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.5F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData body = upperbody.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -6.0F, -5.0F, 12.0F, 12.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, 0.0F));

		ModelPartData arms = upperbody.addChild("arms", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.0F, 0.0F));

		ModelPartData leftarm = arms.addChild("leftarm", ModelPartBuilder.create(), ModelTransform.pivot(6.0F, -1.0F, 0.0F));

		ModelPartData leftarm_r1 = leftarm.addChild("leftarm_r1", ModelPartBuilder.create().uv(20, 33).cuboid(-1.5F, 0.25F, -1.5F, 3.0F, 15.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -1.0F, 0.0F, 0.0F, 0.0F, -0.1265F));

		ModelPartData rightarm = arms.addChild("rightarm", ModelPartBuilder.create(), ModelTransform.pivot(-6.0F, -1.0F, 0.0F));

		ModelPartData rightarm_r1 = rightarm.addChild("rightarm_r1", ModelPartBuilder.create().uv(32, 33).cuboid(-1.5F, 0.25F, -1.5F, 3.0F, 15.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -1.0F, 0.0F, 3.1416F, 0.0F, -3.0151F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(StoneGuyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(StoneGuyAnimation.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, StoneGuyAnimation.IDLE, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		wholestoneguy.render(matrices, vertexConsumer, light, overlay, color);
	}

	@Override
	public ModelPart getPart() {
		return wholestoneguy;
	}
}