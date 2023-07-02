package meldexun.nothirium.mc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import meldexun.nothirium.opengl.GLHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Nothirium.MODID, acceptableRemoteVersions = "*", dependencies = "required-after:renderlib@[1.3.1,)")
public class Nothirium {

	public static final String MODID = "nothirium";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static boolean isBetterFoliageInstalled;
	public static boolean isChunkAnimatorInstalled;
	public static boolean isFluidloggedAPIInstalled;
	public static boolean isCubicChunksInstalled;

	@EventHandler
	public void onFMLConstructionEvent(FMLConstructionEvent event) {
		GLHelper.init();

		MinecraftForge.EVENT_BUS.register(this);
	}

	@EventHandler
	public void onFMLPostInitializationEvent(FMLPostInitializationEvent event) {
		isBetterFoliageInstalled = Loader.isModLoaded("betterfoliage");
		isChunkAnimatorInstalled = Loader.isModLoaded("chunkanimator");
		isFluidloggedAPIInstalled = Loader.isModLoaded("fluidlogged_api");
		isCubicChunksInstalled = Loader.isModLoaded("cubicchunks");
	}

	@SubscribeEvent
	public void onConfigChangedEvent(OnConfigChangedEvent event) {
		if (event.getModID().equals(MODID)) {
			ConfigManager.sync(MODID, Config.Type.INSTANCE);
		}
	}

}
