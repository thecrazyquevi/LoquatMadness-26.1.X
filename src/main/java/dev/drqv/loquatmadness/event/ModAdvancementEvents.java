package dev.drqv.loquatmadness.event;

import dev.drqv.loquatmadness.LoquatMadness;
import dev.drqv.loquatmadness.item.LoquatMadness_Items; // Tu registro de ítems
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.advancements.AdvancementHolder;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashMap;
import java.util.UUID;

@EventBusSubscriber(modid = LoquatMadness.MOD_ID)
public class ModAdvancementEvents {

    private static final HashMap<UUID, Integer> CONTADOR_NISPEROS = new HashMap<>();
    private static final HashMap<UUID, Integer> TEMPORIZADOR_AMALGAMATION = new HashMap<>();

    @SubscribeEvent
    public static void onFinishEating(LivingEntityUseItemEvent.Finish event) {

        if (!event.getEntity().level().isClientSide() && event.getEntity() instanceof ServerPlayer player) {

            UUID playerUUID = player.getUUID();

            if (event.getItem().is(LoquatMadness_Items.LOQUAT.get())) {

                int cantidadActual = CONTADOR_NISPEROS.getOrDefault(playerUUID, 0) + 1;
                CONTADOR_NISPEROS.put(playerUUID, cantidadActual);

                if (cantidadActual >= 20) {


                    if (player.level() instanceof ServerLevel serverLevel) {
                        net.minecraft.server.MinecraftServer server = serverLevel.getServer();

                        if (server != null) {
                            AdvancementHolder logro = server.getAdvancements()
                                    .get(Identifier.fromNamespaceAndPath("loquatmadness", "main/eat_twenty_loquats"));

                            if (logro != null) {

                                player.getAdvancements().award(logro, "consume_twenty_times");
                            }
                        }
                    }
                }
            }

            if (event.getItem().is(LoquatMadness_Items.LOQUATNITIAN_AMALGAMATION.get())) {
                TEMPORIZADOR_AMALGAMATION.put(playerUUID, 1);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            UUID playerUUID = player.getUUID();

            if (TEMPORIZADOR_AMALGAMATION.containsKey(playerUUID)) {
                int ticksPasados = TEMPORIZADOR_AMALGAMATION.get(playerUUID);

                if (ticksPasados >= 200) {
                    TEMPORIZADOR_AMALGAMATION.remove(playerUUID);

                    if (player.level() instanceof ServerLevel serverLevel) {
                        net.minecraft.server.MinecraftServer server = serverLevel.getServer();

                        if (server != null) {
                            AdvancementHolder logro = server.getAdvancements()
                                    .get(Identifier.fromNamespaceAndPath("loquatmadness", "main/survive_amalgamation"));

                            if (logro != null) {

                                player.getAdvancements().award(logro, "survived_ten_seconds");
                            }
                        }
                    }
                } else {
                    TEMPORIZADOR_AMALGAMATION.put(playerUUID, ticksPasados + 1);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            TEMPORIZADOR_AMALGAMATION.remove(player.getUUID());
        }
    }
}