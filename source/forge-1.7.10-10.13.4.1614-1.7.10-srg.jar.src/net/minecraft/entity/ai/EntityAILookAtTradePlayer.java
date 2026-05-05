/*    */ package net.minecraft.entity.ai;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.passive.EntityVillager;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class EntityAILookAtTradePlayer extends EntityAIWatchClosest {
/*    */   private final EntityVillager field_75335_b;
/*    */   
/*    */   public EntityAILookAtTradePlayer(EntityVillager p_i1633_1_) {
/* 11 */     super((EntityLiving)p_i1633_1_, EntityPlayer.class, 8.0F);
/* 12 */     this.field_75335_b = p_i1633_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001593";
/*    */   
/*    */   public boolean func_75250_a() {
/* 17 */     if (this.field_75335_b.func_70940_q()) {
/* 18 */       this.field_75334_a = (Entity)this.field_75335_b.func_70931_l_();
/* 19 */       return true;
/*    */     } 
/* 21 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAILookAtTradePlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */