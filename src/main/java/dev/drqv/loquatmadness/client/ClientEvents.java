package dev.drqv.loquatmadness.client;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.block.entity.ModBlockEntities;
import dev.drqv.loquatmadness.entity.ModEntities;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.ShelfRenderer;
import net.minecraft.client.renderer.blockentity.StandingSignRenderer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.resources.Identifier;
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