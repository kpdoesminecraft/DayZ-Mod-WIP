package mod.dayz.item;

import java.sql.Time;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mod.dayz.Controls;
import mod.dayz.delay.ClientTickHandler;
import mod.dayz.entity.EntityBullet;
import mod.dayz.event.EventHook;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Timer;
import net.minecraft.world.World;

public class ItemGunSemi extends Item 
{
	
	public float recoil;
	private boolean isGunFired;
	public EnumFireMode fireMode;
	public static int ammoAmount;
	private boolean canShoot;
	public int fireDelay;
	public float accuracy;
	public int damage;
	public float velocity;
	public double speed;
	private int tickReload;
	public float reloadDelay;
	private ItemStack itemInUse;
	private int itemInUseCount;
	private static boolean lastTriggerHeld;
	private static boolean triggerHeld;
	private World world;
	private EntityPlayer player;

	public ItemGunSemi(int par1, float recoil, int ammoAmount, int damage, float velocity, double speed, EnumFireMode fireMode, int fireDelay) 
	{
		super(par1);
		this.recoil = recoil;
		this.ammoAmount = ammoAmount;
		this.damage = damage;
		this.velocity = velocity;
		this.speed = speed;
		this.fireMode = fireMode;
		this.fireDelay = fireDelay;
	}
	
	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		int timeElapsed;
	}
	
	public float getReloadDelay(ItemStack stack) 
	{
		return reloadDelay;
	}
	
	private int getAmmo(ItemStack stack) {
		NBTTagCompound tag = getNBTTagCompound(stack);
		int par1 = 0;
		int par2 = 0;
		
		if (tag.hasKey("gunAmmo"))
		{
			par2 = tag.getInteger("gunAmmo");
		}
		
		tag.setInteger("gunAmmo", this.ammoAmount + par1);
		par2 = tag.getInteger("gunAmmo");
		
		return par2;
	}

	public NBTTagCompound getNBTTagCompound(ItemStack itemstack)
	{
	if (!itemstack.hasTagCompound())
	{
	    itemstack.stackTagCompound = new NBTTagCompound("tag");
	}
	if (!itemstack.stackTagCompound.hasKey("gun"))
	{
		NBTTagCompound tag = new NBTTagCompound("gun");
	    itemstack.stackTagCompound.setTag("gun", tag);
	}
		return (NBTTagCompound)itemstack.stackTagCompound.getTag("gun");
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (getAmmo(stack) > 0)
		{
			delayShot(fireDelay);
			recoil();
			world.spawnEntityInWorld(new EntityBullet(world, player, damage, velocity, speed));
		}
		return stack;
	}

	
	public void setAmmo(ItemStack itemstack, int amount)
	
		{
		NBTTagCompound tag = getNBTTagCompound(itemstack);

		if (tag.hasKey("gunAmmo"))
		{
			tag.removeTag("gunAmmo");
		}
	
		tag.setInteger("gunAmmo", this.ammoAmount);
	}

	private int getDamage() 
	{
		return damage;
	}

	public void recoil()
	{
		Minecraft mc = FMLClientHandler.instance().getClient();
		
		mc.thePlayer.renderArmPitch -= recoil * 40F;
		mc.thePlayer.renderArmYaw += recoil * 5F;
	}
	
	public boolean isShot()
	{
		boolean status = onItemRightClick(null, null, null) != null;
		if(status = true)
		{
			return true;
		}
		else if(status = false)
		{
			return false;
		}
		return status;
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{

		return true;
	}
	
	public void delayShot(int delay)
	{
		int tickssinceshot = delay;

		if(tickssinceshot >= 0)
		{
			tickssinceshot = 4;
		}
		else 
		{
			-- tickssinceshot;
		}
	}
    
}