package mod.dayz.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.EntityDamageSourceIndirect;

/*    */ public class DamageSourceBullet extends EntityDamageSourceIndirect
/*    */ {
/*    */   public Entity shooter;
/*    */   public String gunName;
/*    */ 
/*    */   public DamageSourceBullet(String s, Entity entity, Entity player, String gunname)
/*    */   {
/* 19 */     super(s, entity, player);
/* 20 */     this.shooter = player;
/* 21 */     this.gunName = gunname;
		   }
		}