/*    */ package net.minecraft.client.particle;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityDiggingFX extends EntityFX {
/*    */   private Block field_145784_a;
/*    */   
/*    */   public EntityDiggingFX(World p_i1234_1_, double p_i1234_2_, double p_i1234_4_, double p_i1234_6_, double p_i1234_8_, double p_i1234_10_, double p_i1234_12_, Block p_i1234_14_, int p_i1234_15_) {
/* 13 */     super(p_i1234_1_, p_i1234_2_, p_i1234_4_, p_i1234_6_, p_i1234_8_, p_i1234_10_, p_i1234_12_);
/* 14 */     this.field_145784_a = p_i1234_14_;
/* 15 */     func_110125_a(p_i1234_14_.func_149691_a(0, p_i1234_15_));
/* 16 */     this.field_70545_g = p_i1234_14_.field_149763_I;
/* 17 */     this.field_70552_h = this.field_70553_i = this.field_70551_j = 0.6F;
/* 18 */     this.field_70544_f /= 2.0F;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000932";
/*    */   public EntityDiggingFX func_70596_a(int p_70596_1_, int p_70596_2_, int p_70596_3_) {
/* 22 */     if (this.field_145784_a == Blocks.field_150349_c) return this; 
/* 23 */     int i = this.field_145784_a.func_149720_d((IBlockAccess)this.field_70170_p, p_70596_1_, p_70596_2_, p_70596_3_);
/* 24 */     this.field_70552_h *= (i >> 16 & 0xFF) / 255.0F;
/* 25 */     this.field_70553_i *= (i >> 8 & 0xFF) / 255.0F;
/* 26 */     this.field_70551_j *= (i & 0xFF) / 255.0F;
/* 27 */     return this;
/*    */   }
/*    */   
/*    */   public EntityDiggingFX func_90019_g(int p_90019_1_) {
/* 31 */     if (this.field_145784_a == Blocks.field_150349_c) return this; 
/* 32 */     int i = this.field_145784_a.func_149741_i(p_90019_1_);
/* 33 */     this.field_70552_h *= (i >> 16 & 0xFF) / 255.0F;
/* 34 */     this.field_70553_i *= (i >> 8 & 0xFF) / 255.0F;
/* 35 */     this.field_70551_j *= (i & 0xFF) / 255.0F;
/* 36 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_70537_b() {
/* 41 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 46 */     float f1 = (this.field_94054_b + this.field_70548_b / 4.0F) / 16.0F;
/* 47 */     float f2 = f1 + 0.015609375F;
/* 48 */     float f3 = (this.field_94055_c + this.field_70549_c / 4.0F) / 16.0F;
/* 49 */     float f4 = f3 + 0.015609375F;
/* 50 */     float f5 = 0.1F * this.field_70544_f;
/*    */     
/* 52 */     if (this.field_70550_a != null) {
/* 53 */       f1 = this.field_70550_a.func_94214_a((this.field_70548_b / 4.0F * 16.0F));
/* 54 */       f2 = this.field_70550_a.func_94214_a(((this.field_70548_b + 1.0F) / 4.0F * 16.0F));
/* 55 */       f3 = this.field_70550_a.func_94207_b((this.field_70549_c / 4.0F * 16.0F));
/* 56 */       f4 = this.field_70550_a.func_94207_b(((this.field_70549_c + 1.0F) / 4.0F * 16.0F));
/*    */     } 
/*    */     
/* 59 */     float f6 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * p_70539_2_ - field_70556_an);
/* 60 */     float f7 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * p_70539_2_ - field_70554_ao);
/* 61 */     float f8 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * p_70539_2_ - field_70555_ap);
/* 62 */     p_70539_1_.func_78386_a(this.field_70552_h, this.field_70553_i, this.field_70551_j);
/*    */     
/* 64 */     p_70539_1_.func_78374_a((f6 - p_70539_3_ * f5 - p_70539_6_ * f5), (f7 - p_70539_4_ * f5), (f8 - p_70539_5_ * f5 - p_70539_7_ * f5), f1, f4);
/* 65 */     p_70539_1_.func_78374_a((f6 - p_70539_3_ * f5 + p_70539_6_ * f5), (f7 + p_70539_4_ * f5), (f8 - p_70539_5_ * f5 + p_70539_7_ * f5), f1, f3);
/* 66 */     p_70539_1_.func_78374_a((f6 + p_70539_3_ * f5 + p_70539_6_ * f5), (f7 + p_70539_4_ * f5), (f8 + p_70539_5_ * f5 + p_70539_7_ * f5), f2, f3);
/* 67 */     p_70539_1_.func_78374_a((f6 + p_70539_3_ * f5 - p_70539_6_ * f5), (f7 - p_70539_4_ * f5), (f8 + p_70539_5_ * f5 - p_70539_7_ * f5), f2, f4);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityDiggingFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */