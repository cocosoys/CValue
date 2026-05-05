/*    */ package net.minecraft.util;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class EntityDamageSource
/*    */   extends DamageSource
/*    */ {
/*    */   protected Entity field_76386_o;
/*    */   private static final String __OBFID = "CL_00001522";
/*    */   
/*    */   public EntityDamageSource(String p_i1567_1_, Entity p_i1567_2_) {
/* 15 */     super(p_i1567_1_);
/* 16 */     this.field_76386_o = p_i1567_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   public Entity func_76346_g() {
/* 21 */     return this.field_76386_o;
/*    */   }
/*    */ 
/*    */   
/*    */   public IChatComponent func_151519_b(EntityLivingBase p_151519_1_) {
/* 26 */     ItemStack itemStack = (this.field_76386_o instanceof EntityLivingBase) ? ((EntityLivingBase)this.field_76386_o).func_70694_bm() : null;
/* 27 */     String str1 = "death.attack." + this.field_76373_n;
/* 28 */     String str2 = str1 + ".item";
/*    */     
/* 30 */     if (itemStack != null && itemStack.func_82837_s() && StatCollector.func_94522_b(str2)) {
/* 31 */       return new ChatComponentTranslation(str2, new Object[] { p_151519_1_.func_145748_c_(), this.field_76386_o.func_145748_c_(), itemStack.func_151000_E() });
/*    */     }
/* 33 */     return new ChatComponentTranslation(str1, new Object[] { p_151519_1_.func_145748_c_(), this.field_76386_o.func_145748_c_() });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_76350_n() {
/* 39 */     return (this.field_76386_o != null && this.field_76386_o instanceof EntityLivingBase && !(this.field_76386_o instanceof net.minecraft.entity.player.EntityPlayer));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\EntityDamageSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */