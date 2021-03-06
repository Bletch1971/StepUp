package com.nottoomanyitems.stepup;

import com.nottoomanyitems.stepup.config.Configuration;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

import com.nottoomanyitems.stepup.Client.ClientProxy;
import com.nottoomanyitems.stepup.Server.ServerProxy;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

@Mod(StepUp.MODID)
@EventBusSubscriber(modid = StepUp.MODID, bus = Bus.MOD)
public final class StepUp {
    public static final String MODID = "stepup";
  
	public static final String MOD_VERSION = "1.16.4-0.2.0";
	public static final String MOD_NAME = "StepUp";
	
	public static final StepUpProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
	
	public StepUp() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Configuration.CLIENT_SPEC);
    }
	
	@SubscribeEvent
	public static void onConfigLoading(final ModConfig.Loading e){
	}
	
	@SubscribeEvent
	public static void onLoadComplete(final FMLLoadCompleteEvent e){
		proxy.onLoaded(e);
	}
}
