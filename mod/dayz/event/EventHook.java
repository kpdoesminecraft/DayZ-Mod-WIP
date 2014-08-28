package mod.dayz.event;

import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.common.TickType;

public class EventHook {
	
	public static int delay = 0;

	
	@ForgeSubscribe
	public void onTick(TickType event)
	{
		if (event.CLIENT == TickType.CLIENT && event.RENDER == TickType.RENDER)
		{
			if(delay > 0)
			{
				delay --;
			}
			
		}
		
	}

}
