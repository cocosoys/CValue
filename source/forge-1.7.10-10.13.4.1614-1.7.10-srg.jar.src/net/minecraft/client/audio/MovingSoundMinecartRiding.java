/*    */ package net.minecraft.client.audio;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.item.EntityMinecart;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MovingSoundMinecartRiding
/*    */   extends MovingSound {
/*    */   private final EntityPlayer field_147672_k;
/*    */   
/*    */   public MovingSoundMinecartRiding(EntityPlayer p_i45106_1_, EntityMinecart p_i45106_2_) {
/* 16 */     super(new ResourceLocation("minecraft:minecart.inside"));
/*    */     
/* 18 */     this.field_147672_k = p_i45106_1_;
/* 19 */     this.field_147671_l = p_i45106_2_;
/*    */     
/* 21 */     this.field_147666_i = ISound.AttenuationType.NONE;
/* 22 */     this.field_147659_g = true;
/* 23 */     this.field_147665_h = 0;
/*    */   }
/*    */   private final EntityMinecart field_147671_l; private static final String __OBFID = "CL_00001119";
/*    */   
/*    */   public void func_73660_a() {
/* 28 */     if (this.field_147671_l.field_70128_L || !this.field_147672_k.func_70115_ae() || this.field_147672_k.field_70154_o != this.field_147671_l) {
/* 29 */       this.field_147668_j = true;
/*    */       
/*    */       return;
/*    */     } 
/* 33 */     float f = MathHelper.func_76133_a(this.field_147671_l.field_70159_w * this.field_147671_l.field_70159_w + this.field_147671_l.field_70179_y * this.field_147671_l.field_70179_y);
/* 34 */     if (f >= 0.01D) {
/* 35 */       this.field_147662_b = 0.0F + MathHelper.func_76131_a(f, 0.0F, 1.0F) * 0.75F;
/*    */     } else {
/* 37 */       this.field_147662_b = 0.0F;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\MovingSoundMinecartRiding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */