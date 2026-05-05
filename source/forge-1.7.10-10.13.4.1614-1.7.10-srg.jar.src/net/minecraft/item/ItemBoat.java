/*    */ package net.minecraft.item;
/*    */ import java.util.List;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityBoat;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemBoat extends Item {
/*    */   public ItemBoat() {
/* 15 */     this.field_77777_bU = 1;
/* 16 */     func_77637_a(CreativeTabs.field_78029_e);
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00001774";
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 22 */     float f1 = 1.0F;
/*    */     
/* 24 */     float f2 = p_77659_3_.field_70127_C + (p_77659_3_.field_70125_A - p_77659_3_.field_70127_C) * f1;
/* 25 */     float f3 = p_77659_3_.field_70126_B + (p_77659_3_.field_70177_z - p_77659_3_.field_70126_B) * f1;
/*    */     
/* 27 */     double d1 = p_77659_3_.field_70169_q + (p_77659_3_.field_70165_t - p_77659_3_.field_70169_q) * f1;
/* 28 */     double d2 = p_77659_3_.field_70167_r + (p_77659_3_.field_70163_u - p_77659_3_.field_70167_r) * f1 + 1.62D - p_77659_3_.field_70129_M;
/* 29 */     double d3 = p_77659_3_.field_70166_s + (p_77659_3_.field_70161_v - p_77659_3_.field_70166_s) * f1;
/*    */     
/* 31 */     Vec3 vec31 = Vec3.func_72443_a(d1, d2, d3);
/*    */     
/* 33 */     float f4 = MathHelper.func_76134_b(-f3 * 0.017453292F - 3.1415927F);
/* 34 */     float f5 = MathHelper.func_76126_a(-f3 * 0.017453292F - 3.1415927F);
/* 35 */     float f6 = -MathHelper.func_76134_b(-f2 * 0.017453292F);
/* 36 */     float f7 = MathHelper.func_76126_a(-f2 * 0.017453292F);
/*    */     
/* 38 */     float f8 = f5 * f6;
/* 39 */     float f9 = f7;
/* 40 */     float f10 = f4 * f6;
/*    */     
/* 42 */     double d4 = 5.0D;
/* 43 */     Vec3 vec32 = vec31.func_72441_c(f8 * d4, f9 * d4, f10 * d4);
/* 44 */     MovingObjectPosition movingObjectPosition = p_77659_2_.func_72901_a(vec31, vec32, true);
/* 45 */     if (movingObjectPosition == null) return p_77659_1_;
/*    */ 
/*    */     
/* 48 */     Vec3 vec33 = p_77659_3_.func_70676_i(f1);
/* 49 */     boolean bool = false;
/* 50 */     float f11 = 1.0F;
/* 51 */     List<Entity> list = p_77659_2_.func_72839_b((Entity)p_77659_3_, p_77659_3_.field_70121_D.func_72321_a(vec33.field_72450_a * d4, vec33.field_72448_b * d4, vec33.field_72449_c * d4).func_72314_b(f11, f11, f11)); int i;
/* 52 */     for (i = 0; i < list.size(); i++) {
/* 53 */       Entity entity = list.get(i);
/* 54 */       if (entity.func_70067_L()) {
/*    */         
/* 56 */         float f = entity.func_70111_Y();
/* 57 */         AxisAlignedBB axisAlignedBB = entity.field_70121_D.func_72314_b(f, f, f);
/* 58 */         if (axisAlignedBB.func_72318_a(vec31))
/* 59 */           bool = true; 
/*    */       } 
/*    */     } 
/* 62 */     if (bool) {
/* 63 */       return p_77659_1_;
/*    */     }
/*    */     
/* 66 */     if (movingObjectPosition.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/* 67 */       i = movingObjectPosition.field_72311_b;
/* 68 */       int j = movingObjectPosition.field_72312_c;
/* 69 */       int k = movingObjectPosition.field_72309_d;
/*    */       
/* 71 */       if (p_77659_2_.func_147439_a(i, j, k) == Blocks.field_150431_aC) j--;
/*    */       
/* 73 */       EntityBoat entityBoat = new EntityBoat(p_77659_2_, (i + 0.5F), (j + 1.0F), (k + 0.5F));
/* 74 */       entityBoat.field_70177_z = (((MathHelper.func_76128_c((p_77659_3_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3) - 1) * 90);
/* 75 */       if (!p_77659_2_.func_72945_a((Entity)entityBoat, entityBoat.field_70121_D.func_72314_b(-0.1D, -0.1D, -0.1D)).isEmpty()) {
/* 76 */         return p_77659_1_;
/*    */       }
/* 78 */       if (!p_77659_2_.field_72995_K) {
/* 79 */         p_77659_2_.func_72838_d((Entity)entityBoat);
/*    */       }
/* 81 */       if (!p_77659_3_.field_71075_bZ.field_75098_d) {
/* 82 */         p_77659_1_.field_77994_a--;
/*    */       }
/*    */     } 
/*    */     
/* 86 */     return p_77659_1_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemBoat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */