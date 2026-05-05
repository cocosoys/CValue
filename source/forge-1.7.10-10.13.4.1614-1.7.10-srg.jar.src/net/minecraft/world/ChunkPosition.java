/*    */ package net.minecraft.world;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ public class ChunkPosition {
/*    */   public final int field_151329_a;
/*    */   public final int field_151327_b;
/*    */   
/*    */   public ChunkPosition(int p_i45363_1_, int p_i45363_2_, int p_i45363_3_) {
/* 10 */     this.field_151329_a = p_i45363_1_;
/* 11 */     this.field_151327_b = p_i45363_2_;
/* 12 */     this.field_151328_c = p_i45363_3_;
/*    */   }
/*    */   public final int field_151328_c; private static final String __OBFID = "CL_00000132";
/*    */   public ChunkPosition(Vec3 p_i45364_1_) {
/* 16 */     this(MathHelper.func_76128_c(p_i45364_1_.field_72450_a), MathHelper.func_76128_c(p_i45364_1_.field_72448_b), MathHelper.func_76128_c(p_i45364_1_.field_72449_c));
/*    */   }
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 20 */     if (p_equals_1_ instanceof ChunkPosition) {
/*    */       
/* 22 */       ChunkPosition chunkPosition = (ChunkPosition)p_equals_1_;
/* 23 */       return (chunkPosition.field_151329_a == this.field_151329_a && chunkPosition.field_151327_b == this.field_151327_b && chunkPosition.field_151328_c == this.field_151328_c);
/*    */     } 
/*    */     
/* 26 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 30 */     return this.field_151329_a * 8976890 + this.field_151327_b * 981131 + this.field_151328_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\ChunkPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */