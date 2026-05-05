/*    */ package net.minecraft.util;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class EntityDamageSourceIndirect
/*    */   extends EntityDamageSource
/*    */ {
/*    */   private Entity field_76387_p;
/*    */   private static final String __OBFID = "CL_00001523";
/*    */   
/*    */   public EntityDamageSourceIndirect(String p_i1568_1_, Entity p_i1568_2_, Entity p_i1568_3_) {
/* 14 */     super(p_i1568_1_, p_i1568_2_);
/* 15 */     this.field_76387_p = p_i1568_3_;
/*    */   }
/*    */ 
/*    */   
/*    */   public Entity func_76364_f() {
/* 20 */     return this.field_76386_o;
/*    */   }
/*    */ 
/*    */   
/*    */   public Entity func_76346_g() {
/* 25 */     return this.field_76387_p;
/*    */   }
/*    */ 
/*    */   
/*    */   public IChatComponent func_151519_b(EntityLivingBase p_151519_1_) {
/* 30 */     IChatComponent iChatComponent = (this.field_76387_p == null) ? this.field_76386_o.func_145748_c_() : this.field_76387_p.func_145748_c_();
/* 31 */     ItemStack itemStack = (this.field_76387_p instanceof EntityLivingBase) ? ((EntityLivingBase)this.field_76387_p).func_70694_bm() : null;
/* 32 */     String str1 = "death.attack." + this.field_76373_n;
/* 33 */     String str2 = str1 + ".item";
/*    */     
/* 35 */     if (itemStack != null && itemStack.func_82837_s() && StatCollector.func_94522_b(str2)) {
/* 36 */       return new ChatComponentTranslation(str2, new Object[] { p_151519_1_.func_145748_c_(), iChatComponent, itemStack.func_151000_E() });
/*    */     }
/* 38 */     return new ChatComponentTranslation(str1, new Object[] { p_151519_1_.func_145748_c_(), iChatComponent });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\EntityDamageSourceIndirect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */