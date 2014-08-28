package mod.dayz;

import mod.dayz.event.EventHook;
import mod.dayz.item.EnumFireMode;
import mod.dayz.item.ItemAmmo;
import mod.dayz.item.ItemGunAuto;
import mod.dayz.item.ItemGunSemi;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "dayz", name = "DayZ", version = "1.0")
public class DayZ 
{
	
	public static Item m9;
	public static Item m9ammo;
	public static Item m4;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		m9 = new ItemGunSemi(5000, 1F, 2, 3, 64, 6, EnumFireMode.SEMI, 12).setUnlocalizedName("m9").setCreativeTab(CreativeTabs.tabCombat);
		m9ammo = new ItemAmmo(5001).setUnlocalizedName("m9ammo").setCreativeTab(CreativeTabs.tabCombat);
		m4 = new ItemGunAuto(5002, 1.5F, 30, 7, 80, 7, EnumFireMode.AUTO, 0).setUnlocalizedName("m4").setCreativeTab(CreativeTabs.tabCombat);
		LanguageRegistry.addName(m9, "M9");
		LanguageRegistry.addName(m9ammo, "M9 Ammo");
		LanguageRegistry.addName(m4, "M4");
	}

}
