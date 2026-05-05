/*    */ package net.minecraft.client.audio;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.item.EntityMinecart;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MovingSoundMinecart
/*    */   extends MovingSound
/*    */ {
/*    */   private final EntityMinecart field_147670_k;
/* 15 */   private float field_147669_l = 0.0F;
/*    */   
/*    */   public MovingSoundMinecart(EntityMinecart p_i45105_1_) {
/* 18 */     super(new ResourceLocation("minecraft:minecart.base"));
/*    */     
/* 20 */     this.field_147670_k = p_i45105_1_;
/* 21 */     this.field_147659_g = true;
/* 22 */     this.field_147665_h = 0;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001118";
/*    */   
/*    */   public void func_73660_a() {
/* 27 */     if (this.field_147670_k.field_70128_L) {
/* 28 */       this.field_147668_j = true;
/*    */       
/*    */       return;
/*    */     } 
/* 32 */     this.field_147660_d = (float)this.field_147670_k.field_70165_t;
/* 33 */     this.field_147661_e = (float)this.field_147670_k.field_70163_u;
/* 34 */     this.field_147658_f = (float)this.field_147670_k.field_70161_v;
/*    */     
/* 36 */     float f = MathHelper.func_76133_a(this.field_147670_k.field_70159_w * this.field_147670_k.field_70159_w + this.field_147670_k.field_70179_y * this.field_147670_k.field_70179_y);
/* 37 */     if (f >= 0.01D) {
/* 38 */       this.field_147669_l = MathHelper.func_76131_a(this.field_147669_l + 0.0025F, 0.0F, 1.0F);
/*    */       
/* 40 */       this.field_147662_b = 0.0F + MathHelper.func_76131_a(f, 0.0F, 0.5F) * 0.7F;
/*    */     } else {
/* 42 */       this.field_147669_l = 0.0F;
/* 43 */       this.field_147662_b = 0.0F;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\MovingSoundMinecart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */