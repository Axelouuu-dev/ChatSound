package fr.axelouuu.chatsound;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("chatsound")
public class ChatSound
{
 // Déclarez la variable pour le SoundEvent
    private static final SoundEvent CHAT_NOTIFICATION_SOUND = new SoundEvent(new ResourceLocation("chatsound:chat_notification"));


    public ChatSound() {
	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
        
    }

    private void setup(final FMLClientSetupEvent event) {
        // Ici, vous pouvez mettre en place tout ce qui est nécessaire pour le côté client de votre mod.
    }
    
    @SubscribeEvent
    public void onClientChatReceived(ClientChatReceivedEvent event) {
        // Code pour jouer le son "chatsound:chat_notification" lorsque le client reçoit un nouveau message dans le chat.
	Minecraft mc = Minecraft.getInstance();
        if (mc.player != null) {
            // Code pour jouer le son "chatsound:chat_notification" lorsque le client reçoit un nouveau message dans le chat.
            SoundInstance sound = SimpleSoundInstance.forUI(CHAT_NOTIFICATION_SOUND, 1.0F);
            mc.getSoundManager().play(sound);
        }
    }
    
}
