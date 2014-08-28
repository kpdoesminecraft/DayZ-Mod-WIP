package mod.dayz.entity;

import java.util.List;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
	
public class EntityBullet extends EntityThrowable
{
	
	public float damage;
	public float velocity;

	public EntityBullet(World par1World, EntityLivingBase par2EntityLivingBase, float damage, float velocity, double speed) 
	{
		super(par1World, par2EntityLivingBase);
		this.damage = damage;
		this.velocity = velocity;
		this.motionX *= speed;
		this.motionY *= speed;
		this.motionZ *= speed;
	}

	@Override
	protected void onImpact(MovingObjectPosition mop) 
	{
		if (mop.entityHit != null) {

			float damage = this.damage;

			mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
			}
		
			if (!worldObj.isRemote) {
			setDead();
		}
	}
	
	@Override
	protected float getGravityVelocity() 
	{
		return 0;
	}
	
}
