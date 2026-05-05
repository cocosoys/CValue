/*    */ package net.minecraft.client.particle;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityBreakingFX extends EntityFX {
/*    */   public EntityBreakingFX(World p_i1195_1_, double p_i1195_2_, double p_i1195_4_, double p_i1195_6_, Item p_i1195_8_) {
/* 11 */     this(p_i1195_1_, p_i1195_2_, p_i1195_4_, p_i1195_6_, p_i1195_8_, 0);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000897";
/*    */   public EntityBreakingFX(World p_i1196_1_, double p_i1196_2_, double p_i1196_4_, double p_i1196_6_, Item p_i1196_8_, int p_i1196_9_) {
/* 15 */     super(p_i1196_1_, p_i1196_2_, p_i1196_4_, p_i1196_6_, 0.0D, 0.0D, 0.0D);
/* 16 */     func_110125_a(p_i1196_8_.func_77617_a(p_i1196_9_));
/* 17 */     this.field_70552_h = this.field_70553_i = this.field_70551_j = 1.0F;
/* 18 */     this.field_70545_g = Blocks.field_150433_aE.field_149763_I;
/* 19 */     this.field_70544_f /= 2.0F;
/*    */   }
/*    */   
/*    */   public EntityBreakingFX(World p_i1197_1_, double p_i1197_2_, double p_i1197_4_, double p_i1197_6_, double p_i1197_8_, double p_i1197_10_, double p_i1197_12_, Item p_i1197_14_, int p_i1197_15_) {
/* 23 */     this(p_i1197_1_, p_i1197_2_, p_i1197_4_, p_i1197_6_, p_i1197_14_, p_i1197_15_);
/* 24 */     this.field_70159_w *= 0.10000000149011612D;
/* 25 */     this.field_70181_x *= 0.10000000149011612D;
/* 26 */     this.field_70179_y *= 0.10000000149011612D;
/* 27 */     this.field_70159_w += p_i1197_8_;
/* 28 */     this.field_70181_x += p_i1197_10_;
/* 29 */     this.field_70179_y += p_i1197_12_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_70537_b() {
/* 34 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 39 */     float f1 = (this.field_94054_b + this.field_70548_b / 4.0F) / 16.0F;
/* 40 */     float f2 = f1 + 0.015609375F;
/* 41 */     float f3 = (this.field_94055_c + this.field_70549_c / 4.0F) / 16.0F;
/* 42 */     float f4 = f3 + 0.015609375F;
/* 43 */     float f5 = 0.1F * this.field_70544_f;
/*    */     
/* 45 */     if (this.field_70550_a != null) {
/* 46 */       f1 = this.field_70550_a.func_94214_a((this.field_70548_b / 4.0F * 16.0F));
/* 47 */       f2 = this.field_70550_a.func_94214_a(((this.field_70548_b + 1.0F) / 4.0F * 16.0F));
/* 48 */       f3 = this.field_70550_a.func_94207_b((this.field_70549_c / 4.0F * 16.0F));
/* 49 */       f4 = this.field_70550_a.func_94207_b(((this.field_70549_c + 1.0F) / 4.0F * 16.0F));
/*    */     } 
/*    */     
/* 52 */     float f6 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * p_70539_2_ - field_70556_an);
/* 53 */     float f7 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * p_70539_2_ - field_70554_ao);
/* 54 */     float f8 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * p_70539_2_ - field_70555_ap);
/* 55 */     p_70539_1_.func_78386_a(this.field_70552_h, this.field_70553_i, this.field_70551_j);
/*    */     
/* 57 */     p_70539_1_.func_78374_a((f6 - p_70539_3_ * f5 - p_70539_6_ * f5), (f7 - p_70539_4_ * f5), (f8 - p_70539_5_ * f5 - p_70539_7_ * f5), f1, f4);
/* 58 */     p_70539_1_.func_78374_a((f6 - p_70539_3_ * f5 + p_70539_6_ * f5), (f7 + p_70539_4_ * f5), (f8 - p_70539_5_ * f5 + p_70539_7_ * f5), f1, f3);
/* 59 */     p_70539_1_.func_78374_a((f6 + p_70539_3_ * f5 + p_70539_6_ * f5), (f7 + p_70539_4_ * f5), (f8 + p_70539_5_ * f5 + p_70539_7_ * f5), f2, f3);
/* 60 */     p_70539_1_.func_78374_a((f6 + p_70539_3_ * f5 - p_70539_6_ * f5), (f7 - p_70539_4_ * f5), (f8 + p_70539_5_ * f5 - p_70539_7_ * f5), f2, f4);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityBreakingFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */