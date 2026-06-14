package dev.drqv.loquatmadness.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.drqv.loquatmadness.entity.LoquatniteArrowEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.TippableArrowRenderState;
import net.minecraft.resources.Identifier;

public class LoquatniteArrowRenderer extends ArrowRenderer<LoquatniteArrowEntity, TippableArrowRenderState> {

    private static final Identifier TEXTURE =
            Identifier.fromNamespaceAndPath("loquatmadness", "textures/entity/projectiles/loquatnite_arrow.png");

    public LoquatniteArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public TippableArrowRenderState createRenderState() {
        return new TippableArrowRenderState();
    }

    @Override
    public void extractRenderState(LoquatniteArrowEntity entity, TippableArrowRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
    }

    @Override
    public Identifier getTextureLocation(TippableArrowRenderState state) {
        return TEXTURE;
    }
}