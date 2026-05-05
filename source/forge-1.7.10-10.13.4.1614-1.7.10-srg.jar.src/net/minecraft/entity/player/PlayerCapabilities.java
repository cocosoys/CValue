/*    */ package net.minecraft.entity.player;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.nbt.NBTBase;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ public class PlayerCapabilities {
/*    */   public boolean field_75102_a;
/*    */   public boolean field_75100_b;
/* 11 */   private float field_75096_f = 0.05F; public boolean field_75101_c; public boolean field_75098_d; public boolean field_75099_e = true;
/* 12 */   private float field_75097_g = 0.1F; private static final String __OBFID = "CL_00001708";
/*    */   
/*    */   public void func_75091_a(NBTTagCompound p_75091_1_) {
/* 15 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*    */     
/* 17 */     nBTTagCompound.func_74757_a("invulnerable", this.field_75102_a);
/* 18 */     nBTTagCompound.func_74757_a("flying", this.field_75100_b);
/* 19 */     nBTTagCompound.func_74757_a("mayfly", this.field_75101_c);
/* 20 */     nBTTagCompound.func_74757_a("instabuild", this.field_75098_d);
/* 21 */     nBTTagCompound.func_74757_a("mayBuild", this.field_75099_e);
/* 22 */     nBTTagCompound.func_74776_a("flySpeed", this.field_75096_f);
/* 23 */     nBTTagCompound.func_74776_a("walkSpeed", this.field_75097_g);
/* 24 */     p_75091_1_.func_74782_a("abilities", (NBTBase)nBTTagCompound);
/*    */   }
/*    */   
/*    */   public void func_75095_b(NBTTagCompound p_75095_1_) {
/* 28 */     if (p_75095_1_.func_150297_b("abilities", 10)) {
/* 29 */       NBTTagCompound nBTTagCompound = p_75095_1_.func_74775_l("abilities");
/*    */       
/* 31 */       this.field_75102_a = nBTTagCompound.func_74767_n("invulnerable");
/* 32 */       this.field_75100_b = nBTTagCompound.func_74767_n("flying");
/* 33 */       this.field_75101_c = nBTTagCompound.func_74767_n("mayfly");
/* 34 */       this.field_75098_d = nBTTagCompound.func_74767_n("instabuild");
/*    */       
/* 36 */       if (nBTTagCompound.func_150297_b("flySpeed", 99)) {
/* 37 */         this.field_75096_f = nBTTagCompound.func_74760_g("flySpeed");
/* 38 */         this.field_75097_g = nBTTagCompound.func_74760_g("walkSpeed");
/*    */       } 
/* 40 */       if (nBTTagCompound.func_150297_b("mayBuild", 1)) {
/* 41 */         this.field_75099_e = nBTTagCompound.func_74767_n("mayBuild");
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public float func_75093_a() {
/* 47 */     return this.field_75096_f;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_75092_a(float p_75092_1_) {
/* 51 */     this.field_75096_f = p_75092_1_;
/*    */   }
/*    */   
/*    */   public float func_75094_b() {
/* 55 */     return this.field_75097_g;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_82877_b(float p_82877_1_) {
/* 59 */     this.field_75097_g = p_82877_1_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\player\PlayerCapabilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */