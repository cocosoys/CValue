/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.passive.EntityVillager;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class EntityAITradePlayer
/*    */   extends EntityAIBase {
/*    */   private EntityVillager field_75276_a;
/*    */   private static final String __OBFID = "CL_00001617";
/*    */   
/*    */   public EntityAITradePlayer(EntityVillager p_i1658_1_) {
/* 13 */     this.field_75276_a = p_i1658_1_;
/* 14 */     func_75248_a(5);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 19 */     if (!this.field_75276_a.func_70089_S()) return false; 
/* 20 */     if (this.field_75276_a.func_70090_H()) return false; 
/* 21 */     if (!this.field_75276_a.field_70122_E) return false; 
/* 22 */     if (this.field_75276_a.field_70133_I) return false;
/*    */     
/* 24 */     EntityPlayer entityPlayer = this.field_75276_a.func_70931_l_();
/* 25 */     if (entityPlayer == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     if (this.field_75276_a.func_70068_e((Entity)entityPlayer) > 16.0D)
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     if (!(entityPlayer.field_71070_bA instanceof net.minecraft.inventory.Container))
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 45 */     this.field_75276_a.func_70661_as().func_75499_g();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 50 */     this.field_75276_a.func_70932_a_(null);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAITradePlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */