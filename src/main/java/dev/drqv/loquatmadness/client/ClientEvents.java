package dev.drqv.loquatmadness.client;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.block.entity.ModBlockEntities;
import dev.drqv.loquatmadness.client.renderer.LoquatniteArrowRenderer;
import dev.drqv.loquatmadness.entity.LoquatniteArrowEntity;
import dev.drqv.loquatmadness.entity.ModEntities;
import dev.drqv.loquatmadness.registry.ModEntityTypes;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.ShelfRenderer;
import net.minecraft.client.renderer.blockentity.StandingSignRenderer;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.TippableArrowRenderer;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.client.renderer.entity.state.TippableArrowRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = LoquatMadness.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(
                ModBlockEntities.LOQUAT_SIGN.get(),
                StandingSignRenderer::new
        );

        event.registerBlockEntityRenderer(
                ModBlockEntities.LOQUAT_HANGING_SIGN.get(),
                HangingSignRenderer::new
        );

        event.registerBlockEntityRenderer(
                ModBlockEntities.LOQUAT_SHELF.get(),
                ShelfRenderer::new
        );

        event.registerEntityRenderer(ModEntityTypes.LOQUATNITE_ARROW.get(),
                context -> new ArrowRenderer<LoquatniteArrowEntity, TippableArrowRenderState>(context) {


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
                        return Identifier.fromNamespaceAndPath("loquatmadness", "textures/entity/projectiles/loquatnite_arrow.png");
                    }
                }
        );

        event.registerEntityRenderer(ModEntities.LOQUAT_BOAT.get(),
                context -> new BoatRenderer(context,
                        new ModelLayerLocation(Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "boat/loquat"), "main")));

        event.registerEntityRenderer(ModEntities.LOQUAT_CHEST_BOAT.get(),
                context -> new BoatRenderer(context,
                        new ModelLayerLocation(Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "chest_boat/loquat"), "main")));
    }

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(
                new ModelLayerLocation(Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "boat/loquat"), "main"),
                BoatModel::createBoatModel
        );
        event.registerLayerDefinition(
                new ModelLayerLocation(Identifier.fromNamespaceAndPath(LoquatMadness.MOD_ID, "chest_boat/loquat"), "main"),
                BoatModel::createChestBoatModel
        );
    }
}